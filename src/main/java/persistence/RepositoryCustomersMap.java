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

  //  Parameter value ([1] - inserted value from keyboard) did not match expected type

//    public void updateCustomersWhoHasMap(int customersMapId, int newCustomerId, int newMapId) {
//        em.getTransaction().begin();
//        int result = em.createQuery("UPDATE CustomersMap SET customerId = :newCustomerId, mapId = :newMapId"
//                + " WHERE customersMapId = :id")
//                .setParameter("newCustomerId", newCustomerId)
//                .setParameter("newMapId", newMapId)
//                .setParameter("id", customersMapId)
//                .executeUpdate();
//        if (result > 0) {
//            System.out.println("Update was successful!");
//        }
//        em.getTransaction().commit();
//    }

    public List<Object[]> customersWhoHasMap() {
        return em.createQuery("select c.firstName, c.lastName, m.name from Customer as c " +
                "right join CustomersMap as cm " +
                "on c.customerId = cm.customerId left join Map as m " +
                "on m.mapId = cm.mapId")
                .getResultList();
    }
}
