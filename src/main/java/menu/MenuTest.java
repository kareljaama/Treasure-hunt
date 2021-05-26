package menu;

import model.Customer;
import model.Map;
import persistence.RepositoryCustomer;
import persistence.RepositoryMap;

import java.util.List;
import java.util.Scanner;

public class MenuTest {

    private RepositoryCustomer repositoryCustomer;
    private RepositoryMap repositoryMap;

    public MenuTest() {

        this.repositoryCustomer = new RepositoryCustomer();
        this.repositoryMap = new RepositoryMap();
    }

    private int menuOptions(Scanner input) {

        System.out.println("Select option");
        System.out.println("1 - save customer");
        System.out.println("2 - update customer");
        System.out.println("3 - delete customer");
        System.out.println("4 - show customers information");
        System.out.println("5 - list all customers");
        System.out.println("6 - save map");
        System.out.print("Option: ");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;
        userChoice = menuOptions(input);

        switch (userChoice) {
            case 1:
                saveCustomer(input);
                break;
            case 2:
                updateCustomerById(input);
                break;
            case 3:
                deleteCustomerById(input);
                break;
            case 4:
                showCustomersInfo(input);
                break;
            case 5:
                listAllCustomers(input);
                break;
        }
    }

    private void saveCustomer(Scanner input) {
        System.out.println("Insert first name");
        String firstName = input.next();
        System.out.println("Insert last name");
        String lastName = input.next();
        System.out.println("Insert phone number");
        String phoneNumber = input.next();
        System.out.println("Insert email");
        String email = input.next();
        System.out.println("Insert date of birth");
        String dateOfBirth = input.next();

        Customer customer = new Customer(firstName, lastName, phoneNumber, email, dateOfBirth);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setDateOfBirth(dateOfBirth);
        repositoryCustomer.saveCustomer(customer);
    }

    private void updateCustomerById(Scanner input) {
        System.out.println("Insert customer ID");
        int id = input.nextInt();
        System.out.println("Insert first name");
        String firstName = input.next();
        System.out.println("Insert last name");
        String lastName = input.next();
        System.out.println("Insert phone number");
        String phoneNumber = input.next();
        System.out.println("Insert email");
        String email = input.next();
        System.out.println("Insert date of birth");
        String dateOfBirth = input.next();
        repositoryCustomer.updateCustomerById(id, firstName, lastName, phoneNumber, email, dateOfBirth);
    }

    private void deleteCustomerById(Scanner input) {
        System.out.println("Insert customers ID you would like to delete");
        int id = input.nextInt();
        repositoryCustomer.deleteCustomerById(id);
    }

    private Customer showCustomersInfo(Scanner input) {
        System.out.print("Insert customers ID:");
        int id = input.nextInt();
        return repositoryCustomer.showCustomersInfo(id);
    }

    private void listAllCustomers(Scanner input) {
        List<Customer> customerList = repositoryCustomer.listAllCustomers();
        for (Customer cust : customerList) {
            System.out.println(cust.toString());
        }
    }


}
