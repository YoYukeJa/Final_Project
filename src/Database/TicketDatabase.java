package Database;

import User_related.Ticket;

import java.util.List;
import java.util.Vector;

public class TicketDatabase extends Database implements ITicketDatabase {
    protected final Vector<Ticket> ticketDB;

    public TicketDatabase() {
        this.ticketDB = new Vector<>();
    }

    @Override
    public void editTicketEntry(Ticket t) {

    }

    @Override
    public Ticket getTicketEntry(int id) {
        return null;
    }

    @Override
    public void addTicketEntry(int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, int k) {

    }
}
