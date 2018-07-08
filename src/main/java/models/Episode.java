package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="episodes")
public class Episode {

    private int id;
    private int year;
    private String title;
    private Director director;
    private List<Actor> cast;
    private List<Writer> writers;
    private Studio studio;
    private Season season;

    public Episode(){

    }

    public Episode(int year, String title, Director director, Studio studio, Season season) {
        this.year = year;
        this.title = title;
        this.director = director;
        this.cast = new ArrayList<Actor>();
        this.writers = new ArrayList<Writer>();
        this.studio = studio;
        this.season = season;
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

    @Column(name="year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name="director_id", nullable = false)
    public Director getDirector() {
        return director;
    }


    public void setDirector(Director director) {
        this.director = director;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name="episode_cast",
    joinColumns = {@JoinColumn(name="episode_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="actor_id", nullable = false, updatable = false)})
    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name="episode_writer",
    joinColumns = {@JoinColumn(name="episode_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="writer_id", nullable = false, updatable = false)})
    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    @ManyToOne
    @JoinColumn(name="studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @Enumerated(EnumType.STRING)
    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void addActors(Actor actor){
        this.cast.add(actor);
    }

    public void addWriters(Writer writer){
        this.writers.add(writer);
    }
}

