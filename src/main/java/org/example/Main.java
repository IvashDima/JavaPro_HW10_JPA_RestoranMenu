package org.example;

import org.example.dao.*;
import org.example.models.DiscountMenu;
import org.example.models.Menu;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of program!");
        MenuDAO menuDAO = new MenuDAO();
        DiscountMenuDAO discMenuDAO = new DiscountMenuDAO();

        insertRandomMenu(menuDAO);
        insertRandomDiscountMenu(discMenuDAO);

        Scanner sc = new Scanner(System.in);
        try{
            while (true) {
                System.out.println("\n1: add dish to menu");
                System.out.println("2: add dish to discount menu");
                System.out.println("3: view dishes by price");
                System.out.println("4: view dishes with discount");
                System.out.println("5: view dishes with total weight no more than 1 kg");
                System.out.println("0: exit");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        addDishToMenu(menuDAO, sc);
                        break;
                    case "2":
                        addDishToDiscountMenu(discMenuDAO, sc);
                        break;
                    case "3":
                        showMenuByPrice(menuDAO, sc);
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Try again!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("End of program!");
        }
        menuDAO.close();
        AbstractDAO.closeFactory();
    }
    private static void addDishToMenu(MenuDAO menuDAO, Scanner sc) {
        System.out.print("Enter dish name: ");
        String dishName = sc.nextLine();

        System.out.print("Enter price: ");
        String sPrice = sc.nextLine();
        double price = Double.parseDouble(sPrice);

        System.out.print("Enter weight: ");
        String sWeight = sc.nextLine();
        int weight = Integer.parseInt(sWeight);

        Menu menu = new Menu(dishName, price, weight);
        menuDAO.add(menu);
        System.out.println("Dish was added: " + menu);
    }

    private static void addDishToDiscountMenu(DiscountMenuDAO discMenuDAO, Scanner sc) {
        System.out.print("Enter name of the discount dish: ");
        String dishName = sc.nextLine();

        System.out.print("Enter price: ");
        String sPrice = sc.nextLine();
        double price = Double.parseDouble(sPrice);

        System.out.print("Enter weight: ");
        String sWeight = sc.nextLine();
        int weight = Integer.parseInt(sWeight);

        System.out.print("Enter percent of discount: ");
        String sPercentDiscount = sc.nextLine();
        double percentDiscount = Double.parseDouble(sPercentDiscount);

        DiscountMenu discMenu = new DiscountMenu(dishName, price, weight, percentDiscount);
        discMenuDAO.add(discMenu);
        System.out.println("Dish was added: " + discMenu);
    }

    private static void insertRandomMenu(MenuDAO menuDAO) {
        for (int i = 0; i < 3; i++) {
            Menu menu = new Menu(randomName(), RND.nextInt(10,100), RND.nextInt(100,500));
            menuDAO.add(menu);
            System.out.println("Dish was added: " + menu);
        }
    }
    private static void insertRandomDiscountMenu(DiscountMenuDAO discMenuDAO) {
        for (int i = 0; i < 3; i++) {
            DiscountMenu discMenu = new DiscountMenu(randomName(), RND.nextInt(10,100), RND.nextInt(100,500), RND.nextInt(10,30));
            discMenuDAO.add(discMenu);
            System.out.println("Dish was added: " + discMenu);
        }
    }

    private static void showMenuByPrice(MenuDAO menuDAO, Scanner sc) {
        System.out.print("Enter price From: ");
        String sPriceFrom = sc.nextLine();
        double priceFrom = Double.parseDouble(sPriceFrom);

        System.out.print("Enter price To: ");
        String sPriceTo = sc.nextLine();
        double priceTo = Double.parseDouble(sPriceTo);

        List<Menu> dishes = menuDAO.viewMenuByPrice(priceFrom, priceTo);
        for (Menu m: dishes)
            System.out.println(m);
    }

    static final String[] NAMES = {"Potato", "Steak", "Pizza", "Pasta", "Lazania", "Salat Cezar"};
    static final Random RND = new Random();

    static String randomName() {
        return NAMES[RND.nextInt(NAMES.length)];
    }
}