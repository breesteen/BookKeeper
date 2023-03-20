package dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLibraryDao implements LibraryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLibraryDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

@Override
public List<Book> getUserLibrary(long userId){

    String sql1 = "SELECT user_id FROM bk_user_book WHERE user_id = ?";

    Long loggedInUserId = jdbcTemplate.queryForObject(sql1, Long.class, userId);

    List<Book> principalBooks = new ArrayList<>();
    String sql = "SELECT title, author_id FROM book b" +
            "Join bk_user_book ub ON b.book_id = ub.book_id" +
            "WHERE user_id = ?";

    SqlRowSet result = jdbcTemplate.queryForRowSet(sql, loggedInUserId);
    while(result.next()){
        principalBooks.add(mapPrincipalBooks(result));
    }

    return principalBooks;
}

@Override
public Book getBook(long bookId){
        String sql = "SELECT b.book_id, author_id, title, length, date_started, date_ended FROM book " +
                "JOIN bk_user_book ub ON b.book_id = ub.book_id" +
                "WHERE ub.book_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, bookId);
        Book book = new Book();

        if(result.next()){
            book = mapRowToBook(result);
        }
        return book;
}

@Override
public Integer getNumberOfBooksRead(long userId){
        String sql1 = "SELECT user_id FROM bk_user_book WHERE user_id = ?";

        Long loggedInUser = jdbcTemplate.queryForObject(sql1, Long.class, userId);

        String sql = "SELECT COUNT(book_id)" +
                "FROM bk_user_book WHERE user_id = ?";

        Integer countOfBooks = jdbcTemplate.queryForObject(sql, Integer.class, loggedInUser);
        return countOfBooks;
}

public List<Book> getAllBooksByOneAuthor(long authorId){
        String sql = "SELECT title From book " +
                "JOIN author a ON b.author_id = a.author_id" +
                "WHERE a.author_id = ?";

        List<Book> booksByAuthor = new ArrayList<>();

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, authorId);


        while(result.next()){
            booksByAuthor.add(mapPrincipalBooks(result));
        }
        return booksByAuthor;
}

public Integer pagesRead(long userId){

    String sql1 = "SELECT user_id FROM bk_user_book WHERE user_id = ?";
    Long loggedInUser = jdbcTemplate.queryForObject(sql1, Long.class, userId);



    String sql = "JOIN bk_user_book ub ON b.book_id=ub.book_id " +
                "WHERE b.length IS NOT NULL AND ub.user_id = ?";

    Integer totalPagesRead = jdbcTemplate.queryForObject(sql, Integer.class, loggedInUser);
    return totalPagesRead;
}





    //users library mapper
    public Book mapPrincipalBooks(SqlRowSet bookrowSet){
        Book book = new Book();
        book.setTitle(bookrowSet.getString("title"));
        book.setAuthor(bookrowSet.getLong("author_id"));
        return book;
}



    // specific Instance of Book mapper
    private Book mapRowToBook(SqlRowSet bookRowSet){
        Book book = new Book();
        book.setBookId(bookRowSet.getLong("book_id"));
        book.setAuthor(bookRowSet.getLong("author_id"));
        book.setTitle(bookRowSet.getString("title"));
        book.setLength(bookRowSet.getInt("length"));
        if(bookRowSet.getDate("date_started") != null){
            book.setDateStarted(bookRowSet.getDate("date_started").toLocalDate());
        }
        if(bookRowSet.getDate("date_ended")!= null){
            book.setDateEnded(bookRowSet.getDate("date_ended").toLocalDate());
        }
        return book;
    }
}
