package main

import "fmt"

// AbstractWorker is the abstract class defining the template method.
type AbstractWorker interface {
	dailyRoutine()
	wakeUp()
	eatBreakfast()
	goToWork()
	work()
	comeBackHome()
	eatDinner()
	sleep()
}

// Doctor is a concrete implementation of AbstractWorker for doctors.
type Doctor struct{}

func (d *Doctor) dailyRoutine() {
	d.wakeUp()
	d.eatBreakfast()
	d.goToWork()
	d.work()
	d.comeBackHome()
	d.eatDinner()
	d.sleep()
}

func (d *Doctor) wakeUp() {
	fmt.Println("Wake Up")
}

func (d *Doctor) eatBreakfast() {
	fmt.Println("Eat Breakfast")
}

func (d *Doctor) goToWork() {
	fmt.Println("Go to work")
}

func (d *Doctor) work() {
	fmt.Println("...Treat Patients...")
}

func (d *Doctor) comeBackHome() {
	fmt.Println("Come back Home")
}

func (d *Doctor) eatDinner() {
	fmt.Println("Eat dinner")
}

func (d *Doctor) sleep() {
	fmt.Println("Sleep")
}

// FireFighter is another concrete implementation of AbstractWorker for firefighters.
type FireFighter struct{}

func (f *FireFighter) dailyRoutine() {
	f.wakeUp()
	f.eatBreakfast()
	f.goToWork()
	f.work()
	f.comeBackHome()
	f.eatDinner()
	f.sleep()
}

func (f *FireFighter) wakeUp() {
	fmt.Println("Wake Up")
}

func (f *FireFighter) eatBreakfast() {
	fmt.Println("Eat Breakfast")
}

func (f *FireFighter) goToWork() {
	fmt.Println("Go to work")
}

func (f *FireFighter) work() {
	fmt.Println("...Fight Fire...")
}

func (f *FireFighter) comeBackHome() {
	fmt.Println("Come back Home")
}

func (f *FireFighter) eatDinner() {
	fmt.Println("Eat dinner")
}

func (f *FireFighter) sleep() {
	fmt.Println("Sleep")
}

// SuperHero is another concrete implementation of AbstractWorker for superheroes.
type SuperHero struct{}

func (s *SuperHero) dailyRoutine() {
	s.wakeUp()
	s.eatBreakfast()
	s.goToWork()
	s.work()
	s.comeBackHome()
	s.eatDinner()
	s.sleep()
}

func (s *SuperHero) wakeUp() {
	fmt.Println("Wake Up")
}

func (s *SuperHero) eatBreakfast() {
	fmt.Println("Eat Breakfast")
}

func (s *SuperHero) goToWork() {
	fmt.Println("Go to work")
}

func (s *SuperHero) work() {
	fmt.Println("...Save the world!...")
}

func (s *SuperHero) comeBackHome() {
	fmt.Println("Come back Home")
}

func (s *SuperHero) eatDinner() {
	fmt.Println("Eat dinner")
}

func (s *SuperHero) sleep() {
	fmt.Println("Sleep")
}

// Client code
func main() {
	d := &Doctor{}
	d.dailyRoutine()
	fmt.Println()

	f := &FireFighter{}
	f.dailyRoutine()
	fmt.Println()

	s := &SuperHero{}
	s.dailyRoutine()
}

/*
Wake Up
Eat Breakfast
Go to work
...Treat Patients...
Come back Home
Eat dinner
Sleep

Wake Up
Eat Breakfast
Go to work
...Fight Fire...
Come back Home
Eat dinner
Sleep

Wake Up
Eat Breakfast
Go to work
...Save the world!...
Come back Home
Eat dinner
Sleep
*/