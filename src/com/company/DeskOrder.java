package com.company;

/**
 * Created by Brad Myers on 5/16/2015.
 */
public class DeskOrder {

    private int orderNum;
    private String firstName, lastName;

    private String woodType;
    private int deskWidth;
    private int deskLength;
    private int numDrawers;

    private double finalPrice;


    public void DeskOrder(int order, String fname, String lname, String wood, int width, int length, int drawers){
        orderNum = order;
        firstName = fname;
        lastName = lname;
        woodType = wood;
        deskWidth = width;
        deskLength = length;
        numDrawers = drawers;


        finalPrice = calcPrice();

    }
    public void DeskOrder(){
        orderNum = 0;
        firstName = "First Name";
        lastName = "Last Name";
        woodType = "Wood Type";
        deskWidth = 0;
        deskLength = 0;
        numDrawers = 0;


        setPrice();


    }
    //setters
    public void setWoodType(String wood) {
        woodType = wood;
    }
    public void setWidth(int width) {
        deskWidth = width;
    }
    public void setLength(int length) {
        deskLength = length;
    }
    public void setNumDrawers(int drawers) {
        numDrawers = drawers;
    }
    public void setFirstName(String fname) {
        firstName = fname;
    }
    public void setLastName(String lname) {
        lastName = lname;
    }
    public void setOrderNum(int order) {
        this.orderNum = order;
    }
    public void setPrice() {
        this.finalPrice = calcPrice();
    }

    //getters
    public String getWoodType() {
        return woodType;
    }
    public int getWidth() {
        return deskWidth;
    }
    public int getLength() {
        return deskLength;
    }
    public int getNumDrawers() {
        return numDrawers;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getOrderNum() {
        return orderNum;
    }
    public double getPrice() {
        return finalPrice;
    }

    //Other functions

    public void printOrder(){
        System.out.println("Order #: " + this.getOrderNum()+1);
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Wood Type: "+ this.getWoodType());
        System.out.println("Desk Width: " + this.getWidth());
        System.out.println("Desk Length: " + this.getLength());
        System.out.println("Drawer Count: " + this.getNumDrawers());
        System.out.println("Desk Dimensions: "+ this.getLength() * this.getWidth() + " sq inches");
        System.out.println("Price: " + getPrice());
        System.out.println("...................................");


    }
    protected double calcPrice(){

        //sets the final price based on the parameters required.
        double deskPrice = 200;

        //sets price + $30 per drawer
        deskPrice = deskPrice + (this.numDrawers * 30);
        if(this.deskLength * this.deskWidth > 750){
         deskPrice = deskPrice + 50;
        }
        //Mahogany is $150, Oak is $125, Pine is no extra charge
        if(this.woodType == "Mahogany"){
            deskPrice = deskPrice + 150;
        }else if(this.woodType == "Oak"){
            deskPrice = deskPrice + 125;
        }else if(this.woodType == "Pine") {

        }
        this.finalPrice = deskPrice;
        return deskPrice;
    }
}
