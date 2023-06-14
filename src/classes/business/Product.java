/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.business;

public class Product{
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Product(String text, String text2, String text3) {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
   
    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

}