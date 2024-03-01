import java.sql.*;

public class PostgreSQLBookDAO implements BookDAO {
    private final Connection connection;

    public PostgreSQLBookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.executeUpdate();
        }
    }

    @Override
    public Book read(int id) throws SQLException {
        String query = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Book(resultSet.getInt("id"), resultSet.getString("title"),
                            resultSet.getString("author"), resultSet.getInt("year"));
                }
            }
        }
        return null;
    }

    @Override
    public Book[] readAll() throws SQLException {
        String query = "SELECT * FROM books";
        try (Statement countStatement = connection.createStatement();
             ResultSet countResultSet = countStatement.executeQuery(query)) {
            countResultSet.next();
            int rowCount = countResultSet.getInt(1);
            Book[] books = new Book[rowCount];
            query = "SELECT * FROM books";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                int index = 0;
                while (resultSet.next()) {
                    books[index++] = new Book(resultSet.getInt("id"), resultSet.getString("title"),
                            resultSet.getString("author"), resultSet.getInt("year"));
                }
            }
            return books;
        }
    }

    @Override
    public void update(Book book) throws SQLException {
        String query = "UPDATE books SET title = ?, author = ?, year = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setInt(4, book.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}