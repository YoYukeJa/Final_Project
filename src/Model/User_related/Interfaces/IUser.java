package Model.User_related.Interfaces;

import java.util.List;

public interface IUser {
    void addPayment(int id);
    void paybackPerson(double amount);
    void addGroup(int id);
    List<Integer> getGroupIDList();
    int getUserId();
    String getName();
    void addFriend(int id);
    void removeFriend(int id);
}
