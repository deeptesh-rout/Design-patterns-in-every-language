import java.util.ArrayList;
import java.util.List;

// Data Access Layer
class DataAccessLayer {
    private List<String> products;

    public DataAccessLayer() {
        this.products = new ArrayList<>();
    }

    public List<String> getData() {
        return this.products;
    }

    public void addData(String product) {
        this.products.add(product);
    }
}

// Business Logic Layer
class BusinessLogicLayer {
    private DataAccessLayer dataAccess;

    public BusinessLogicLayer(DataAccessLayer dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<String> getAllProducts() {
        return this.dataAccess.getData();
    }

    public void addProduct(String product) {
        this.dataAccess.addData(product);
    }
}

// Presentation Layer
class PresentationLayer {
    private BusinessLogicLayer businessLogic;

    public PresentationLayer(BusinessLogicLayer businessLogic) {
        this.businessLogic = businessLogic;
    }

    public void displayProducts() {
        List<String> products = this.businessLogic.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    public void addProduct(String product) {
        this.businessLogic.addProduct(product);
    }
}

// Main class
public class LayeredPattern {
    public static void main(String[] args) {
        DataAccessLayer dataAccess = new DataAccessLayer();
        BusinessLogicLayer businessLogic = new BusinessLogicLayer(dataAccess);
        PresentationLayer presentationLayer = new PresentationLayer(businessLogic);

        presentationLayer.addProduct("Apple");
        presentationLayer.addProduct("Banana");
        presentationLayer.addProduct("Mango");
        presentationLayer.displayProducts();
    }
}

/*
1. Apple
2. Banana
3. Mango
*/