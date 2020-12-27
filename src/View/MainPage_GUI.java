package View;


import Controller.MainController;
import Model.User_related.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class MainPage_GUI extends JFrame {
    private MainController mainController;
    private JPanel panel;
    private JFrame frame;
    private JLabel label;
    private JButton group_button, new_ticket_button, ticket_history_button, logout;


    public MainPage_GUI(){
    }

    public void Initialize(){
        mainController = new MainController();

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
                AddTicket_GUI addTicket_gui = new AddTicket_GUI();
                addTicket_gui.Initialize();
            }
        });
        ticket_history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Ticket> tickets =mainController.getTicketHistory(mainController.getCurrentUserId());
                TicketHistory_GUI ticketHistory_gui = new TicketHistory_GUI();
                ticketHistory_gui.Initialize(tickets);
            }
        });
        group_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupPage_GUI groupPage_gui = new GroupPage_GUI();
                groupPage_gui.Initialize();
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage_GUI loginPage_gui = new LoginPage_GUI();
                loginPage_gui.Initialize();
                frame.setVisible(false);
                frame.dispose();
                mainController.logOut();
            }
        });

        label = new JLabel("You are now logged in");

        panel = new JPanel();
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
