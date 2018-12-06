package  CatalogProducts;
/**
 * * Данный класс получает поле  класса IdProducts из класса DataCatalog и предоставляет доступ
 * * к полученным полям из любого места в проекте.
 *
 * @author dmitri
 * @version 1.0
 */
public class ProductsInitialization {

    private static ProductsInitialization ProductsInitialization = new ProductsInitialization();
    private int IdProducts;

    /*This is a JavaDoc method
     * @param getIdProducts
     * @return IdProducts
     */
    public int getIdProducts() {return IdProducts; }
    /*This is a JavaDoc method
     *метод принимает параметр IdProducts
     */
    public void setIdProducts(int IdProducts) {this.IdProducts = IdProducts; }

    private ProductsInitialization() {
    }
    /*This is a JavaDoc method
     *метод позволяет использовать одну ссылку на объект
     @return ProductsInitialization
     */
    public static ProductsInitialization getInstanse() {
        return ProductsInitialization;
    }
}