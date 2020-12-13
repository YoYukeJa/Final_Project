package Model.Factories;

import Model.User_related.Ticket;

import java.util.List;

public class TicketFactoryProvider {
    public Ticket getTicketFactory(int _id, int group_id, List<Integer> u_ids, List<Double> user_amounts, Boolean split_evenly, int k){
        return new TicketFactory().create(_id, group_id, u_ids, user_amounts, split_evenly, k);
    }
}
