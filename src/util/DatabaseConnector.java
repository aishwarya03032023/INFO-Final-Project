/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;
import java.util.ArrayList;
import model.Item;

/**
 * Database Connector class for interacting with database
 * @author Praveen
 */
public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Privatized constructor so as to not allow object creation
     */
    private DatabaseConnector() {
    }

    /**
     * Insert given user to database
     * @see User
     * @param user User object to be added
     */
    public static void addUser(Item user) {
        //add to database
        String query = "INSERT INTO data(ItemName,Manufacturer,SKU,Quantity,Category,Active) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getItemName());
            stmt.setString(2, user.getManufacturer());
            stmt.setString(3, user.getSkuNo());
            stmt.setString(4, user.getQuantity());
            stmt.setString(5, user.getCategory());
            stmt.setString(6, user.getActive());
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows);
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return lost of all items in database
     * @see User
     * @return list of items
     */
    public static ArrayList<Item> getAllusers() {
//        return list of items from db
        ArrayList<Item> users = new ArrayList<>();

        String query = "SELECT * FROM data";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item newUser = new Item();
                newUser.setItemName(rs.getString("ItemName"));
                newUser.setManufacturer(rs.getString("Manufacturer"));
                newUser.setSkuNo(rs.getString("SKU"));
                newUser.setQuantity(rs.getString("Quantity"));
                newUser.setCategory(rs.getString("Category"));
                newUser.setActive(rs.getString("Active"));
                newUser.setId(rs.getInt("ID"));
                users.add(newUser);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public static ArrayList<Item> getAllItemsWithCriteria(String category) {
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT * FROM data ";
        
        if (category!= null && !category.equalsIgnoreCase("All")) {
            query += "where category = '" + category+"'";
        }

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item newItem = new Item();
                newItem.setItemName(rs.getString("ItemName"));
                newItem.setManufacturer(rs.getString("Manufacturer"));
                newItem.setSkuNo(rs.getString("SKU"));
                newItem.setQuantity(rs.getString("Quantity"));
                newItem.setCategory(rs.getString("Category"));
                newItem.setActive(rs.getString("Active"));
                newItem.setId(rs.getInt("ID"));
                items.add(newItem);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    /**
     * Delete given user from database
     * @see User
     * @param u User to be deleted
     * 
     */
    public static void deleteItem(Item u) {
        String query = "delete from data where ID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edit given user details in the database
     * @param oldUser existing user in database
     * @param newUser modified user details to be added
     */
    public static void editUser(Item oldUser, Item newUser) {
        String query = "UPDATE data SET ItemName=?, Manufacturer=?, SKU=?, Quantity=?, Category=?, Active=? WHERE ID=?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newUser.getItemName());
            stmt.setString(2, newUser.getManufacturer());
            stmt.setString(3, newUser.getSkuNo());
            stmt.setString(4, newUser.getQuantity());
            stmt.setString(5, newUser.getCategory());
            stmt.setString(6, newUser.getActive());
            stmt.setInt(7, oldUser.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
