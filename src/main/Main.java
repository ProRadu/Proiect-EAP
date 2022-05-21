package main;

import classes.DbConnection;
import classes.Item;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.*;


public class Main { //implements ActionListener {

   // static JLabel text;
    public static void main(String[] args) {
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
            System.out.print("11.) Exit\n");
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
            }


        } while (choice <=10);




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
