package Registration;
public class UserInitialization {

    private static UserInitialization UserInitialization = new UserInitialization();

    private String userLogin;
    private int IdUser;

    /*This is a JavaDoc method
     * метод передаёт параметр getUserLogin
     * @return userLogin
     */
    public String getUserLogin() {
        return userLogin;
    }

    /*This is a JavaDoc method
     *метод передаёт параметр IdUser
     *@return IdUser
     */
    public int getId_user() {
        return IdUser;
    }

    /*This is a JavaDoc method
     *метод принимает параметр userLogin
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /*This is a JavaDoc method
     *метод принимает параметр IdUser
     */
    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    private UserInitialization() {
    }

    /*This is a JavaDoc method
     *метод позволяет использовать одну ссылку на объект
     @return UserInitialization
     */
    public static UserInitialization getInstance() { return UserInitialization; }

}