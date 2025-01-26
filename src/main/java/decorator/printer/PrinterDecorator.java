package decorator.printer;

// Abstract base decorator, so that all decorators can extend this class and use super.print(message) to call the next decorator
public class PrinterDecorator implements Printer {
    protected Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    public void print(String message) {
        printer.print(message);
    }
}
