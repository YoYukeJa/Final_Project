package Database;

import RegisterEntries.UserRegisterEntry;
import User_related.Group;
import User_related.Ticket;
import User_related.User;

public abstract class Database {
    public Database(){

    }

    public abstract void addUserEntry(User u);
    public abstract void addGroupEntry(Group g);
    public abstract void addTicketEntry(Ticket t);

    public abstract void editUserEntry(User u);
    public abstract void editGroupEntry(Group g);
    public abstract void editTicketEntry(Ticket t);

    public abstract User getUserEntry(User u);
}
