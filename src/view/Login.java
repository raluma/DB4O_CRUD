package view;

import javax.swing.*;

public class Login extends JFrame {
    private JPanel window;
    private JTextField userTxt;
    private JPasswordField passTxt;
    private JButton signupBtn;
    private JButton loginBtn;
    private JPanel form;

    public Login() {
        super();
        setContentPane(this.window);
    }

    public JTextField getUserTxt() {
        return userTxt;
    }

    public JPasswordField getPassTxt() {
        return passTxt;
    }

    public JButton getSignupBtn() {
        return signupBtn;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }
}
