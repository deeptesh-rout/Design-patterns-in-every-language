import java.util.ArrayList

// Filter Base Class
abstract class Filter {
    abstract fun process(data: String): String
}

// Filters
class CapitalizeFilter : Filter() {
    override fun process(data: String): String {
        return data.uppercase()
    }
}

class ReplaceSpaceFilter : Filter() {
    override fun process(data: String): String {
        return data.replace(" ", "_")
    }
}

class RemoveSpecialCharactersFilter : Filter() {
    override fun process(data: String): String {
        val specialCharacters = ",@!"
        val result = StringBuilder()
        for (c in data.toCharArray()) {
            if (!specialCharacters.contains(c)) {
                result.append(c)
            }
        }
        return result.toString()
    }
}

// Data Processing Pipeline
class DataProcessingPipeline {
    private val filters: MutableList<Filter> = ArrayList()

    fun addFilter(filter: Filter) {
        filters.add(filter)
    }

    fun processData(data: String): String {
        var processedData = data
        for (filter in filters) {
            processedData = filter.process(processedData)
        }
        return processedData
    }
}

// Client code.
fun main() {
    val pipeline = DataProcessingPipeline()
    pipeline.addFilter(CapitalizeFilter())
    pipeline.addFilter(ReplaceSpaceFilter())
    pipeline.addFilter(RemoveSpecialCharactersFilter())

    val data = "Hello, World!"
    val result = pipeline.processData(data)
    println("Result: $result")  // Output: "HELLO_WORLD"
}
