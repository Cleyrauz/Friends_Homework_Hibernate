package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="studios")
public class Studio {

    private int id;
    private String name;
    private int budget;
    private String location;
    private List<Episode> episodes;
    private List<Set> sets;

    public Studio(){

    }

    public Studio(String name, int budget, String location) {
        this.name = name;
        this.budget = budget;
        this.location = location;
        this.episodes = new ArrayList<Episode>();
        this.sets = new ArrayList<Set>();
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
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
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


    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public void addSets(Set set){
        this.sets.add(set);
    }

    public void addEpisodes(Episode episode){
        this.episodes.add(episode);
    }

    public int paidMember(int amount){
        this.budget -= amount;
        return this.budget;
    }
}

