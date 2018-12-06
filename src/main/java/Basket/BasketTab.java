package  Basket;
import Main.Start;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Данный класс осуществляет получение данных о ID покупателя и ID товара,
 * который был выбран этим покупателем.
 * Эти данные служат для заполнения таблицы о покупателях и купленном ими товаре
 * и внесении полученных данных в таблицу MYSQL.
 * Так же в данном классе назначаются имена для столбцов таблицы.
 *
 * @author dmitri
 * @version 1.0
 */

public class BasketTab extends AbstractTableModel {

    private String ColumnName[] = {"id_buy", "id_buer", "idPr"};
    private ArrayList<Object[]> DataArrayList;

    /*This is a JavaDoc method
     * создание списка массива данных типа Object
     */

    public BasketTab() {
        DataArrayList = new ArrayList<>();

    }

    /*This is a JavaDoc method
     * получает количество колонок таблицы
     */
    public int getColumnCount() {

        return ColumnName.length;
    }
    /*This is a JavaDoc method
     *  @return Column name
     */

    public String getColumnName(int i) {
        return ColumnName[i];

    }

    /*This is a JavaDoc method
     *  @return количество строковых данных
     */
    public int getRowCount() {

        return DataArrayList.size();
    }

    /*This is a JavaDoc method
     * отвечает за отображение определённых данных
     * в определённых ячейках таблицы
     * в качестве параметров передаёт индекс строки и
     * и индекс столбца в таблице JTable
     *  @return индекс строки и ячейки
     */
    public Object getValueAt(int a, int b) {

        return DataArrayList.get(a)[b];
    }

    /*This is a JavaDoc method
     * добавляет данные в массив данных построчно
     */
    public void addDataBasket(Object[] row) {
        DataArrayList.add(row);

    }

    /*This is a JavaDoc method
     * выбирает данные из массива данных таблицы mysql
     * орабатывается исключение, при невозможности получения доступа
     * к таблице basket.
     */
    public void loadBasket() {

        try {
            ResultSet rs = Start.st.executeQuery("SELECT*FROM basket");
            while (rs.next()) {

                Object row[] = {rs.getInt("id_buy"), rs.getInt("id_buer"), rs.getInt("idPr"),

                };

                addDataBasket(row);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}

