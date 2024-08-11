package main

import (
	"fmt"
	"sync"
	"time"
)

// Barrier represents a synchronization barrier
type Barrier struct {
	count int
	lock  sync.Mutex
	cond  *sync.Cond
}

// NewBarrier creates a new Barrier with the given count
func NewBarrier(count int) *Barrier {
	b := &Barrier{count: count}
	b.cond = sync.NewCond(&b.lock)
	return b
}

// Wait waits until all goroutines have called Wait on the barrier
func (b *Barrier) Wait() {
	b.lock.Lock()
	defer b.lock.Unlock()

	b.count--
	if b.count > 0 {
		b.cond.Wait()
	} else {
		b.cond.Broadcast()
	}
}

// Worker represents a worker goroutine
type Worker struct {
	id      int
	barrier *Barrier
}

// NewWorker creates a new Worker with the given id and barrier
func NewWorker(id int, barrier *Barrier) *Worker {
	return &Worker{id: id, barrier: barrier}
}

// Work simulates work for the worker
func (w *Worker) Work() {
	fmt.Printf("Worker %d started\n", w.id)
	for i := 0; i < 3; i++ {
		fmt.Printf("Worker %d working...\n", w.id)
		time.Sleep(time.Second)
	}
	fmt.Printf("Worker %d finished\n", w.id)
	w.barrier.Wait()
}

// Client Code
func main() {
	numWorkers := 3
	barrier := NewBarrier(numWorkers)
	var wg sync.WaitGroup

	for i := 0; i < numWorkers; i++ {
		wg.Add(1)
		worker := NewWorker(i, barrier)
		go func() {
			defer wg.Done()
			worker.Work()
		}()
	}

	wg.Wait()
	fmt.Println("All workers finished. Proceeding to the next step.")
}
