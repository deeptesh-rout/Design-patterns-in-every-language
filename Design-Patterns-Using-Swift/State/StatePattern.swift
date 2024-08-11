protocol BulbState {
    func flip(_ bc: BulbControl)
    var description: String { get }
}

class BulbControl {
    private var current: BulbState

    init() {
        self.current = Off()
    }

    func setState(_ state: BulbState) {
        self.current = state
    }

    func flip() {
        self.current.flip(self)
    }

    var descriptionState: String {
        return self.current.description
    }
}

class On: BulbState {
    func flip(_ bc: BulbControl) {
        bc.setState(Off())
    }

    var description: String {
        return "On"
    }
}

class Off: BulbState {
    func flip(_ bc: BulbControl) {
        bc.setState(On())
    }

    var description: String {
        return "Off"
    }
}

// Client code.
let c = BulbControl()
c.flip()
print(c.descriptionState)
c.flip()
print(c.descriptionState)

/* 
On
Off
*/