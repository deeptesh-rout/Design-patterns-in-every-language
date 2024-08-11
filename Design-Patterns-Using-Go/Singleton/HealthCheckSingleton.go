package main

import "fmt"

type HealthCheck struct {
	servers []string
}

var instance *HealthCheck

func NewHealthCheck() *HealthCheck {
	if instance == nil {
		instance = &HealthCheck{}
	}
	return instance
}

func (hc *HealthCheck) addServer() {
	hc.servers = append(hc.servers, "Server 1", "Server 2")
}

func (hc *HealthCheck) changeServer() {
	hc.servers = append(hc.servers[:len(hc.servers)-1], "Server 5")
}

// Client code
func main() {
	hc1 := NewHealthCheck()
	hc1.addServer()

	hc2 := NewHealthCheck()
	hc2.addServer()

	fmt.Println(hc1.servers)
	fmt.Println(hc2.servers)
}
