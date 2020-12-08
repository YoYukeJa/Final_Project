package Database.Interface;

import Database.Database;

import java.util.List;

public interface ITicketTypeDatabase {
    int addTicketEntry(int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, int k);
}
