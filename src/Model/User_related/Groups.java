package Model.User_related;

import Interfaces.IGroup;

import java.util.ArrayList;
import java.util.List;

public class Groups implements IGroup {
    protected int groupID;
    protected String groupName;
    protected List<Integer> userIDList;
    protected List<Integer> ticketIDList;

    public Groups(String _name, int _id){
        groupID = _id;
        groupName = _name;
        userIDList = new ArrayList<>();
        ticketIDList = new ArrayList<>();
    }

    @Override
    public void addMember(int userID) {
        userIDList.add(userID);
    }

    @Override
    public void deleteMember(int userID) {
        userIDList.remove(userID);
    }

    @Override
    public void addPayment(int id) {
        ticketIDList.add(id);
    }

    @Override
    public double getTotalBalance() {
        return 0;
    }

    @Override
    public List<Integer> getTicketIDList() {
        return ticketIDList;
    }

    @Override
    public List<Integer> getUsers(){
        return userIDList;
    }

    @Override
    public String getName() {
        return groupName;
    }

    @Override
    public int getIndex() {
        return groupID;
    }
}
