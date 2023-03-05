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
    private JScrollPane ScrollPane;

    public Admin() {
        super();
        setContentPane(this.window);
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getUserNameTxt() {
        return userNameTxt;
    }

    public JTextField getEmailTxt() {
        return emailTxt;
    }

    public JTextField getPasswordTxt() {
        return passwordTxt;
    }

    public JComboBox getRolCombo() {
        return rolCombo;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getDropBtn() {
        return dropBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }
}
