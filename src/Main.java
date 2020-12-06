import Database.ApplicationDB;
import Database.*;
import Model.User_related.Groups;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }

    public Main(){}

    public void run(){
        UserDatabase userdb = new UserDatabase();
        GroupsDatabase groupdb = new GroupsDatabase();
        TicketDatabase ticketdb = new TicketDatabase();

        userdb.addEntry("Alice");
        userdb.addEntry("Mina");
        userdb.addEntry("Henry");
        userdb.addEntry("Alois");
        userdb.addEntry("Minx");

        groupdb.addEntry("testgroep");
        Groups g = groupdb.getGroupEntry(0);
        g.addMember(0);
        g.addMember(1);
        g.addMember(3);
        userdb.getUserEntry(0).addGroup(0);
        userdb.getUserEntry(1).addGroup(0);
        userdb.getUserEntry(3).addGroup(0);
        groupdb.editGroupEntry(g);
        //How to get username from db
        System.out.println(userdb.getUserEntry(1).getName());
        //How to get groupname from db
        System.out.println(groupdb.getGroupEntry(0).getName());
        //System.out.println(db.getUsersFromGroup(0));

        //Get list of user ids from a group and print their names
        List<Integer> lijstje = groupdb.getUsersFromGroup(0);
        for (int i = 0; i < lijstje.size(); i++){
            System.out.println(userdb.getUserEntry(lijstje.get(i)).getName());
        }
        /* How to get group ID
        System.out.println(db.getUserEntry(0).getGroupIDList());
        System.out.println(db.getUserEntry(1).getGroupIDList());
        System.out.println(db.getUserEntry(3).getGroupIDList());
        */
        List<Double> amounts = new ArrayList<>();
        amounts.add(5.5);
        amounts.add(23.4);
        amounts.add(31.35);
        List<Integer> userlist = groupdb.getUsersFromGroup(0);
        int temp_id = ticketdb.addTicketEntry(0, groupdb.getUsersFromGroup(0), amounts, 2);
        //int temp_id = 0;
        for (int i = 0; i < userlist.size(); i++){
            userdb.addTicketToUser(userlist.get(i), temp_id);
        }
        groupdb.addTicketToGroup(0, temp_id);

        List<Integer> ticketIds = groupdb.getGroupEntry(0).getTicketIDList();

        for (int i = 0; i < ticketIds.size(); i++){
            for (int j = 0; j < lijstje.size(); j++) {
                //How to get the name of the user and the amount they need to pay FROM A GROUP
                System.out.println("De gebruiker " + userdb.getUserEntry(lijstje.get(j)).getName() + " moet betalen: " + ticketdb.getTicketEntry(ticketIds.get(i)).getTicketAmount(j));
            }
        }
        //gives list of all tickets currently related to the user
        System.out.println(userdb.getUserEntry(1).getTickets());
        //Gives the total amount of a ticket in Double form.
        System.out.println(ticketdb.getTicketEntry(0).getTotalAmount());

    }

}
