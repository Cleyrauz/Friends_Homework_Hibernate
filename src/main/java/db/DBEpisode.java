package db;

import models.Actor;
import models.Episode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBEpisode {

    private static Session session;


    public static void addActorToEpisode(Actor actor, Episode episode) {
        actor.addEpisode(episode);
        episode.addActors(actor);
        DBHelper.save(episode);
    }

    public static List<Actor> getAllActorsForEpisode(Episode episode) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Actor> results = null;
        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("episodes", "episode");
            cr.add(Restrictions.eq("episode.id", episode.getId()));
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
