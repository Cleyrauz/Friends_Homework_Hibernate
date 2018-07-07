package db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="studios")
public class Studio {

    private int id;
    private String name;
    private double budget;
    private String location;
    private List<Episode> episodes;
//    private List<Set> sets;

    public Studio(){

    }

    public Studio(String name, double budget, String location) {
        this.name = name;
        this.budget = budget;
        this.location = location;
        this.episodes = new ArrayList<Episode>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Column(name="location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}

