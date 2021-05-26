package model;


import javax.persistence.*;

@Entity
@Table(name = "map")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_id")
    private int mapId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Map: " +
                "mapId = " + mapId +
                ", name = " + name +
                ", description = " + description;
    }
}
