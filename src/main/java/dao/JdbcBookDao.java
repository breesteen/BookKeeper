package dao;
import model.Book;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcBookDao implements BookDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}



    @Override
    public Book saveBook(Book bookToSave){
        String sql1 = "INSERT INTO book (DEFAULT, ?, ? ?, ?, ?,?)";
        Long bookId = jdbcTemplate.queryForObject(sql1, Long.class, bookToSave.getAuthorId(), bookToSave.getTitle(),bookToSave.getLength(),
                bookToSave.getDateStarted(), bookToSave.getDateEnded());
        bookToSave.setBookId(bookId);
        return bookToSave;


    }

    @Override
    public void addBookToLibrary(Long userId, Book bookToAdd){

        saveBook(bookToAdd);

        String sql1 = "SELECT user_id FROM bk_user_book WHERE user_id = ?";
        Long loggedInUser= jdbcTemplate.queryForObject(sql1, Long.class, userId);

        String sql2 = "INSERT INTO bk_user_book VALUES (?,?)";
       jdbcTemplate.update(sql2, loggedInUser, bookToAdd.getBookId());

    }

    @Override
    public boolean updateBook(long bookId, Book bookChanged){
        String sql = "UPDATE book SET title = ?, author_id = ?, length = ?, isbn = ?, date_started = ?, date_ended = ? WHERE book_id = ?";
        return jdbcTemplate.update(sql, bookChanged.getTitle(), bookChanged.getAuthorId(), bookChanged.getLength(),
                bookChanged.getDateStarted(), bookChanged.getDateEnded(), bookId) == 1;
    }


}
