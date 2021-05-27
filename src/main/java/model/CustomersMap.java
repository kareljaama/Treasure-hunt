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
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private Map map;

    public int getCustomersMapId() {
        return customersMapId;
    }

    public void setCustomersMapId(int customersMapId) {
        this.customersMapId = customersMapId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "CustomersMap{" +
                "customersMapId=" + customersMapId +
                ", customer=" + customer +
                ", map=" + map +
                '}';
    }
}
