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
    List<JLabel> ticket_types;
    List<List<JLabel>> payments, group_member_names;
    private JButton close_button;

    public TicketHistory_GUI(){}

    public void Initialize(List<Ticket> tickets){
        mainController = new MainController();
        frame = new JFrame();

        close_button = new JButton("Close page");
        panel = new JPanel();
        label = new JLabel("User");
        payments = new ArrayList<List<JLabel>>();
        group_member_names = new ArrayList<List<JLabel>>();

        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(close_button);
        if (tickets != null) {
            for (int i = 0; i < tickets.size(); i++) {
                List<JLabel> temp_payments = new ArrayList<>();
                List<Integer> u_ids = tickets.get(i).getUserIDs();
                List<JLabel> temp_names = new ArrayList<>();
                payments.add(new ArrayList<JLabel>());
                group_member_names.add(new ArrayList<JLabel>());
                for (int j = 0; j < u_ids.size(); j++) {
                    temp_names.add(j, new JLabel(mainController.getUserName(u_ids.get(j))));
                    temp_payments.add(j, new JLabel((Double.toString(tickets.get(i).getTicketAmount(u_ids.get(j))))));
                }
                group_member_names.add(i, temp_names);
                payments.add(i, temp_payments);
                for (int j = 0; j < payments.get(i).size(); j++) {
                    payments.get(i).get(j).setBounds(150, (i * payments.get(i).size() * 100) + (j * 25), 40, 25);
                    group_member_names.get(i).get(j).setBounds(70, (i * group_member_names.get(i).size() * 100) + (j * 25), 40, 25);

                    panel.add(payments.get(i).get(j));
                    panel.add(group_member_names.get(i).get(j));
                }

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
