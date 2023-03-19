package model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {



    //INSTANCE VARIABLES

    private long bookId;
    private long authorId;
    private String title;
    private int totalPages;
    private LocalDate dateStarted;
    private LocalDate dateFinished;
    //
    // !!! ISBN ATTRIBUTE? !!!

    //CONSTRUCTOR
    public Book (int bookId, long authorId, String title, int totalPages, LocalDate dateStarted, LocalDate dateFinished){
        this.bookId = bookId;
        this.authorId = authorId;
        this.title = title;
        this.totalPages = totalPages;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
    }

    //GETTERS

    public long getBookId() {return this.bookId;}

    public long getAuthorId() {return this.authorId;}

    public String getTitle() {return this.title;}

    public int getTotalPages() {return this.totalPages;}

    public LocalDate getDateStarted() {return this.dateStarted;}

    public LocalDate getDateFinished() {return this.dateFinished;}

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

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setDateFinished(LocalDate dateFinished) {
        this.dateFinished = dateFinished;
    }


    //METHODS

    @Override
    public String toString() {
        return "model.Book{" +
                "bookId=" + bookId +
                ", authorId='" + authorId + '\'' +
                ", title='" + title + '\'' +
                ", totalPages=" + totalPages +
                ", dateStarted=" + dateStarted +
                ", dateFinished=" + dateFinished +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && totalPages == book.totalPages && Objects.equals(authorId, book.authorId) && Objects.equals(title, book.title) && Objects.equals(dateStarted, book.dateStarted) && Objects.equals(dateFinished, book.dateFinished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, authorId, title, totalPages, dateStarted, dateFinished);
    }
}
