package Controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketController extends AbstractController{

    public TicketController(){
        groupsDB.addObserver(this);
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

    public Integer createNewTicket(Boolean split_evenly, List<Double> payment_amounts, String _ticket_type, int group_id){
        int ticket_type = 0;
        switch (_ticket_type.toLowerCase()){
            case "movieticket":
                ticket_type = 0;
                break;
            case "trafficticket":
                ticket_type = 1;
                break;
            case "drinks":
                ticket_type = 2;
                break;
            case "food":
                ticket_type = 3;
                break;
            case "supermarket":
                ticket_type = 4;
                break;
            case "housing":
                ticket_type = 5;
                break;
            case "publictransport":
                ticket_type = 6;
                break;
        }
        int id = ticketDB.addTicketEntry(group_id, groupsDB.getUsersFromGroup(group_id), payment_amounts, split_evenly, ticket_type);
        groupsDB.addTicketToGroup(group_id, id);
        for (Integer user: groupsDB.getUsersFromGroup(group_id)
             ) {
            userDB.addTicketToUser(user, id);
        }
        return id;
    }
}
