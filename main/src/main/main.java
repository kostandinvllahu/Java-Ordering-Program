
package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Kostandin Vllahu
 */
public class main {
   
    private static ArrayList<Table> being_served = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Table> served = new ArrayList<>();

    private static Manager manager;
    private static Waiter waiter;


    private static double overall_discount = 0.1;
    private static double item_discount = 0.2;
    private static double christmas_discount = 0.3;
    private static int buy_for_less = 2;

    private static void pay_bill() throws InputMismatchException {
        try {
            Scanner s = new Scanner(System.in);

            for (Table t : being_served) {

                System.out.println("Table: " + t.getID() + ", Total Amount: " + (int) t.getTotal_Amount());

            }
            System.out.println("Choose a Table: ");
            int num = s.nextInt() -1; //-1
           //System.out.println("Test num: " + num);
            if(num == -1) {
                num = 0;
            }
            
               if(num == 1) {
                num = num+1;
            }
            
            if(num > 1) {
                num = 0;
            }
            //System.out.println("Test num: " + num);
            Table t = being_served.get(num); //problem
            served.add(being_served.get(num));
            System.out.println("Customer's Balance: ");
            int balance = s.nextInt();

            System.out.println("Customer's Change: " + (balance - (int) t.getTotal_Amount()));

            System.out.println("Payment is Completed!");
            being_served.remove(num);
        } catch (InputMismatchException e) {

            e.printStackTrace();
        }
    }
    
  


    private static void add_item(Table table, int ID) throws InputMismatchException {

        try {

            Item i;

            Scanner sc = new Scanner(System.in);
            Scanner kc = new Scanner(System.in);

            System.out.println("Input Name of item: ");

            String name = kc.nextLine();

            System.out.println("Input item's Price: ");
            
            //double price = 0;//sc.nextFloat();
             // label for outer loop 
    double price;
        do {
            System.out.print("Please enter a positive number: ");
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            price = sc.nextInt();
        } while (price < 0);
       // System.out.printf("You have entered a positive number %d.\n", price);
    
            System.out.println("Choose a category: ");
            System.out.println("------------------");
            System.out.println("1. Item's with no Discount: ");
            System.out.println("2. Item's With Discount: ");
            System.out.println("3. Item's With Christmas Discount: ");
            System.out.println("4. Item's In Offer: ");
            switch (sc.nextInt()) {

                case 1:
                    i = new Item(name, price);
                    i.setID(ID);
                    table.add_to_table(i);
                    i.setDiscount_rate(overall_discount);
                    break;
                case 2:
                    i = new ItemWithDiscount(name, price);
                    i.setID(ID);
                    table.add_to_table(i);
                    i.setDiscount_rate(item_discount);
                    break;
                case 3:
                    i = new ItemChristmas(name, price);
                    i.setID(ID);
                    table.add_to_table(i);
                    i.setDiscount_rate(christmas_discount);
                    break;
                case 4:
                    i = new ItemsInOffer(name, price);
                    i.setID(ID);
                    table.add_to_table(i);
                    i.setDiscount_rate(buy_for_less);
                    if(table.list_of_items.size() >= buy_for_less){

                        table.list_of_items.get(buy_for_less-1).price=0;

                    }
                    break;
            }

        } catch (InputMismatchException e) {

            e.printStackTrace();

        }
    }

    private static Waiter Login_Waiter() throws InputMismatchException {

        Data data = new Data();
        data.Load();
        System.out.println("\n----Login Staff---- ");

        Scanner sc = new Scanner(System.in);

        Scanner kc = new Scanner(System.in);
        try {

            System.out.printf("Username: ");

            String user = sc.nextLine();

            System.out.printf("Password: ");

            Integer pass = kc.nextInt();

            Waiter w = data.Waiter_Login(user, pass);

            w.setShift_start();
            System.out.println("Welcome back " + user);
            return w;

        } catch (InputMismatchException e) {


            e.printStackTrace();

        }
        return new Waiter();
    } 

