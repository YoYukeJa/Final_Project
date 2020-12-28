package Controller;

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

    public Boolean addExistingGroupToUser(int user_id, int current_group){
        groupsDB.addMemberToGroup(current_group, userDB.getUserEntry(user_id));
        return false;
    }

    public void createNewGroup(String _name){
        int id = groupsDB.addEntry(_name);
        groupsDB.addMemberToGroup(id, userDB.getUserEntry(current_user));
    }
}
