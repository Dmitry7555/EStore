package Registration;

import Main.Start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/* В данном классе осуществляется регистрация новых пользователей сайта.
 * Для ввода подходят любые сиимволы.
 * Проверка Login пользователя с уже зарегестрированными пользователями.
 * При наличии совпадения Login регистрируемого пользователя с уже зарегестрированным пользователем
 * выводится сообщение о совпадении и просьбой придумать другой логин.
 * После успешной регистрации вновь зарегистрированный пользователь переходит на вкладку с товаром.
 *
 * @author dmitri
 * @version 1.0
 */

public class Registration extends JPanel {

    protected static JTextField login = new JTextField();
    protected static JTextField name = new JTextField();
    protected static JPasswordField password = new JPasswordField();
    protected JButton Registration = new JButton("Registration");
    protected JButton Back = new JButton("Back");
    protected JLabel Name = new JLabel("Name");
    protected JLabel Login = new JLabel("Login");
    protected JLabel Password = new JLabel("Password");

    /*This is a JavaDoc method
     * создаёт форму для прохождения регистрации пользователя
     * на форме отображаются кнопки ячейки и подписи к ячейкам
     */
    public Registration() throws SQLException {
        setLayout(null);
        int leftLogin = 250;
        int topLogin = 150;
        int widthLogin = 300;
        int heightLogin = 30;
        login.setBounds(leftLogin, topLogin, widthLogin, heightLogin);
        int leftPassword = 250;
        int topPassword = 200;
        int widthPassword = 300;
        int heightPassword = 30;
        password.setBounds(leftPassword, topPassword, widthPassword, heightPassword);
        int leftName = 250;
        int topName = 100;
        int widthName = 300;
        int heightName = 30;
        name.setBounds(leftName, topName, widthName, heightName);
        int leftRegistration = 250;
        int topRegistration = 250;
        int widthRegistration = 300;
        int heightRegistration = 30;
        Registration.setBounds(leftRegistration, topRegistration, widthRegistration, heightRegistration);
        int leftNamePromt = 150;
        int topNamePromt = 100;
        int widthNamePromt = 40;
        int heightNamePromt = 20;
        Name.setBounds(leftNamePromt, topNamePromt, widthNamePromt, heightNamePromt);
        int leftLoginPromt = 150;
        int topLoginPromt = 150;
        int widthLoginPromt = 40;
        int heightLoginPromt = 20;
        Login.setBounds(leftLoginPromt, topLoginPromt, widthLoginPromt, heightLoginPromt);
        int leftPasswordPromt = 150;
        int topPasswordPromt = 200;
        int widthPasswordPromt = 70;
        int heightPasswordPromt = 20;
        Password.setBounds(leftPasswordPromt, topPasswordPromt, widthPasswordPromt, heightPasswordPromt);
        int leftBoundBack = 250;
        int topBoundBack = 300;
        int widthBoundBack = 300;
        int heightBoundBack = 30;
        Back.setBounds(leftBoundBack, topBoundBack, widthBoundBack, heightBoundBack);
        add(login);
        add(password);
        add(Registration);
        add(name);
        add(Name);
        add(Login);
        add(Password);
        add(Back);

        Registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationBase registrationBase =new RegistrationBase();
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.cardLayout.show(Start.panel, "Login");
            }
        });
    }
}