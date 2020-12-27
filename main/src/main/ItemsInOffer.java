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
public class ItemsInOffer extends Item {
    
     protected int num_items;

    public int ID;


    @Override
    public void setDiscount_rate(double num_items) {

        this.num_items = (int) num_items;

    }


    public ItemsInOffer(String name, double price) {

        super(name, price);
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public double calculateDiscount() {


        return super.price * (this.num_items - 1);

    }

    @Override
    public String PrintInfo() {
        return "ItemsInOffer{" + "Offer=" + calculateDiscount() + ", ID= " + getID() +  ", Name= " + getName() + '}';
    }
    
}
