package menu;

import model.Customer;
import model.Place;
import persistence.RepositoryPlace;
import util.DBUtil;

import java.util.List;
import java.util.Scanner;

public class SubMenuPlace {

    private RepositoryPlace repositoryPlace;

    public SubMenuPlace() {
        this.repositoryPlace = new RepositoryPlace();
    }

    private int menuOptions(Scanner input) {
        System.out.println("Select option");
        System.out.println("1 - save place");
        System.out.println("2 - update place");
        System.out.println("3 - delete place");
        System.out.println("4 - show place information");
        System.out.println("5 - list all places");
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
                    savePlace(input);
                    break;
                case 2:
                    updatePlaceById(input);
                    break;
                case 3:
                    deletePlaceById(input);
                    break;
                case 4:
                    showPlaceInfo(input);
                    break;
                case 5:
                    listAllPlaces(input);
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

    private void savePlace(Scanner input) {
        System.out.println("Insert name: ");
        String name = input.next();
        System.out.println("Insert description: ");
        String description = input.next();

        Place place = new Place(name, description);
        place.setName(name);
        place.setDescription(description);
        repositoryPlace.savePlace(place);
    }

    private void updatePlaceById(Scanner input) {
        System.out.println("Insert place ID: ");
        int id = input.nextInt();
        System.out.println("Insert name: ");
        String name = input.next();
        System.out.println("Insert description: ");
        String description = input.next();
        repositoryPlace.updatePlaceById(id, name, description);
    }

    private void deletePlaceById(Scanner input) {
        System.out.println("Insert place ID you would like to delete: ");
        int id = input.nextInt();
        repositoryPlace.deletePlaceById(id);
    }

    private Place showPlaceInfo(Scanner input) {
        System.out.print("Insert place ID: ");
        int id = input.nextInt();
        return repositoryPlace.showPlaceInfo(id);
    }

    private void listAllPlaces(Scanner input) {
        List<Place> placeList = repositoryPlace.listAllPlaces();
        for (Place place : placeList) {
            System.out.println(place.toString());
        }
    }
}
