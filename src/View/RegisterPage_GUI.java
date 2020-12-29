package View;

import Controller.LoginController;
import Controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage_GUI extends JFrame implements IDefaultPage_GUI{
    private JFrame frame;
    private JPanel panel;
    private JLabel userLabel, passwordLabel, successLabel, failureLabel;
    private JButton  registerButton, cancelbutton;
    private JTextField userText;
    private JPasswordField passwordText;
    private RegisterController controller;

    public RegisterPage_GUI(){

    }

    @Override
    public void Initialize(){
        controller = new RegisterController();
        frame = new JFrame();
        panel = new JPanel();
        userLabel = new JLabel("User");
        passwordLabel = new JLabel("Password");
        successLabel = new JLabel("");
        failureLabel = new JLabel("");
        registerButton = new JButton("Register");
        cancelbutton = new JButton("Cancel");
        userText = new JTextField(20);
        passwordText = new JPasswordField();

        registerButton.setBounds(10, 80, 100, 25);
        cancelbutton.setBounds(130, 80, 100, 25);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();

                System.out.println(user + ", " + password);

                if (controller.RegisterNewUser(user, password.hashCode())){
                    successLabel.setText("Successful registration");
                    MainPage_GUI mainPage_gui = new MainPage_GUI();
                    mainPage_gui.Initialize();
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    failureLabel.setText("Failed to create account.");
                }
            }
        });

        cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage_GUI loginPage_gui = new LoginPage_GUI();
                loginPage_gui.Initialize();
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
        panel.add(registerButton);
        panel.add(cancelbutton);
        panel.add(userText);
        panel.add(passwordText);

        //frame.setSize(100, 100);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);

    }

}
