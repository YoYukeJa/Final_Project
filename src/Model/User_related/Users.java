package User_related;

import Interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

public abstract class Users implements IUser {
    // Class variables
    protected int userId;
    protected List<Integer> groupIDList;
    protected List<Integer> ticketIDList;
    protected String name;

    // Constructor
    public Users(String _name, int _id){
        name = _name;
        userId = _id;
        groupIDList = new ArrayList<>();
        ticketIDList = new ArrayList<>();
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void addPayment(int id) {
        ticketIDList.add(id);
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

    public List<Integer> getTickets(){
        return ticketIDList;
    }
}
