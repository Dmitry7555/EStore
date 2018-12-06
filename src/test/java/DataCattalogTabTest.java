import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataCattalogTabTest {
    public static Statement st;

    @Test
    public void loadData() {
        try {
            st = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shop", "root", "root").createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
           // st.executeUpdate("SET foreign_key_checks = 0;");
            st.executeUpdate("DELETE FROM products");
            st.executeUpdate("ALTER TABLE products AUTO_INCREMENT = 1");
            st.executeUpdate("INSERT INTO products (name, description, cost) VALUES ('Canon','scaner',9)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}