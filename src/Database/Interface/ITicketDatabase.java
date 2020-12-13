package Database.Interface;

import Model.User_related.Ticket;

public interface ITicketDatabase extends ITicketTypeDatabase {

    void editTicketEntry(Ticket t);
    Ticket getTicketEntry(int id);
}
