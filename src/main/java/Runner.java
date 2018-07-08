import db.DBHelper;
import models.Actor;

public class Runner {

    public static void main(String[] args) {

        Actor actor1 = new Actor("Jennifer", "Aniston", 10000.00);
        DBHelper.save(actor1);
        Actor actor2 = new Actor("David", "Schwimmer", 5000.00);
        DBHelper.save(actor2);
        Actor actor3 = new Actor("Lisa", "Kudrow", 2500.00);
        DBHelper.save(actor3);

    }

}
