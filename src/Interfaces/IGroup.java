package Interfaces;

import User_related.Ticket;

import java.util.List;

public interface IGroup {
    public void addMember(int userID);
    public void deleteMember(int userID);
    public void addPayment(Ticket ticket);
    public double getTotalBalance();
    public double[] getPreviousPayments();
    public List<Integer> getUsers();
    public String getName();
}
