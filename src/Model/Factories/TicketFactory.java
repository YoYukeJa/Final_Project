package Model.Factories;

import Model.User_related.NormalGroup;
import User_related.Ticket;

import java.util.List;

public class TicketFactory implements TicketAbstractFactory<Ticket> {

    @Override
    public Ticket create(int _id, int group_id, List<Integer> u_ids, List<Double> user_amounts, Boolean split_evenly, int k) {
        return new Ticket(_id, group_id, u_ids, user_amounts, split_evenly, k);
    }
}
