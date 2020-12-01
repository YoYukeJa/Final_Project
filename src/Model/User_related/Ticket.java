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
    

    public Ticket(int _id, int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, int k){
        id = _id;
        group_id = _group_id;
        user_id = u_ids;
        amount_per_user = _amount_per_user;
        type = editTypeOfTicket(k);
    }

    public Type editTypeOfTicket(int k) {
        switch (k){
            case 0:
                return Type.movieticket;
            case 1:
                return Type.trafficticket;
            case 2:
                return Type.drinks;
            case 3:
                return Type.food;
            case 4:
                return Type.supermarket;
            case 5:
                return Type.housing;
            case 6:
                return Type.publictransport;
        }
        return null;
    }

    @Override
    public void editTicket() {

    }

    @Override
    public double getTicketAmount(int id) {
        return amount_per_user.get(id);
    }

    public double getTotalAmount(){
        return amount_per_user.stream().mapToDouble(Double::doubleValue).sum();
    }
}
