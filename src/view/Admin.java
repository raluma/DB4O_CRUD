package view;

import javax.swing.*;

public class Admin extends JFrame {
    private JPanel window;
    private JTable table;
    private JTextField emailTxt;
    private JTextField userNameTxt;
    private JPanel form;
    private JTextField passwordTxt;
    private JComboBox rolCombo;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;

    public Admin() {
        super();
        setContentPane(this.window);
    }

    public JTable getTable() {
        return this.table;
    }

    public JTextField getUserNameTxt() {
        return this.userNameTxt;
    }

    public JTextField getEmailTxt() {
        return this.emailTxt;
    }

    public JTextField getPasswordTxt() {
        return this.passwordTxt;
    }

    public JComboBox getRolCombo() {
        return this.rolCombo;
    }

    public JButton getAddBtn() {
        return this.addBtn;
    }

    public JButton getDropBtn() {
        return this.dropBtn;
    }

    public JButton getUpdateBtn() {
        return this.updateBtn;
    }
}
