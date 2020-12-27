/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ArrayList;
/**
 *
 * @author User
 */

public class TableFidelity extends Table {
    
    private int point;


    private double Net = super.Net_Amount;


    private int Bonus=0;


    public TableFidelity(int ID, String name) {
        super(ID, name);
    }

    @Override
    public void CalculateBonus() {

        this.point = (int) super.Net_Amount / 10;

        int B = 0;

        while (point >= 100) {

            point = point - 100;

            B += 50;

        }


        Net_Amount -= B;
        Total_Amount -= B;
        Bonus = B;

    }


    @Override

    public String getName() {

        return Name_of_cashier;
    }


    @Override
    public void add_to_table(Item i) {

        list_of_items.add(i);

    }

    public String convert(ArrayList<Item> list_of_items) {

        String str = "";

        for (Item i : list_of_items) {

            str += (i.PrintInfo() + ", ");

        }
        return str;
    }

    @Override
    public int getBonus() {
        return Bonus;
    }

@Override
    public int getPoint() {
        return point;
    }

    @Override
    public String PrintInfo() {
        return "TableFidelity{" +
                "Bonus=" + Bonus +"$"+
                ", Points Left=" + this.point+
                ", ID=" + ID +
                ", Net_Amount=" + (setNet_Amount()-Bonus) +
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
  
    
}
