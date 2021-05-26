package menu;

import model.Map;
import persistence.RepositoryMap;
import util.DBUtil;

import java.util.List;
import java.util.Scanner;

public class SubMenuMap {

    private RepositoryMap repositoryMap;

    public SubMenuMap() {
        this.repositoryMap = new RepositoryMap();
    }

    private int menuOptions(Scanner input) {
        System.out.println("Select option");
        System.out.println("1 - Save map");
        System.out.println("2 - Delete map");
        System.out.println("3 - Update map");
        System.out.println("4 - Show map");
        System.out.println("5 - List all maps");
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
                case 6:
                    DBUtil.shutdown();
                    input.close();
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
                    break;
            }
        } while (userChoice != 6);
        System.out.println("Closing system...");
        System.out.println("Have a nice day!");
    }

    private void saveMap(Scanner input) {
        System.out.println("Insert maps name: ");
        String name = input.next();
        System.out.println("Draw a map: ");
        String description = input.next();

        Map map = new Map();
        map.setDescription(description);
        map.setName(name);
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
}
