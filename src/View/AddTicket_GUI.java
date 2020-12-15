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

public class AddTicket_GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel end_label;
    private List<JLabel> username_labels;
    private JButton add_ticket_button;
    private JTextField input_amount, ticket_type;
    private List<JTextField> input_amounts;
    private List<JTextField> amount_per_user;
    private Boolean split_evenly;
    private JCheckBox splitting_evenly;
    private TicketController ticketController;
    private JComboBox group_list;

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
        ticket_type = new JTextField(20);
        group_list = new JComboBox(group_names.toArray());
        end_label = new JLabel("Your ticket has been added.");
        username_labels = new ArrayList<JLabel>();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);

        splitting_evenly.setBounds(100, 100, 200, 50);
        add_ticket_button.setBounds(10, 120, 80, 25);
        group_list.setSize(80, 25);
        end_label.setBounds(10, 200, 100, 25);

        getGroupID(groupids, group_names);
        getUserNamesFromGroup();

        add_ticket_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ticketController.createNewTicket(split_evenly);
                end_label.setText("clicked finish button");
            }
        });



        splitting_evenly.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                split_evenly = !split_evenly;
                System.out.println(split_evenly);
                if (split_evenly){
                    end_label.setText("Te wer von da");
                } else {
                    getUserNamesFromGroup();
                    end_label.setText("Te ne mer von da");
                }
            }
        });

        System.out.println(group_list.getSelectedItem());
        group_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(group_list.getSelectedItem());
                getGroupID(groupids, group_names);
                getUserNamesFromGroup();
            }
        });




        panel.add(add_ticket_button);
        panel.add(splitting_evenly);
        panel.add(end_label);
        panel.add(group_list);
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);
    }

    public void getGroupID(List<Integer> groupids, List<String> group_names) {
        for (int i = 0; i < groupids.size(); i++){
            if (group_list.getSelectedItem().equals(group_names.get(i))){
                groupID = groupids.get(i);
                System.out.println(groupID);
            }
        }
    }

    public void getUserNamesFromGroup(){
        username_labels.clear();
        List<String> usernames = ticketController.getUsernamesFromGroup(groupID);
        for (int i = 0; i < usernames.size(); i++) {
            username_labels.add(new JLabel(usernames.get(i)));
            username_labels.get(i).setBounds(150, (i * 25) + 10, 100, 25);
            //username_labels.get(i).setVisible(true);
            panel.add(username_labels.get(i));
        }
        System.out.println(usernames);
    }
}
