package User_related;

import Interfaces.IUser;

public class User implements IUser {
    protected int userId;

    protected String name;

    public User(String _name, int _id){
        name = _name;
        userId = _id;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void addPayment(double amount) {

    }

    @Override
    public void paybackPerson(double amount) {

    }

    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }
}
