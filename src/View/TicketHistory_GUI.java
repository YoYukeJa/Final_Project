package View;

import Controller.MainController;
import Model.User_related.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TicketHistory_GUI extends JFrame {
    private MainController mainController;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private List<Ticket> tickets;
    private List<JLabel> ticket_types;
    private List<List<JLabel>> payments, group_member_names;
    private JButton close_button;

    private JLabel end_label;

    public TicketHistory_GUI(){
    }

    public void Initialize(){
        mainController = new MainController();
        frame = new JFrame();
        close_button = new JButton("Close page");
        tickets = mainController.getTicketHistory(mainController.getCurrentUserId());
        ticket_types = new ArrayList<>();
        panel = new JPanel();
        label = new JLabel("User");
        payments = new ArrayList<List<JLabel>>();
        group_member_names = new ArrayList<List<JLabel>>();

        end_label = new JLabel("Your ticket has been added.");
        label.setBounds(10, 240, 100, 25);

        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(close_button);
        panel.add(label);
        if (tickets != null) {
            for (int i = 0; i < tickets.size(); i++) {
                List<JLabel> temp_payments = new ArrayList<>();
                List<Integer> u_ids = tickets.get(i).getUserIDs();
                List<JLabel> temp_names = new ArrayList<>();
                payments.add(new ArrayList<JLabel>());
                group_member_names.add(new ArrayList<JLabel>());
                for (int j = 0; j < u_ids.size(); j++) {
                    temp_names.add(j, new JLabel(mainController.getUserName(u_ids.get(j))));
                    temp_payments.add(j, new JLabel((Double.toString(tickets.get(i).getTicketAmount(j)))));
                }
                group_member_names.add(i, temp_names);
                payments.add(i, temp_payments);
                for (int j = 0; j < payments.get(i).size(); j++) {
                    payments.get(i).get(j).setBounds(150, (i * payments.get(i).size() * 100) + (j * 25), 40, 25);
                    group_member_names.get(i).get(j).setBounds(70, (i * group_member_names.get(i).size() * 100) + (j * 25), 40, 25);
                    group_member_names.get(i).get(j).setText(temp_names.get(j).getText());
                    panel.add(payments.get(i).get(j));
                    panel.add(group_member_names.get(i).get(j));
                }
                System.out.println(tickets.get(i).getType());
                ticket_types.add(new JLabel(tickets.get(i).getType()));
                panel.add(ticket_types.get(i));
            }
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Ticket history");
        frame.pack();
        frame.setVisible(true);
    }
}
