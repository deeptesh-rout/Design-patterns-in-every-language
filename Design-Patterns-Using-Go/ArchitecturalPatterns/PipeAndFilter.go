package main

import (
	"fmt"
	"strings"
)

// Filter interface
type Filter interface {
	Process(data string) string
}

// CapitalizeFilter struct
type CapitalizeFilter struct{}

// Process method for CapitalizeFilter
func (c *CapitalizeFilter) Process(data string) string {
	return strings.ToUpper(data)
}

// ReplaceSpaceFilter struct
type ReplaceSpaceFilter struct{}

// Process method for ReplaceSpaceFilter
func (r *ReplaceSpaceFilter) Process(data string) string {
	return strings.ReplaceAll(data, " ", "_")
}

// RemoveSpecialCharactersFilter struct
type RemoveSpecialCharactersFilter struct{}

// Process method for RemoveSpecialCharactersFilter
func (r *RemoveSpecialCharactersFilter) Process(data string) string {
	var specialCharacters = ",@!"
	var result strings.Builder
	for _, c := range data {
		if !strings.ContainsRune(specialCharacters, c) {
			result.WriteRune(c)
		}
	}
	return result.String()
}

// DataProcessingPipeline struct
type DataProcessingPipeline struct {
	filters []Filter
}

// NewDataProcessingPipeline constructor
func NewDataProcessingPipeline() *DataProcessingPipeline {
	return &DataProcessingPipeline{
		filters: make([]Filter, 0),
	}
}

// AddFilter method for DataProcessingPipeline
func (d *DataProcessingPipeline) AddFilter(filter Filter) {
	d.filters = append(d.filters, filter)
}

// ProcessData method for DataProcessingPipeline
func (d *DataProcessingPipeline) ProcessData(data string) string {
	for _, filter := range d.filters {
		data = filter.Process(data)
	}
	return data
}

// Client Code
func main() {
	pipeline := NewDataProcessingPipeline()
	pipeline.AddFilter(&CapitalizeFilter{})
	pipeline.AddFilter(&ReplaceSpaceFilter{})
	pipeline.AddFilter(&RemoveSpecialCharactersFilter{})

	data := "Hello, World!"
	result := pipeline.ProcessData(data)
	fmt.Println("Result:", result)
}

/*
Result: HELLO_WORLD
*/