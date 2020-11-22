package User_related;

import Interfaces.IGroup;
import Interfaces.ITicket;
import Interfaces.IUser;

public class Group implements IGroup {
    @Override
    public void addMember(IUser user) {

    }

    @Override
    public void deleteMember(IUser user) {

    }

    @Override
    public void addPayment(ITicket ticket) {

    }

    @Override
    public double getTotalBalance() {
        return 0;
    }

    @Override
    public double[] getPreviousPayments() {
        return new double[0];
    }
}
