package db;

import models.Actor;
import models.Episode;
import models.Writer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBEpisode {

    private static Session session;


    public static void addActorToEpisode(Actor actor, Episode episode) {
        actor.addEpisode(episode);
        episode.addActors(actor);
        DBHelper.save(episode);
    }

    public static void addWriterToEpisode(Writer writer, Episode episode) {
        writer.addEpisode(episode);
        episode.addWriters(writer);
        DBHelper.save(episode);
    }

    public static List<Actor> getAllActorsForEpisode(Episode episode) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Actor> results = null;
        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("episodes", "episode");
            cr.add(Restrictions.eq("episode.id", episode.getId()));
            cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Writer> getAllWritersForEpisode(Episode episode) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Writer> results = null;
        try {
            Criteria cr = session.createCriteria(Writer.class);
            cr.createAlias("episodes", "episode");
            cr.add(Restrictions.eq("episode.id", episode.getId()));
            cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
