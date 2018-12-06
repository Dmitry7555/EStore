package  CatalogProducts;
import Main.Start;
import Registration.UserInitialization;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

/* Класс получает данные из класса DataCattalogTab и вносит полученны е данные в таблицу.
 * Из данного класса осуществляется доступ к методу getValueAt класса DataCattalogTab
 * который проверяет CheckBox в колонке Select products.
 * После после нажатия кнопки buy осуществляется проверка на покупку товара и, если ничего не
 * куплено, появляется соообщение о невозможности покунуть магазин без покупки.
 * Если товар выбран, после нажатия кнопки buy осуществляется переход в класс Buy.
 * Из данного класса передаются общедоступные поля UserId и idProducts в класс BasketTab.
 *
 * @author dmitri
 * @version 1.0
 */

public class DataCatalog extends JPanel {
    DataCattalogTab dataCattalogTab = new DataCattalogTab();
   // public some_shit.an(dataCattalogTab);
    protected JButton buy = new JButton("Buy");
    static ProductsInitialization idProducts = ProductsInitialization.getInstanse();
    static UserInitialization UserId = UserInitialization.getInstance();
    static UserInitialization loginUser = UserInitialization.getInstance();
    int id_buer;
    int id_pr;

    /*This is a JavaDoc method
     * создаёт форму на которой отображаются товары и кнопки
     */
    public DataCatalog() throws InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchMethodException {
        setLayout(new BorderLayout());
        int left = 700;
        int top = 500;
        int width = 70;
        int height = 30;
        buy.setBounds(left, top, width, height);
        add(buy);
        dataCattalogTab.loadData();
        JTable tableProducts = new JTable(dataCattalogTab);
        tableProducts.setShowGrid(false);
        JScrollPane scroll = new JScrollPane(tableProducts);
        TableColumn tableColumn = new TableColumn();
        tableColumn = tableProducts.getColumnModel().getColumn(3);
        tableColumn.setCellEditor(tableProducts.getDefaultEditor(Boolean.class));
        tableColumn.setCellRenderer(tableProducts.getDefaultRenderer(Boolean.class));
        add(scroll);
        setVisible(true);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bool = false;
                for (int i = 0; i < dataCattalogTab.getRowCount(); i++) {
                    if (dataCattalogTab.getValueAt(i, 3).equals(true)) {
                        bool = true;
                        System.out.println("Ordered goods " + dataCattalogTab.getValueAt(i, 0));
                        System.out.println("Login buyer " + DataCatalog.loginUser.getUserLogin());
                        Start.cardLayout.show(Start.panel, "Buy");
                        try {
                            ResultSet rs = Start.st.executeQuery("SELECT id_pr FROM products WHERE name ='"
                                    + dataCattalogTab.getValueAt(i, 0) + "'");
                            while (rs.next()) {
                                id_pr = rs.getInt("id_pr");
                            }
                            DataCatalog.idProducts.setIdProducts(id_pr);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            ResultSet rs = Start.st.executeQuery("SELECT * FROM basket");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            Start.st.executeUpdate("INSERT INTO basket (id_buer, idPr) VALUES (" + DataCatalog.UserId.getId_user()
                                    + "," + id_pr + ") ");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}


