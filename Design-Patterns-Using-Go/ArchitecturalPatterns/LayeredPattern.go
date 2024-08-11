package main

import "fmt"

// DataAccessLayer struct
type DataAccessLayer struct {
	products []string
}

// NewDataAccessLayer constructor
func NewDataAccessLayer() *DataAccessLayer {
	return &DataAccessLayer{
		products: make([]string, 0),
	}
}

// GetData method
func (dal *DataAccessLayer) GetData() []string {
	return dal.products
}

// AddData method
func (dal *DataAccessLayer) AddData(product string) {
	dal.products = append(dal.products, product)
}

// BusinessLogicLayer struct
type BusinessLogicLayer struct {
	dataAccess *DataAccessLayer
}

// NewBusinessLogicLayer constructor
func NewBusinessLogicLayer(dataAccess *DataAccessLayer) *BusinessLogicLayer {
	return &BusinessLogicLayer{
		dataAccess: dataAccess,
	}
}

// GetAllProducts method
func (bll *BusinessLogicLayer) GetAllProducts() []string {
	return bll.dataAccess.GetData()
}

// AddProduct method
func (bll *BusinessLogicLayer) AddProduct(product string) {
	bll.dataAccess.AddData(product)
}

// PresentationLayer struct
type PresentationLayer struct {
	businessLogic *BusinessLogicLayer
}

// NewPresentationLayer constructor
func NewPresentationLayer(businessLogic *BusinessLogicLayer) *PresentationLayer {
	return &PresentationLayer{
		businessLogic: businessLogic,
	}
}

// DisplayProducts method
func (pl *PresentationLayer) DisplayProducts() {
	products := pl.businessLogic.GetAllProducts()
	for i, product := range products {
		fmt.Printf("%d. %s\n", i+1, product)
	}
}

// AddProduct method
func (pl *PresentationLayer) AddProduct(product string) {
	pl.businessLogic.AddProduct(product)
}

// Client Code
func main() {
	dataAccess := NewDataAccessLayer()
	businessLogic := NewBusinessLogicLayer(dataAccess)
	presentationLayer := NewPresentationLayer(businessLogic)

	presentationLayer.AddProduct("Apple")
	presentationLayer.AddProduct("Banana")
	presentationLayer.AddProduct("Mango")
	presentationLayer.DisplayProducts()
}
