abstract class Printer {
    abstract fun print(document: String)
    abstract fun scan()
    abstract fun fax(document: String)
}

interface Printable {
    fun print(document: String)
}

interface Scannable {
    fun scan()
}

interface Faxable {
    fun fax(document: String)
}

class BasicInkjetPrinter : Printable {
    override fun print(document: String) {
        println("Printing $document using basic inkjet printer")
    }

}

class HighEndOfficePrinter : Printable, Scannable, Faxable {
    override fun print(document: String) {
        println("Printing $document using high end office printer")
    }

    override fun scan() {
        println("Scanning using high end office printer")
    }

    override fun fax(document: String) {
        println("Faxing $document using high end office printer")
    }
}

// Client code
fun main() {
    // BasicInkjetPrinter
    val basicPrinter = BasicInkjetPrinter()
    basicPrinter.print("Sample Document")

    // HighEndOfficePrinter
    val officePrinter = HighEndOfficePrinter()
    officePrinter.print("Important Report")
    officePrinter.scan()
    officePrinter.fax("Confidential Memo")
}

/*
Printing Sample Document using basic inkjet printer
Printing Important Report using high end office printer
Scanning using high end office printer
Faxing Confidential Memo using high end office printer
*/