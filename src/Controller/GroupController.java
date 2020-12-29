package Controller;

import Model.User_related.Users;

import java.util.ArrayList;
import java.util.List;

public class GroupController extends AbstractController {
    public GroupController(){

    }

    public List<String> getGroupMembers(int id){
        List<Integer> member_ids = groupsDB.getUsersFromGroup(id);
        List<String> member_names = new ArrayList<>();
        for (Integer member: member_ids
             ) {
            member_names.add(userDB.getUserEntry(member).getName());
        }
        return member_names;
    }

    public List<Integer> getGroupsFromUser(){
        System.out.println(userDB.getUserEntry(current_user).getGroupIDList());
        return userDB.getUserEntry(current_user).getGroupIDList();
    }

    public Double getTotalAmountFromGroup(int id){
        double total = 0.00;
        List<Integer> tickets = groupsDB.getGroupEntry(id).getTicketIDList();
        for (Integer ticket: tickets
             ) {
            total += ticketDB.getTicketEntry(ticket).getTotalAmount();
        }
        return total;
    }

    public List<String> getGroupNamesFromCurrentUser() {
        List<Integer> group_ids = userDB.getUserEntry(current_user).getGroupIDList();
        List<String> names =  new ArrayList<>();
        for (Integer group_id: group_ids
             ) {
            names.add(groupsDB.getGroupEntry(group_id).getName());
        }
        return names;
    }

    public List<String> getFriendList(){
        List<Integer> friend_ids = userDB.getUserEntry(current_user).getFriendList();
        List<String> names = new ArrayList<>();
        for (Integer id: friend_ids
             ) {
            names.add(userDB.getUserEntry(id).getName());
        }
        return names;
    }

    public Boolean addExistingGroupToUser(String username, String groupname){
        List<Integer> current_user_groups = userDB.getUserEntry(current_user).getGroupIDList();
        Integer current_group = 0;
        for (Integer group_id: current_user_groups
             ) {
            if (groupsDB.getGroupEntry(group_id).getName().equals(groupname)){
                current_group = group_id;
            } else { return false; }
        }

        for (int i = 0; i < userDB.getLengthOfDatabase(); i++){
            if (userDB.getUserEntry(i).getName().equals(username)){
                groupsDB.addMemberToGroup(current_group, userDB.getUserEntry(i));
                Users user = userDB.getUserEntry(i);
                user.addGroup(current_group);
                userDB.editUserEntry(user);
                return true;
            }
        }
        return false;
    }

    public void createNewGroup(String _name){
        int id = groupsDB.addEntry(_name);
        groupsDB.addMemberToGroup(id, userDB.getUserEntry(current_user));
        userDB.getUserEntry(current_user).addGroup(id);
    }
}
