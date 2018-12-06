package Registration;

import Main.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * В данном классе осуществляется проверка введённых пользователем данных (для ввода подходят
 * любые сиимволы) на совпадение с имеющимися данными о пользователях в базе данных.
 * После успешной проверки пользователь переходит на вкладку с товаром.
 * При несовпадении данных введённых пользователем в поля Login и Password с данными в базе
 * данных о зарегистрированных пользователях, появляется сообщение об ошибке и пользователь
 * может повторить аутентификацию.
 * Если это не зарегистрированный пользователь, то при нажатии на кнопку Registration осуществляется
 * переход на вкладку для регистрации нового пользователя.
 * Если на сайт входит администратор, то он переходит на страницу для осуществления правки товара.
 *
 * @author dmitri
 * @version 1.0
 */

public class Login extends JPanel {
    public static JTextField login = new JTextField();
    public static JPasswordField password = new JPasswordField();
    private JButton Enter = new JButton("Enter");
    public JButton RegistrationUser = new JButton("Registration");
    public JLabel LoginRegistration = new JLabel("Login");
    public JLabel PasswordRegistration = new JLabel("Password");
    static UserInitialization loginUser = UserInitialization.getInstance();
    static UserInitialization idUser = UserInitialization.getInstance();

    /*This is a JavaDoc method
     * создаёт форму для прохождения аутентификации пользователя
     * на форме отображаются кнопки ячейки и подписи к ячейкам
     */
    public Login() throws SQLException {

        setLayout(new BorderLayout());
        setLayout(null);
        int leftLogin = 250;
        int topLogin = 100;
        int widthLogin = 300;
        int heightLogin = 30;
        login.setBounds(leftLogin, topLogin, widthLogin, heightLogin);
        int leftPassword = 250;
        int topPassword = 150;
        int widthPassword = 300;
        int heightPassword = 30;
        password.setBounds(leftPassword, topPassword, widthPassword, heightPassword);
        int leftEnterButton = 250;
        int topEnterButton = 200;
        int widthEnterButton = 300;
        int heightEnterButton = 30;
        Enter.setBounds(leftEnterButton, topEnterButton, widthEnterButton, heightEnterButton);
        int leftRegistrationUser = 250;
        int topRegistrationUser = 250;
        int widthRegistrationUser = 300;
        int heightRegistrationUser = 30;
        RegistrationUser.setBounds(leftRegistrationUser, topRegistrationUser, widthRegistrationUser,
                heightRegistrationUser);
        int leftLoginEntrance = 150;
        int topLoginEntrance = 100;
        int widthLoginEntrance = 70;
        int heightLoginEntrance = 30;
        LoginRegistration.setBounds(leftLoginEntrance, topLoginEntrance, widthLoginEntrance, heightLoginEntrance);
        int leftPasswordEntrance = 150;
        int topPasswordEntrance = 150;
        int widthPasswordEntrance = 70;
        int heightPasswordEntrance = 30;
        PasswordRegistration.setBounds(leftPasswordEntrance, topPasswordEntrance, widthPasswordEntrance,
                heightPasswordEntrance);
        add(login);
        add(password);
        add(Enter);
        add(RegistrationUser);
        add(LoginRegistration);
        add(PasswordRegistration);
        RegistrationUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Start.cardLayout.show(Start.panel, "Registration");
            }
        });
        Enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LoginInitialization loginInitialization = new LoginInitialization();

            }
        });

    }
}