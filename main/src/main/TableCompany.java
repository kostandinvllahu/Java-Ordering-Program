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

public class TableCompany extends Table {
    
    private int Num_of_items = super.list_of_items.size();

    private double Net = super.Net_Amount;

    public int Bonus;

    public TableCompany(int ID, String name) {
        super(ID, name);
    }


    public double getTotal_Amount() {
        return Total_Amount;
    }

    @Override
    public void CalculateBonus() {
        int B = 0;
        while (Num_of_items >= 300) {

            Num_of_items -= 300;

            if (Net <= 100) {


                Net = Net - 100;
                B = 100;
            }

        }

        Net_Amount -= B;
        Total_Amount -= B;
        Bonus =B;

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
    public String PrintInfo() {
        return "TableCompany{" +
                "Bonus=" + Bonus +"$"+
                ", ID=" + ID +
                ", Net_Amount=" + (Net_Amount-Bonus)  +
                ", Total_Amount=" + (Total_Amount-Bonus) +
                ", VAT=" + VAT +
                ", list_of_items=" + convert(list_of_items) +
                ", Date_Time='" + Date_Time + '\'' +
                ", Address='" + Address + '\'' +
                ", Name_of_cashier='" + Name_of_cashier + '\'' +
                '}';
    }

    @Override

    public String getName() {

        return Name_of_cashier;
    }

    
}
