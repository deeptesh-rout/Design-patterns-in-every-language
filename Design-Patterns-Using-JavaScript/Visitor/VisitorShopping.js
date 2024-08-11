class Element {
    price() {
        throw new Error("price method must be implemented");
    }

    accept(visitor) {
        throw new Error("accept method must be implemented");
    }
}

class Book extends Element {
    constructor(price, isbn) {
        super();
        this.priceValue = price;
        this.isbn = isbn;
    }

    price() {
        return this.priceValue;
    }

    accept(visitor) {
        return visitor.visitBook(this);
    }
}

class Fruit extends Element {
    constructor(price, quantity, type) {
        super();
        this.priceValue = price;
        this.quantity = quantity;
        this.type = type;
    }

    price() {
        return this.priceValue;
    }

    accept(visitor) {
        return visitor.visitFruit(this) * this.quantity;
    }
}

class Visitor {
    visitBook(book) {
        throw new Error("visitBook method must be implemented");
    }

    visitFruit(fruit) {
        throw new Error("visitFruit method must be implemented");
    }
}

class SundayDiscount extends Visitor {
    visitBook(book) {
        return book.price() - 50;
    }

    visitFruit(fruit) {
        return fruit.price() - 5;
    }
}

class SaleDiscount extends Visitor {
    visitBook(book) {
        return book.price() / 2;
    }

    visitFruit(fruit) {
        return fruit.price() / 2;
    }
}

class ShoppingCart {
    constructor() {
        this.list = [];
        this.visitor = null;
    }

    add(element) {
        this.list.push(element);
    }

    setDiscountVisitor(discount) {
        this.visitor = discount;
    }

    accept() {
        let cost = 0;
        for (const element of this.list) {
            cost += element.accept(this.visitor);
        }
        console.log("Total cost: " + cost);
    }
}

// Client code
const cart = new ShoppingCart();
cart.add(new Fruit(100, 10, "Apple"));
cart.add(new Book(100, 12345));

cart.setDiscountVisitor(new SundayDiscount());
cart.accept();

cart.setDiscountVisitor(new SaleDiscount());
cart.accept();

/*
Total cost: 1000
Total cost: 550
*/