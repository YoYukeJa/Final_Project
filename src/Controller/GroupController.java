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
}
