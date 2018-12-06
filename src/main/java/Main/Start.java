package Main;
import Basket.Basket;
import Basket.Buy;
import CatalogProducts.DataCatalog;
import CatalogProducts.DataProducts;
import Registration.Login;
import Registration.Registration;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start extends JFrame {
    public static Statement st;
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel panel = new JPanel();

    Start() throws SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        super("E-SHOP");
        int width = 800;
        int height = 627;
        setSize(width, height);
        panel.setLayout(cardLayout);
        panel.add(new Login(), "Login");
        panel.add(new Registration(), "Registration");
        panel.add(new DataProducts(), "DataProducts");
        panel.add(new Buy(), "Buy");
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        cardLayout.show(panel, "Login");
        try {
            st = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shop", "root", "root").createStatement();
            panel.add(new  DataCatalog(), "DataCatalog");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        panel.add(new Basket(), "Basket");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    try {
                        new Start();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}