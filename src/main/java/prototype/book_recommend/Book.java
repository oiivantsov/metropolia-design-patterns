package prototype.book_recommend;

public class Book implements Prototype<Book> {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // get title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Book clone() {
        return new Book(this.title, this.author, this.genre, this.publicationYear);
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d) - Genre: %s", title, author, publicationYear, genre);
    }
}