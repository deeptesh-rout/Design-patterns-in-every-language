import Foundation

// Filter Protocol
protocol Filter {
    func process(data: String) -> String
}

// Filters
class CapitalizeFilter: Filter {
    func process(data: String) -> String {
        return data.uppercased()
    }
}

class ReplaceSpaceFilter: Filter {
    func process(data: String) -> String {
        return data.replacingOccurrences(of: " ", with: "_")
    }
}

class RemoveSpecialCharactersFilter: Filter {
    func process(data: String) -> String {
        let specialCharacters = ",@!"
        var result = ""
        for char in data {
            if !specialCharacters.contains(char) {
                result.append(char)
            }
        }
        return result
    }
}

// Data Processing Pipeline
class DataProcessingPipeline {
    private var filters: [Filter] = []

    func addFilter(_ filter: Filter) {
        filters.append(filter)
    }

    func processData(_ data: String) -> String {
        var processedData = data
        for filter in filters {
            processedData = filter.process(data: processedData)
        }
        return processedData
    }
}

// Client Code
let pipeline = DataProcessingPipeline()
pipeline.addFilter(CapitalizeFilter())
pipeline.addFilter(ReplaceSpaceFilter())
pipeline.addFilter(RemoveSpecialCharactersFilter())

let data = "Hello, World!"
let result = pipeline.processData(data)
print("Result: \(result)") // Output: "HELLO_WORLD"

/*
Result: HELLO_WORLD
*/
