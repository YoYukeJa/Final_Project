package View;

import Controller.GroupController;
import Controller.MainController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GroupPage_GUI extends JFrame {

    private GroupController controller;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private double total_amount;
    private List<List<JLabel>> payments, group_member_names;
    private JButton close_button;

    public GroupPage_GUI(){

    }

    public void Initialize() {
        controller = new GroupController();
        frame = new JFrame();
        close_button = new JButton("Close page");
        panel = new JPanel();
        label = new JLabel("User");
        payments = new ArrayList<List<JLabel>>();
        group_member_names = new ArrayList<List<JLabel>>();
    }
}
