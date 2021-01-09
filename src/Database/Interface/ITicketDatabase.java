package Database.Interface;

import Model.User_related.Ticket;

import java.util.List;

public interface ITicketDatabase {

    int addTicketEntry(int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, boolean split_evenly, int k);
    void editTicketEntry(Ticket t);
    Ticket getTicketEntry(int id);
}
