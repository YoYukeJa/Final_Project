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
        ticketDB.set(t.getId(), t);
    }

    @Override
    public Ticket getTicketEntry(int id) {
        return this.ticketDB.get(id);
    }

    @Override
    public int addTicketEntry(int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, int k) {
        int id = generateAuthenticId(ticketDB);
        if (id != -1){
            System.out.println(_amount_per_user);
            Ticket t = new Ticket(id, _group_id, u_ids, _amount_per_user, k);
            this.ticketDB.add(t);
            /*for (int i = 0; i < u_ids.size(); i++) {
                UsersDB.get(i).addPayment(id);
            }
            groupDB.get(_group_id).addPayment(id);*/
        }
        return id;
    }
}
