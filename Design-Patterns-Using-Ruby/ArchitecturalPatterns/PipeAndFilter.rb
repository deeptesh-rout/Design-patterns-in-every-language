# Filter Base Class
class Filter
    def process(data)
        raise NotImplementedError, 'Subclasses must implement the process method'
    end
end

# Filters
class CapitalizeFilter < Filter
    def process(data)
        data.upcase
    end
end

class ReplaceSpaceFilter < Filter
    def process(data)
        data.gsub(' ', '_')
    end
end

class RemoveSpecialCharactersFilter < Filter
    def process(data)
        data.gsub(/[, @!]/, '')
    end
end

# Data Processing Pipeline
class DataProcessingPipeline
    def initialize
        @filters = []
    end

    def add_filter(filter)
        @filters << filter
    end

    def process_data(data)
        @filters.inject(data) { |processed_data, filter| filter.process(processed_data) }
    end
end

# Main class
pipeline = DataProcessingPipeline.new
pipeline.add_filter(CapitalizeFilter.new)
pipeline.add_filter(ReplaceSpaceFilter.new)
pipeline.add_filter(RemoveSpecialCharactersFilter.new)

data = 'Hello, World!'
result = pipeline.process_data(data)
puts "Result: #{result}"

=begin 
Result: HELLO_WORLD
 =end