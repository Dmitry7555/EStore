package Registration;
import Main.Start;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationBase {

    /*This is a JavaDoc method
     * получает данные из таблицы mysql Users сверяет их с данными
     * введённвми ранее зарегистрированными пользователем, при
     * совпадении дынных, предлагает пройти повторную регистрацию.
     * При несовпадении данных, вносит нового пользователя в базу данных
     * и направляет пользователя в каталог товаров.
     */
    public RegistrationBase() {
        try {
            ResultSet rs = Start.st
                    .executeQuery("SELECT login FROM users WHERE login='" + Registration.login.getText() + "'");
            if (!Registration.login.getText().equals("")) {
                if (!rs.next()) {
                    Start.st.executeUpdate("INSERT INTO users (name, login, password) VALUES ('"
                            + Registration.name.getText() + "','" +
                            Registration.login.getText() + "','" +
                            Registration.password.getText() + "')");
                    Start.cardLayout.show(Start.panel, "DataCatalog");
                } else
                    JOptionPane.showMessageDialog(null, "Try other login");
            } else
                JOptionPane.showMessageDialog(null, "Try other login");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
