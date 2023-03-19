package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private int totalBooksRead;
    private long bookId;
    private long userId;


    public Library(){};

    public Library (int totalBooksRead, long bookId, long userId){
        this.totalBooksRead = totalBooksRead;
        this.bookId = bookId;
        this.userId = userId;
    }

    public int getTotalBooksRead() {
        return totalBooksRead;
    }

    public void setTotalBooksRead(int totalBooksRead) {
        this.totalBooksRead = totalBooksRead;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return totalBooksRead == library.totalBooksRead && Objects.equals(bookId, library.bookId) && Objects.equals(userId, library.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalBooksRead, bookId, userId);
    }

    @Override
    public String toString() {
        return "Library{" +
                "totalBooksRead=" + totalBooksRead +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }


}
