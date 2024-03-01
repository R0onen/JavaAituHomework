import java.sql.SQLException;


interface BookDAO {
    void create(Book book) throws SQLException;
    Book read(int id) throws SQLException;
    Book[] readAll() throws SQLException;
    void update(Book book) throws SQLException;
    void delete(int id) throws SQLException;
}