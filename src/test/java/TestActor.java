import models.Actor;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestActor {

    Actor actor1, actor2, actor3;
    Studio studio;

    @Before
    public void setUp(){
        actor1 = new Actor("Jennifer", "Aniston", 10000);
        actor2 = new Actor("David", "Schwimmer", 5000);
        actor3 = new Actor("Lisa", "Kudrow", 2500);

        studio = new Studio("Warner Bros. Studio", 1000000, "Los Angeles");
    }

    @Test
    public void canGetPaidAndCanReduceBudgetForStudio(){
        actor1.getPaid(10000);
        studio.paidMember(10000);
        assertEquals(20000, actor1.getMoney());
        assertEquals(990000, studio.getBudget());
    }

}
