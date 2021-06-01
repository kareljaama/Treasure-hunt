package persistence;

import model.Map;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RepositoryMap {

    private final EntityManager em;

    public RepositoryMap() {
        this.em = DBUtil.getEntityManager();
    }

    public void saveMap(Map map) {
        try {
            em.getTransaction().begin();
            em.persist(map);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deleteMapbyId(int mapId) {
        em.getTransaction().begin();
        int result = em.createQuery("DELETE FROM Map m WHERE m.mapId = :id")
                .setParameter("id", mapId).executeUpdate();
        em.getTransaction().commit();
        if (result > 0) {
            System.out.println("Map was deleted successfully!");
        }
    }

    public void updateMapById(int mapId, String newName, String newDescription) {
        em.getTransaction().begin();
        int result = em.createQuery("UPDATE Map m SET m.name = :newName, "
        + "m.description = :newDescription "
                + "WHERE m.mapId = :id")
                .setParameter("newName", newName)
                .setParameter("newDescription", newDescription)
                .setParameter("id", mapId)
                .executeUpdate();
        if (result > 0) {
            System.out.println("Map updated sucessfully!");
        }
        em.getTransaction().commit();
    }

    public Map showMapInfo(int mapId) {
        Map mapInfo;
        mapInfo = em.createQuery("FROM Map m WHERE m.mapId = :id", Map.class)
                .setParameter("id", mapId)
                .getSingleResult();
        return mapInfo;
    }

    public List<Map> listAllMaps() {
        return em.createQuery("FROM Map m ORDER BY m.name asc", Map.class)
                .getResultList();
    }

}
