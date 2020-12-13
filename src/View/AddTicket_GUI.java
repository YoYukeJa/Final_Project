package View;

import Controller.TicketController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AddTicket_GUI {
    private JFrame frame;
    private JLabel label;
    private JButton add_ticket_button;
    private JTextField input_amount;
    private List<JTextField> amount_per_user;
    private Boolean split_evenly;
    private JCheckBox splitting_evenly;
    private TicketController ticketController;
    private JComboBox type_options;

    private int groupID;


    public AddTicket_GUI(){
    }

    public void Initialize() {
        System.out.println();
        ticketController = new TicketController();
        split_evenly = false;
        List<Integer> groupids = ticketController.getGroupsFromUser();
        List<String> group_names = new ArrayList<>();
        for (int i = 0; i < groupids.size(); i++){
            group_names.add(ticketController.getGroupName(groupids.get(i)));
        }
        frame = new JFrame();
        add_ticket_button = new JButton("Add ticket");
        splitting_evenly = new JCheckBox("Splitting evenly");
        input_amount = new JTextField(20);
        type_options = new JComboBox(group_names.toArray());

        splitting_evenly.setBounds(100, 100, 200, 50);
        add_ticket_button.setBounds(10, 120, 80, 25);

        add_ticket_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ticketController.createNewTicket(split_evenly);
            }
        });



        splitting_evenly.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                split_evenly = !split_evenly;
                System.out.println(split_evenly);
            }
        });

        label = new JLabel("Your ticket has been added.");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(add_ticket_button);
        panel.add(splitting_evenly);
        panel.add(label);
        panel.add(type_options);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);
    }
}
