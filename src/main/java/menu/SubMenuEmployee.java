package menu;

import main.Main;
import model.Customer;
import model.Employee;
import persistence.RepositoryEmployee;

import java.util.List;
import java.util.Scanner;

public class SubMenuEmployee {

    private RepositoryEmployee repositoryEmployee;
    private Object MainMenu;

    public SubMenuEmployee() {
        this.repositoryEmployee = new RepositoryEmployee();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\nSelect option");
        System.out.println("1 - save employee");
        System.out.println("2 - update employee");
        System.out.println("3 - delete employee");
        System.out.println("4 - show employee information");
        System.out.println("5 - list all employees");
        System.out.println("6 - back");
        System.out.print("\nOption: ");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;

        do {
            userChoice = menuOptions(input);

            switch (userChoice) {
                case 1:
                    saveEmployee(input);
                    break;
                case 2:
                    updateEmployeeById(input);
                    break;
                case 3:
                    deleteEmployeeById(input);
                    break;
                case 4:
                    showEmployeeInfo(input);
                    break;
                case 5:
                    listAllEmployees(input);
                    break;
                case 6:
                    backToMainMenu(input);
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
                    menuChoice(input);
                    break;
            }
        } while (userChoice != 6);
    }

    private void saveEmployee(Scanner input) {
        System.out.println("Insert first name: ");
        String firstName = input.next();
        System.out.println("Insert last name: ");
        String lastName = input.next();
        System.out.println("Insert phone number: ");
        String phoneNumber = input.next();
        System.out.println("Insert email: ");
        String email = input.next();
        System.out.println("Insert date of birth: ");
        String dateOfBirth = input.next();
        System.out.println("Insert new salary: ");
        int salary = input.nextInt();

        Employee employee = new Employee(firstName, lastName, phoneNumber, email, dateOfBirth, salary);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);
        employee.setDateOfBirth(dateOfBirth);
        employee.setSalary(salary);
        repositoryEmployee.saveEmployee(employee);
    }

    private void updateEmployeeById(Scanner input) {
        System.out.println("Insert employee ID: ");
        int id = input.nextInt();
        System.out.println("Insert first name: ");
        String firstName = input.next();
        System.out.println("Insert last name: ");
        String lastName = input.next();
        System.out.println("Insert phone number: ");
        String phoneNumber = input.next();
        System.out.println("Insert email: ");
        String email = input.next();
        System.out.println("Insert date of birth: ");
        String dateOfBirth = input.next();
        System.out.println("Insert new salary: ");
        int salary = input.nextInt();
        repositoryEmployee.updateEmployeeById(id, firstName, lastName, phoneNumber, email, dateOfBirth, salary);
    }

    private void deleteEmployeeById(Scanner input) {
        System.out.println("Insert employees ID you would like to delete: ");
        int id = input.nextInt();
        repositoryEmployee.deleteEmployeeById(id);
    }

    private Employee showEmployeeInfo(Scanner input) {
        System.out.print("Insert employees ID: ");
        int id = input.nextInt();
        return repositoryEmployee.showEmployeeInfo(id);
    }

    private void listAllEmployees(Scanner input) {
        List<Employee> employeeList = repositoryEmployee.listAllEmployees();
        for (Employee emp : employeeList) {
            System.out.println(emp.toString());
        }
    }

    private void backToMainMenu(Scanner input) {
        Main.getMainMenu();
    }
}

