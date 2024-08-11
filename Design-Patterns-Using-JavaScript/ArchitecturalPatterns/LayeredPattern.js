// Data Access Layer
class DataAccessLayer {
    constructor() {
        this.products = [];
    }

    getData() {
        return this.products;
    }

    addData(product) {
        this.products.push(product);
    }
}

// Business Logic Layer
class BusinessLogicLayer {
    constructor(dataAccess) {
        this.dataAccess = dataAccess;
    }

    getAllProducts() {
        return this.dataAccess.getData();
    }

    addProduct(product) {
        this.dataAccess.addData(product);
    }
}

// Presentation Layer
class PresentationLayer {
    constructor(businessLogic) {
        this.businessLogic = businessLogic;
    }

    displayProducts() {
        const products = this.businessLogic.getAllProducts();
        products.forEach((product, index) => {
            console.log(`${index + 1}. ${product}`);
        });
    }

    addProduct(product) {
        this.businessLogic.addProduct(product);
    }
}

// Client code
const dataAccess = new DataAccessLayer();
const businessLogic = new BusinessLogicLayer(dataAccess);
const presentationLayer = new PresentationLayer(businessLogic);

presentationLayer.addProduct("Apple");
presentationLayer.addProduct("Banana");
presentationLayer.addProduct("Mango");
presentationLayer.displayProducts();

/*
1. Apple
2. Banana
3. Mango
*/