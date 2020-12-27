/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author User
 */
public class Item {
    
    private String name;
    public int ID;
    protected double price;
    protected double discount;


    public Item(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public Item() {

    }

    public void setDiscount_rate(double discount) {

        this.discount = discount;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }


    public double calculateDiscount() {

        return price - (price * discount);

    }


    public String PrintInfo() {
        return "Item{" + "Name= " + name + ", price= " + price + ", ID= " + getID() + '}';
        
   }
    
}
