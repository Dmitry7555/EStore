package Registration;

import Main.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginInitialization {
    /*This is a JavaDoc method
     * получает данные из таблицы mysql Users сверяет их с данными
     * введённвми пользователем, при несовпадении дынных, предлагает
     * пройти повторную аутентификацию.
     * При совпадении данных - направляет пользователя в каталог товаров.
     */
    public LoginInitialization() {

        try {
            Login.loginUser.setUserLogin(Login.login.getText());
            ResultSet rs = Start.st.executeQuery("SELECT*FROM users");
            String getLogin = null;
            String getPassword = null;
            while (rs.next()) {
                int id_user = rs.getInt("id_user");
                getLogin = rs.getString("login");
                getPassword = rs.getString("password");
                Login.idUser.setIdUser(rs.getInt("id_user"));

                if (Login.login.getText().equals(getLogin) & Login.password.getText().equals(getPassword) & !Login.login.equals("1")) {
                    Start.cardLayout.show(Start.panel, "DataCatalog");
                    System.out.println("Next user in directorya:");
                    System.out.println("id " + id_user);
                    System.out.println("login " + getLogin);
                    System.out.println("password " + getPassword);
                    break;
                }
            }
            if (Login.login.getText().equals("1") & Login.password.getText().equals("1")) {
                Start.cardLayout.show(Start.panel, "DataProducts");
            }

            if (!Login.login.getText().equals(getLogin) & !Login.password.getText().equals(getPassword)) {
                JOptionPane.showMessageDialog(null, "Wrong login or password");
            }

        } catch (SQLException e1) {

            e1.printStackTrace();
        }
    }
}