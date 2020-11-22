package Interfaces;

public interface IGroup {
    public void addMember(IUser user);
    public void deleteMember(IUser user);
    public void addPayment(ITicket ticket);
    public double getTotalBalance();
    public double[] getPreviousPayments();
}
