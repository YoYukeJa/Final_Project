package User_related;

import Interfaces.ITicket;

import java.util.List;

enum Type {
    movieticket,
    trafficticket,
    drinks,
    food,
    supermarket,
    housing,
    publictransport
};

public class Ticket implements ITicket {
    protected int id;
    protected int group_id;
    protected List<Integer> user_id;
    protected List<Double> amount_per_user;
    protected Type type;
    protected boolean total_amount;
    

    public Ticket(int _id, int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, Type _type){
        id = _id;
        group_id = _group_id;
        user_id = u_ids;
        amount_per_user = _amount_per_user;
        type = _type;
    }

    @Override
    public void editTicket() {

    }

    @Override
    public double getTicketAmount(int id) {
        return amount_per_user.get(id);
    }
}
