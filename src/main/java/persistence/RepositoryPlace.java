package persistence;

import model.Customer;
import model.Place;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryPlace {

    private final EntityManager em;

    public RepositoryPlace() {
        this.em = DBUtil.getEntityManager();
    }

    public void savePlace(Place place) {
        try {
            em.getTransaction().begin();
            em.persist(place);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updatePlaceById(int placeId, String newName, String newDescription) {
        em.getTransaction().begin();
        int result = em.createQuery("UPDATE Place p SET p.name = :newName, "
                + "p.description = :newDescription"
                + " WHERE p.placeId = :id")
                .setParameter("newName", newName)
                .setParameter("newDescription", newDescription)
                .setParameter("id", placeId)
                .executeUpdate();
        if (result > 0) {
            System.out.println("Place updated successfully!");
        }
        em.getTransaction().commit();


    }

    public void deletePlaceById(int placeId) {
        em.getTransaction().begin();
        int result = em.createQuery("DELETE FROM Place p WHERE p.placeId = :id")
                .setParameter("id", placeId).executeUpdate();
        em.getTransaction().commit();
        if (result > 0) {
            System.out.println("Place was deleted successfully!");
        }
    }

    public Place showPlaceInfo(int placeId) {
        Place placeInfo;
        placeInfo = em.createQuery("FROM Place p WHERE p.placeId = :id", Place.class)
                .setParameter("id", placeId)
                .getSingleResult();
        System.out.println(placeInfo);
        return placeInfo;

    }

    public List<Place> listAllPlaces() {
        return em.createQuery("FROM Place p ORDER BY p.name asc", Place.class)
                .getResultList();
    }
}
