
import java.util.ArrayList;
import java.util.List;

// Filter Base Class
abstract class Filter {
    abstract String process(String data);
}

// Filters
class CapitalizeFilter extends Filter {
    @Override
    String process(String data) {
        return data.toUpperCase();
    }
}

class ReplaceSpaceFilter extends Filter {
    @Override
    String process(String data) {
        return data.replace(" ", "_");
    }
}

class RemoveSpecialCharactersFilter extends Filter {
    @Override
    String process(String data) {
        String specialCharacters = ",@!";
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (specialCharacters.indexOf(c) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }
}

// Data Processing Pipeline
class DataProcessingPipeline {
    private List<Filter> filters;

    public DataProcessingPipeline() {
        this.filters = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public String processData(String data) {
        for (Filter filter : this.filters) {
            data = filter.process(data);
        }
        return data;
    }
}

// Main class
public class PipeAndFilter {
    public static void main(String[] args) {
        DataProcessingPipeline pipeline = new DataProcessingPipeline();
        pipeline.addFilter(new CapitalizeFilter());
        pipeline.addFilter(new ReplaceSpaceFilter());
        pipeline.addFilter(new RemoveSpecialCharactersFilter());

        String data = "Hello, World!";
        String result = pipeline.processData(data);
        System.out.println("Result: " + result);  // Output: "HELLO_WORLD"
    }
}

