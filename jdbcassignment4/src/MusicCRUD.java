import java.sql.*;
import java.util.Scanner;

public class MusicCRUD {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "admin";

    public void run() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Scanner scanner = new Scanner(System.in);
            MusicItemFactory musicItemFactory = new MusicItemFactory();
            while (true) {
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createmusicItem(conn, scanner, musicItemFactory);
                        break;
                    case 2:
                        readmusicItem(conn, scanner, musicItemFactory);
                        break;
                    case 3:
                        updatemusicItem(conn, scanner, musicItemFactory);
                        break;
                    case 4:
                        deletemusicItem(conn, scanner, musicItemFactory);
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

    private static void createmusicItem(Connection conn, Scanner scanner, MusicItemFactory musicItemFactory) throws SQLException {
        System.out.println("Select the type of music item to create (album/track): ");
        String itemType = scanner.next();

        MusicItem musicItem = musicItemFactory.MusicItem(itemType);
        if (musicItem != null) {
            musicItem.create(conn, scanner);
        } else {
            System.out.println("Invalid music item type.");
        }
    }

    private static void readmusicItem(Connection conn, Scanner scanner, MusicItemFactory musicItemFactory) throws SQLException {
        System.out.println("Select the type of music item to read (album/track): ");
        String itemType = scanner.next();

        MusicItem musicItem = musicItemFactory.MusicItem(itemType);
        if (musicItem != null) {
            musicItem.read(conn);
        } else {
            System.out.println("Invalid music item type.");
        }
    }

    private static void updatemusicItem(Connection conn, Scanner scanner, MusicItemFactory musicItemFactory) throws SQLException {
        System.out.println("Select the type of music item to read (album/track): ");
        String itemType = scanner.next();

        MusicItem musicItem = musicItemFactory.MusicItem(itemType);
        if (musicItem != null) {
            musicItem.update(conn, scanner);
        } else {
            System.out.println("Invalid music item type.");
        }
    }
    private static void deletemusicItem(Connection conn, Scanner scanner, MusicItemFactory musicItemFactory) throws SQLException {
        System.out.println("Select the type of music item to read (album/track): ");
        String itemType = scanner.next();

        MusicItem musicItem = musicItemFactory.MusicItem(itemType);
        if (musicItem != null) {
            musicItem.delete(conn, scanner);
        } else {
            System.out.println("Invalid music item type.");
        }
    }

}
