class Person {
    var name: String
    var age: Int
    var gender: String

    init(name: String, age: Int, gender: String) {
        self.name = name
        self.age = age
        self.gender = gender
    }

    var description: String {
        return "Person: \(name) is a \(gender) and \(age) years old."
    }

    func getGender() -> String {
        return gender
    }
}

class Citizen: Person {
    private var id: Int

    init(name: String, age: Int, id: Int, gender: String) {
        self.id = id
        super.init(name: name, age: age, gender: gender)
    }

    func getVoterId() -> Int {
        return id
    }

    override var description: String {
        return "Citizen: \(name) is a \(gender) and \(age) years old with voter id \(id)."
    }
}

let p = Person(name: "John", age: 32, gender: "Male")
print(p.description)

let c = Citizen(name: "Smith", age: 31, id: 1234, gender: "Male")
print(c.description)
