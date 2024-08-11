using System;
using System.Collections.Generic;

// Filter Base Class
abstract class Filter
{
    public abstract string Process(string data);
}

// Filters
class CapitalizeFilter : Filter
{
    public override string Process(string data)
    {
        return data.ToUpper();
    }
}

class ReplaceSpaceFilter : Filter
{
    public override string Process(string data)
    {
        return data.Replace(" ", "_");
    }
}

class RemoveSpecialCharactersFilter : Filter
{
    public override string Process(string data)
    {
        string specialCharacters = ",@!";
        var result = new System.Text.StringBuilder();
        foreach (char c in data)
        {
            if (specialCharacters.IndexOf(c) == -1)
            {
                result.Append(c);
            }
        }
        return result.ToString();
    }
}

// Data Processing Pipeline
class DataProcessingPipeline
{
    private List<Filter> filters;

    public DataProcessingPipeline()
    {
        this.filters = new List<Filter>();
    }

    public void AddFilter(Filter filter)
    {
        this.filters.Add(filter);
    }

    public string ProcessData(string data)
    {
        foreach (Filter filter in this.filters)
        {
            data = filter.Process(data);
        }
        return data;
    }
}

// Main class
class PipeAndFilter
{
    public static void Main(string[] args)
    {
        DataProcessingPipeline pipeline = new DataProcessingPipeline();
        pipeline.AddFilter(new CapitalizeFilter());
        pipeline.AddFilter(new ReplaceSpaceFilter());
        pipeline.AddFilter(new RemoveSpecialCharactersFilter());

        string data = "Hello, World!";
        string result = pipeline.ProcessData(data);
        Console.WriteLine("Result: " + result);
    }
}
/*
Result: HELLO_WORLD
*/