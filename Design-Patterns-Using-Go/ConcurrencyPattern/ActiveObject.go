package main

import (
	"fmt"
	"sync"
)

// MethodRequest encapsulates a method call along with its arguments
type MethodRequest struct {
	method func()
}

// Execute runs the method
func (m *MethodRequest) Execute() {
	m.method()
}

// ActiveObject encapsulates its own thread of control and executes methods asynchronously
type ActiveObject struct {
	queue     chan *MethodRequest
	isRunning bool
	wg        sync.WaitGroup
}

// NewActiveObject creates a new ActiveObject
func NewActiveObject() *ActiveObject {
	return &ActiveObject{
		queue:     make(chan *MethodRequest),
		isRunning: true,
	}
}

// Run executes method requests
func (ao *ActiveObject) Run() {
	ao.wg.Add(1)
	defer ao.wg.Done()
	for ao.isRunning || len(ao.queue) > 0 {
		select {
		case methodRequest := <-ao.queue:
			methodRequest.Execute()
		}
	}
}

// ScheduleMethod schedules a method request
func (ao *ActiveObject) ScheduleMethod(method func()) {
	ao.queue <- &MethodRequest{method: method}
}

// StopThread stops the ActiveObject thread
func (ao *ActiveObject) StopThread() {
	ao.isRunning = false
	close(ao.queue)
}

// Proxy acts as a wrapper around the ActiveObject and forwards method calls to it
type Proxy struct {
	activeObject *ActiveObject
}

// NewProxy creates a new Proxy
func NewProxy(activeObject *ActiveObject) *Proxy {
	return &Proxy{activeObject: activeObject}
}

// InvokeMethod invokes a method request
func (p *Proxy) InvokeMethod(method func()) {
	p.activeObject.ScheduleMethod(method)
}

// Client Code
func main() {
	// Create an instance of ActiveObject and Proxy
	activeObject := NewActiveObject()
	proxy := NewProxy(activeObject)

	// Start the ActiveObject thread
	go activeObject.Run()

	// Invoke methods on the Proxy
	proxy.InvokeMethod(func() { fmt.Println("Hello") })
	proxy.InvokeMethod(func() { fmt.Println("World") })

	// Wait for the ActiveObject thread to complete
	activeObject.StopThread()
	activeObject.wg.Wait()
}
