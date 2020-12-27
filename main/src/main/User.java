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
public class User {
    
    protected int ID;
    protected String Username;
    protected int password;
    protected String Address;
    protected String PhoneNumber;
    
    public User(int ID, String username, int password, String address, String phoneNumber) {
        this.ID = ID;
        Username = username;
        this.password = password;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public User() {

    }


    public void setBonus(int bonus) {
        return;
    }
    public int getID() {
        return ID;
    }
    public double CalculateWage() {

        return 0.0;
    }

    public void setPoints(int points) {
        return;
    }


    public int getBonus() {
        return 0;
    }

    public String PrintInfo() {
        return "User{" +
                "ID=" + ID +
                ", Username='" + Username + '\'' +
                ", password=" + password +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
    
}
