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
        if (id != -1) {
            User u = new User(_name, id);
            this.userDB.add(u);
        }
    }

    @Override
    public void addGroupEntry(String _name) {
        int id = generateAuthenticId("group");
        if (id != -1) {
            Group g = new Group(_name, id);
            this.groupDB.add(g);
        }
    }

    @Override
    public void addTicketEntry(int _group_id, List<Integer> u_ids, List<Double> _amount_per_user, int k) {
        int id = generateAuthenticId("ticket");
        if (id != -1){
            Ticket t = new Ticket(id, _group_id, u_ids, _amount_per_user, k);
            this.ticketDB.add(t);
            for (int i = 0; i < u_ids.size(); i++) {
                userDB.get(i).addPayment(id);
            }
            groupDB.get(_group_id).addPayment(id);
        }
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
    public Ticket getTicketEntry(int id){
        return this.ticketDB.get(id);
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
