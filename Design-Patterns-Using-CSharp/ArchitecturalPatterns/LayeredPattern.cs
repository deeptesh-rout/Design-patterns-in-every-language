using System;
using System.Collections.Generic;

// Data Access Layer
class DataAccessLayer
{
    private List<string> products;

    public DataAccessLayer()
    {
        this.products = new List<string>();
    }

    public List<string> GetData()
    {
        return this.products;
    }

    public void AddData(string product)
    {
        this.products.Add(product);
    }
}

// Business Logic Layer
class BusinessLogicLayer
{
    private DataAccessLayer dataAccess;

    public BusinessLogicLayer(DataAccessLayer dataAccess)
    {
        this.dataAccess = dataAccess;
    }

    public List<string> GetAllProducts()
    {
        return this.dataAccess.GetData();
    }

    public void AddProduct(string product)
    {
        this.dataAccess.AddData(product);
    }
}

// Presentation Layer
class PresentationLayer
{
    private BusinessLogicLayer businessLogic;

    public PresentationLayer(BusinessLogicLayer businessLogic)
    {
        this.businessLogic = businessLogic;
    }

    public void DisplayProducts()
    {
        List<string> products = this.businessLogic.GetAllProducts();
        for (int i = 0; i < products.Count; i++)
        {
            Console.WriteLine((i + 1) + ". " + products[i]);
        }
    }

    public void AddProduct(string product)
    {
        this.businessLogic.AddProduct(product);
    }
}

// Main class
class LayeredPattern
{
    public static void Main(string[] args)
    {
        DataAccessLayer dataAccess = new DataAccessLayer();
        BusinessLogicLayer businessLogic = new BusinessLogicLayer(dataAccess);
        PresentationLayer presentationLayer = new PresentationLayer(businessLogic);

        presentationLayer.AddProduct("Apple");
        presentationLayer.AddProduct("Banana");
        presentationLayer.AddProduct("Mango");
        presentationLayer.DisplayProducts();
    }
}

/*
1. Apple
2. Banana
3. Mango
*/
