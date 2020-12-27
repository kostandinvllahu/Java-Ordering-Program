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
public class CustomerEmployee extends User {
    
     private int Bonus;
@Override
    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public int getBonus() {
        return Bonus;
    }

    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String PrintInfo() {
        return "CompanyCustomer{" + "Extra Wage=" + Bonus + ", ID=" + ID + ", Username='" + Username + '\'' + ", password=" + password + ", Address='" + Address + '\'' + ", PhoneNumber='" + PhoneNumber + '\'' +'}';
    }
    
}
