package Database;

import RegisterEntries.UserRegisterEntry;
import User_related.Group;
import User_related.Ticket;
import User_related.User;

import java.util.HashMap;

public class ApplicationDB extends Database {

    protected boolean single_instance;
    private final HashMap<User, UserRegisterEntry> userDB;

    public ApplicationDB(){

        userDB = new HashMap<>();
    }

    @Override
    public void addUserEntry(User u, UserRegisterEntry re) {
        this.userDB.put(u, re);
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
        return this.userDB.get(u);
    }
}
