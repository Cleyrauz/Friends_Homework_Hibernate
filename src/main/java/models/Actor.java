package models;

import models.Episode;
import models.Member;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actors")
public class Actor extends Member {

    private List<Episode> episodes = new ArrayList<Episode>();

    public Actor() {

    }

    public Actor(String firstName, String lastName, int money) {
        super(firstName, lastName, money);
    }


    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name="episode_cast",
    joinColumns = {@JoinColumn(name="actor_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="episode_id", nullable = false, updatable = false)})
    public List<Episode> getEpisodes() {
        return episodes;
    }


    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisode(Episode episode){
        this.episodes.add(episode);
    }

}
