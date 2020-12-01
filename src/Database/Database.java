package Database;

import Model.User_related.Groups;
import User_related.Ticket;
import Model.User_related.DefaultUser;
import User_related.Users;

import java.util.List;
import java.util.Vector;

public abstract class Database {
    protected boolean single_instance;


    public Database(){

    protected boolean single_instance;
    protected final Vector<Users> UsersDB;
    protected final Vector<Ticket> ticketDB;
    protected final Vector<Groups> groupDB;

    public Database(){
        UsersDB = new Vector<>();
        ticketDB = new Vector<>();
        groupDB = new Vector<>();
    }

    public abstract void addEntry(String _name);

    public abstract void addUserEntry(String _name);
    public abstract void addGroupEntry(String name);
    public abstract void addTicketEntry(int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, int k);

    public abstract void editUserEntry(DefaultUser u);
    public abstract void editGroupEntry(Groups g);
    public abstract void editTicketEntry(Ticket t);

    public abstract Users getUserEntry(int id);
    public abstract Groups getGroupEntry(int id);
    public abstract Ticket getTicketEntry(int id);

    public abstract void addMemberToGroup(int id, DefaultUser u);

    public int generateAuthenticId(String choice) {
        int length = 0;
        if (choice.toLowerCase() == "group") {
            length = groupDB.size();
            return length;
        } else if (choice.toLowerCase() == "user") {
            length = UsersDB.size();
            return length;
        } else if (choice.toLowerCase() == "ticket") {
            length = ticketDB.size();
            return length;
        }
        return -1;
    }
}
