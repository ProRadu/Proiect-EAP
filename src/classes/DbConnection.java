package classes;

import classes.drink.AppleJuice;
import classes.drink.Tea;
import classes.drink.Water;
import classes.food.Bread;
import classes.food.Cheese;
import classes.food.Rice;

import java.sql.*;

public class DbConnection {


    Connection conn = null;
    Statement stmt = null;

    public DbConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_store" , "java_project" , "password");

            System.out.println("Connection to Database successful!");

        } catch (SQLException e) {
            throw new Error("Custom error", e);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public Item getItemById(int id) {
        String query = "select * from item where id=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                int itemId = rs.getInt(1);
                String name = rs.getString(2);
                double itemPrice = rs.getDouble(3);
                double itemWeight = rs.getDouble(4);
                double itemEnergeticValue = rs.getDouble(5);
                double itemCarbohydrates = rs.getDouble(6);
                double itemSodium = rs.getDouble(7);
                double itemProteins = rs.getDouble(8);

                if(name.equals("Bread"))
                {Bread bread = new Bread(itemId, itemPrice, itemWeight, itemEnergeticValue, itemCarbohydrates, itemSodium, itemProteins);
                return bread;} else if (name.equals("Rice")) {
                    Rice rice = new Rice(itemId, itemPrice, itemWeight, itemEnergeticValue, itemCarbohydrates, itemSodium, itemProteins);
                    return rice;
                } else if (name.equals("Cheese")) {
                    Cheese cheese = new Cheese(itemId, itemPrice, itemWeight, itemEnergeticValue, itemCarbohydrates, itemSodium, itemProteins);
                    return cheese;
                } else if (name.equals("Water")) {
                    Water water= new Water(itemId, itemPrice, itemWeight, itemEnergeticValue, itemCarbohydrates, itemSodium, itemProteins);
                    return water;
                } else if (name.equals("Tea")) {
                    Tea tea = new Tea(itemId, itemPrice, itemWeight, itemEnergeticValue, itemCarbohydrates, itemSodium, itemProteins);
                    return tea;
                } else if (name.equals("AppleJuice")) {
                    AppleJuice appleJuice=new AppleJuice(itemId, itemPrice, itemWeight, itemEnergeticValue, itemCarbohydrates, itemSodium, itemProteins);
                    return appleJuice;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
