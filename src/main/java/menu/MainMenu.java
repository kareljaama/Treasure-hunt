package menu;

import util.DBUtil;

import java.util.Scanner;

public class MainMenu {

    private Object SubMenuCustomer;
    private Object SubMenuMap;
    private Object SubMenuEmployee;
    private Object SubMenuPlace;
    private Object SubMenuTreasure;

    public int menuOptions(Scanner input) {

        System.out.println("Select table");
        System.out.println("1 - Customer");
        System.out.println("2 - Map");
        System.out.println("3 - Employee");
        System.out.println("4 - Place");
        System.out.println("5 - Treasure");
        System.out.println("6 - Quit");
        System.out.print("\nOption: ");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;

    //    do {
            userChoice = menuOptions(input);

            switch (userChoice) {
                case 1:
                    subMenuCustomer(input);
                    break;
                case 2:
                    subMenuMap(input);
                    break;
                case 3:
                    subMenuEmployee(input);
                    break;
                case 4:
                    subMenuPlace(input);
                    break;
                case 5:
                    subMenuTreasure(input);
                    break;
                case 6:
                    DBUtil.shutdown();
                    input.close();
                    break;
                default:
                    System.out.println("Invalid option, please try again!\n");
                    menuChoice(input);
                    break;
            }
      //  } while (userChoice != 6);
     //  System.out.println("Closing system...");
      //  System.out.println("Have a nice day!");

    }

    public SubMenuCustomer subMenuCustomer(Scanner input) {
        return (SubMenuCustomer) SubMenuCustomer;
    }

    public SubMenuMap subMenuMap(Scanner input) {
        return (SubMenuMap) SubMenuMap;
    }

    public SubMenuEmployee subMenuEmployee(Scanner input) {
        return (SubMenuEmployee) SubMenuEmployee;
    }

    public SubMenuPlace subMenuPlace(Scanner input) {
        return (SubMenuPlace) SubMenuPlace;
    }

    public SubMenuTreasure subMenuTreasure(Scanner input) {
        return (SubMenuTreasure) SubMenuTreasure;
    }
}
