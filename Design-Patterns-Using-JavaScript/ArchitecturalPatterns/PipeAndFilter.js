// Filter Base Class
class Filter {
    process(data) {
        throw new Error('You have to implement the method process!');
    }
}

// Filters
class CapitalizeFilter extends Filter {
    process(data) {
        return data.toUpperCase();
    }
}

class ReplaceSpaceFilter extends Filter {
    process(data) {
        return data.replace(/ /g, '_');
    }
}

class RemoveSpecialCharactersFilter extends Filter {
    process(data) {
        const specialCharacters = ",@!";
        let result = '';
        for (let i = 0; i < data.length; i++) {
            if (specialCharacters.indexOf(data[i]) === -1) {
                result += data[i];
            }
        }
        return result;
    }
}

// Data Processing Pipeline
class DataProcessingPipeline {
    constructor() {
        this.filters = [];
    }

    addFilter(filter) {
        this.filters.push(filter);
    }

    processData(data) {
        let processedData = data;
        this.filters.forEach(filter => {
            processedData = filter.process(processedData);
        });
        return processedData;
    }
}

// Client code
const pipeline = new DataProcessingPipeline();
pipeline.addFilter(new CapitalizeFilter());
pipeline.addFilter(new ReplaceSpaceFilter());
pipeline.addFilter(new RemoveSpecialCharactersFilter());

const data = "Hello, World!";
const result = pipeline.processData(data);
console.log("Result: " + result);  