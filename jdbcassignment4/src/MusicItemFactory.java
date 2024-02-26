import java.sql.*;
import java.util.Scanner;

class MusicItemFactory {
    public MusicItem MusicItem(String itemType) {
        switch (itemType.toLowerCase()) {
            case "album":
                return new Album();
            case "track":
                return new Track();
            default:
                throw new IllegalArgumentException("Invalid music item type.");
        }
    }
}