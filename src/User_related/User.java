package User_related;

import Interfaces.IUser;

public class User implements IUser {
    protected int userId;

    public User(){

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
}
