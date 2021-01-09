package Controller;

import Database.GroupsDatabase;
import Database.TicketDatabase;
import Database.UserDatabase;

public abstract class AbstractController {
    protected UserDatabase userDB;
    protected GroupsDatabase groupsDB;
    protected TicketDatabase ticketDB;
    protected static Integer current_user;

    public AbstractController(){
        userDB = UserDatabase.getInstance();
        groupsDB = GroupsDatabase.getInstance();
        ticketDB = TicketDatabase.getInstance();
    }

    public void logOut() {
        current_user = null;
    }

    public void update(GroupsDatabase _groupsDB){
        groupsDB = _groupsDB;
    }
}
