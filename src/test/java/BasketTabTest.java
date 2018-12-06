import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class BasketTabTest {
    public static Statement st;

    @Test
    public void loadBasket() {
        try {
            st = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shop", "root", "root").createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.executeUpdate("DROP DATABASE shop");
            st.executeUpdate("CREATE DATABASE shop");
            st.executeUpdate("USE shop");
            st.executeUpdate("CREATE TABLE users(id_user int (10)  AUTO_INCREMENT,login VARCHAR(15) UNIQUE NOT NULL, name VARCHAR (15) NOT NULL, password VARCHAR(15) NOT NULL, PRIMARY KEY (id_user))");
            st.executeUpdate("CREATE TABLE products(id_pr int (10) AUTO_INCREMENT, name VARCHAR(15) UNIQUE NOT NULL, description VARCHAR (15) NOT NULL,cost int (10) NOT NULL, PRIMARY KEY (id_pr))");
            st.executeUpdate("CREATE TABLE basket(id_buy int (10) AUTO_INCREMENT,id_buer int(10) , idPr int (10) NOT NULL, PRIMARY KEY (id_buy), FOREIGN KEY (id_buer) REFERENCES users (id_user),FOREIGN KEY (idPr) REFERENCES products(id_pr))");
            st.executeUpdate("INSERT INTO users (login, name, password) VALUES (1,1,1)");
            st.executeUpdate("INSERT INTO products (name, description, cost) VALUES ('HP','printer',10)");
            st.executeUpdate("INSERT INTO basket (id_buy, id_buer, idPr) VALUES (1,1,1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}