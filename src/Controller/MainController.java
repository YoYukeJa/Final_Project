package Controller;

import Database.UserDatabase;
import Model.User_related.Ticket;

import java.util.ArrayList;
import java.util.List;

public class MainController extends AbstractController{

    public MainController(){

    }

    public Integer getCurrentUserId(){
        return current_user;
    }

    public List<Ticket> getTicketHistory(int id){
        List<Ticket> tickets = new ArrayList<>();
        for (int ticket_id: userDB.getUserEntry(id).getTickets()
             ) {
            tickets.add(ticketDB.getTicketEntry(ticket_id));
        }
        return tickets;
    }

    public String getUserName(int id){
        return userDB.getUserEntry(id).getName();
    }

    public Boolean addFriend(String _name){
        boolean check = false;
        for (int i = 0; i < userDB.getLengthOfDatabase(); i++){
            if (userDB.getUserEntry(i).getName().equals(_name)){
                userDB.getUserEntry(current_user).addFriend(i);
                check = true;
            }
        }
        return check;
    }
}
