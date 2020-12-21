package View;

import Controller.MainController;
import Model.User_related.Ticket;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TicketHistory_GUI extends JFrame {
    //private MainController mainController;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    List<JLabel> group_member_names, ticket_types;
    List<List<JLabel>> payments;
    private JButton close_button;

    public TicketHistory_GUI(){}

    public void Initialize(List<Ticket> tickets){
        frame = new JFrame();

        close_button = new JButton("Close page");
        panel = new JPanel();
        label = new JLabel("User");
        payments = new ArrayList<List<JLabel>>();
        for (int i = 0; i < tickets.size(); i++) {
            List<JLabel> temp_payments = new ArrayList<>();
            List<Integer> u_ids = tickets.get(i).getUserIDs();
            group_member_names.add(new JLabel());
            payments.add(new ArrayList<JLabel>());
            for (int uid: u_ids
                 ) {
                temp_payments.add(uid, new JLabel((Double.toString(tickets.get(i).getTicketAmount(uid)))));
            }
            payments.add(i, temp_payments);

            ticket_types.add(new JLabel(tickets.get(i).getType()));
        }

    }
}
