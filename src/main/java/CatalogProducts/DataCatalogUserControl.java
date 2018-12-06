/*package CatalogProducts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;1
import java.sql.SQLException;

public class DataCatalogUserControl {
    DataCatalog dataCatalog = new DataCatalog();

    *//*This is a JavaDoc method
     *получает значение true or false из третьей колонки
     * метод даёт возможность редактирования 3-ей колонки
     * орабатывается исключение, при невозможности получения доступа
     * к базе данных mysql - products и к базе данных - basket
     * орабатывается исключение, при невозможности внесения данных в
     * базу mysql - basket
     *//*

    public DataCatalogUserControl() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        boolean bool = false;
        for (int i = 0; i < dataCatalog.getRowCount(); i++) {
            if (DataCattalogTab.getValueAt(i, 3).equals(true)) {
                bool = true;
                System.out.println("Ordered goods " + dataCatalog.dataCattalogTab.getValueAt(i, 0));
                System.out.println("Login buyer " + DataCatalog.loginUser.getUserLogin());
                Start.cardLayout.show(Start.panel, "Buy");
                try {
                    ResultSet rs = Start.st.executeQuery("SELECT id_pr FROM products WHERE name ='"
                            + dataCatalog.dataCattalogTab.getValueAt(i, 0) + "'");
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
}
    }

            }*/
