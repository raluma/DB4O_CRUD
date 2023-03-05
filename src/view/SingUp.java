package view;

import javax.swing.*;

public class SingUp extends JFrame {
    private JPanel window;
    private JTextField userNameTxt;
    private JTextField emailTxt;
    private JPasswordField password1Txt;
    private JPasswordField password2Txt;
    private JButton signUpBtn;

    public SingUp() {
        super();
        setContentPane(this.window);
    }

    public JTextField getUserNameTxt() {
        return userNameTxt;
    }

    public JTextField getEmailTxt() {
        return emailTxt;
    }

    public JPasswordField getPassword1Txt() {
        return password1Txt;
    }

    public JPasswordField getPassword2Txt() {
        return password2Txt;
    }

    public JButton getSignUpBtn() {
        return signUpBtn;
    }
}
