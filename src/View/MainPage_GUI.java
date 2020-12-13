package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage_GUI extends JFrame {
    private JFrame frame;
    private JLabel label;
    private JButton group_button, new_ticket_button, ticket_history_button, logout;


    public MainPage_GUI(){
    }

    public void Initialize(){
        frame = new JFrame();

        group_button = new JButton("Groups");
        new_ticket_button = new JButton("Add ticket");
        ticket_history_button = new JButton("See all tickets");
        logout = new JButton("Log out");


        group_button.setBounds(10, 80, 80, 25);
        new_ticket_button.setBounds(100, 80, 80, 25);
        ticket_history_button.setBounds(190, 80, 80, 25);
        logout.setBounds(10, 120, 80, 25);
        group_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        new_ticket_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ticket_history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage_GUI loginPage_gui = new LoginPage_GUI();
                loginPage_gui.Initialize();
            }
        });

        label = new JLabel("You are now logged in");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(ticket_history_button);
        panel.add(new_ticket_button);
        panel.add(group_button);
        panel.add(logout);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);
    }
}
