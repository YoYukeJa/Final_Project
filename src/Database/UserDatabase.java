package Database;

import Model.User_related.DefaultUser;
import User_related.Users;

import java.util.Vector;

public class UserDatabase extends Database implements IUserDatabase{
    protected final Vector<Users> usersDB;

    public UserDatabase() {
        usersDB = new Vector<>();
    }

    @Override
    public void addEntry(String _name) {
        int id = generateAuthenticId(usersDB);
        Users u = new DefaultUser(_name, id);
        usersDB.add(u);
    }

    @Override
    public void editUserEntry(Users u) {
        usersDB.set(u.getUserId(), u);
    }

    @Override
    public Users getUserEntry(int id) {
        return this.usersDB.get(id);
    }

    @Override
    public void addTicketToUser(int u_id, int ticket_id) {
        Users u = usersDB.get(u_id);
        u.addPayment(ticket_id);
        editUserEntry(u);
    }
}