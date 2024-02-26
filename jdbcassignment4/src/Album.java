import java.sql.*;
import java.util.Scanner;

class Album implements MusicItem {
    @Override
    public void create(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Album title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.print("Album release year: ");
        int year = scanner.nextInt();

        String sql = "INSERT INTO album(title, release) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, year);
            pstmt.executeUpdate();
        }
    }
    @Override
    public void read(Connection conn) throws SQLException {
        String sql = "SELECT * FROM album";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") + ", Album title: " + rs.getString("title") + ", Album release: " + rs.getInt("release"));
            }
        }
    }
    @Override
    public void update(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Album title: ");
        String title = scanner.nextLine();
        System.out.print("Album release year: ");
        int year = scanner.nextInt();

        String sql = "UPDATE album SET title=?, release=? WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, year);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                System.out.print("Success!");
            }
            else{
                System.out.print("No music with ID " + id);
            }
        }
    }
    @Override
    public void delete(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Album ID to delete: ");
        int id = scanner.nextInt();
        String sql = "DELETE FROM album WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                System.out.print("Success!");
            }
            else{
                System.out.print("No music with ID " + id);
            }
        }
    }
}