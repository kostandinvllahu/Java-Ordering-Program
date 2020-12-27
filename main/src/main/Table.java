/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author User
 */
public class Table {
    
    protected int ID;
    protected double Net_Amount = 0;
    protected double Total_Amount = 0;
    protected double VAT = 0.23;
    public ArrayList<Item> list_of_items = new ArrayList<>();
    protected Date Date_Time;
    protected String Address = "Rr. Qemal Stafa"; 
    protected String Phone_Number = "+15678439473";
    protected String Name_of_cashier;


    private int Bonus = 0;

    public Table() {

    }

    public int getID() {
        return ID;
    }

    public void setName(String name_of_cashier) {
        Name_of_cashier = name_of_cashier;
    }


    public Table(int ID, String name) {

        Calendar cal = Calendar.getInstance();


        this.ID = ID;
        this.Date_Time = cal.getTime();
        this.Name_of_cashier = name;
    }

    public void add_to_table(Item i) {

        list_of_items.add(i);

    }

    public int getPoint() {
        return 0;
    }

    public void print_table() {


        for (Item i : list_of_items) {

            System.out.println(i.PrintInfo());

        }


    }

    public void modify_table(Item i, Item other_item) {

        int index = list_of_items.indexOf(i.getName());

        list_of_items.set(index, other_item);
    }
    
    public void remove_item(Item i, Item remove_item) {
        
        int index = list_of_items.indexOf(i.getName());
        list_of_items.set(index, remove_item);
    }


    public void setTotal_Amount() {

        Total_Amount = 0;

        for (Item i : list_of_items) {

            Total_Amount += i.calculateDiscount();

        }

        Total_Amount = Total_Amount + (Total_Amount * VAT);


    }


    public double setNet_Amount() {

        Net_Amount = 0;

        for (Item i : list_of_items) {

            Net_Amount += i.calculateDiscount();

        }

        return Net_Amount;
    }

    public String convert(ArrayList<Item> list_of_items) {

        String str = "";

        for (Item i : list_of_items) {

            str += (i.PrintInfo() + ", ");

        }
        return str;
    }

    public String PrintInfo() {
        return "Table " + 
                " ID=" + ID +
                ", Net_Amount=" + Net_Amount +
                ", Total_Amount=" + Total_Amount +
                ", VAT=" + VAT +
                ", list_of_items=" + convert(list_of_items) +
                ", Date_Time='" + Date_Time + '\'' +
                ", Address='" + Address + '\'' +
                ", Name_of_cashier='" + Name_of_cashier + '\'' +
                '}';
    }
    //---------------KY TESTIM----------------------
    public String PrintInfo_By_Cashier() {
        return " Name_of_cashier='" + Name_of_cashier + '\'' +
                "Table{" +
                "ID=" + ID +
                ", Net_Amount=" + Net_Amount +
                ", Total_Amount=" + Total_Amount +
                ", VAT=" + VAT +
                ", list_of_items=" + convert(list_of_items) +
                ", Date_Time='" + Date_Time + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
//----------------------------------------------
    public String served_Table_By_cashier() {
        return " Name_of_cashier='" + Name_of_cashier + '\'' +
                "Table{" +
                "ID=" + ID +
                '}';
    }
    
    
    
    

    public int getBonus() {
        return Bonus;
    }

    public void CalculateBonus() {

        Bonus = 0;
    }

    public double getTotal_Amount() {
        return Total_Amount;
    }

    public String getName() {
        return Name_of_cashier;
    }
    
}
