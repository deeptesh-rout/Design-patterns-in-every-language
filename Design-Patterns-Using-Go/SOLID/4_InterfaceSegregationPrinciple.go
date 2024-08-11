package main

import "fmt"

// Printable interface
type Printable interface {
	Print(document string)
}

// Scannable interface
type Scannable interface {
	Scan()
}

// Faxable interface
type Faxable interface {
	Fax(document string)
}

// BasicInkjetPrinter struct
type BasicInkjetPrinter struct{}

// Print method for BasicInkjetPrinter
func (bip BasicInkjetPrinter) Print(document string) {
	fmt.Printf("Printing %s using basic inkjet printer\n", document)
}

// HighEndOfficePrinter struct
type HighEndOfficePrinter struct{}

// Print method for HighEndOfficePrinter
func (heop HighEndOfficePrinter) Print(document string) {
	fmt.Printf("Printing %s using high end office printer\n", document)
}

// Scan method for HighEndOfficePrinter
func (heop HighEndOfficePrinter) Scan() {
	fmt.Println("Scanning using high end office printer")
}

// Fax method for HighEndOfficePrinter
func (heop HighEndOfficePrinter) Fax(document string) {
	fmt.Printf("Faxing %s using high end office printer\n", document)
}

// Client code
func main() {
	basicPrinter := BasicInkjetPrinter{}
	basicPrinter.Print("Sample Document")

	officePrinter := HighEndOfficePrinter{}
	officePrinter.Print("Important Report")
	officePrinter.Scan()
	officePrinter.Fax("Confidential Memo")
}

/*
Printing Sample Document using basic inkjet printer
Printing Important Report using high end office printer
Scanning using high end office printer
Faxing Confidential Memo using high end office printer
*/