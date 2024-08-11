
class Printer
    def print(document)
        raise NotImplementedError, "Method 'print' must be implemented in subclass."
    end
  
    def scan
        raise NotImplementedError, "Method 'scan' must be implemented in subclass."
    end
  
    def fax(document)
        raise NotImplementedError, "Method 'fax' must be implemented in subclass."
    end
end
  


# Define Printable module
module Printable
    def print(document)
        raise NotImplementedError, 'Subclasses must implement the print method'
    end
end

# Define Scannable module
module Scannable
    def scan
        raise NotImplementedError, 'Subclasses must implement the scan method'
    end
end

# Define Faxable module
module Faxable
    def fax(document)
        raise NotImplementedError, 'Subclasses must implement the fax method'
    end
end

# Implement BasicInkjetPrinter class including Printable
class BasicInkjetPrinter
    include Printable

    def print(document)
        puts "Printing #{document} using basic inkjet printer"
    end
end

# Implement HighEndOfficePrinter class including Printable, Scannable, and Faxable modules
class HighEndOfficePrinter
    include Printable
    include Scannable
    include Faxable

    def print(document)
        puts "Printing #{document} using high end office printer"
    end

    def scan
        puts "Scanning using high end office printer"
    end

    def fax(document)
        puts "Faxing #{document} using high end office printer"
    end
end

# Client code
# BasicInkjetPrinter
basic_printer = BasicInkjetPrinter.new
basic_printer.print("Sample Document")

# HighEndOfficePrinter
office_printer = HighEndOfficePrinter.new
office_printer.print("Important Report")
office_printer.scan
office_printer.fax("Confidential Memo")

=begin 
Printing Sample Document using basic inkjet printer
Printing Important Report using high end office printer
Scanning using high end office printer
Faxing Confidential Memo using high end office printer
=end