package menu;

import main.Main;
import model.Customer;
import model.Place;
import persistence.RepositoryPlace;
import util.DBUtil;

import java.util.List;
import java.util.Scanner;

public class SubMenuPlace {

    private RepositoryPlace repositoryPlace;
    private Object MainMenu;

    public SubMenuPlace() {
        this.repositoryPlace = new RepositoryPlace();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\nSelect option");
        System.out.println("1 - save place");
        System.out.println("2 - update place");
        System.out.println("3 - delete place");
        System.out.println("4 - show place information");
        System.out.println("5 - list all places");
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

    private void backToMainMenu(Scanner input) {
        Main.getMainMenu();
    }
}
