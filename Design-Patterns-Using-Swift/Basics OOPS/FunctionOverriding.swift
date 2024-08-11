class Person {
    var name: String
    var oath: String?

    init(name: String) {
        self.name = name
    }

    func setOath() {
        self.oath = "Always tell the truth"
    }

    var description: String {
        return "Person: \(name):\(oath ?? "")"
    }
}

class Citizen: Person {
    private var id: Int

    init(name: String, id: Int) {
        self.id = id
        super.init(name: name)
    }

    override func setOath() {
        self.oath = "Country comes first"
    }
}

let p = Person(name: "John")
p.setOath()
print(p.description)

let c = Citizen(name: "Smith", id: 31)
c.setOath()
print(c.description)
