import java.sql.*;
import java.util.Scanner;

interface MusicItem {
    void create(Connection conn, Scanner scanner) throws SQLException;
    void read(Connection conn) throws SQLException;
    void update(Connection conn, Scanner scanner) throws SQLException;
    void delete(Connection conn, Scanner scanner) throws SQLException;
}