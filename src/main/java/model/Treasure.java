package model;

import javax.persistence.*;

@Entity
@Table(name = "treasures")
public class Treasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treasure_id")
    private int treasureId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private int value;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Treasure(String name, int value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public Treasure() {

    }

    public int getTreasureId() {
        return treasureId;
    }

    public void setTreasureId(int treasureId) {
        this.treasureId = treasureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Treasure: " +
                "Id = " + treasureId +
                ", name = " + name +
                ", value = " + value +
                ", description = " + description;
    }
}
