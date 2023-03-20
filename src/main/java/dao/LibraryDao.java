package dao;

import model.Book;

import java.util.List;

public interface LibraryDao {

    //Get all books in user's library
    List<Book> getUserLibrary(long userId);

    //get details of specific book in loggedin user library (start date, finish date, length)
    Book getBook(long bookId);

    //get #of books read by loggedin user
    Integer getNumberOfBooksRead(long userId);

    //return all books read by loggedin user by specific author
    List<Book> getAllBooksByOneAuthor(long authorId);

    //return number of pages read by loggedin user
    Integer pagesRead(long UserId);




}
