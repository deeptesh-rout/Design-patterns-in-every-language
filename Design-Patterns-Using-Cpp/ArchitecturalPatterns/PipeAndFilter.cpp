#include <iostream>
#include <string>
#include <vector>

// Filter Base Class
class Filter {
public:
    virtual std::string process(const std::string& data) = 0;
    virtual ~Filter() {}
};

// Filters
class CapitalizeFilter : public Filter {
public:
    std::string process(const std::string& data) override {
        std::string processedData = data;
        for (char& c : processedData) {
            c = std::toupper(c);
        }
        return processedData;
    }
};

class ReplaceSpaceFilter : public Filter {
public:
    std::string process(const std::string& data) override {
        std::string processedData = data;
        for (char& c : processedData) {
            if (c == ' ') {
                c = '_';
            }
        }
        return processedData;
    }
};

class RemoveSpecialCharactersFilter : public Filter {
public:
    std::string process(const std::string& data) override {
        std::string processedData;
        for (char c : data) {
            if (c != ',' && c != '@' && c != '!') {
                processedData += c;
            }
        }
        return processedData;
    }
};

// Data Processing Pipeline
class DataProcessingPipeline {
private:
    std::vector<Filter*> filters;

public:
    ~DataProcessingPipeline() {
        for (Filter* filter : filters) {
            delete filter;
        }
    }

    void addFilter(Filter* filter) {
        filters.push_back(filter);
    }

    std::string processData(const std::string& data) {
        std::string processedData = data;
        for (Filter* filter : filters) {
            processedData = filter->process(processedData);
        }
        return processedData;
    }
};

// Main function
int main() {
    DataProcessingPipeline pipeline;
    pipeline.addFilter(new CapitalizeFilter());
    pipeline.addFilter(new ReplaceSpaceFilter());
    pipeline.addFilter(new RemoveSpecialCharactersFilter());

    std::string data = "Hello, World!";
    std::string result = pipeline.processData(data);
    std::cout << "Result: " << result << std::endl;  // Output: "HELLO_WORLD"

    return 0;
}

/*
Result: HELLO_WORLD
*/