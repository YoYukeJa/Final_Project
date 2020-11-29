import Database.ApplicationDB;
import User_related.Group;
import User_related.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }

    public Main(){}

    public void run(){
        ApplicationDB db = new ApplicationDB();

        db.addUserEntry("Alice");
        db.addUserEntry("Mina");
        db.addUserEntry("Henry");
        db.addUserEntry("Alois");
        db.addUserEntry("Minx");

        db.addGroupEntry("testgroep");
        Group g = db.getGroupEntry(0);
        g.addMember(0);
        g.addMember(1);
        g.addMember(3);
        db.getUserEntry(0).addGroup(0);
        db.getUserEntry(1).addGroup(0);
        db.getUserEntry(3).addGroup(0);
        db.editGroupEntry(g);
        //How to get username from db
        System.out.println(db.getUserEntry(1).getName());
        //How to get groupname from db
        System.out.println(db.getGroupEntry(0).getName());
        //System.out.println(db.getUsersFromGroup(0));

        //Get list of user ids from a group and print their names
        List<Integer> lijstje = db.getUsersFromGroup(0);
        for (int i = 0; i < lijstje.size(); i++){
            System.out.println(db.getUserEntry(lijstje.get(i)).getName());
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
        db.addTicketEntry(0, db.getUsersFromGroup(0), amounts, 2);
        List<Integer> ticketIds = db.getGroupEntry(0).getTicketIDList();
        for (int i = 0; i < ticketIds.size(); i++){
            for (int j = 0; j < lijstje.size(); j++) {
                //How to get the name of the user and the amount they need to pay FROM A GROUP
                System.out.println("De gebruiker " + db.getUserEntry(lijstje.get(j)).getName() + " moet betalen: " + db.getTicketEntry(ticketIds.get(i)).getTicketAmount(j));
            }
        }
        //gives list of all tickets currently related to the user
        System.out.println(db.getUserEntry(1).getTickets());
        //Gives the total amount of a ticket in Double form.
        System.out.println(db.getTicketEntry(0).getTotalAmount());

    }

}
