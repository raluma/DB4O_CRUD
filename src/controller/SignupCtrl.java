package controller;

import model.Queries;
import view.SingUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupCtrl implements ActionListener {
    private final SingUp signUp;
    private final Queries queries;

    private void windowConfig() {
        this.signUp.setTitle("Registro");
        this.signUp.setLocationRelativeTo(null);
        this.signUp.setSize(500, 400);
        this.signUp.setVisible(true);
    }

    public SignupCtrl() {
        this.signUp = new SingUp();
        this.windowConfig();

        this.queries = new Queries();
        this.signUp.getSignUpBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.signUp.getSignUpBtn()) {
            if (!this.signUp.getEmailTxt().getText().contains("@")) {
                JOptionPane.showMessageDialog(null,
                        "El email no es válido.");
            } else if (!this.queries.createUser(this.signUp.getUserNameTxt().getText(),
                    new String(this.signUp.getPassword1Txt().getPassword()),
                    this.signUp.getEmailTxt().getText(), "User")) {

                JOptionPane.showMessageDialog(null,
                        "Ese Nombre de Usuario o Email ya está registrado");
            } else {
                JOptionPane.showMessageDialog(null,
                        "El Usuario ha sido registrado");
            }
        }
    }
}