    private static Manager Login_Manager() throws InputMismatchException {

        Data data = new Data();
        data.Load();
        System.out.println("\n----Login Manager-----");

        Scanner sc = new Scanner(System.in);

        Scanner kc = new Scanner(System.in);
        try {

            System.out.printf("Username: ");

            String user = sc.nextLine();

            System.out.printf("Password: ");

            int pass = kc.nextInt();


            if (data.manager.Username.equals(user) && data.manager.password == pass) {
                System.out.println("Welcome back Eri!");
                return data.manager;

            }


        } catch (InputMismatchException e) {


            System.err.printf("\nExeption: %s\n", e);
            e.printStackTrace();

        }
        return new Manager();
    } 

    private static void add_table(int i) {

        Waiter w = new Waiter();

        Scanner s = new Scanner(System.in);

        System.out.println("Customer Type:\n");
        System.out.println("1. Simple Customer: ");
        System.out.println("2. Loyal Customer: ");
        System.out.println("3. Company Customer: ");
        System.out.println("4. Employee Customer: ");
     

        switch (s.nextInt()) {

            case 1:
                SimpleCustomer simple = new SimpleCustomer();

                simple.setID(i);
                users.add(simple);
                being_served.add(new Table(i, w.getUsername()));
                break;
            case 2:
                LoyalCustomer loyal = new LoyalCustomer();

                loyal.setID(i);
                users.add(loyal);
                being_served.add(new TableFidelity(i, w.getUsername()));
                break;
            case 3:
                CompanyCustomer company = new CompanyCustomer();

                company.setID(i);
                users.add(company);
                being_served.add(new TableCompany(i, w.getUsername()));
                break;
            case 4:
                CustomerEmployee employee = new CustomerEmployee();
                employee.setID(i++);

                users.add(employee);
                being_served.add(new TableEmployee(i, w.getUsername()));
                break;
        }

    }

    private static Table select_table(int id) {

        return being_served.get(id);
    }

    private static Boolean check_credentials() throws InputMismatchException {

        Scanner s = new Scanner(System.in);

        try {

            System.out.println("Manager Password: ");
            int pass = s.nextInt();

            if (pass == manager.getPassword() && manager.getPassword() != 0) {

                return true;
            } else
                return false;
        } catch (InputMismatchException e) {

            e.printStackTrace();
        }

        return null;
    }

    private static void discount() throws InputMismatchException {


        System.out.println("1. Overall Discount. ");
        System.out.println("2. Item Discount. ");
        System.out.println("3. Christmas Discount. ");
        System.out.println("4. Buy More Pay Less Offer. ");
        System.out.println("0. Return to menu. \n");


        Scanner s = new Scanner(System.in);
        Scanner k = new Scanner(System.in);


        try {
            //while (true) {
                switch (k.nextInt()) {

                    case 1:
                        System.out.printf("Discount: ");
                        overall_discount = s.nextDouble() / 100;
                        break;
                    case 2:
                        System.out.printf("Discount: ");
                        item_discount = s.nextDouble() / 100 + overall_discount;
                        break;
                    case 3:
                        System.out.printf("Discount: ");
                        christmas_discount = s.nextDouble() / 100 + overall_discount;
                        break;
                    case 4:
                        System.out.printf("Offer: ");
                        buy_for_less = s.nextInt();
                        break;
                    case 0:
                            
                        break;
                }
            //}
        } catch (InputMismatchException e) {

            e.printStackTrace();

        }

    }
    
