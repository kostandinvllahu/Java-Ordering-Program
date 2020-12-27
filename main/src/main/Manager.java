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
public class Manager extends User {

    
    private String Name;
    private String Surname;
    private String InternalPhoneNumber;


    public Manager(int ID, String username, int password, String address, String phoneNumber, String Name, String Surname, String IntenalPhoneNumber) {

        super(ID, username, password, address, phoneNumber);
        this.Name = Name;
        this.Surname = Surname;
        this.InternalPhoneNumber = IntenalPhoneNumber;
    }


    public Manager() {

    }

    public double set_discount(double discount_rate) {

        return discount_rate;

    }

    public double set_discount_ch(double dis_christmas) {


        return dis_christmas;

    }


    public String getUsername() {


        return super.Username;

    }

    public int getPassword() {


        return super.password;

    }

    @Override
    public String PrintInfo() {
        return "Manager{" +  "Name='" + Name + '\'' +  ", Surname='" + Surname + '\'' + ", InternalPhoneNumber='" + InternalPhoneNumber + '\'' + ", ID=" + ID + ", Username='" + Username + '\'' + ", password=" + password + ", Address='" + Address + '\'' + ", PhoneNumber='" + PhoneNumber + '\'' + '}';
    }
    
}
