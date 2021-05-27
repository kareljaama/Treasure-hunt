package main;

import menu.*;

import java.util.Scanner;

public class Main {
    private static MainMenu mainMenu;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        MainMenu mainMenu = new MainMenu();
        mainMenu.menuChoice(input);
        SubMenuCustomer subMenuCustomer = new SubMenuCustomer();
        subMenuCustomer.menuChoice(input);
        SubMenuEmployee subMenuEmployee = new SubMenuEmployee();
        subMenuEmployee.menuChoice(input);
        SubMenuMap subMenuMap = new SubMenuMap();
        subMenuMap.menuChoice(input);
        SubMenuPlace subMenuPlace = new SubMenuPlace();
        subMenuPlace.menuChoice(input);
        SubMenuTreasure subMenuTreasure = new SubMenuTreasure();
        subMenuTreasure.menuChoice(input);

    }

    public static MainMenu getMainMenu() {
        return mainMenu;
    }
}
