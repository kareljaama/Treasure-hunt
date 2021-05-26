package menu;

import model.Customer;
import model.Treasure;
import persistence.RepositoryTreasure;
import util.DBUtil;

import java.util.List;
import java.util.Scanner;

public class SubMenuTreasure {

    private RepositoryTreasure repositoryTreasure;

    public SubMenuTreasure() {
        this.repositoryTreasure = new RepositoryTreasure();
    }

    private int menuOptions(Scanner input) {
        System.out.println("Select option");
        System.out.println("1 - save treasure");
        System.out.println("2 - update treasure");
        System.out.println("3 - delete treasure");
        System.out.println("4 - show treasure information");
        System.out.println("5 - list all treasures");
        System.out.println("6 - quit");
        System.out.print("Option: ");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;

        do {
            userChoice = menuOptions(input);

            switch (userChoice) {
                case 1:
                    saveTreasure(input);
                    break;
                case 2:
                    updateTreasureById(input);
                    break;
                case 3:
                    deleteTreasureById(input);
                    break;
                case 4:
                    showTreasureInfo(input);
                    break;
                case 5:
                    listAllTreasures(input);
                    break;
                case 6:
                    DBUtil.shutdown();
                    input.close();
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
                    menuOptions(input);
                    break;
            }
        } while (userChoice != 6);
        System.out.println("Closing system...");
        System.out.println("Have a nice day!");
    }

    private void saveTreasure(Scanner input) {
        System.out.println("Insert name: ");
        String name = input.next();
        System.out.println("Insert value: ");
        int value = input.nextInt();
        System.out.println("Insert description: ");
        String description = input.next();

        Treasure treasure = new Treasure(name, value, description);
        treasure.setName(name);
        treasure.setValue(value);
        treasure.setDescription(description);
        repositoryTreasure.saveTreasure(treasure);
    }

    private void updateTreasureById(Scanner input) {
        System.out.println("Insert treasure ID: ");
        int id = input.nextInt();
        System.out.println("Insert name: ");
        String name = input.next();
        System.out.println("Insert value: ");
        int value = input.nextInt();
        System.out.println("Insert description: ");
        String description = input.next();
        repositoryTreasure.updateTreasureById(id, name, value, description);
    }

    private void deleteTreasureById(Scanner input) {
        System.out.println("Insert treasures ID you would like to delete: ");
        int id = input.nextInt();
        repositoryTreasure.deleteTreasureById(id);
    }

    private Treasure showTreasureInfo(Scanner input) {
        System.out.print("Insert treasure ID: ");
        int id = input.nextInt();
        return repositoryTreasure.showTreasureInfo(id);
    }

    private void listAllTreasures(Scanner input) {
        List<Treasure> treasureList = repositoryTreasure.listAllTreasures();
        for (Treasure treas : treasureList) {
            System.out.println(treas.toString());
        }
    }
}
