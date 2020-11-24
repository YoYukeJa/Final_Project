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

    public ApplicationDB(){

        userDB = new Vector<>();
    }

    @Override
    public void addUserEntry(User u, UserRegisterEntry re) {
        this.userDB.add(u);
    }

    @Override
    public void addGroupEntry(Group g) {

    }

    @Override
    public void addTicketEntry(Ticket t) {

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
    public UserRegisterEntry getUserEntry(User u) {
        return this.userDB.get(u.id);
    }
}
