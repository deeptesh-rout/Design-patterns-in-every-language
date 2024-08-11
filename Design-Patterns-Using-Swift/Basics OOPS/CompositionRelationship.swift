class Tyre {
    private var type: String

    init(type: String) {
        self.type = type
    }

    func getType() -> String {
        return type
    }
}

class Car {
    private var model: String
    private var tyres: [Tyre]

    init(model: String) {
        self.model = model
        self.tyres = []
        for _ in 0..<4 {
            self.tyres.append(Tyre(type: "MRF"))
        }
    }

    func display() {
        print("Car: \(model), Tyre: \(tyres[0].getType())")
    }
}

let car = Car(model: "BMW")
car.display()
