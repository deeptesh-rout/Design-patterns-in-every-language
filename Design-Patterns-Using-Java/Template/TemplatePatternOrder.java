import java.io.*;

abstract class OrderPackingTemplate {
    
    final void packProduct() {
        getProduct();
        addProductToBox();
        delivery();
    }

    void getProduct() {
        System.out.println("Get the product from the shelf.");
    }

    void addProductToBox() {
        System.out.println("Put the product inside the box.");
    }

    abstract void delivery();
}

class OnlineOrderPacking extends OrderPackingTemplate {
    @Override
    void delivery() {
        System.out.println("Add delivery address slip and ship.");
    }
}

class StoreOrderPacking extends OrderPackingTemplate {
    @Override
    void delivery() {
        System.out.println("Add thanks message to the box and deliver to the customer.");
    }
}

public class TemplatePatternOrder {
    public static void main(String[] args) {
        OnlineOrderPacking onlineOrder = new OnlineOrderPacking();
        onlineOrder.packProduct();

        System.out.println();

        StoreOrderPacking storeOrder = new StoreOrderPacking();
        storeOrder.packProduct();
    }
}

/*
Get the product from the shelf.
Put the product inside the box.
Add delivery address slip and ship.

Get the product from the shelf.
Put the product inside the box.
Add thanks message to the box and deliver to the customer.
*/