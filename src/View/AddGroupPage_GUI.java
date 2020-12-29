package View;

import Controller.GroupController;
import Controller.TicketController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddGroupPage_GUI extends JFrame implements IDefaultPage_GUI{
    private GroupController controller;
    private JFrame frame, pop_up_frame;
    private JPanel panel;
    private JLabel label, name_label;
    private List<JLabel> username_labels;
    private JButton close_button, save_button, add_friend_button;
    private JTextField group_name;
    private JComboBox friend_list;

    public AddGroupPage_GUI(){

    }

    @Override
    public void Initialize() {
        controller = new GroupController();
        frame = new JFrame();
        pop_up_frame = new JFrame();
        close_button = new JButton("Close page"); //TODO: Add pop-up for confirmation about closing without saving
        save_button = new JButton("Create group");
        panel = new JPanel();
        label = new JLabel("Create a new group");
        name_label = new JLabel("Set the name of the group: ");
        group_name = new JTextField(100);
        username_labels = new ArrayList<>();
        friend_list = new JComboBox(controller.getFriendList().toArray());
        add_friend_button = new JButton("Add friend");

        name_label.setBounds(10, 10, 120, 25);
        group_name.setBounds(150, 10, 100, 25);
        friend_list.setBounds(100, 150, 100, 25);
        add_friend_button.setBounds(200, 150, 100, 25);
        save_button.setBounds(10, 200, 80, 25);
        close_button.setBounds(100, 200, 80, 25);

        pop_up_frame.setSize(300, 300);
        pop_up_frame.setLayout(null);
        pop_up_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        add_friend_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createNewGroup(group_name.getText());
            }
        });

        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(pop_up_frame, "Selecting yes will discard all progress.", "Select an option", JOptionPane.YES_NO_OPTION);
                if (answer==JOptionPane.YES_OPTION) {
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        panel.add(save_button);
        panel.add(close_button);
        panel.add(friend_list);
        panel.add(name_label);
        panel.add(group_name);
        panel.add(add_friend_button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Create Group");
        frame.pack();
        frame.setVisible(true);
    }
}
