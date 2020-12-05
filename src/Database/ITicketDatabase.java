package Database;

import User_related.Ticket;

public interface ITicketDatabase extends ITicketTypeDatabase {

    void editTicketEntry(Ticket t);
    Ticket getTicketEntry(int id);
}
