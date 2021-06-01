package persistence;

import model.Customer;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryCustomer {

    private final EntityManager em;

    public RepositoryCustomer() {
        this.em = DBUtil.getEntityManager();
    }

    public void saveCustomer(Customer customer) {
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateCustomerById(int customerId, String newFirstName, String newLastName, String newPhoneNumber, String newEmail, String newDateOfBirth) {
        em.getTransaction().begin();
        int result = em.createQuery("UPDATE Customer c SET c.firstName = :newFirstName, "
                + "c.lastName = :newLastName, "
                + "c.phoneNumber = :newPhoneNumber, "
                + " c.email = :newEmail, "
                + "c.dateOfBirth = :newDateOfBirth"
                + " WHERE c.customerId = :id")
                .setParameter("newFirstName", newFirstName)
                .setParameter("newLastName", newLastName)
                .setParameter("newPhoneNumber", newPhoneNumber)
                .setParameter("newEmail", newEmail)
                .setParameter("newDateOfBirth", newDateOfBirth)
                .setParameter("id", customerId)
                .executeUpdate();
        if (result > 0) {
            System.out.println("Customer updated successfully!");
        }
        em.getTransaction().commit();
    }

    // Cannot delete or update a parent row: a foreign key constraint fails
    public void deleteCustomerById(int customerId) {
        em.getTransaction().begin();
        int result = em.createQuery("DELETE FROM Customer c WHERE c.customerId = :id")
                .setParameter("id", customerId).executeUpdate();
        em.getTransaction().commit();
        if (result > 0) {
            System.out.println("Customer was deleted successfully!");
        }
    }

    public Customer showCustomersInfo(int customerId) {
        Customer customerInfo;
        customerInfo = em.createQuery("FROM Customer c WHERE c.customerId = :id", Customer.class)
                .setParameter("id", customerId)
                .getSingleResult();
        return customerInfo;
    }

    public List<Customer> listAllCustomers() {
        return em.createQuery("FROM Customer c ORDER BY c.lastName asc", Customer.class)
                .getResultList();
    }
}
