package proxy.protected_docs;

import java.time.LocalDate;

public class RealDocument implements Document {
    private final String identifier;
    private final String creationDate;
    private final String content;
    private final boolean isProtected;

    public RealDocument(String identifier, String content, boolean isProtected) {
        this.identifier = identifier;
        this.creationDate = LocalDate.now().toString();
        this.content = content;
        this.isProtected = isProtected;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    public boolean isProtected() {
        return isProtected;
    }
}