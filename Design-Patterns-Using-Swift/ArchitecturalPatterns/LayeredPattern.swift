import Foundation

// Data Access Layer
class DataAccessLayer {
    private var products: [String]

    init() {
        self.products = [String]()
    }

    func getData() -> [String] {
        return self.products
    }

    func addData(product: String) {
        self.products.append(product)
    }
}

// Business Logic Layer
class BusinessLogicLayer {
    private var dataAccess: DataAccessLayer

    init(dataAccess: DataAccessLayer) {
        self.dataAccess = dataAccess
    }

    func getAllProducts() -> [String] {
        return self.dataAccess.getData()
    }

    func addProduct(product: String) {
        self.dataAccess.addData(product: product)
    }
}

// Presentation Layer
class PresentationLayer {
    private var businessLogic: BusinessLogicLayer

    init(businessLogic: BusinessLogicLayer) {
        self.businessLogic = businessLogic
    }

    func displayProducts() {
        let products = self.businessLogic.getAllProducts()
        for (index, product) in products.enumerated() {
            print("\(index + 1). \(product)")
        }
    }

    func addProduct(product: String) {
        self.businessLogic.addProduct(product: product)
    }
}

// Client Code
let dataAccess = DataAccessLayer()
let businessLogic = BusinessLogicLayer(dataAccess: dataAccess)
let presentationLayer = PresentationLayer(businessLogic: businessLogic)

presentationLayer.addProduct(product: "Apple")
presentationLayer.addProduct(product: "Banana")
presentationLayer.addProduct(product: "Mango")
presentationLayer.displayProducts()

/*
1. Apple
2. Banana
3. Mango
*/
