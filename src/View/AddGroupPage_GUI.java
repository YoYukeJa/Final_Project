package View;

import Controller.TicketController;

import javax.swing.*;
import java.util.List;

public class AddGroupPage_GUI extends JFrame implements IDefaultPage_GUI{
    private JFrame frame;
    private JPanel panel;
    private JLabel end_label;
    private List<JLabel> username_labels;
    private JButton add_ticket_button, update_total;
    private JTextField total_amount, ticket_type;
    private List<JTextField> input_amounts;
    private List<JTextField> amount_per_user;
    private Boolean split_evenly;
    private JCheckBox splitting_evenly;
    private TicketController ticketController;
    private JComboBox group_list;

    public AddGroupPage_GUI(){

    }

    @Override
    public void Initialize() {

    }
}
