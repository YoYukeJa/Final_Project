import Database.ApplicationDB;
import User_related.Group;
import User_related.User;

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
        db.editGroupEntry(g);
        System.out.println(db.getUserEntry(1).getName());
        System.out.println(db.getGroupEntry(0).getName());
        //System.out.println(db.getUsersFromGroup(0));
        List<Integer> lijstje = db.getUsersFromGroup(0);
        for (int i = 0; i < lijstje.size(); i++){
            System.out.println(db.getUserEntry(lijstje.get(i)).getName());
        }
        /*User user1 = new User("Jozef");
        User user2 = new User("Alice");
        User user3 = new User("Henry");*/


    }

}
