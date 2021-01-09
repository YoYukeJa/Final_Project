package IntegrationTests;

import Controller.TicketController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TicketControllerIntegrationTest {
    @Autowired
    private TicketController controller;

    @Test
    public void groupnameGivenWhenAsked(){
        controller = new TicketController();

        Assert.assertEquals("testgroep", controller.getGroupName(0));
    }
}
