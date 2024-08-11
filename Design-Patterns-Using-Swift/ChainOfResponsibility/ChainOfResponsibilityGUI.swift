// Abstract class representing a handler
class Handler {
    var parent: Handler?
    var helpText: String?

    init(parent: Handler?) {
        self.parent = parent
        self.helpText = nil
    }

    func showHelperText() {
        fatalError("Abstract method. Subclasses must implement this method.")
    }

    func setHelperText(text: String) {
        self.helpText = text
    }
}

// Concrete class representing a container
class Container: Handler {
    override func showHelperText() {
        if let helpText = helpText {
            print("Help :: \(helpText)")
        } else if let parent = parent {
            print("Message passed to next in chain by Container")
            parent.showHelperText()
        }
    }
}

// Concrete class representing a button
class Button: Handler {
    var label: String

    init(label: String, parent: Handler?) {
        self.label = label
        super.init(parent: parent)
    }

    override func showHelperText() {
        if let helpText = helpText {
            print("Help :: \(helpText)")
        } else if let parent = parent {
            print("Message passed to next in chain by Button")
            parent.showHelperText()
        }
    }
}

// Concrete class representing a panel
class Panel: Handler {
    override init(parent: Handler?) {
        super.init(parent: parent)
    }

    override func showHelperText() {
        if let helpText = helpText {
            print("Help :: \(helpText)")
        } else if let parent = parent {
            print("Message passed to next in chain by Panel")
            parent.showHelperText()
        }
    }
}

// Client code
let p = Panel(parent: nil)
p.setHelperText(text: "Panel help text.")

let b1 = Button(label: "Ok", parent: p)
b1.setHelperText(text: "Ok button help text.")

let b2 = Button(label: "Cancel", parent: p)

b1.showHelperText()
b2.showHelperText()

/*
Help :: Ok button help text.
Message passed to next in chain by Button
Help :: Panel help text.
*/