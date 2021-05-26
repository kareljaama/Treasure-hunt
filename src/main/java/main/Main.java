package main;

import menu.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        MainMenu mainMenu = new MainMenu();
        mainMenu.menuChoice(input);
        SubMenuCustomer subMenuCustomer = new SubMenuCustomer();
        subMenuCustomer.menuChoice(input);
        SubMenuMap subMenuMap = new SubMenuMap();
        subMenuMap.menuChoice(input);
        SubMenuPlace subMenuPlace = new SubMenuPlace();
        subMenuPlace.menuChoice(input);
        SubMenuTreasure subMenuTreasure = new SubMenuTreasure();
        subMenuTreasure.menuChoice(input);

    }
}