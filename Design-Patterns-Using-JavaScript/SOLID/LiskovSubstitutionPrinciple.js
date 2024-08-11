class Animal {
    constructor(name) {
        this.name = name;
    }

    makeSound() {
        console.log("Animal sound");
    }
}

class Dog extends Animal {
    constructor(name) {
        super(name);
    }

    makeSound() {
        console.log("woof woof!");
    }
}

class Cat extends Animal {
    constructor(name) {
        super(name);
    }

    makeSound() {
        console.log("meow!");
    }
}

class Rectangle {
    constructor(l, w) {
        this.height = l;
        this.width = w;
    }

    setWidth(w) {
        this.width = w;
    }

    setHeight(h) {
        this.height = h;
    }

    getWidth() {
        return this.width;
    }

    getHeight() {
        return this.height;
    }
}

class Square extends Rectangle {
    constructor(l) {
        super(l, l);
    }

    setWidth(w) {
        super.setWidth(w);
        super.setHeight(w);
    }

    setHeight(h) {
        super.setWidth(h);
        super.setHeight(h);
    }
}

function testRect(rect) {
    rect.setHeight(10);
    rect.setWidth(20);
    if (200 === rect.getHeight() * rect.getWidth()) {
        console.log("success");
    } else {
        console.log("failure");
    }
}

// Client code
const r = new Rectangle(10, 20);
testRect(r);
const s = new Square(10);
testRect(s);

/*
success
failure
*/