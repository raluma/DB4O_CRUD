package controller;

import model.Queries;
import model.User;
import view.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AdminCtrl implements ActionListener, MouseListener {
    private final Admin admin;
    private final Queries queries;

    private void windowConfig() {
        this.admin.setTitle("Administrador");
        this.admin.setLocationRelativeTo(null);
        this.admin.setSize(800, 400);
        this.admin.setVisible(true);
    }

    private void writeInTable() {
        ArrayList<User> users = this.queries.readUsers();

        Object[][] data = new Object[users.size()][];

        for (int i = 0; i < users.size(); i++) {
            data[i] = new String[]{
                    String.valueOf(users.get(i).getId()),
                    users.get(i).getUsername(),
                    users.get(i).getEmail(),
                    users.get(i).getPassword(),
                    users.get(i).getRole()
            };
        }

        this.admin.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"Id", "Nombre de Usuario", "Email", "Contraseña", "Rol"}
        ));
    }

    public AdminCtrl() {
        super();
        this.admin = new Admin();
        this.windowConfig();

        this.queries = new Queries();
        this.writeInTable();

        this.admin.getAddBtn().addActionListener(this);
        this.admin.getUpdateBtn().addActionListener(this);
        this.admin.getDropBtn().addActionListener(this);
        this.admin.getTable().addMouseListener(this);
        this.admin.getRolCombo().addItem("User");
        this.admin.getRolCombo().addItem("Admin");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.admin.getAddBtn()) {
            if (!this.admin.getEmailTxt().getText().contains("@")) {
                JOptionPane.showMessageDialog(null,
                        "El email no es válido.");
            } else if (!this.queries.createUser(this.admin.getUserNameTxt().getText(), this.admin.getPasswordTxt().getText(),
                    this.admin.getEmailTxt().getText(), (String) this.admin.getRolCombo().getSelectedItem())) {
                JOptionPane.showMessageDialog(null,
                        "Este nombre de Usuario o email ya está registrado");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Se ha añadido el Usuario");

                this.writeInTable();
            }
        } else if (e.getSource() == this.admin.getUpdateBtn()) {
            boolean updateDone = false;

            try {
                int fila = this.admin.getTable().getSelectedRow();
                int id = Integer.parseInt(this.admin.getTable().getValueAt(fila, 0).toString());

                if (!Objects.equals(this.admin.getTable().getValueAt(fila, 1).toString(),
                        this.admin.getUserNameTxt().getText())) {

                    this.queries.updateUserName(id, this.admin.getUserNameTxt().getText());

                    updateDone = true;
                }

                if (!Objects.equals(this.admin.getTable().getValueAt(fila, 2).toString(),
                        this.admin.getEmailTxt().getText())) {

                    if (this.admin.getEmailTxt().getText().contains("@")) {

                        this.queries.updateEmail(id, this.admin.getEmailTxt().getText());

                        updateDone = true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "El email no es válido");
                    }
                }

                if (!Objects.equals(this.admin.getTable().getValueAt(fila, 3).toString(),
                        this.admin.getPasswordTxt().getText())) {

                    this.queries.updatePassword(id, this.admin.getPasswordTxt().getText());

                    updateDone = true;
                }

                if (!Objects.equals(this.admin.getTable().getValueAt(fila, 4).toString(),
                        this.admin.getRolCombo().getSelectedItem())) {

                    this.queries.updateRole(id, (String) this.admin.getRolCombo().getSelectedItem());

                    updateDone = true;
                }

                if (updateDone) {
                    JOptionPane.showMessageDialog(null,
                            "Se ha actualizado el Usuario");

                    this.writeInTable();
                }

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Debe seleccionar el usuario a actualizar en la tabla");
            }

        } else if (e.getSource() == this.admin.getDropBtn()) {
            try {
                int fila = this.admin.getTable().getSelectedRow();
                int id = Integer.parseInt(this.admin.getTable().getValueAt(fila, 0).toString());

                this.queries.deleteUser(id);
                this.writeInTable();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Debe seleccionar el usuario a borrar en la tabla");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = this.admin.getTable().getSelectedRow();

        this.admin.getUserNameTxt().setText(this.admin.getTable().getValueAt(fila, 1).toString());
        this.admin.getEmailTxt().setText(this.admin.getTable().getValueAt(fila, 2).toString());
        this.admin.getPasswordTxt().setText(this.admin.getTable().getValueAt(fila, 3).toString());
        this.admin.getRolCombo().setSelectedItem(this.admin.getTable().getValueAt(fila, 4));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
