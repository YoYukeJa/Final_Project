package View;

import Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage_GUI extends JFrame implements IDefaultPage_GUI{
    private JFrame frame;
    private JPanel panel;
    private JLabel userLabel, passwordLabel, successLabel, failureLabel;
    private JButton loginButton, registerButton;
    private JTextField userText;
    private JPasswordField passwordText;
    private LoginController controller;

    public LoginPage_GUI(){
    }

    public static void main(String[] args){
        new LoginPage_GUI();
    }

    @Override
    public void Initialize() {controller = new LoginController();
        frame = new JFrame();
        panel = new JPanel();
        userLabel = new JLabel("User");
        passwordLabel = new JLabel("Password");
        successLabel = new JLabel("");
        failureLabel = new JLabel("");
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        userText = new JTextField(20);
        passwordText = new JPasswordField();

        loginButton.setBounds(10, 80, 80, 25);
        registerButton.setBounds(100, 80, 100, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();

                System.out.println(user + ", " + password);

                if (controller.checkIfLoginIsCorrect(user, password)){
                    successLabel.setText("Succesful login");
                    failureLabel.setText("");
                    MainPage_GUI mainPage_gui = new MainPage_GUI();
                    mainPage_gui.Initialize();
                    //MainPage_GUI mainPage_gui = new MainPage_GUI();
                    //mainPage_gui.setVisible(true);
                    //this.setVisible(false);
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    successLabel.setText("");
                    failureLabel.setText("Failed to login. Incorrect Password or username entered.");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterPage_GUI registerPage = new RegisterPage_GUI();
                registerPage.Initialize();
                frame.setVisible(false);
                frame.dispose();
            }
        });

        userLabel.setBounds(10, 20, 80, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        successLabel.setBounds(10, 110, 300, 25);
        failureLabel.setBounds(10, 110, 500, 25);

        userText.setBounds(100, 20, 165, 25);
        passwordText.setBounds(100, 50, 165, 25);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 300));
        panel.setLayout(null);
        panel.add(userLabel);
        panel.add(passwordLabel);
        panel.add(successLabel);
        panel.add(failureLabel);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(userText);
        panel.add(passwordText);

        //frame.setSize(100, 100);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.setSize(700, 300);
        frame.setVisible(true);
    }
}
