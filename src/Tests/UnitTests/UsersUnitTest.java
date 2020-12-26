package Tests.UnitTests;

import Model.User_related.DefaultUser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UsersUnitTest {
    Model.User_related.Users user1, user2, user3, user4;
    @Before
    public void Initialize(){
        user1 = new DefaultUser("Seraphine", 234, "appel".hashCode());
        user2 = new DefaultUser("Jos", 1, "appel".hashCode());
        user3 = new DefaultUser("Merel", 3456, "appel".hashCode());
        user4 = new DefaultUser("Alex", 0, "appel".hashCode());
    }

    @Test
    public void usersShouldReturnCorrectNameTest(){
        assertEquals("Username should be Seraphine", user1.getName(), "Seraphine");
        assertEquals("Username should be Jos", user2.getName(), "Jos");
        assertEquals("Username should be Merel", user3.getName(), "Merel");
        assertEquals("Username should be Alex", user4.getName(), "Alex");
    }

    @Test
    public void usersShouldReturnCorrectLengthOfAddedTicketsTest(){
        assertEquals(0, user1.getTickets().size());
        assertEquals(0, user2.getTickets().size());
        assertEquals(0, user3.getTickets().size());
        assertEquals(0, user4.getTickets().size());

        //Adding tickets to user1
        user1.addPayment(1);
        user1.addPayment(2);
        user1.addPayment(3);
        user1.addPayment(15);
        user1.addPayment(34575);

        //Adding tickets to user2
        user2.addPayment(1);
        user2.addPayment(2);
        user2.addPayment(3);
        user2.addPayment(15);

        //Adding tickets to user3
        user3.addPayment(1);
        user3.addPayment(2);
        user3.addPayment(3);

        //Adding tickets to user4
        user4.addPayment(1);
        user4.addPayment(2);


        assertEquals(5, user1.getTickets().size());
        assertEquals(4, user2.getTickets().size());
        assertEquals(3, user3.getTickets().size());
        assertEquals(2, user4.getTickets().size());
    }

    @Test
    public void userShouldReturnCorrectTicketsTest(){
        //Adding tickets to user1
        user1.addPayment(1);
        user1.addPayment(2);
        user1.addPayment(3);
        user1.addPayment(15);
        user1.addPayment(3475);

        List<Integer> list_user1 = new ArrayList<>();
        list_user1.add(1);
        list_user1.add(2);
        list_user1.add(3);
        list_user1.add(15);
        list_user1.add(3475);

        assertEquals(list_user1, user1.getTickets());
    }

    @Test
    public void userShouldReturnCorrectAmountOfGroupsTest(){
        assertEquals(0, user1.getGroupIDList().size());
        assertEquals(0, user2.getGroupIDList().size());
        assertEquals(0, user3.getGroupIDList().size());
        assertEquals(0, user4.getGroupIDList().size());

        //Adding groups to user1
        user1.addGroup(1);
        user1.addGroup(2);
        user1.addGroup(3);
        user1.addGroup(15);
        user1.addGroup(34575);

        //Adding groups to user2
        user2.addGroup(1);
        user2.addGroup(2);
        user2.addGroup(3);
        user2.addGroup(15);

        //Adding groups to user3
        user3.addGroup(1);
        user3.addGroup(2);
        user3.addGroup(3);

        //Adding groups to user4
        user4.addGroup(1);
        user4.addGroup(2);

        assertEquals(5, user1.getGroupIDList().size());
        assertEquals(4, user2.getGroupIDList().size());
        assertEquals(3, user3.getGroupIDList().size());
        assertEquals(2, user4.getGroupIDList().size());
    }

    @Test
    public void userShouldReturnCorrectGroupsTest(){
        //Adding groups to user1
        user1.addGroup(1);
        user1.addGroup(2);
        user1.addGroup(3);
        user1.addGroup(15);
        user1.addGroup(34575);

        List<Integer> list_user1 = new ArrayList<>();
        list_user1.add(1);
        list_user1.add(2);
        list_user1.add(3);
        list_user1.add(15);
        list_user1.add(34575);

        assertEquals(list_user1, user1.getGroupIDList());
    }

    @Test
    public void usersShouldReturnValidUserIDTest(){
        assertNotNull(user1.getUserId());
        assertNotNull(user2.getUserId());
        assertNotNull(user3.getUserId());
        assertNotNull(user4.getUserId());
    }

    @Test
    public void usersShouldReturnCorrectUserIDTest(){
        assertEquals(234, user1.getUserId());
        assertEquals(1, user2.getUserId());
        assertEquals(3456, user3.getUserId());
        assertEquals(0, user4.getUserId());
    }

}
