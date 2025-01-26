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

            // first encrypt, then decrypt
            Printer printer5 = new EncryptedPrinter(new EncryptedPrinter(new BasicPrinter(), true));
            printer5.print("Hello World!");

            // code below will not work as the order of decorators is important - we can not decrypt before encrypting
            Printer printer6 = new EncryptedPrinter(new EncryptedPrinter(new BasicPrinter()), true);
//            printer6.print("Hello World!");


        }
}
