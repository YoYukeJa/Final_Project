package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage_GUI extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JButton button;

    public LoginPage_GUI(){
        frame = new JFrame();

        button = new JButton("Click me to go to the next page");
        button.addActionListener(this);
        button.setSize(30, 10);

        label = new JLabel("loginpage");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 200, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new LoginPage_GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPage_GUI mainPage_gui = new MainPage_GUI();
        mainPage_gui.setVisible(true);
        this.setVisible(false);
    }
}
