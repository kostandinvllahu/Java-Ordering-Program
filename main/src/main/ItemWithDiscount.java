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
public class ItemWithDiscount extends Item {
    
    public double discount_rate;

    private int ID;

    public ItemWithDiscount(String name, double price) {

        super(name, price);


    }

    @Override
    public void setDiscount_rate(double discount_rate)

    {
        this.discount_rate = discount_rate;

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int get_ID() {
        return ID;
    }

    @Override
    public double calculateDiscount() {

        return super.price - (super.price * discount_rate);

    }


    @Override

    public String PrintInfo() {
        return "ItemWithDiscount{" + "Name= " + getName() + ", discount_rate= " + discount_rate + ", price= " + calculateDiscount() + ", ID= " + get_ID() + '}';
    }
    
}
