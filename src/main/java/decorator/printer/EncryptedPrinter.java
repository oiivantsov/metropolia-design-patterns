package decorator.printer;

import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {
    private boolean decrypted = false;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    public EncryptedPrinter(Printer printer, boolean decrypted) {
        super(printer);
        this.decrypted = decrypted;
    }

    @Override
    public void print(String message) {
        if (decrypted) {
            String decrypted = decrypt(message);
            super.print(decrypted);
            return;
        }
        String encrypted = encrypt(message);
        super.print(encrypted);
    }

    // same logic as Caesar Cipher but for bytes
    private String encrypt(String data) {
        byte[] result = data.getBytes();
        // encryption mechanism: add 1 to each byte
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decrypt(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }

}
