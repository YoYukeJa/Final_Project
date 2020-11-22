package User_related;

import Interfaces.ITicket;

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
    protected int user_id;
    protected Type type;
    

    public Ticket(){
        
    }

    @Override
    public void editTicket() {

    }

    @Override
    public void getTicket(int id) {

    }
}
