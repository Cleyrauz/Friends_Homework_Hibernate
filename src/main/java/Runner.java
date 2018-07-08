import db.DBHelper;
import models.*;

public class Runner {

    public static void main(String[] args) {

        Actor actor1 = new Actor("Jennifer", "Aniston", 10000);
        DBHelper.save(actor1);
        Actor actor2 = new Actor("David", "Schwimmer", 5000);
        DBHelper.save(actor2);
        Actor actor3 = new Actor("Lisa", "Kudrow", 2500);
        DBHelper.save(actor3);

        Director director = new Director("David", "Crane", 12000);
        DBHelper.save(director);

        Writer writer1 = new Writer("Marta", "Kauffman", 3000);
        Writer writer2 = new Writer("Scott", "Silveri", 8000);
        Writer writer3= new Writer("Alexa", "Junge", 6000);
        DBHelper.save(writer1);
        DBHelper.save(writer2);
        DBHelper.save(writer3);


        Studio studio = new Studio("Warner Bros. Studio", 1000000, "Los Angeles");
        DBHelper.save(studio);

        Set set1 = new Set("Central Perk", "Los Angeles", studio);
        Set set2 = new Set("Ross's House", "Los Angeles", studio);
        Set set3 = new Set("Joey's House", "Los Angeles", studio);
        DBHelper.save(set1);
        DBHelper.save(set2);
        DBHelper.save(set3);

       studio.addSets(set1);
       studio.addSets(set2);
       studio.addSets(set3);

       Episode episode1 = new Episode(1994, "Chandler accidentally reveals that Ross loves Rachel", director,
               studio, Season.S1);
       Episode episode2 = new Episode(1994, "Chandler breaks up with girlfriend Janice", director,
                studio, Season.S1);
       Episode episode3 = new Episode(1994, "Carol delivers a baby boy who is named Ben", director,
                studio, Season.S1);
       Episode episode4 = new Episode(1994, "Monica begins dating Richard", director,
                studio, Season.S2);
       DBHelper.save(episode1);
       DBHelper.save(episode2);
       DBHelper.save(episode3);
       DBHelper.save(episode4);


        actor1.addEpisode(episode1);
        actor2.addEpisode(episode2);
        actor3.addEpisode(episode3);
        actor1.addEpisode(episode2);
        actor1.addEpisode(episode2);
        actor3.addEpisode(episode4);
        actor1.addEpisode(episode4);

        director.addEpisodes(episode1);
        director.addEpisodes(episode2);
        director.addEpisodes(episode3);
        director.addEpisodes(episode4);


        studio.addEpisodes(episode1);
        studio.addEpisodes(episode2);
        studio.addEpisodes(episode3);
        studio.addEpisodes(episode4);

        writer1.addEpisode(episode1);
        writer2.addEpisode(episode2);
        writer3.addEpisode(episode3);
        writer3.addEpisode(episode4);

        episode1.addActors(actor1);
        episode1.addActors(actor2);
        episode1.addActors(actor3);
        episode1.addWriters(writer1);
        episode2.addActors(actor1);
        episode2.addActors(actor2);
        episode2.addActors(actor3);
        episode2.addWriters(writer2);
        episode3.addActors(actor1);
        episode3.addActors(actor2);
        episode3.addActors(actor3);
        episode3.addWriters(writer3);
        episode4.addActors(actor1);
        episode4.addActors(actor2);
        episode4.addActors(actor3);
        episode4.addWriters(writer2);

    }

}
