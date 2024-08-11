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
        super.setHeight(h);
        super.setWidth(h);
    }
}

function testRectangle() {
    const r = new Rectangle(10, 20);
    testRect(r);
}

function testSquare() {
    const s = new Square(10);
    s.setWidth(20);
    testRect(s);
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

testRectangle();
testSquare();

/*
success
failure
*/