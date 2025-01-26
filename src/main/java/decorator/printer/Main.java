package decorator.printer;

public class Main {

        public static void main(String[] args) {
            Printer printer = new BasicPrinter();
            printer.print("Hello World!");

            Printer printer1 = new XMLPrinter(new BasicPrinter());
            printer1.print("Hello World!");

            Printer printer2 = new EncryptedPrinter(new BasicPrinter());
            printer2.print("Hello World!");

            // The order of decorators is important
            Printer printer3 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
            printer3.print("Hello World!");

            Printer printer4 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
            printer4.print("Hello World!");


        }
}
