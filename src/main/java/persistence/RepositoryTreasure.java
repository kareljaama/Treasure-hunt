package persistence;

import model.Customer;
import model.Treasure;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryTreasure {

    private final EntityManager em;

    public RepositoryTreasure() {
        this.em = DBUtil.getEntityManager();
    }

    public void saveTreasure(Treasure treasure) {
        try {
            em.getTransaction().begin();
            em.persist(treasure);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateTreasureById(int treasureId, String newName, int newValue, String newDescription) {
        em.getTransaction().begin();
        int result = em.createQuery("UPDATE Treasure t SET t.name = :newName, "
                + "t.value = :newValue, "
                + "t.description = :newDescription "
                + "WHERE t.treasureId = :id")
                .setParameter("newName", newName)
                .setParameter("newValue", newValue)
                .setParameter("newDescription", newDescription)
                .setParameter("treasureId", treasureId)
                .executeUpdate();
        if (result > 0) {
            System.out.println("Treasure updated successfully!");
        }
        em.getTransaction().commit();
    }

    // Runs without errors, but does not delete from database
    public void deleteTreasureById(int treasureId) {
        em.getTransaction().begin();
        int result = em.createQuery("DELETE FROM Treasure t WHERE t.treasureId = :id")
                .setParameter("id", treasureId).executeUpdate();
        if (result > 0) {
            System.out.println("Treasure was deleted successfully!");
        }
    }

    public Treasure showTreasureInfo(int treasureId) {
        Treasure treasureInfo;
        treasureInfo = em.createQuery("FROM Treasure t WHERE t.treasureId = :id", Treasure.class)
                .setParameter("id", treasureId)
                .getSingleResult();
        System.out.println(treasureInfo);
        return treasureInfo;
    }

    public List<Treasure> listAllTreasures() {
        return em.createQuery("FROM Treasure t ORDER BY t.name asc",Treasure.class)
                .getResultList();

    }

    public List<Treasure> listAllTreasuresByPlaceId(int placeId) {
        return em.createQuery("FROM Treasure WHERE place_id = :id")
                .setParameter("id", placeId)
                .getResultList();
    }
}
