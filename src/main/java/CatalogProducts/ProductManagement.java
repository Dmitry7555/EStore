/*
package CatalogProducts;

import Main.Start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductManagement {
    DataProducts dataProducts = new DataProducts();


    public ProductManagement() {
        dataProducts.enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = Start.st
                            .executeQuery("SELECT * FROM products where name=\'" + dataProducts.name.getText() + "\' ");
                    if (!rs.next()) {
                        Start.st.executeUpdate(
                                "INSERT INTO products (name, description, cost)  VALUES (\'" + dataProducts.name.getText()
                                        + "\'," + "\'" + dataProducts.description.getText() + "\',\'" + dataProducts.cost.getText() + "\')");
                    } else
                        JOptionPane.showMessageDialog(null, "This products there in catalogue");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        dataProducts.show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = Start.st.executeQuery("SELECT * FROM products where name='" + dataProducts.name.getText() + "' ");
                    while (rs.next()) {
                        String name = rs.getString("name");
                        System.out.println(name);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        dataProducts.listProductsDataAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = Start.st
                            .executeQuery("SELECT id_pr, name, cost, description FROM products ORDER BY cost");
                    while (rs.next()) {
                        DataCattalogTab dct = new DataCattalogTab();
                        String name = rs.getString("name");
                        int cost = rs.getInt("cost");
                        int id_pr = rs.getInt("id_pr");
                        String description = rs.getString("description");
                        System.out.println(
                                name + "\t|" + " cost-" + cost + ", " + "\t|" + dataProducts.description + "\t|" + "id " + id_pr);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        dataProducts.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ResultSet rs = Start.st.executeQuery("SELECT EXISTS(SELECT * FROM products)");
                    rs.next();
                    boolean exists = rs.getBoolean(1);
                    if (!exists) {
                        JOptionPane.showMessageDialog(null, "There is no such product");
                    } else {
                        System.out.println("DELETE FROM products WHERE name = " + "\"" + dataProducts.name.getText() + "\" " + "");
                        Start.st.executeUpdate(
                                "DELETE FROM products WHERE name = " + "\"" + dataProducts.name.getText() + "\" " + "");
                        JOptionPane.showMessageDialog(null, "Deleted Succesfully");
                    }
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        });

        dataProducts.orders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.cardLayout.show(Start.panel, "Basket");
            }
        });
    }
}*/
