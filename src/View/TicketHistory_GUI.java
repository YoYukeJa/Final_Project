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

public class TicketHistory_GUI extends JFrame implements IDefaultPage_GUI {
    private MainController mainController;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private List<Ticket> tickets;
    private List<JLabel> ticket_types;
    private List<List<JLabel>> payments, group_member_names;
    private JButton close_button;

    private List<JLabel> end_label;

    public TicketHistory_GUI(){
    }

    @Override
    public void Initialize(){
        mainController = new MainController();
        frame = new JFrame();
        close_button = new JButton("Close page");
        tickets = mainController.getTicketHistory(mainController.getCurrentUserId());
        ticket_types = new ArrayList<>();
        end_label = new ArrayList<>();
        panel = new JPanel();
        payments = new ArrayList<List<JLabel>>();
        group_member_names = new ArrayList<List<JLabel>>();

        close_button.setBounds(300, 10, 80, 25);

        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                MainPage_GUI mainPage_gui = new MainPage_GUI();
                mainPage_gui.Initialize();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(close_button);
        if (tickets != null) {
            int height = 0;
            for (int i = 0; i < tickets.size(); i++) {
                height += 20;
                end_label.add(new JLabel("Ticket " + (i+1) + " information"));
                end_label.get(i).setBounds(0, height, 120, 25);
                height += 20;
                panel.add(end_label.get(i));
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
                int temp_height = 0;
                for (int j = 0; j < payments.get(i).size(); j++) {
                    temp_height = height + (j * 25);
                    payments.get(i).get(j).setBounds(150, temp_height, 40, 25);
                    group_member_names.get(i).get(j).setBounds(70, temp_height, 40, 25);
                    group_member_names.get(i).get(j).setText(temp_names.get(j).getText());
                    panel.add(payments.get(i).get(j));
                    panel.add(group_member_names.get(i).get(j));
                }
                height = height + temp_height;
                System.out.println(tickets.get(i).getType());
                ticket_types.add(new JLabel(tickets.get(i).getType()));
                panel.add(ticket_types.get(i));
            }
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Ticket history");
        frame.setSize(700, 300);
        frame.setVisible(true);
    }
}
