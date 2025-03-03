package prototype.book_recommend;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype<Recommendation> {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public Recommendation clone() {
        Recommendation cloned = new Recommendation(this.targetAudience);
        for (Book book : this.books) {
            cloned.addBook(book.clone()); // Deep copy
        }
        return cloned;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Target Audience: " + targetAudience + "\nBooks:\n");
        for (Book book : books) {
            sb.append(" - ").append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}