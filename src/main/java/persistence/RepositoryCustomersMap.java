package persistence;

import model.CustomersMap;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryCustomersMap {

    private final EntityManager em;

    public RepositoryCustomersMap() {
        this.em = DBUtil.getEntityManager();
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

    public List<CustomersMap> customersWhoHasMapByMapId(int mapid) {
        return em.createQuery("FROM CustomersMap WHERE map_id = :id")
                .setParameter("id", mapid)
                .getResultList();
    }
}
