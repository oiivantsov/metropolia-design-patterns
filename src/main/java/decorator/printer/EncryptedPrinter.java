package decorator.printer;

import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {
    private Printer printer;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        super.print(encrypted);
    }

    // Encrypts a message using the Caesar cipher
    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        final int SHIFT = 3; // Shift by 3 positions
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) { // Only shift alphabetic characters
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encrypted.append((char) ((c - base + SHIFT) % 26 + base)); // Wrap within 'A'-'Z' or 'a'-'z'
            } else {
                encrypted.append(c); // Leave non-alphabetic characters unchanged
            }
        }
        return encrypted.toString();
    }


}
