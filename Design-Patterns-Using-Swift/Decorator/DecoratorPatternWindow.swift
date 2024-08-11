// Window (Component)
protocol Window {
    func draw()
}

// SimpleWindow (ConcreteComponent)
class SimpleWindow: Window {
    func draw() {
        print("SimpleWindow draw.")
    }
}

// Decorator (Decorator)
class Decorator: Window {
    var component: Window

    init(_ component: Window) {
        self.component = component
    }

    func draw() {
        component.draw()
    }
}

// VerticalScrollBarDecorator (ConcreteDecorator)
class VerticalScrollBarDecorator: Decorator {
    override func draw() {
        super.draw()
        print("VerticalScrollBarDecorator draw")
    }
}

// HorizontalScrollBarDecorator (ConcreteDecorator)
class HorizontalScrollBarDecorator: Decorator {
    override func draw() {
        super.draw()
        print("HorizontalScrollBarDecorator draw")
    }
}

// Client code
let component: Window = SimpleWindow()
let decorator1: Window = VerticalScrollBarDecorator(component)
let decorator2: Window = HorizontalScrollBarDecorator(decorator1)
decorator2.draw()

/*
SimpleWindow draw.
VerticalScrollBarDecorator draw
HorizontalScrollBarDecorator draw
*/