    private static void table_overall() throws InputMismatchException {
        double total = 0;
        int count_item = 0;
        int count_dis = 0;
        int count_chris = 0;
        int count_offer = 0;
                
        
            Scanner p = new Scanner(System.in);

            for (Table t : being_served) {
                total += t.setNet_Amount();

                for (Item i : t.list_of_items) {

                    if (i.getClass() == Item.class) count_item++;

                    if (i.getClass() == ItemWithDiscount.class) count_dis++;

                    if (i.getClass() == ItemChristmas.class) count_chris++;

                    if (i.getClass() == ItemsInOffer.class) count_offer++;

                 waiter.setShift_stop();
           System.out.println("-------------------------");
           System.out.println("Items: " + count_item);
           System.out.println("Items With Discount: " + count_dis);
           System.out.println("Items With Christmas Discount: " + count_chris);
           System.out.println("Items In Offer: " + count_offer);
            
           
            }
        }
        
    }

    private static void overall() throws InputMismatchException {

        double total = 0;
        int count_item = 0;
        int count_dis = 0;
        int count_chris = 0;
        int count_offer = 0;

        try {
            Scanner p = new Scanner(System.in);

            for (Table t : being_served) {
                total += t.setNet_Amount();

                for (Item i : t.list_of_items) {

                    if (i.getClass() == Item.class) count_item++;

                    if (i.getClass() == ItemWithDiscount.class) count_dis++;

                    if (i.getClass() == ItemChristmas.class) count_chris++;

                    if (i.getClass() == ItemsInOffer.class) count_offer++;

                }


            }

            waiter.setShift_stop();


            System.out.println("/n----TOTAL----");
            System.out.println("Day's Total: " + total);
            System.out.println("Total Items: " + (count_chris + count_dis + count_offer + count_item));
            System.out.println("Total Tables Served: " + (being_served.size() + served.size()));
            System.out.println("Items: " + count_item);
            System.out.println("Items With Discount: " + count_dis);
            System.out.println("Items With Christmas Discount: " + count_chris);
            System.out.println("Items In Offer: " + count_offer);
              
           

            System.out.println("\n---------------------\n");

            System.out.println("\n----SALARIES----");
            for (User u : users) {
            if (u.getClass() == Waiter.class) {
            System.out.println(u.Username + ", Wage: " + u.CalculateWage() + " $"); //RREGULLO PAGEN
            
            break;
            }
            }
            
            
            System.out.println("\n------------------------\n");
            System.out.println("Waiter's Name: ");

            for (User u : users) {

                if (u.getClass() == Waiter.class) {

                    System.out.println(u.Username);
                }

            }

            String user = p.nextLine();

            int tables_served = 0;

            int items_served = 0;

            for (Table t : being_served) {

                if (t.getName().equals(user)) {
                    {
                        for (Item i : t.list_of_items) {

                            items_served++;
                        }

                    }

                    tables_served++;
                } else return;
            }


            for (Table t : served) {

                if (t.getName().equals(user)) {

                    tables_served++;

                }
            }

            System.out.println("\n----Waiter-Stats----");
            System.out.println("Username: " + user);
            System.out.println("Tables Served: " + tables_served);
            System.out.println("Items Served: " + items_served);
            System.out.println("\n----Closed----");

            System.out.println("\n----Customer_Stats----");
            calculate_bonus();


        } catch (InputMismatchException e) {

            e.printStackTrace();

        }


    }

    private static void list_all_items(Table t) {

        for (Item i : t.list_of_items) {

            System.out.println("Name: " + i.getName());

        }

    }
    
   

     private static void modify_table(Table f, int item_id) throws InputMismatchException {

        Scanner l = new Scanner(System.in);

        for (Table t : being_served) {

            System.out.println("Table " + t.getID());

            list_all_items(t);

        }

        System.out.println("Enter Name: ");

        for (Item j : f.list_of_items) {
            if (j.getName().equals(l.nextLine())) {

                item_id--;

                f.list_of_items.remove(j);

                add_item(f, item_id);
            }
        }


   }
    
     private static void remove_item(Table f, int item_id) throws InputMismatchException {
         
         Scanner l = new Scanner(System.in);

        for (Table t : being_served) {

            System.out.println("Table " + t.getID());

            list_all_items(t);
     }
          System.out.println("Enter Name: ");
          String name = l.nextLine();
        for (Item j : f.list_of_items) {
            if (j.getName().equals(name)) {

                item_id--;

                f.list_of_items.remove(j);
                
                remove_item(f, item_id);
                System.out.println("Product is succesfully removed!" );
                list_all_items(f);
                break;
            }
        }
     }
     
