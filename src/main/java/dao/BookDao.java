package dao;

import model.Book;

import java.util.List;

public interface BookDao {

    //Save book Object
    Book saveBook(Book bookToSave);

    //Add Book To Loggedin User Library
    void addBookToLibrary(Long userId, Book book);

    //Update instance of book (date_ended)
    boolean updateBook (long bookId, Book book);


}
