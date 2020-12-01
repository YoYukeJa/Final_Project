package Database;

import RegisterEntries.UserRegisterEntry;
import User_related.Group;
import User_related.Ticket;
import User_related.User;

import java.util.List;

public abstract class Database {
    protected boolean single_instance;


    public Database(){

    }

    public abstract void addEntry(String _name);

    public abstract void addUserEntry(String _name);
    public abstract void addGroupEntry(String name);
    public abstract void addTicketEntry(int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, int k);

    public abstract void editUserEntry(User u);
    public abstract void editGroupEntry(Group g);
    public abstract void editTicketEntry(Ticket t);

    public abstract User getUserEntry(int id);
    public abstract Group getGroupEntry(int id);
    public abstract Ticket getTicketEntry(int id);

    public abstract void addMemberToGroup(int id, User u);

    public abstract int generateAuthenticId(String choice);
}
