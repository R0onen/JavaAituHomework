import java.sql.*;

public class LibrarySystem{
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "admin";

    public void run() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            BookDAO bookDAO = new PostgreSQLBookDAO(connection);

            Book book1 = new Book("Java Programming", "John Doe", 2020);
            bookDAO.create(book1);

            System.out.println(bookDAO.read(1));

            book1.setYear(2021);
            bookDAO.update(book1);

            Book[] books = bookDAO.readAll();
            for (Book book : books) {
                System.out.println(book);
            }

            bookDAO.delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}