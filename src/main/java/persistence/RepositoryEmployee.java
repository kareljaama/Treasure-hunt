package persistence;

import model.Customer;
import model.Employee;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryEmployee {

    private final EntityManager em;

    public RepositoryEmployee() {
        this.em = DBUtil.getEntityManager();
    }

    public void saveEmployee(Employee employee) {
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void updateEmployeeById(int employeeId, String newFirstName, String newLastName
            , String newPhoneNumber, String newEmail, String newDateOfBirth
            , int newSalary) {
        em.getTransaction().begin();
        int result = em.createQuery("UPDATE Employee e SET e.firstName = :newFirstName, "
                + "e.lastName = :newLastName, "
                + "e.phoneNumber = :newPhoneNumber, "
                + "e.email = :newEmail, "
                + "e.dateOfBirth = :newDateOfBirth"
                + "e.salary = :newSalary"
                + " WHERE e.employeeId = :id")
                .setParameter("newFirstName", newFirstName)
                .setParameter("newLastName", newLastName)
                .setParameter("newPhoneNumber", newPhoneNumber)
                .setParameter("newEmail", newEmail)
                .setParameter("newDateOfBirth", newDateOfBirth)
                .setParameter("newSalary", newSalary)
                .setParameter("id", employeeId)
                .executeUpdate();
        if (result > 0) {
            System.out.println("Employee updated successfully!");
        }
        em.getTransaction().commit();
    }

    public void deleteEmployeeById(int employeeId) {
        em.getTransaction().begin();
        int result = em.createQuery("DELETE FROM Employee e WHERE e.employeeId = :id")
                .setParameter("id", employeeId).executeUpdate();
        if (result > 0) {
            System.out.println("Employee was deleted successfully!");
        }
    }

    public Employee showEmployeeInfo(int employeeId) {
        Employee employeeInfo;
        employeeInfo = em.createQuery("FROM Employee e WHERE e.employeeId = :id", Employee.class)
                .setParameter("id", employeeId)
                .getSingleResult();
        System.out.println(employeeInfo);
        return employeeInfo;

    }

    public List<Employee> listAllEmployees() {
        return em.createQuery("FROM Employee e ORDER BY e.lastName asc", Employee.class)
                .getResultList();

    }
}
