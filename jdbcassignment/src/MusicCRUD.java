import java.sql.*;
import java.util.Scanner;

public class MusicCRUD {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "admin";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Create Music Collection");
                System.out.println("2. Read Music Collection");
                System.out.println("3. Update Music Collection");
                System.out.println("4. Delete Music Collection");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createmusic(conn, scanner);
                        break;
                    case 2:
                        readmusic(conn);
                        break;
                    case 3:
                        updatemusic(conn, scanner);
                        break;
                    case 4:
                        deletemusic(conn, scanner);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createmusic(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Music title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.print("Enter Music Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Music release year: ");
        int year = scanner.nextInt();

        String sql = "INSERT INTO music(title, genre, release) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setInt(3, year);
            pstmt.executeUpdate();
            System.out.println("Success!");
        }
    }

    private static void readmusic(Connection conn) throws SQLException {
        String sql = "SELECT * FROM music";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Title: " + rs.getString("title") +
                                ", Genre: " + rs.getString("genre") +
                                ", Release: " + rs.getInt("release"));
            }
        }
    }

    private static void updatemusic(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Music ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Music title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new Music genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter new Music release year: ");
        int year = scanner.nextInt();

        String sql = "UPDATE music SET title=?, genre=?, release=? WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setInt(3, year);
            pstmt.setInt(4, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Success!");
            } else {
                System.out.println("No Music found with ID " + id);
            }
        }
    }

    private static void deletemusic(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Music ID to delete: ");
        int id = scanner.nextInt();
        String sql = "DELETE FROM music WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Success!");
            } else {
                System.out.println("No Music found with ID " + id);
            }
        }
    }
}
