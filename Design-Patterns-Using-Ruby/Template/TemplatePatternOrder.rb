# Define OrderPackingTemplate
class OrderPackingTemplate
    def pack_product
        get_product
        add_product_to_box
        delivery
    end

    def get_product
        puts 'Get the product from the shelf.'
    end

    def add_product_to_box
        puts 'Put the product inside the box.'
    end

    def delivery
        raise NotImplementedError, 'Subclasses must implement the delivery method'
    end
end

# Define OnlineOrderPacking extending OrderPackingTemplate
class OnlineOrderPacking < OrderPackingTemplate
    def delivery
        puts 'Add delivery address slip and ship.'
    end
end

# Define StoreOrderPacking extending OrderPackingTemplate
class StoreOrderPacking < OrderPackingTemplate
    def delivery
        puts 'Add thanks message to the box and deliver to the customer.'
    end
end

# Client code
online_order = OnlineOrderPacking.new
online_order.pack_product

puts

store_order = StoreOrderPacking.new
store_order.pack_product
=begin 
Get the product from the shelf.
Put the product inside the box.
Add delivery address slip and ship.

Get the product from the shelf.
Put the product inside the box.
Add thanks message to the box and deliver to the customer.
 =end