package Database;

import Database.Interface.IUserDatabase;
import Model.Factories.UserFactory;
import Model.User_related.Users;

import java.util.Vector;

public class UserDatabase extends Database implements IUserDatabase {
    protected final Vector<Users> usersDB;
    private static UserDatabase single_instance;

    private UserDatabase() {
        usersDB = new Vector<>();
    }

    public static UserDatabase getInstance(){
        if (single_instance == null){
            single_instance = new UserDatabase();
        }
        return single_instance;
    }

    @Override
    public void addEntry(String _name) {
        int id = generateAuthenticId(usersDB);
        Users u  = new UserFactory().create("default", _name, id);
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

    public int getLengthOfDatabase(){
        return usersDB.size();
    }

    @Override
    public void addTicketToUser(int u_id, int ticket_id) {
        Users u = usersDB.get(u_id);
        u.addPayment(ticket_id);
        editUserEntry(u);
    }
}