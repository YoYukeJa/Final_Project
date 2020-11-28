package Interfaces;

import java.util.List;

public interface IUser {
    public void deleteUser();
    public void addPayment(double amount);
    public void paybackPerson(double amount);
    public void addGroup(int id);
    public List<Integer> getGroupIDList();
    public int getUserId();
    public String getName();
}
