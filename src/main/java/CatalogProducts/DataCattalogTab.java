package  CatalogProducts;
import Main.Start;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* В данном классе осуществляется получение данных о товаре из таблицы MYSQL,
 * назначаются имена для столбцов таблицы, осуществлляется проверка начилия
 * CheckBox в колонке Select products.
 *
 * @author dmitri
 * @version 1.0
 */
class DataCattalogTab extends AbstractTableModel {
    public String[] ColumnName = {"Name", "Description", "Cost", "Select products"};
    public ArrayList<Object[]> DAL;

    /*This is a JavaDoc method
     * создаёт массив данных типа Object
     */
    public DataCattalogTab() {
        DAL = new ArrayList<>();
    }

    /*This is a JavaDoc method
     *получает количество колонок в таблице
     *  * @return количество колонок
     */
    public int getColumnCount() {
        return ColumnName.length;
    }

    /*This is a JavaDoc method
     *получает имена колонок в таблице
     *@return внутри метода проверяется
     *индекс и возвращается соответствующее
     *имя колонки
     */
    public String getColumnName(int i) {
        return ColumnName[i];
    }

    /*This is a JavaDoc method
     *получает количество строк в таблице
     *@return количество строк
     */
    public int getRowCount() {
        return DAL.size();
    }

    /*This is a JavaDoc method
     *отвечает за получение данных из таблицы
     *Методу в качестве параметров
     *передаетяс индекс строки и столбца ячейки
     */
    public Object getValueAt(int a, int b) {
        return DAL.get(a)[b];
    }

    /*This is a JavaDoc method
     *отвечает за получение данных из массива строк
     */
    public void addData(Object[] row) {
        DAL.add(row);
    }

    /*This is a JavaDoc method
     *получает доступ к таблице mysql - products
     *при невозможности получения доступа к таблице обрабатывает ошибку
     */
    public void loadData() {
        try {
            ResultSet rs = Start.st.executeQuery("SELECT*FROM products");
            while (rs.next()) {
                Object[] row = {
                        rs.getString("name"), rs.getString("description"), rs.getInt("cost"), false};
                addData(row);
                rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*This is a JavaDoc method
     * проверяет, редактируема ли ячейка JTable индекс
     * строки и столбца которой передаются методу в качестве параметра
     */
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    /*This is a JavaDoc method
     *отвечает за то, какие данные в каких ячейках
     *будут передаваться. Методу в качестве параметров
     *передаетяс индекс строки и столбца ячейки
     */
    public void setValueAt(Object value, int a, int b) {
        DAL.get(a)[b] = value;
        fireTableCellUpdated(a, b);
    }

}