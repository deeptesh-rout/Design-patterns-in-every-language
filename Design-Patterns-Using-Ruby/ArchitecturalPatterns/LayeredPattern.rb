# Data Access Layer
class DataAccessLayer
    attr_reader :products

    def initialize
        @products = []
    end

    def add_data(product)
        @products << product
    end
end
  
# Business Logic Layer
class BusinessLogicLayer
    def initialize(data_access)
        @data_access = data_access
    end

    def get_all_products
        @data_access.products
    end

    def add_product(product)
        @data_access.add_data(product)
    end
end
  
# Presentation Layer
class PresentationLayer
    def initialize(business_logic)
        @business_logic = business_logic
    end

    def display_products
        @business_logic.get_all_products.each_with_index do |product, index|
            puts "#{index + 1}. #{product}"
        end
    end

    def add_product(product)
        @business_logic.add_product(product)
    end
end

# Main
data_access = DataAccessLayer.new
business_logic = BusinessLogicLayer.new(data_access)
presentation_layer = PresentationLayer.new(business_logic)

presentation_layer.add_product("Apple")
presentation_layer.add_product("Banana")
presentation_layer.add_product("Mango")
presentation_layer.display_products
  
=begin 
1. Apple
2. Banana
3. Mango
=end