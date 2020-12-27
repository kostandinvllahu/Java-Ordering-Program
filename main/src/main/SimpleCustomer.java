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
public class SimpleCustomer extends User {
    
      private int Bonus=0;


    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String PrintInfo() {
        return "SimpleCustomer{" +  "Bonus=" + Bonus +  ", ID=" + ID + ", Username='" + Username + '\'' + ", password=" + password + ", Address='" + Address + '\'' + ", PhoneNumber='" + PhoneNumber + '\'' +  '}';
    }
    
}
