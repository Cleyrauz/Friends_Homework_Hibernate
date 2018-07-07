package db;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actors")
public class Actor extends Member {

    private List<Episode> episodes;

    public Actor(String firstName, String lastName, double money) {
        super(firstName, lastName, money);
        this.episodes = new ArrayList<Episode>();
    }

    public Actor() {

    }

    @Cascade(CascadeType.SAVE_UPDATE)
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
}
