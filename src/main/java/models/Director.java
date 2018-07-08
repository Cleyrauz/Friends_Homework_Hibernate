package models;

import models.Episode;
import models.Member;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="directors")
public class Director extends Member {

    private List<Episode> episodes;

    public Director(){

    }

    public Director(String firstName, String lastName, int money) {
        super(firstName, lastName, money);
        this.episodes = new ArrayList<Episode>();
    }

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    public List<Episode> getEpisodes() {
        return episodes;
    }


    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisodes(Episode episode){
       this.episodes.add(episode);
    }
}

