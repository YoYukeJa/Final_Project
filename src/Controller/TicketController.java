package Controller;

import java.util.ArrayList;
import java.util.List;

public class TicketController extends AbstractController{

    public TicketController(){

    }

    public String getGroupName(int id){
        return groupsDB.getGroupEntry(id).getName();
    }


    public List<Integer> getGroupsFromUser(){
        System.out.println(userDB.getUserEntry(current_user).getGroupIDList());
        return userDB.getUserEntry(current_user).getGroupIDList();
    }

    public int getAmountOfUsersInGroup(int id){
        return groupsDB.getUsersFromGroup(id).size();
    }

    public List<String> getUsernamesFromGroup(int id){
        List<Integer> user_ids = groupsDB.getUsersFromGroup(id);
        List<String> usernames = new ArrayList<>();
        for (int i = 0; i < user_ids.size(); i++) {
            usernames.add(userDB.getUserEntry(user_ids.get(i)).getName());
        }
        return usernames;
    }

    public boolean createNewTicket(Boolean split_evenly, List<Double> payment_amounts, int ticket_type, int group_id){
        ticketDB.addTicketEntry(group_id, groupsDB.getUsersFromGroup(group_id), payment_amounts, split_evenly, ticket_type);
        return false;
    }
}
