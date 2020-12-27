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
public class Data {
    
    public ArrayList<Waiter> waiters = new ArrayList<Waiter>();

    private Waiter empty = new Waiter();
    private Manager emp = new Manager();


    public void Load() {

        waiters.add(new Waiter(1, "Altin", 1995, "Rr. Qemal Stafa", "0697830800", "Waiter1", "Er1"));
        waiters.add(new Waiter(2, "Reni", 1996, "Rr. Qemal Stafa", "0698754560", "Waiter2",  "Er2"));
        waiters.add(new Waiter(3, "Ardit",1997, "Rr. Qemal Stafa", "0697881316", "Waiter3", "Er3"));
        waiters.add(new Waiter(4, "Mikela", 1998, "Rr. Qemal Stafa", "0678451313", "Waiter4",  "Er4"));
        waiters.add(new Waiter(5, "Lindita", 1999, "Rr. Qemal Stafa", "+15678439473", "Waiter5",  "Er5"));
        waiters.add(new Waiter(6, "Ilir", 2000, "Rr.Qemal Stafa", "+15678439473", "Waiter6",  "Er6"));


    }


    public Waiter Waiter_Login(String username, int password) {


        for (Waiter w : waiters) {

            if (w.getUsername(). equals (username) && w.getPassword() == password) {

                return w; 
            }
        }
        
        return empty;

    }
    
    public static Manager manager = new Manager(0, "Ilir", 2000, "Rr. Qemal Stafa", "+15678439473,", "Mana", "Ger", "1234567");

}
