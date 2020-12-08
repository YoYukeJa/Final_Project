package Model.User_related.Interfaces;

import java.util.List;

public interface IUser {
    public void deleteUser();
    public void addPayment(int id);
    public void paybackPerson(double amount);
    public void addGroup(int id);
    public List<Integer> getGroupIDList();
    public int getUserId();
    public String getName();
}
