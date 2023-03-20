package model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {



    //INSTANCE VARIABLES

    private long bookId;
    private long authorId;
    private String title;
    private int length;
    private LocalDate dateStarted;
    private LocalDate dateEnded;

    public Book() {

    };

    //CONSTRUCTOR
    public Book (int bookId, long authorId, String title, int length, LocalDate dateStarted, LocalDate dateEnded){
        this.bookId = bookId;
        this.authorId = authorId;
        this.title = title;
        this.length = length;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
    }

    //GETTERS

    public long getBookId() {return this.bookId;}

    public long getAuthorId() {return this.authorId;}

    public String getTitle() {return this.title;}

    public int getLength() {return this.length;}

    public LocalDate getDateStarted() {return this.dateStarted;}

    public LocalDate getDateEnded() {return this.dateEnded;}

    //SETTERS

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(long authorId) {
        this.authorId = authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength (int length) {
        this.length= length;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setDateEnded(LocalDate dateFinished) {
        this.dateEnded = dateFinished;
    }


    //METHODS

    @Override
    public String toString() {
        return "model.Book{" +
                "bookId=" + bookId +
                ", authorId='" + authorId + '\'' +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", dateStarted=" + dateStarted +
                ", dateFinished=" + dateEnded +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && length == book.length && Objects.equals(authorId, book.authorId) && Objects.equals(title, book.title) && Objects.equals(dateStarted, book.dateStarted)
                && Objects.equals(dateEnded, book.dateEnded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, authorId, title, length, dateStarted, dateEnded);
    }
}
