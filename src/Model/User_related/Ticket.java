package Model.User_related;

import Model.User_related.Interfaces.ITicket;

import java.util.List;

enum TicketType {
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
    protected boolean split_evenly = false;
    protected List<Integer> user_id;
    protected List<Double> amount_per_user;
    protected TicketType ticketType;
    

    public Ticket(int _id, int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, boolean _split_evenly, int k){
        id = _id;
        group_id = _group_id;
        user_id = u_ids;
        amount_per_user = _amount_per_user;
        ticketType = editTypeOfTicket(k);
        split_evenly = _split_evenly;
    }

    public void changeSplit_evenly() {
        this.split_evenly = !split_evenly;
    }

    public TicketType editTypeOfTicket(int k) {
        switch (k){
            case 0:
                return TicketType.movieticket;
            case 1:
                return TicketType.trafficticket;
            case 2:
                return TicketType.drinks;
            case 3:
                return TicketType.food;
            case 4:
                return TicketType.supermarket;
            case 5:
                return TicketType.housing;
            case 6:
                return TicketType.publictransport;
        }
        return null;
    }

    @Override
    public void editTicket() {

    }

    public String getType(){
        return ticketType.toString();
    }

    public int getId(){
        return id;
    }

    @Override
    public double getTicketAmount(int id) {
        System.out.println("Voor id " + id + " vinden we: " + amount_per_user);
        return amount_per_user.get(id);
    }

    public List<Integer> getUserIDs() { return user_id; }

    public double getTotalAmount(){
        return amount_per_user.stream().mapToDouble(Double::doubleValue).sum();
    }
}
