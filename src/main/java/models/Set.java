package models;

import models.Studio;

import javax.persistence.*;

@Entity
@Table(name="sets")
public class Set {

    private int id;
    private String name;
    private String location;
    private Studio studio;

    public Set(){

    }

    public Set(String name, String location, Studio studio) {
        this.name = name;
        this.location = location;
        this.studio = studio;
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
    @Column(name="location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @ManyToOne
    @JoinColumn(name="studio_id", nullable=false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
