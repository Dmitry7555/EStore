package  Basket;
/** Этот клас служит для вывода на экран данных из таблицы BasketTab.
 * К нему имеет доступ только администратор.

 @author dmitri
 @version 1.0
 */
import javax.swing.*;
import java.awt.*;

public class Basket extends JPanel {
  BasketTab basketTab = new BasketTab();

    /*This is a JavaDoc method
     * @param loadBasket
     * @return basketTab
     */

    public Basket() {

        setLayout(new BorderLayout());
        basketTab.loadBasket();
        JTable tab = new JTable(basketTab);
        JScrollPane scroll = new JScrollPane(tab);
        add(scroll);
        setVisible(true);

    }
}