package main

import "fmt"

// Agent struct (Invoker)
type Agent struct{}

// placeOrder method for Agent
func (a *Agent) placeOrder(command Order) {
	command.execute()
}

// Order interface
type Order interface {
	execute()
}

// BuyStockOrder struct
type BuyStockOrder struct {
	stock *ReceiverStockTrade
}

// NewBuyStockOrder constructor
func NewBuyStockOrder(stock *ReceiverStockTrade) *BuyStockOrder {
	return &BuyStockOrder{
		stock: stock,
	}
}

// execute method for BuyStockOrder
func (b *BuyStockOrder) execute() {
	b.stock.buy()
}

// SellStockOrder struct
type SellStockOrder struct {
	stock *ReceiverStockTrade
}

// NewSellStockOrder constructor
func NewSellStockOrder(stock *ReceiverStockTrade) *SellStockOrder {
	return &SellStockOrder{
		stock: stock,
	}
}

// execute method for SellStockOrder
func (s *SellStockOrder) execute() {
	s.stock.sell()
}

// ReceiverStockTrade struct (Receiver)
type ReceiverStockTrade struct{}

// buy method for ReceiverStockTrade
func (r *ReceiverStockTrade) buy() {
	fmt.Println("Buy stocks")
}

// sell method for ReceiverStockTrade
func (r *ReceiverStockTrade) sell() {
	fmt.Println("Sell stocks")
}

// Client Code
func main() {
	trader := &ReceiverStockTrade{}
	buyStock := NewBuyStockOrder(trader)
	sellStock := NewSellStockOrder(trader)
	agent := &Agent{}
	agent.placeOrder(buyStock)
	agent.placeOrder(sellStock)
}


/*
Buy stocks
Sell stocks
*/