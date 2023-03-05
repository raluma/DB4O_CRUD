package view;

import javax.swing.*;

public class User extends JFrame {
    private JPanel window;
    private JTextField userNameTxt;
    private JTextField emailTxt;
    private JPasswordField pass1Txt;
    private JPasswordField pass2Txt;
    private JButton updateBtn;

    public User() {
        super();
        setContentPane(this.window);
    }

    public JTextField getUserNameTxt() {
        return userNameTxt;
    }

    public JTextField getEmailTxt() {
        return emailTxt;
    }

    public JPasswordField getPass1Txt() {
        return pass1Txt;
    }

    public JPasswordField getPass2Txt() {
        return pass2Txt;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }
}
