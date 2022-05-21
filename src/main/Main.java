package main;

import classes.DbConnection;
import classes.Item;
import classes.drink.AppleJuice;
import classes.drink.Tea;
import classes.drink.Water;
import classes.food.Bread;
import classes.food.Cheese;
import classes.food.Rice;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class Main { //implements ActionListener {

   // static JLabel text;
    public static void main(String[] args) throws SQLException {
        DbConnection db = new DbConnection();
        List<Item> items = new ArrayList<>();
        for(int i=0;i<18;i++)
        {
            items.add(db.getItemById(i+1));
        }
        HashMap<Integer, Item> table = new HashMap<>();
        for(int i=0;i<items.size();i++)
        {
            table.put(items.get(i).getId(), items.get(i));
        }


        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Main Menu\n");
            System.out.print("1.) Show all items in store.\n");
            System.out.print("2.) Show the map of items with the id as key.\n");
            System.out.print("3.) Show total price of all items.\n");
            System.out.print("4.) Show the item with lowest carbs.\n");
            System.out.print("5.) Show the item with the highest energetic value.\n");
            System.out.print("6.) Show the item with the highest proteic value.\n");
            System.out.print("7.) Show the item with the lowest sodium amount.\n");
            System.out.print("8.) Show the items with the weight higher than 1kg.\n");
            System.out.print("9.) Show the cheapest item in the store\n");
            System.out.print("10.) Show the most expensive item in the store\n");
            System.out.print("11.) Insert item into database\n");
            System.out.print("12.) Delete item from database\n");
            System.out.print("13.) Update item from database\n");
            System.out.print("14.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();


            if(choice==1)
                for(int i=0;i<items.size();i++) {
                System.out.println("Item no. " + (i+1) + ":");
                System.out.println(items.get(i));
                System.out.print("This item's class type is: ");
                System.out.println(items.get(i).getClass());
                System.out.println(" ");
            }
            else if (choice==2) {
                System.out.println(table);
            } else if (choice==3) {double sum=0;
                for(int i=0;i<items.size();i++)
                    sum+=items.get(i).getPrice();
                System.out.println("Total value of item in store is: "+sum+" lei");
            } else if (choice==4) {
                Comparator<Item> carbsComparator = Comparator.comparing(Item::getCarbohydrates);
                System.out.println(items.stream().min(carbsComparator));
            } else if (choice==5) {
                Comparator<Item> enValueComparator = Comparator.comparing(Item::getEnergeticValue);
                System.out.println(items.stream().max(enValueComparator));
            } else if (choice==6) {
                Comparator<Item> proteinComparator = Comparator.comparing(Item::getProteins);
                System.out.println(items.stream().max(proteinComparator));
            } else if (choice==7) {
                Comparator<Item> sodiumComparator = Comparator.comparing(Item::getSodium);
                System.out.println(items.stream().min(sodiumComparator));
            } else if (choice==8) {
                items.forEach(item -> {if(item.getWeight()<1) System.out.println(item);});
            } else if (choice==9) {
                Comparator<Item> priceComparator = Comparator.comparing(Item::getPrice);
                System.out.println(items.stream().min(priceComparator));
            } else if (choice==10) {
                Comparator<Item> priceComparator = Comparator.comparing(Item::getPrice);
                System.out.println(items.stream().max(priceComparator));
            } else if (choice==11) {
                String query = "insert into item (id, nume, price, weight, energeticValue, carbohydrates, sodium, proteins)" + " values(?,?,?,?,?,?,?,?)";
                System.out.println("Insert name: ");
                String name;
                name = input.next();
                if(name.equals("Bread"))
                {
                    Bread bread = new Bread();
                    System.out.println("Insert ID: ");
                    bread.setId(input.nextInt());
                    System.out.println("Insert price: ");
                    bread.setPrice(input.nextDouble());
                    System.out.println("Insert weight: ");
                    bread.setWeight(input.nextDouble());
                    System.out.println("Insert energeticValue: ");
                    bread.setEnergeticValue(input.nextDouble());
                    System.out.println("Insert carbohydrates: ");
                    bread.setCarbohydrates(input.nextDouble());
                    System.out.println("Insert sodium: ");
                    bread.setSodium(input.nextDouble());
                    System.out.println("Insert proteins: ");
                    bread.setProteins(input.nextDouble());
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.setInt(1, bread.getId());
                    stmt.setString(2, name);
                    stmt.setDouble(3, bread.getPrice());
                    stmt.setDouble(4, bread.getWeight());
                    stmt.setDouble(5, bread.getEnergeticValue());
                    stmt.setDouble(6, bread.getCarbohydrates());
                    stmt.setDouble(7, bread.getSodium());
                    stmt.setDouble(8, bread.getProteins());
                    stmt.executeUpdate();
                    } else if (name.equals("Rice")) {
                    Rice rice = new Rice();
                    System.out.println("Insert ID: ");
                    rice.setId(input.nextInt());
                    System.out.println("Insert price: ");
                    rice.setPrice(input.nextDouble());
                    System.out.println("Insert weight: ");
                    rice.setWeight(input.nextDouble());
                    System.out.println("Insert energeticValue: ");
                    rice.setEnergeticValue(input.nextDouble());
                    System.out.println("Insert carbohydrates: ");
                    rice.setCarbohydrates(input.nextDouble());
                    System.out.println("Insert sodium: ");
                    rice.setSodium(input.nextDouble());
                    System.out.println("Insert proteins: ");
                    rice.setProteins(input.nextDouble());
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.setInt(1, rice.getId());
                    stmt.setString(2, name);
                    stmt.setDouble(3, rice.getPrice());
                    stmt.setDouble(4, rice.getWeight());
                    stmt.setDouble(5, rice.getEnergeticValue());
                    stmt.setDouble(6, rice.getCarbohydrates());
                    stmt.setDouble(7, rice.getSodium());
                    stmt.setDouble(8, rice.getProteins());
                    stmt.executeUpdate();
                } else if (name.equals("Cheese")) {
                    Cheese cheese = new Cheese();
                    System.out.println("Insert ID: ");
                    cheese.setId(input.nextInt());
                    System.out.println("Insert price: ");
                    cheese.setPrice(input.nextDouble());
                    System.out.println("Insert weight: ");
                    cheese.setWeight(input.nextDouble());
                    System.out.println("Insert energeticValue: ");
                    cheese.setEnergeticValue(input.nextDouble());
                    System.out.println("Insert carbohydrates: ");
                    cheese.setCarbohydrates(input.nextDouble());
                    System.out.println("Insert sodium: ");
                    cheese.setSodium(input.nextDouble());
                    System.out.println("Insert proteins: ");
                    cheese.setProteins(input.nextDouble());
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.setInt(1, cheese.getId());
                    stmt.setString(2, name);
                    stmt.setDouble(3, cheese.getPrice());
                    stmt.setDouble(4, cheese.getWeight());
                    stmt.setDouble(5, cheese.getEnergeticValue());
                    stmt.setDouble(6, cheese.getCarbohydrates());
                    stmt.setDouble(7, cheese.getSodium());
                    stmt.setDouble(8, cheese.getProteins());
                    stmt.executeUpdate();
                } else if (name.equals("Water")) {
                    Water water= new Water();
                    System.out.println("Insert ID: ");
                    water.setId(input.nextInt());
                    System.out.println("Insert price: ");
                    water.setPrice(input.nextDouble());
                    System.out.println("Insert weight: ");
                    water.setWeight(input.nextDouble());
                    System.out.println("Insert energeticValue: ");
                    water.setEnergeticValue(input.nextDouble());
                    System.out.println("Insert carbohydrates: ");
                    water.setCarbohydrates(input.nextDouble());
                    System.out.println("Insert sodium: ");
                    water.setSodium(input.nextDouble());
                    System.out.println("Insert proteins: ");
                    water.setProteins(input.nextDouble());
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.setInt(1, water.getId());
                    stmt.setString(2, name);
                    stmt.setDouble(3, water.getPrice());
                    stmt.setDouble(4, water.getWeight());
                    stmt.setDouble(5, water.getEnergeticValue());
                    stmt.setDouble(6, water.getCarbohydrates());
                    stmt.setDouble(7, water.getSodium());
                    stmt.setDouble(8, water.getProteins());
                    stmt.executeUpdate();
                } else if (name.equals("Tea")) {
                    Tea tea = new Tea();
                    System.out.println("Insert ID: ");
                    tea.setId(input.nextInt());
                    System.out.println("Insert price: ");
                    tea.setPrice(input.nextDouble());
                    System.out.println("Insert weight: ");
                    tea.setWeight(input.nextDouble());
                    System.out.println("Insert energeticValue: ");
                    tea.setEnergeticValue(input.nextDouble());
                    System.out.println("Insert carbohydrates: ");
                    tea.setCarbohydrates(input.nextDouble());
                    System.out.println("Insert sodium: ");
                    tea.setSodium(input.nextDouble());
                    System.out.println("Insert proteins: ");
                    tea.setProteins(input.nextDouble());
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.setInt(1, tea.getId());
                    stmt.setString(2, name);
                    stmt.setDouble(3, tea.getPrice());
                    stmt.setDouble(4, tea.getWeight());
                    stmt.setDouble(5, tea.getEnergeticValue());
                    stmt.setDouble(6, tea.getCarbohydrates());
                    stmt.setDouble(7, tea.getSodium());
                    stmt.setDouble(8, tea.getProteins());
                    stmt.executeUpdate();
                } else if (name.equals("AppleJuice")) {
                    AppleJuice appleJuice=new AppleJuice();
                    System.out.println("Insert ID: ");
                    appleJuice.setId(input.nextInt());
                    System.out.println("Insert price: ");
                    appleJuice.setPrice(input.nextDouble());
                    System.out.println("Insert weight: ");
                    appleJuice.setWeight(input.nextDouble());
                    System.out.println("Insert energeticValue: ");
                    appleJuice.setEnergeticValue(input.nextDouble());
                    System.out.println("Insert carbohydrates: ");
                    appleJuice.setCarbohydrates(input.nextDouble());
                    System.out.println("Insert sodium: ");
                    appleJuice.setSodium(input.nextDouble());
                    System.out.println("Insert proteins: ");
                    appleJuice.setProteins(input.nextDouble());
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.setInt(1, appleJuice.getId());
                    stmt.setString(2, name);
                    stmt.setDouble(3, appleJuice.getPrice());
                    stmt.setDouble(4, appleJuice.getWeight());
                    stmt.setDouble(5, appleJuice.getEnergeticValue());
                    stmt.setDouble(6, appleJuice.getCarbohydrates());
                    stmt.setDouble(7, appleJuice.getSodium());
                    stmt.setDouble(8, appleJuice.getProteins());
                    stmt.executeUpdate();
                }
            } else if (choice==12) {
                int id;
                System.out.println("Insert ID: ");
                id=input.nextInt();
                String query = "delete from item "+"where id="+id+" ";
                PreparedStatement stmt = db.getConn().prepareStatement(query);
                stmt.executeUpdate();
            } else if (choice==13) {
                int id;
                String field;
                System.out.println("Insert ID: ");
                id=input.nextInt();
                System.out.println("Insert field to by modified: ");
                field=input.next();
                if(field.equals("name"))
                {
                    System.out.println("Insert new name: ");
                    String newName=input.next();
                    String query = "update item set name="+newName+" "+" where id ="+id+" ";
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.executeUpdate();
                } else if (field.equals("price")) {
                    System.out.println("Insert new price: ");
                    double newPrice;
                    newPrice=input.nextDouble();
                    String query = "update item set price="+newPrice+" "+" where id ="+id+" ";
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.executeUpdate();
                } else if (field.equals("weight")) {
                    System.out.println("Insert new weight: ");
                    double newWeight=input.nextDouble();
                    String query = "update item set weight="+newWeight+" "+" where id ="+id+" ";
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.executeUpdate();
                } else if (field.equals("energeticValue")) {
                    System.out.println("Insert new energeticValue: ");
                    double newEnergeticValue=input.nextDouble();
                    String query = "update item set energeticValue="+newEnergeticValue+" "+" where id ="+id+" ";
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.executeUpdate();
                } else if (field.equals("carbohydrates")) {
                    System.out.println("Insert new carbohydrates: ");
                    double newCarbs=input.nextDouble();
                    String query = "update item set carbohydrates="+newCarbs+" "+" where id ="+id+" ";
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.executeUpdate();
                } else if (field.equals("sodiume")) {
                    System.out.println("Insert new sodium: ");
                    double newSodium=input.nextDouble();
                    String query = "update item set sodium="+newSodium+" "+" where id ="+id+" ";
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.executeUpdate();
                } else if (field.equals("proteins")) {
                    System.out.println("Insert new proteins: ");
                    double newProteins=input.nextDouble();
                    String query = "update item set proteins="+newProteins+" "+" where id ="+id+" ";
                    PreparedStatement stmt = db.getConn().prepareStatement(query);
                    stmt.executeUpdate();
                }

            }


        } while (choice <=13);




// Am incercat sa fac si un popup pentru a face meniul in interfata grafica, dar nu mai stiam sigur cum lucrase la curs si m-am impotmolit
//        JFrame frame = new JFrame("Menu");
//        frame.setSize(900,900);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
//
//        ActionListener obj = e -> text.setText("Menu Item Selected: "+e.getActionCommand());
//        JMenu menu = new JMenu("Select Here");
//        JMenuItem[] item = new JMenuItem[10];
//        for(int i=0;i<10;i++)
//        {
//            item[i]=new JMenuItem("Item "+(i+1));
//            item[i].addActionListener(obj);
//            menu.add(item[i]);
//        }
//
//        JMenuBar mb= new JMenuBar();
//        mb.add(menu);
//        frame.setJMenuBar(mb);
//
//        text = new JLabel();
//        frame.add(text);
//        frame.setVisible(true);
    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
}
