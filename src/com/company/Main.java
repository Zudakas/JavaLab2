package com.company;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Random;

public class Main {

    public static ArrayList<DeskOrder> Orders;

    public static void main(String arg[]) {
        Orders = new ArrayList<>();
        showMenu();
    }
    public static void showMenu() {
        Scanner userInput = new Scanner(System.in);
        int appState = 0;
        while(appState == 0) {
            System.out.println("...................................");
            System.out.println("Please make a selection:  ");
            System.out.println("1 - Add new order");
            System.out.println("2 - View orders");
            System.out.println("3 - Search orders");
            System.out.println("4 - Exit application");

            appState = userInput.nextInt();
           appState = execMenuItem(appState);
        }



    }
    public static int execMenuItem(int appState) {


        if(appState == 1) {
            createOrder();
        }else if(appState == 2) {
            showOrders();
        }else if(appState == 3) {
            searchOrders();
        }else if (appState == 4) {
            exitApp(0);
        }else {

        }

        appState = 0;
        return appState;

    }
    public static void createOrder() {
        Scanner userInput = new Scanner(System.in);
        DeskOrder Order = new DeskOrder();
        Order.setOrderNum(Orders.size());

        int woodChoice;

        System.out.println("Order number: "+ Order.getOrderNum());
        System.out.println("Please enter a first name: ");
        Order.setFirstName(userInput.next());
        System.out.println("Please enter a last name: ");
        Order.setLastName(userInput.next());
        Order.setWoodType("");
        while (Order.getWoodType() == ""){
        System.out.println("Please type 1 for Mahogany, 2 for Oak, or 3 for Pine");
        woodChoice = userInput.nextInt();

        switch (woodChoice){
            case 1 :
                Order.setWoodType("Mahogany");
                break;
            case 2 :
                Order.setWoodType("Oak");
                break;
            case 3 :
                Order.setWoodType("Pine");
                break;
            default:
                System.out.println("Invalid Selection.");
        }}
        System.out.println("What is the width of the desk?");
        Order.setWidth(userInput.nextInt());

        System.out.println("What is the length of the desk?");
        Order.setLength(userInput.nextInt());

        System.out.println("How many drawers does the desk need?");
        Order.setNumDrawers(userInput.nextInt());
        Order.calcPrice();
        System.out.println("Final price: "+ Order.getPrice());
        Order.printOrder();
        Orders.add(Order);
    }

    public static void showOrders() {
        Orders.stream().forEach(deskOrder -> {
            deskOrder.printOrder();
        });

    }
    public static void searchOrders(){
        String inputString;
        int inputInt;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a search term.");
        inputString = userInput.next();

        try {
            inputInt = Integer.parseInt(inputString);
            Orders.stream().forEach(deskOrder -> {

            if(inputInt == deskOrder.getOrderNum()) {
                deskOrder.printOrder();
            }
        });}
        catch(Exception e){
          // Enable this to see a null pointer exception.
          //  System.out.println(e.toString());
            Orders.stream().forEach(deskOrder -> {

                if((deskOrder.getFirstName().toLowerCase().equals(inputString.toLowerCase()))||(deskOrder.getLastName().toLowerCase().equals(inputString.toLowerCase()))){
                    deskOrder.printOrder();
                }
        });}
    }
    public static void exitApp(int code){
        System.exit(code);
    }
}
