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
public class ItemChristmas extends ItemWithDiscount {
  
     public double christmas_rate;

    private static int ID;

    public ItemChristmas(String name, double price) {

        super(name, price);

    }


    public void setID(int ID) {
        this.ID = ID;
    }


    public int get_ID() {
        return ID;
    }


    @Override
    public void setDiscount_rate(double christmas_rate) {

        this.christmas_rate = christmas_rate;
    }

    @Override
    public double calculateDiscount() {

        return super.price - ((super.discount_rate + christmas_rate) * super.price);

    }

    @Override
    public String PrintInfo() {
        return "ItemChristmas{" + "Name= " + getName() + ", christmas_rate= " + christmas_rate + ", price= " + calculateDiscount() + ", ID= " + get_ID() + '}';
    }
    
}
