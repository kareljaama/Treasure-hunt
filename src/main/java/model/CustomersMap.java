package model;

import javax.persistence.*;

@Entity
@Table(name = "customers_map")
public class CustomersMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customers_map_id")
    private int customersMapId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String  lastName;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private Map mapId;

    @Column(name = "map_name")
    private String mapName;

    public CustomersMap(Customer customerId, Map mapId) {
        this.customerId = customerId;
        this.mapId = mapId;
    }

    public CustomersMap(int customerId, int mapId) {

    }

    public int getCustomersMapId() {
        return customersMapId;
    }

    public void setCustomersMapId(int customersMapId) {
        this.customersMapId = customersMapId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomer(Customer customer) {
        this.customerId = customer;
    }

    public Map getMapId() {
        return mapId;
    }

    public void setMapId(Map mapId) {
        this.mapId = mapId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    @Override
    public String toString() {
        return "CustomersMap: " +
                "customersMapId = " + customersMapId +
                ", customer = " + customerId +
                ", map = " + mapId;
    }


}
