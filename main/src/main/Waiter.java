/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Calendar;
/**
 *
 * @author User
 */
public class Waiter extends User {

    private String Name;
    private String Surname;

    private long shift_start;
    private long shift_stop;

    private double wagePerHour = 15;
    private double hoursOfWork = 0;

    private int bonus = 5;


    public Waiter(int ID, String username, int password, String address, String phoneNumber, String Name, String Surname) {
        super(ID, username, password, address, phoneNumber);

        this.Name = Name;
        this.Surname = Surname;
    }

    public Waiter() {

    }

    public String getUsername() {


        return super.Username;

    }

    public int getPassword() {


        return super.password;

    }


    public void setShift_start() {
        Calendar cal = Calendar.getInstance();

        this.shift_start = cal.get(Calendar.HOUR_OF_DAY);
         System.out.println("shift_start: " + shift_start );  
    }

    public long getShift_start() {
        return shift_start;
    }


    public void setShift_stop() {

        Calendar cal = Calendar.getInstance();

        this.shift_stop = cal.get(Calendar.HOUR_OF_DAY);
        System.out.println("shift_stop: " + shift_stop );  
        
    }


    public long getShift_stop() {
        return shift_stop;
    }


    public double getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(double wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    public double getHoursOfWork() {

        hoursOfWork = shift_stop - shift_start;
        return hoursOfWork;
    }

    public void setHoursOfWork(double hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    @Override
    public double CalculateWage() {
        hoursOfWork = shift_stop - shift_start;
        double wage = 0;
         
        if (hoursOfWork > 0)
        {
            System.out.println("Hours of work: " + hoursOfWork + ":" + wagePerHour); 
            wage = (hoursOfWork * wagePerHour);
            if (hoursOfWork > 8 && hoursOfWork > 0) {
                wage = wage + (hoursOfWork - 8) * bonus;
            }
        }
        return wage;
    }

    @Override
    public String PrintInfo() {
        return "Waiter{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", shift_start=" + getShift_start() +
                ", shift_stop=" + getShift_stop() +
                ", wagePerHour=" + wagePerHour +
                ", hoursOfWork=" + hoursOfWork +
                ", bonus=" + bonus +
                ", ID=" + ID +
                ", Username='" + Username + '\'' +
                ", password=" + password +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
     
}
