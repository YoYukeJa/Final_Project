package User_related;

import Interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    protected int userId;
    protected List<Integer> groupIDList;
    protected String name;

    public User(String _name, int _id){
        name = _name;
        userId = _id;
        groupIDList = new ArrayList<>();
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

    @Override
    public void addGroup(int id){
        groupIDList.add(id);
    }

    @Override
    public List<Integer> getGroupIDList() {
        return groupIDList;
    }

    @Override
    public int getUserId(){
        return userId;
    }
    
    @Override
    public String getName(){
        return name;
    }
}
