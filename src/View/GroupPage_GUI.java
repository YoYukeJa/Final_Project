package View;

import Controller.GroupController;

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
    private JLabel total_amount_label, friend_label;
    private double total_amount;
    private List<Integer> group_ids;
    private List<String> group_members, group_names, selected_friends, friends_not_in_group;
    private List<JLabel> group_member_names;
    private JButton close_button, add_friend_button;
    private JComboBox group_list, friends_to_add;
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
        add_friend_button = new JButton("Add friend");
        panel = new JPanel();
        total_amount_label = new JLabel();
        friends_to_add = new JComboBox();
        setTotalAmount();
        friend_label = new JLabel("Add a friend to the group: ");
        selected_friends = new ArrayList<>();

        group_names = controller.getGroupNamesFromCurrentUser();
        group_list = new JComboBox(group_names.toArray());
        group_list.setSize(80, 25);


        friends_not_in_group = new ArrayList<>();

        getMembersOfGroup();

        List<String> friends = controller.getFriendList();
        checkFriendsNotInGroup(friends);
        friend_label.setBounds(250, 150, 80, 25);
        friends_to_add.setBounds(350, 150, 80, 25);
        add_friend_button.setBounds(500, 150, 80, 25);
        close_button.setBounds(10, 150, 80, 25);
        total_amount_label.setBounds(10, 120, 100, 25);

        add_friend_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected_friends.add(friends_to_add.getSelectedItem().toString());
                group_member_names.add(new JLabel(friends_to_add.getSelectedItem().toString()));
                controller.addExistingGroupToUser(friends_to_add.getSelectedItem().toString(), group_list.getSelectedItem().toString());
                friends_to_add.removeItemAt(friends_to_add.getSelectedIndex());
                pageUIUpdate();
            }
        });

        group_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(group_list.getSelectedItem());
                for (JLabel label: group_member_names
                     ) {
                    label.setText("");
                }
                for (int i = 0; i < group_names.size(); i++) {
                    if (group_list.getSelectedItem().equals(group_names.get(i))){
                        current_group_id = group_ids.get(i);
                    }
                }
                setTotalAmount();
                checkFriendsNotInGroup(friends);
                pageUIUpdate();
            }
        });

        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                MainPage_GUI mainPage_gui = new MainPage_GUI();
                mainPage_gui.Initialize();
            }
        });

        createFrame();
    }

    public void setTotalAmount() {
        total_amount = controller.getTotalAmountFromGroup(current_group_id);
        total_amount_label.setText("Total: " + (total_amount));
    }

    public void checkFriendsNotInGroup(List<String> friends) {
        panel.invalidate();
        frame.invalidate();
        friends_not_in_group = new ArrayList<>();
        group_members = controller.getGroupMembers(current_group_id);
        System.out.println("123" + friends);
        for (int i = 0; i < friends_to_add.getItemCount(); i++){
            friends_to_add.removeItemAt(i);
        }
        for (int i = 0; i < friends.size(); i++){
            boolean check = false;
            for (int j = 0; j < group_members.size(); j++){
                if (friends.get(i).equals(group_members.get(j))){
                    check = true;
                }
            }
            if (!check){
                friends_not_in_group.add(friends.get(i));
                friends_to_add.addItem(friends_not_in_group.get(i));
            }
        }
        System.out.println(friends_not_in_group);
        frame.validate();
        frame.repaint();
        panel.revalidate();
        panel.repaint();
        panel.updateUI();
    }

    public void pageUIUpdate() {
        panel.invalidate();
        getMembersOfGroup();
        System.out.println(controller.getGroupMembers(current_group_id));
        panel.revalidate();
        panel.repaint();
        panel.updateUI();
    }

    public void createFrame() {
        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(null);
        panel.add(group_list);
        panel.add(close_button);
        panel.add(total_amount_label);
        panel.add(friend_label);
        panel.add(friends_to_add);
        panel.add(add_friend_button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Groups");
        frame.setSize(700, 300);
        frame.setVisible(true);
    }

    public void getMembersOfGroup() {
        frame.invalidate();
        group_member_names = new ArrayList<JLabel>();
        group_members = controller.getGroupMembers(current_group_id);
        System.out.println(group_members);
        for (int i = 0; i < controller.getGroupMembers(current_group_id).size(); i++) {
            group_member_names.add(new JLabel(group_members.get(i)));
            group_member_names.get(i).setBounds(100, 20 + (i * 25), 80, 25);
            panel.add(group_member_names.get(i));
            System.out.println("Hey");
        }
        frame.validate();
        frame.repaint();

    }
}
