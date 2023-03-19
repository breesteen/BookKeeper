package dao;

import model.Author;

import java.util.List;

public interface AuthorDao {


    Author getAuthorById();

    List<Author> getListOfAllAuthors();

    List<Author> getListOfBooksByAuthorId();

    List<Author> getListOfPrincipalAuthorsRead();

    List<Author> getListOfPrincipalBooksReadByAuthorId();


}
