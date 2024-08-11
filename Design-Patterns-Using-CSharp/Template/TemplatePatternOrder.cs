using System;

abstract class OrderPackingTemplate
{
    // The template method
    public void PackProduct()
    {
        GetProduct();
        AddProductToBox();
        Delivery();
    }

    // Primitive operation: GetProduct
    protected void GetProduct()
    {
        Console.WriteLine("Get the product from the shelf.");
    }

    // Primitive operation: AddProductToBox
    protected void AddProductToBox()
    {
        Console.WriteLine("Put the product inside the box.");
    }

    // Primitive operation: Delivery
    protected abstract void Delivery();
}

class OnlineOrderPacking : OrderPackingTemplate
{
    protected override void Delivery()
    {
        Console.WriteLine("Add delivery address slip and ship.");
    }
}

class StoreOrderPacking : OrderPackingTemplate
{
    protected override void Delivery()
    {
        Console.WriteLine("Add thanks message to the box and deliver to the customer.");
    }
}

// Client code
class TemplatePatternOrder
{
    public static void Main(string[] args)
    {
        OnlineOrderPacking onlineOrder = new OnlineOrderPacking();
        onlineOrder.PackProduct();

        Console.WriteLine();

        StoreOrderPacking storeOrder = new StoreOrderPacking();
        storeOrder.PackProduct();
    }
}
