// Define OrderPackingTemplate
class OrderPackingTemplate {
    packProduct() {
        this.getProduct();
        this.addProductToBox();
        this.delivery();
    }

    getProduct() {
        console.log("Get the product from the shelf.");
    }

    addProductToBox() {
        console.log("Put the product inside the box.");
    }

    delivery() {
        throw new Error("delivery method must be implemented");
    }
}

// Define OnlineOrderPacking extending OrderPackingTemplate
class OnlineOrderPacking extends OrderPackingTemplate {
    delivery() {
        console.log("Add delivery address slip and ship.");
    }
}

// Define StoreOrderPacking extending OrderPackingTemplate
class StoreOrderPacking extends OrderPackingTemplate {
    delivery() {
        console.log("Add thanks message to the box and deliver to the customer.");
    }
}

// Client code
const onlineOrder = new OnlineOrderPacking();
onlineOrder.packProduct();

console.log();

const storeOrder = new StoreOrderPacking();
storeOrder.packProduct();

/*
Get the product from the shelf.
Put the product inside the box.
Add delivery address slip and ship.

Get the product from the shelf.
Put the product inside the box.
Add thanks message to the box and deliver to the customer.
*/