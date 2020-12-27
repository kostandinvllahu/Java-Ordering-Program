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
public class LoyalCustomer extends User {

     private int points;
    private int ID;
    private int Bonus;

    public void setPoints(int points) {
        this.points = points;
    }


    public int getBonus() {
        return Bonus;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }




    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String PrintInfo() {
        return "LoyalCustomer{" + "Points Left=" + points + ", Bonus=" + Bonus + ", ID=" + ID +  ", Username='" + Username + '\'' +   ", password=" + password +  ", Address='" + Address + '\'' +  ", PhoneNumber='" + PhoneNumber + '\'' + '}';
    }
    
}
