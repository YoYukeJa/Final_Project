package View;

import Controller.GroupController;
import Controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GroupPage_GUI extends JFrame implements IDefaultPage_GUI {

    private GroupController controller;
    private JFrame frame;
    private JPanel panel;
    private JLabel total_amount_label;
    private double total_amount;
    private List<Integer> group_ids;
    private List<String> group_members, group_names;
    private List<JLabel> group_member_names;
    private JButton close_button;
    private JComboBox group_list;
    private int current_group_id;

    public GroupPage_GUI(){

    }

    @Override
    public void Initialize() {
        controller = new GroupController();
        group_ids = controller.getGroupsFromUser();
        current_group_id = group_ids.get(0);
        frame = new JFrame();
        close_button = new JButton("Close page");
        panel = new JPanel();
        total_amount = controller.getTotalAmountFromGroup(current_group_id);
        total_amount_label = new JLabel((Double.toString(total_amount)));

        group_names = controller.getGroupNamesFromCurrentUser();
        group_list = new JComboBox(group_names.toArray());
        group_list.setSize(80, 25);

        group_member_names = new ArrayList<JLabel>();

        group_members = controller.getGroupMembers(current_group_id);
        for (int i = 0; i < controller.getGroupMembers(current_group_id).size(); i++) {
            group_member_names.add(new JLabel(group_members.get(i)));
            group_member_names.get(i).setBounds(100, 20 + (i * 25), 80, 25);
            panel.add(group_member_names.get(i));
        }

        group_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(group_list.getSelectedItem());
                for (int i = 0; i < group_names.size(); i++) {
                    if (group_list.getSelectedItem().equals(group_names.get(i))){
                        current_group_id = group_ids.get(i);
                    }
                }
            }
        });

        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(group_list);
        panel.add(close_button);
        panel.add(total_amount_label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Groups");
        frame.pack();
        frame.setVisible(true);
    }
}
