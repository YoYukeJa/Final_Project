import Database.ApplicationDB;
import User_related.User;

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

        db.getUserEntry()
        /*User user1 = new User("Jozef");
        User user2 = new User("Alice");
        User user3 = new User("Henry");*/


    }

}
