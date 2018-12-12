package com.design.principles.isp;

/* Interface segregation principle (ISP)
*  - how to split interfaces in smaller interfaces
* */

class Document {

}

interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionalPrinter implements Machine {

    @Override
    public void print(Document d) {}

    @Override
    public void fax(Document d) {}

    @Override
    public void scan(Document d) {}
}

// YAGNI = You Ain't Going to Need It

class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {}

    @Override
    public void fax(Document d) {
        // you don't need this
    }

    @Override
    public void scan(Document d) {
        // you don't need this
    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

class JustAPrinter implements Printer {

    @Override
    public void print(Document d) {}
}

class Photocopier implements Printer, Scanner {

    @Override
    public void print(Document d) {}

    @Override
    public void scan(Document d) {}
}

interface MultiFunctionDevice extends Printer, Scanner {}

class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}

public class Demo {}
