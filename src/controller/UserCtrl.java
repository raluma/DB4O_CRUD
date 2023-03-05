package controller;

import model.Queries;
import view.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class UserCtrl implements ActionListener {
    private final view.User userView;
    private final model.User user;
    private final Queries queries;

    private void windowConfig() {
        this.userView.setTitle("Usuario");
        this.userView.setLocationRelativeTo(null);
        this.userView.setSize(700, 400);
        this.userView.setVisible(true);
    }

    public UserCtrl(model.User user) {
        this.userView = new User();
        this.user = user;
        this.windowConfig();

        this.queries = new Queries();

        this.userView.getUserNameTxt().setText(this.user.getUsername());
        this.userView.getEmailTxt().setText(this.user.getEmail());
        this.userView.getPass1Txt().setText(this.user.getPassword());
        this.userView.getPass2Txt().setText(this.user.getPassword());
        this.userView.getUpdateBtn().addActionListener(this);
    }

    private void updateUser() {
        model.User user = this.queries.readUserById(this.user.getId());

        this.userView.getUserNameTxt().setText(user.getUsername());
        this.userView.getEmailTxt().setText(user.getEmail());
        this.userView.getPass1Txt().setText(user.getPassword());
        this.userView.getPass2Txt().setText(user.getPassword());

        JOptionPane.showMessageDialog(null,
                "Se ha actualizado su Perfil.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.userView.getUpdateBtn()) {
            boolean updateDone = false;

            if (!Objects.equals(this.user.getUsername(), this.userView.getUserNameTxt().getText())) {
                this.queries.updateUserName(user.getId(), this.userView.getUserNameTxt().getText());

                updateDone = true;
            }

            if (!Objects.equals(this.user.getEmail(), this.userView.getEmailTxt().getText())) {
                if (this.userView.getEmailTxt().getText().contains("@")) {
                    this.queries.updateEmail(user.getId(), this.userView.getEmailTxt().getText());

                    updateDone = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "El email no es válido.");
                }
            }

            if (!new String(this.userView.getPass1Txt().getPassword()).equals(this.user.getPassword())
                || !new String(this.userView.getPass2Txt().getPassword()).equals(this.user.getPassword())) {

                if (Arrays.equals(this.userView.getPass1Txt().getPassword(), this.userView.getPass2Txt().getPassword())) {
                    this.queries.updatePassword(user.getId(), new String(this.userView.getPass1Txt().getPassword()));

                    updateDone = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Las contraseñas son diferentes. Vuelva a intertarlo.");
                }
            }

            if (updateDone) { this.updateUser(); }
        }
    }
}
