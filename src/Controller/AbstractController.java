package Controller;

import Database.GroupsDatabase;
import Database.TicketDatabase;
import Database.UserDatabase;

public abstract class AbstractController {
    protected UserDatabase userDB;
    protected GroupsDatabase groupsDB;
    protected TicketDatabase ticketDB;

    public AbstractController(){
        userDB = UserDatabase.getInstance();
        groupsDB = GroupsDatabase.getInstance();
        ticketDB = TicketDatabase.getInstance();
    }
}
