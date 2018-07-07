package models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="writers")
public class Writer extends Member {

    private List<Episode> episodes;

    public Writer(){

    }

    public Writer(String firstName, String lastName, double money) {
        super(firstName, lastName, money);
        this.episodes = new ArrayList<Episode>();
    }

    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name="episode_writer",
    joinColumns = {@JoinColumn(name="writer_id", nullable = false, updatable = false)},
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
