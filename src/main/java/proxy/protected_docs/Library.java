package proxy.protected_docs;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents;

    public Library() {
        this.documents = new HashMap<>();
    }

    public void addDocument(Document document) {
        documents.put(document.getIdentifier(), document);
    }

    public Document getDocument(String identifier) {
        return documents.get(identifier);
    }

    public void createDocument(String identifier, String content, boolean isProtected) {
        RealDocument doc = new RealDocument(identifier, content, isProtected);
        if (isProtected) {
            addDocument(new DocumentProxy(doc));
        } else {
            addDocument(doc);
        }
    }
}
