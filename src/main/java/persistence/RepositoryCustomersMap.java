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

    public List<CustomersMap> customersWhoHasMapByMapId(int mapid) {
        return em.createQuery("FROM CustomersMap WHERE map_id = :id")
                .setParameter("id", mapid)
                .getResultList();
    }
}
