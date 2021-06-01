package menu;

import main.Main;
import model.Map;
import persistence.RepositoryMap;
import util.DBUtil;

import java.util.List;
import java.util.Scanner;

public class SubMenuMap {

    private RepositoryMap repositoryMap;
    private Object MainMenu;

    public SubMenuMap() {
        this.repositoryMap = new RepositoryMap();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\nSelect option");
        System.out.println("1 - Save map");
        System.out.println("2 - Delete map");
        System.out.println("3 - Update map");
        System.out.println("4 - Show map");
        System.out.println("5 - List all maps");
        System.out.println("10 - back");
        System.out.print("\nOption: ");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;

        do {

            userChoice = menuOptions(input);

            switch (userChoice) {
                case 1:
                    saveMap(input);
                    break;
                case 2:
                    deleteMapById(input);
                    break;
                case 3:
                    updateMapById(input);
                    break;
                case 4:
                    showMap(input);
                    break;
                case 5:
                    listAllMaps(input);
                    break;
                case 10:
                    backToMainMenu(input);
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
                    menuChoice(input);
                    break;
            }
        } while (userChoice != 10);
    }

    private void saveMap(Scanner input) {
        System.out.println("Insert maps name: ");
        String name = input.next();
        System.out.println("Insert maps description: ");
        String description = input.nextLine();
        System.out.println("Upload a map: ");
        String imageAddress = input.next();

        Map map = new Map();
        map.setDescription(description);
        map.setName(name);
        map.setImageAddress(imageAddress);
        repositoryMap.saveMap(map);
    }

    private void deleteMapById(Scanner input) {
        System.out.println("Insert map ID you would like to delete: ");
        int id = input.nextInt();
        repositoryMap.deleteMapbyId(id);
    }

    private void updateMapById(Scanner input) {
        System.out.println("Insert map ID: ");
        int id = input.nextInt();
        System.out.println("Insert map name: ");
        String name = input.next();
        System.out.println("Insert map description: ");
        String description = input.next();
        repositoryMap.updateMapById(id, name, description);
    }


    private Map showMap(Scanner input) {
        System.out.println("Insert maps ID: ");
        int id = input.nextInt();
        return repositoryMap.showMapInfo(id);
    }

    private void listAllMaps(Scanner input) {
        List<Map> mapList = repositoryMap.listAllMaps();
        for (Map map : mapList) {
            System.out.println(map.toString());
        }
    }

    private void backToMainMenu(Scanner input) {
        Main.getMainMenu();
    }
}
