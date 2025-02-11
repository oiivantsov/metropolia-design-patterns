package proxy.protected_docs;

public class DocumentProxy implements Document {
    private final RealDocument realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getIdentifier() {
        return realDocument.getIdentifier();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getIdentifier(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access Denied: User " + user.getUsername() + " is not authorized to view this document.");
        }
    }
}