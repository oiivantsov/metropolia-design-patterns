package prototype.book_recommend;

// use <T> to make the interface generic, i.e., we don't need to use (object) casting when we implement the interface
// like that: Book clonedBook = (Book) super.clone();
// instead, we can use: Book clonedBook = super.clone(); - return type is Book
public interface Prototype<T> {
    T clone();
}
