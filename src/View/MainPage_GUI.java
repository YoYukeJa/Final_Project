package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage_GUI extends JFrame {
    private JFrame frame;
    private JLabel label;
    private JButton group_button, new_ticket_button, ticket_history_button;


    public MainPage_GUI(){
        frame = new JFrame();

        group_button = new JButton("Groups");
        new_ticket_button = new JButton("Add ticket");
        group_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        group_button.setSize(300, 100);

        label = new JLabel("Number of clicks: 0");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(group_button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);
    }
}
