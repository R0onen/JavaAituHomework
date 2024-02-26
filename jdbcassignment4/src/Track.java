import java.sql.*;
import java.util.Scanner;

class Track implements MusicItem {
    @Override
    public void create(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Track title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.print("Track duration: ");
        int duration = scanner.nextInt();

        String sql = "INSERT INTO track(title, duration) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, duration);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void read(Connection conn) throws SQLException {
        String sql = "SELECT * FROM track";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") + ", Track title: " + rs.getString("title") + ", Track duration: " + rs.getInt("duration"));
            }
        }
    }

    @Override
    public void update(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Track title: ");
        String title = scanner.nextLine();
        System.out.print("Track duration: ");
        int duration = scanner.nextInt();

        String sql = "UPDATE track SET title=?, duration=? WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, duration);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.print("Success!");
            } else {
                System.out.print("No music with ID " + id);
            }
        }
    }
    @Override
    public void delete(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Album ID to delete: ");
        int id = scanner.nextInt();
        String sql = "DELETE FROM track WHERE id=?";
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