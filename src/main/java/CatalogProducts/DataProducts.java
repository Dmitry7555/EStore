package CatalogProducts;

import Main.Start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Данный класс предназначен только для администратора сайта.
 * В этом классе администратор может внести в базу данных новый товар
 * Для ввода подходят любые сиимволы(осуществлляется проверка товара в
 * базе с введённой позицией на поступление. При сововпадении всплывает
 * ошибка, о наличии такого товара в базе.), удалить из базы данных товар
 * осуществлляется проверка товара в базе с введённой позицией на удаление.
 * При невовпадении всплывает ошибка.), вывести на просмотр отдельную
 * позицию по товару, а так же вывести в консоль  весь имеющийся в магизине
 * товар (с сортировкой по стоимости). Из данного класса осуществляется
 * переход на страницу с заказами, класс Basket.
 *
 * @author dmitri
 * @version 1.0
 */
public class DataProducts extends JPanel {
    protected JTextField name = new JTextField();
    protected JTextField description = new JTextField();
    protected JTextField cost = new JTextField();
    protected JButton enter = new JButton("save");
    protected JButton delete = new JButton("delete");
    protected JButton show = new JButton("show");
    protected JButton orders = new JButton("orders");
    protected JLabel Name = new JLabel("Name");
    protected JLabel Description = new JLabel("Description");
    protected JLabel Cost = new JLabel("Cost");
    protected JButton listProductsDataAdmin = new JButton("lowest price sort");

    /*This is a JavaDoc method
     * создаёт форму для внесения записей в таблицу products
     * наформе отображаются кнопки ячейки и подписи к ячейкам
     */
    public DataProducts() {

        setLayout(null);
        int leftEnterButton = 250;
        int topEnterButton = 150;
        int widthEnterButton = 300;
        int heightEnterButton = 20;
        enter.setBounds(leftEnterButton, topEnterButton, widthEnterButton, heightEnterButton);
        int leftNameText = 250;
        int topNameText = 200;
        int widthNameText = 300;
        int heightNameText = 20;
        name.setBounds(leftNameText, topNameText, widthNameText, heightNameText);
        int leftNamePromt = 100;
        int topNamePromt = 200;
        int widthNamePromt = 50;
        int heightNamePromt = 20;
        Name.setBounds(leftNamePromt, topNamePromt, widthNamePromt, heightNamePromt);
        int leftDescriptionText = 250;
        int topDescriptionText = 250;
        int widthDescriptionText = 300;
        int heightDescriptionText = 20;
        description.setBounds(leftDescriptionText, topDescriptionText, widthDescriptionText, heightDescriptionText);
        int leftDescriptionPromt = 100;
        int topDescriptionPromt = 250;
        int widthDescriptionPromt = 120;
        int heightDescriptionPromt = 20;
        Description.setBounds(leftDescriptionPromt, topDescriptionPromt, widthDescriptionPromt, heightDescriptionPromt);
        int leftCostText = 250;
        int topCostText = 300;
        int widthCostText = 300;
        int heightCostText = 20;
        cost.setBounds(leftCostText, topCostText, widthCostText, heightCostText);
        int leftCostDescription = 100;
        int topCostDescription = 300;
        int widthCostDescription = 50;
        int heightCostDescription = 20;
        Cost.setBounds(leftCostDescription, topCostDescription, widthCostDescription, heightCostDescription);
        int leftBoundShow = 250;
        int topBoundShow = 350;
        int widthBoundShow = 300;
        int heightBoundShow = 30;
        show.setBounds(leftBoundShow, topBoundShow, widthBoundShow, heightBoundShow);
        int leftBoundListProducts = 250;
        int topBoundListProducts = 400;
        int widthBoundListProducts = 300;
        int heightBoundListProducts = 30;
        listProductsDataAdmin.setBounds(leftBoundListProducts, topBoundListProducts, widthBoundListProducts, heightBoundListProducts);
        int leftBoundDelete = 250;
        int topBoundDelete = 450;
        int widthBoundDelete = 300;
        int heightBoundDelete = 30;
        delete.setBounds(leftBoundDelete, topBoundDelete, widthBoundDelete, heightBoundDelete);
        int leftBoundOrders = 250;
        int topBoundOrders = 500;
        int widthBoundOrders = 300;
        int heightBoundOrders = 30;
        orders.setBounds(leftBoundOrders, topBoundOrders, widthBoundOrders, heightBoundOrders);
        add(Name);
        add(enter);
        add(name);
        add(description);
        add(cost);
        add(show);
        add(Description);
        add(Cost);
        add(listProductsDataAdmin);
        add(delete);
        add(orders);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = Start.st
                            .executeQuery("SELECT * FROM products where name=\'" + name.getText() + "\' ");
                    if (!rs.next()) {
                        Start.st.executeUpdate(
                                "INSERT INTO products (name, description, cost)  VALUES (\'" + name.getText()
                                        + "\'," + "\'" + description.getText() + "\',\'" + cost.getText() + "\')");
                    } else
                        JOptionPane.showMessageDialog(null, "This products there in catalogue");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        show.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = Start.st.executeQuery("SELECT * FROM products where name='" + name.getText() + "' ");
                    while (rs.next()) {
                        String name = rs.getString("name");
                        System.out.println(name);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        listProductsDataAdmin.addActionListener(new ActionListener() {

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
                                name + "\t|" + " cost-" + cost + ", " + "\t|" + description + "\t|" + "id " + id_pr);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        delete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                try {
                    ResultSet rs = Start.st.executeQuery("SELECT EXISTS(SELECT * FROM products)");
                    rs.next();
                    boolean exists = rs.getBoolean(1);
                    if (!exists) {
                        JOptionPane.showMessageDialog(null, "There is no such product");
                    } else {
                        System.out.println("DELETE FROM products WHERE name = " + "\"" + name.getText() + "\" " + "");
                        Start.st.executeUpdate(
                                "DELETE FROM products WHERE name = " + "\"" + name.getText() + "\" " + "");
                        JOptionPane.showMessageDialog(null, "Deleted Succesfully");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        orders.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                Start.cardLayout.show(Start.panel, "Basket");
            }
        });
    }
}
