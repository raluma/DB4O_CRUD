package controller;

import model.Queries;
import model.User;
import view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginCtrl implements ActionListener {
    private final Login login;
    private final Queries queries;

    private void windowConfig() {
        this.login.setTitle("Inicio de Sesión");
        this.login.setLocationRelativeTo(null);
        this.login.setSize(700, 400);
        this.login.setVisible(true);
    }

    public LoginCtrl() {
        this.login = new Login();
        this.windowConfig();

        this.queries = new Queries();
        this.login.getLoginBtn().addActionListener(this);
        this.login.getSignupBtn().addActionListener(this);

        this.queries.createUser("admin", "admin","admin@tac7.com",  "Admin");
    }

    private void checkPassword(User user) {
        if (!Objects.equals(user.getPassword(), new String(this.login.getPassTxt().getPassword()))) {
            JOptionPane.showMessageDialog(null,
                    "La contraseña es errónea. Vuelva a intertarlo.");
        } else {
            if (Objects.equals(user.getRole(), "User")) {
                new UserCtrl(user);
            } else if (Objects.equals(user.getRole(), "Admin")) {
                new AdminCtrl();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getLoginBtn()) {

            if (this.queries.readUserByUserName(this.login.getUserTxt().getText()) == null &&
                    this.queries.readUserByEmail(this.login.getUserTxt().getText()) == null) {

                JOptionPane.showMessageDialog(null,
                        "El Usuario no existe. Vuelva a intertarlo");

            } else {
                if (this.queries.readUserByUserName(this.login.getUserTxt().getText()) != null) {
                    User user = this.queries.readUserByUserName(this.login.getUserTxt().getText());

                    this.checkPassword(user);
                } else if (this.queries.readUserByEmail(this.login.getUserTxt().getText()) != null) {
                    User user = this.queries.readUserByEmail(this.login.getUserTxt().getText());

                    this.checkPassword(user);
                }
            }

        } else if (e.getSource() == this.login.getSignupBtn()) {
            new SignupCtrl();
        }
    }
}
