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
public class TableEmployee extends Table {
    
     private double Net = super.Net_Amount;

    private int Bonus=0;


    public TableEmployee(int ID, String name) {
        super(ID, name);
    }

    @Override
    public int getBonus() {
        return Bonus;
    }

    @Override
    public String PrintInfo() {
        return "TableEmployee{" +"Bonus=" + Bonus +"$"+

                ", ID=" + ID +
                ", Net_Amount=" + (Net_Amount-Bonus) +
                ", Total_Amount=" + (Total_Amount-Bonus) +
                ", VAT=" + VAT +
                ", list_of_items=" + convert(list_of_items) +
                ", Date_Time='" + Date_Time + '\'' +
                ", Address='" + Address + '\'' +
                ", Name_of_cashier='" + Name_of_cashier + '\'' +
                '}';
    }

    public double getTotal_Amount() {
        return Total_Amount;
    }

    @Override
    public void CalculateBonus() {

        if(Net == 500){

            Bonus =50;

        }

    }


    @Override

    public String getName() {

        return Name_of_cashier;
    }
    
}
