package proxy.protected_docs;

public class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}
