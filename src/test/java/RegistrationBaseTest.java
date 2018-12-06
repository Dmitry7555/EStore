import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class RegistrationBaseTest {
    public static Statement st;

    @Test
    public void RegistrationBaseTest() {
        try {
            st = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shop", "root", "root").createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.executeUpdate("DELETE  FROM users");
            st.executeUpdate("ALTER TABLE users AUTO_INCREMENT = 1");
            st.executeUpdate("INSERT INTO users (login, name, password) VALUES (2,2,2)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
