package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class AddTicket_GUI {
    private JFrame frame;
    private JLabel label;
    private JButton add_ticket_button;
    private JTextField input_amount;
    private List<JTextField> amount_per_user;
    private Boolean split_evenly;
    private JCheckBox splitting_evenly;


    public AddTicket_GUI(){
    }

    public void Initialize() {
        frame = new JFrame();
        add_ticket_button = new JButton("Add ticket");
        splitting_evenly = new JCheckBox("Splitting evenly");
        input_amount = new JTextField(20);

        splitting_evenly.setBounds(100, 100, 200, 50);
        add_ticket_button.setBounds(10, 120, 80, 25);

        add_ticket_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        splitting_evenly.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        label = new JLabel("Your ticket has been added.");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(add_ticket_button);
        panel.add(splitting_evenly);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);
    }
}
