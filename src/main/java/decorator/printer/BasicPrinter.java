package decorator.printer;

// Wrappee (the original object)
public class BasicPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
