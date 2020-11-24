package Database;

import RegisterEntries.UserRegisterEntry;
import User_related.Group;
import User_related.Ticket;
import User_related.User;

import java.util.HashMap;
import java.util.Vector;

public class ApplicationDB extends Database {

    protected boolean single_instance;
    private final Vector<User> userDB;
    private final Vector<Ticket> ticketDB;
    private final Vector<Group> groupDB;

    public ApplicationDB(){

        userDB = new Vector<>();
        ticketDB = new Vector<>();
        groupDB = new Vector<>();
    }

    @Override
    public void addUserEntry(User u) {
        this.userDB.add(u);
    }

    @Override
    public void addGroupEntry(Group g) {
        this.groupDB.add(g);
    }

    @Override
    public void addTicketEntry(Ticket t) {
        this.ticketDB.add(t);
    }

    @Override
    public void editUserEntry(User u) {

    }

    @Override
    public void editGroupEntry(Group g) {

    }

    @Override
    public void editTicketEntry(Ticket t) {

    }

    @Override
    public User getUserEntry(User u) {
        return this.userDB.get(u.getUserId());
    }
}
