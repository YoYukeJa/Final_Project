package Database;

import RegisterEntries.UserRegisterEntry;
import User_related.Group;
import User_related.Ticket;
import User_related.User;

import java.util.HashMap;
import java.util.List;
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
    public void addUserEntry(String _name) {
        int id = generateAuthenticId("user");
        User u = new User(_name, id);
        this.userDB.add(u);
    }

    @Override
    public void addGroupEntry(String _name) {
        int id = generateAuthenticId("group");
        Group g = new Group(_name, id);
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
    public User getUserEntry(int id) {
        return this.userDB.get(id);
    }

    @Override
    public Group getGroupEntry(int id) {
        return this.groupDB.get(id);
    }

    @Override
    public void addMemberToGroup(int id, User u) {

    }

    public List<Integer> getUsersFromGroup(int id){
        return this.groupDB.get(id).getUsers();
    }

    @Override
    public int generateAuthenticId(String choice) {
        int length = 0;
        if (choice.toLowerCase() == "group") {
            length = groupDB.size();
            return length;
        } else if (choice.toLowerCase() == "user") {
            length = userDB.size();
            return length;
        } else if (choice.toLowerCase() == "ticket") {
            length = ticketDB.size();
            return length;
        }
        return -1;
    }
}
