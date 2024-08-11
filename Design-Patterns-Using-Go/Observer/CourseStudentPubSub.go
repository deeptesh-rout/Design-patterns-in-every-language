package main

import "fmt"

type Courses struct {
	courseStudents map[string]map[*Student]struct{}
}

func NewCourses() *Courses {
	return &Courses{
		courseStudents: make(map[string]map[*Student]struct{}),
	}
}

func (c *Courses) Subscribe(subject string, student *Student) {
	if _, ok := c.courseStudents[subject]; !ok {
		c.courseStudents[subject] = make(map[*Student]struct{})
	}
	c.courseStudents[subject][student] = struct{}{}
}

func (c *Courses) Unsubscribe(subject string, student *Student) {
	if students, ok := c.courseStudents[subject]; ok {
		delete(students, student)
		if len(students) == 0 {
			delete(c.courseStudents, subject)
		}
	}
}

func (c *Courses) Publish(subject, message string) {
	if students, ok := c.courseStudents[subject]; ok {
		for student := range students {
			student.Notify(subject, message)
		}
	} else {
		fmt.Printf("No subscribers for subject '%s'.\n", subject)
	}
}

type Student struct {
	Name string
}

func NewStudent(name string) *Student {
	return &Student{Name: name}
}

func (s *Student) Notify(subject, message string) {
	fmt.Printf("%s received message on subject '%s': %s\n", s.Name, subject, message)
}

// Client code
func main() {
	courses := NewCourses()
	john := NewStudent("John")
	eric := NewStudent("Eric")
	jack := NewStudent("Jack")

	courses.Subscribe("English", john)
	courses.Subscribe("English", eric)
	courses.Subscribe("Maths", eric)
	courses.Subscribe("Science", jack)

	courses.Publish("English", "Tomorrow class at 11")
	courses.Publish("Maths", "Tomorrow class at 1")

	// Unsubscribe Eric from English
	courses.Unsubscribe("English", eric)

	courses.Publish("English", "Updated schedule for English")
}

/*
John received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'English': Tomorrow class at 11
Eric received message on subject 'Maths': Tomorrow class at 1
John received message on subject 'English': Updated schedule for English
*/
