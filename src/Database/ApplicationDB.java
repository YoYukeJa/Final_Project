package Database;

import Model.User_related.Groups;
import User_related.Ticket;
import Model.User_related.DefaultUser;
import User_related.Users;

import java.util.List;

public class ApplicationDB {



    public ApplicationDB(){


    }
/*
    @Override
    public void addUserEntry(String _name) {
        int id = generateAuthenticId("user");
        if (id != -1) {
            Users u = new DefaultUser(_name, id);
            this.UsersDB.add(u);
        }
    }

    @Override
    public void addGroupEntry(String _name) {
        int id = generateAuthenticId("group");
        if (id != -1) {
            User_related.NormalGroup g = new User_related.NormalGroup(_name, id);
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
                UsersDB.get(i).addPayment(id);
            }
            groupDB.get(_group_id).addPayment(id);
        }
    }

    @Override
    public void editUserEntry(DefaultUser u) {

    }

    @Override
    public void editGroupEntry(Groups g) {

    }

    @Override
    public void editTicketEntry(Ticket t) {

    }

    @Override
    public Users getUserEntry(int id) {
        return this.UsersDB.get(id);
    }

    @Override
    public Groups getGroupEntry(int id) {
        return this.groupDB.get(id);
    }

    @Override
    public Ticket getTicketEntry(int id){
        return this.ticketDB.get(id);
    }

    @Override
    public void addMemberToGroup(int id, DefaultUser u) {

    }

    public List<Integer> getUsersFromGroup(int id){
        return this.groupDB.get(id).getUsers();
    }
*/
}