    private static Waiter change_shift() {


        waiter.setShift_stop();

        waiter = Login_Waiter();
        if (waiter.getUsername() == null || waiter.getPassword() == 0) {


            System.out.println("Error Credentials are not correct!");
            System.exit(0);
        }
        users.add(waiter);

        return waiter;
    }

    private static void calculate_bonus(){

        int f=0;
        int c=0;
        int e=0;


        for (User u : users){

            if(u.getClass().equals(LoyalCustomer.class)){

                f +=u.getBonus();

            }
            if(u.getClass().equals(CustomerEmployee.class)){

                e +=u.getBonus();

            }
            if(u.getClass().equals(CompanyCustomer.class)){

                c +=u.getBonus();

            }
        }

        System.out.println("Simple Customers Bonus: " + 0);
        System.out.println("Loyal Customers Bonus: " + f);
        System.out.println("Company Customers Bonus: " + c);
        System.out.println("Employee Customers Bonus: " + e);


    } 
    
    


    public static void main(String[] args) {

        int table_id = 0;
        int item_id = 1;
        int  remove_item_id = 1;

        waiter = Login_Waiter();
        if (waiter.getUsername() == null || waiter.getPassword() == 0) {


            System.out.println("Error Credentials are not correct!");
            System.exit(0);
        }

        users.add(waiter);

        manager = Login_Manager();

        if (manager.Username == null || manager.password == 0) {


            System.out.println("Error Credentials are not correct!");
            System.exit(0);
        }

        users.add(manager);

        System.out.println("\n----Current-Discounts----");
        System.out.println("Overall Discount: "+overall_discount );
        System.out.println("Discount: "+item_discount );
        System.out.println("Christmas Discount: "+christmas_discount );
        System.out.println("Offer: "+buy_for_less );
        System.out.println("-------------------------\n");




        Scanner s = new Scanner(System.in);

        boolean check = true;

        Scanner k = new Scanner(System.in);

        Table table;

        while (check) {

            System.out.println("-------------------");
            System.out.println("1. Add Table: ");
            System.out.println("2. Print Current Table Information: ");
            System.out.println("3. Add Item: ");
            System.out.println("4. Give Discount: "); //SHIKOJE NJEHERE KETE DMTH TESTOJE!
            System.out.println("5. Change Item: ");
            System.out.println("6. Print Bill: ");
            System.out.println("7. Change Account: ");
            System.out.println("8. Remove an Item: ");
            System.out.println("9. Overall number of tables with a certain ID of a waiter: "); //1 SHIKO SE TE MERR VETEM NJE KAMARJER
            System.out.println("10. Total amount of all items of a waiter with a certain ID: ");//2
            System.out.println("11. Total amount of all items of the current day: ");
            System.out.println("12. Print information of a certian table ID: ");
            System.out.println("0.Exit");
            System.out.println("--------------------");
            switch (s.nextInt()) {

                case 1:
                    add_table(table_id++);
                    System.out.println("Table ID " + table_id);
                    System.out.println("waiter.getUsername()  " + waiter.getUsername());
                    being_served.get(table_id - 1).setName(waiter.getUsername()); //problem ketu 
                    break;
                case 2:
//RREGULLO KETE KODIN!
                     if (being_served.size() == 0) {

                        System.out.println("No Active Tables.");
                    } else {
               System.out.println("Select a table:  ");
                    for (Table t : being_served) {

                        System.out.println("Table: "+ t.getID());
                         System.out.println(t.PrintInfo());
                    }
                 }
                     break;


                case 3:
                    System.out.println("Select a Table: ");
                    for (Table t : being_served) {

                        System.out.println("Table: "+ t.getID());
                    }
                    table = select_table(k.nextInt() - 0); //-1
                    add_item(table, item_id);
                    table.setTotal_Amount();
                    table.setNet_Amount();
                    item_id++;
                    for (Table t : being_served) {

                        t.CalculateBonus();
                        for(User us : users){

                            if(us.getID() == t.getID()){

                                us.setBonus( table.getBonus());
                            }
                        }
                    }


                    break;

                case 4:
                    if (check_credentials()) {
                        discount();
                    } else
                        System.out.println("Wrong Password!");

                    break;
                case 5:
                    System.out.println("Select a Table: ");

                    table = select_table(k.nextInt()); //-1

                    modify_table(table, item_id);


                    break;

                case 6:
                    pay_bill();
                    table_id = 0;
                    break;

                case 7:

                    System.out.println("Login Waiter & Manager: ");
                    change_shift();

                    break;
                    
                case 8: 
                    if (check_credentials()) {
                        
                       System.out.println("Select a Table: ");
                     //kopjo kete kodin per te numri 2
                    table = select_table(k.nextInt()); //-1

                    remove_item(table, item_id);      
                    
                    }
                    else
                    {
                       check = false; 
                    }
                 
                break;
                    
                case 9:
                    //Overall number of tables of a certain ID of a waiter!
                    if(check_credentials()) 
                    {
                        //if (being_served.size() == 0) 
                        //{
                        //System.out.println("No Active Tables.");
                        //} 
                        //else 
                        //{
                        //  System.out.println("Select a Table: ");

                          //table = select_table(k.nextInt() - 1);

                          //System.out.println(table.PrintInfo());
                        //  System.out.println(table.served_Table_By_cashier());
                        //}
                   // System.out.println("Enter the credentials of a waiter: ");
                    for (User u : users) 
                    {
                        if (u.getClass() == Waiter.class) 
                        {
                      //  System.out.println(u.Username);
                          //System.out.println("Total Tables Served: " + (being_served.size() + served.size()));
                          for (Table t:being_served)
                          {
                              System.out.println("Table: " + t.getID() + ":" + t.getName() );
                          }
                        break;
                        } else 
                        {
                            check = false;
                            break;
                        }
          //  }
                      }
                    }
                  break; //RREGULLO KODIN TE NDAHET ME EMRA
                                        
                case 10: 
                    
                    //Total number of items of a waiter of a certain ID
                    if(check_credentials()) 
                    {
                   // System.out.println("Enter the credentials of a waiter: ");
                    for (User u : users) 
                    {
                        if (u.getClass() == Waiter.class) 
                        {
                       // System.out.println(u.Username);
                      //    System.out.println("Total Tables Served: " + (being_served.size() + served.size()));
                          for (Table t:being_served)
                          {
                              //System.out.println("Table: " + t.getID() + ":" + t.getName() );
                              for (Item i :t.list_of_items)
                              {
                                  System.out.println( t.getName() + ",Items: " + i.getName() );
                              }
                          }
                        break;
                        } else 
                        {
                            System.out.println("Wrong password");
                            check = false;
                            break;
                        }
          //  }
                      }
                    }
                break;
                     
                case 11: 
                    
                    if(check_credentials()) {
                        
                        overall();
                        break;
                    }else {
                        System.out.println("Wrong password");
                        check = false;
                        break; //RREGULLO PAGEN E KAMARJERIT
                    }
                
                case 12: 
                    if (being_served.size() == 0) {

                        System.out.println("No Active Tables.");
                    } else {
                     System.out.println("Select a Table: ");

                    table = select_table(k.nextInt());

                   System.out.println(table.PrintInfo());
                    
                     break;
                    }
                case 0:
                    if (check_credentials()) {
                        
             System.out.println("Program closed!");
                        
                     System.exit(0);
                    } else
                        System.out.println("Wrong Password!");
                        check = false;

                    break;
            }
        }


    }
    
  
}

 


   