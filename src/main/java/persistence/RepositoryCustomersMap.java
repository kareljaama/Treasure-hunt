package persistence;

import model.Customer;
import model.CustomersMap;
import model.Map;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RepositoryCustomersMap {

    private final EntityManager em;

    public RepositoryCustomersMap() {
        this.em = DBUtil.getEntityManager();
    }

    public void giveCustomerAMap(CustomersMap customersMap) {
        try {
            em.getTransaction().begin();
            em.persist(customersMap);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateCustomersMap(int customersMapId, int newCustomerId, int newMapId) {
        em.getTransaction().begin();
        int result = em.createQuery("UPDATE customers_map SET customer_id = :newCustomerId, map_id = :newMapId"
                + " WHERE customers_map_id = :id")
                .setParameter("newCustomerId", newCustomerId)
                .setParameter("newMapId", newMapId)
                .setParameter("customersMapId", customersMapId)
                .executeUpdate();
        if (result > 0) {
            System.out.println("Update was successful!");
        }
        em.getTransaction().commit();
    }

    // creat customized object?
    // shows address to info
    public List<Object[]> customersWhoHasMap() {
        return em.createQuery("select c.firstName, c.lastName, m.name from Customer as c " +
                "right join CustomersMap as cm " +
                "on c.customerId = cm.customerId left join Map as m " +
                "on m.mapId = cm.mapId")
                .getResultList();
    }
}
