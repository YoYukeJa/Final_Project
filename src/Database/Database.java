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
    }

    public int generateAuthenticId(Vector list) {
        return list.size();
    }
}
