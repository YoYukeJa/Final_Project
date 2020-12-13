package Controller;

import java.util.List;

public class TicketController extends AbstractController{

    public TicketController(){

    }

    public boolean CreateNewTicket(Boolean split_evenly, List<Double> payment_amounts, int ticket_type, int group_id){
        ticketDB.addTicketEntry(group_id, groupsDB.getUsersFromGroup(group_id), payment_amounts, split_evenly, ticket_type);
        return false;
    }
}
