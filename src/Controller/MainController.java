package Controller;

import Model.User_related.Ticket;

import java.util.ArrayList;
import java.util.List;

public class MainController extends AbstractController{

    public List<Ticket> getTicketHistory(int id){
        List<Ticket> tickets = new ArrayList<>();
        for (int ticket_id: userDB.getUserEntry(id).getTickets()
             ) {
            tickets.add(ticketDB.getTicketEntry(ticket_id));
        }
        return tickets;
    }
}
