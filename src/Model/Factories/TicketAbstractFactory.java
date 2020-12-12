package Model.Factories;

import java.util.List;

public interface TicketAbstractFactory {
    User_related.Ticket create(int _id, int group_id, List<Integer> u_ids, List<Double> user_amounts, Boolean split_evenly, int k);

}
