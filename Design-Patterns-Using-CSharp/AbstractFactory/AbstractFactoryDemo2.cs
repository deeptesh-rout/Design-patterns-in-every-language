using System;

// Abstract ProductA
interface ProductA
{
    void OperationA();
}

// Concrete ProductA1
class ProductA1 : ProductA
{
    public void OperationA()
    {
        Console.WriteLine("ProductA1 operationA");
    }
}

// Concrete ProductA2
class ProductA2 : ProductA
{
    public void OperationA()
    {
        Console.WriteLine("ProductA2 operationA");
    }
}

// Abstract ProductB
interface ProductB
{
    void OperationB();
}

// Concrete ProductB1
class ProductB1 : ProductB
{
    public void OperationB()
    {
        Console.WriteLine("ProductB1 operationB");
    }
}

// Concrete ProductB2
class ProductB2 : ProductB
{
    public void OperationB()
    {
        Console.WriteLine("ProductB2 operationB");
    }
}

// Abstract Factory
interface AbstractFactory
{
    ProductA CreateProductA();
    ProductB CreateProductB();
}

// Concrete Factory1
class ConcreteFactory1 : AbstractFactory
{
    public ProductA CreateProductA()
    {
        return new ProductA1();
    }

    public ProductB CreateProductB()
    {
        return new ProductB1();
    }
}

// Concrete Factory2
class ConcreteFactory2 : AbstractFactory
{
    public ProductA CreateProductA()
    {
        return new ProductA2();
    }

    public ProductB CreateProductB()
    {
        return new ProductB2();
    }
}

// Client code
public class AbstractFactoryDemo2
{
    public static void Main(string[] args)
    {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.CreateProductA();
        ProductB productB1 = factory1.CreateProductB();
        productA1.OperationA();
        productB1.OperationB();

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.CreateProductA();
        ProductB productB2 = factory2.CreateProductB();
        productA2.OperationA();
        productB2.OperationB();
    }
}

/* 
ProductA1 operationA
ProductB1 operationB
ProductA2 operationA
ProductB2 operationB
*/