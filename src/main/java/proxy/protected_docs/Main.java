package proxy.protected_docs;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessControl = AccessControlService.getInstance();

        library.createDocument("doc1", "This is a public document.", false);
        library.createDocument("doc2", "This is a protected document.", true);

        User user1 = new User("alice");
        User user2 = new User("bob");

        // grant access to Alice only for protected document
        accessControl.grantAccess("doc2", "alice");

        try {
            System.out.println("User1 accessing doc1: " + library.getDocument("doc1").getContent(user1));
            System.out.println("User2 accessing doc1: " + library.getDocument("doc1").getContent(user2));
            System.out.println("User1 accessing doc2: " + library.getDocument("doc2").getContent(user1));
            System.out.println("User2 accessing doc2: " + library.getDocument("doc2").getContent(user2)); // throw exception
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
