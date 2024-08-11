package main

import (
	"errors"
	"fmt"
)

type LimitedInstances struct {
}

var instances []LimitedInstances
const limit = 4

func NewLimitedInstances() (*LimitedInstances, error) {
	if len(instances) >= limit {
		return nil, errors.New("Instance Limit reached")
	}
	instance := LimitedInstances{}
	instances = append(instances, instance)
	return &instance, nil
}

// Client code
func main() {
	for i := 0; i < 10; i++ {
		instance, err := NewLimitedInstances()
		if err != nil {
			fmt.Println(err)
			break
		}
		fmt.Printf("Instance %d created\n", i+1)
		_ = instance
	}
}

/*
Instance 1 created
Instance 2 created
Instance 3 created
Instance 4 created
Instance Limit reached
*/