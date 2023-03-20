package dao;

import model.Author;

import java.util.List;

public interface AuthorDao {

    //Get list of books by specific author in loogedinuserlibrary
    List<Author> getListOfBooksByAuthorId();

    //Get list of all loggedin users authors
    List<Author> getListOfPrincipalAuthorsRead();


}
