package User_related;

import Interfaces.IGroup;

import java.util.ArrayList;
import java.util.List;

public class Group implements IGroup {
    protected int groupID;
    protected String groupName;
    protected List<Integer> userIDList;

    public Group(String _name, int _id){
        groupID = _id;
        groupName = _name;
        userIDList = new ArrayList<>();
    }

    @Override
    public void addMember(int userID) {
        userIDList.add(userID);
    }

    @Override
    public void deleteMember(int userID) {
        userIDList.remove(userIDList);
    }

    @Override
    public void addPayment(Ticket ticket) {

    }

    @Override
    public double getTotalBalance() {
        return 0;
    }

    @Override
    public double[] getPreviousPayments() {
        return new double[0];
    }

    @Override
    public List<Integer> getUsers(){
        return userIDList;
    }

    @Override
    public String getName() {
        return groupName;
    }
}
