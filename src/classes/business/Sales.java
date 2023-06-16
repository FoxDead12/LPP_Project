/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.business;

import java.util.ArrayList;

/**
 *
 * @author dx3
 */
public class Sales {
    
    private Integer id;
    private Cliente client;
    private ArrayList<Product> products = new ArrayList<>();
    private User employee;
    private double total = 0;
    
    public Sales (Cliente client, User employee, ArrayList<Product> products) {
        this.employee = employee;
        this.client = client;
        this.products = products;
        this.total = CalculateTotal();
    }
    
    public Sales (Cliente client, User employee, ArrayList<Product> products, Integer id) {
        this.employee = employee;
        this.client = client;
        this.products = products;
        this.total = 0;
        this.id = id;
    }
    
    private double CalculateTotal () {
        
        double total = 0;
        
        for (Product product: this.products) {
            total += product.CalculatePrice();
        }
        
        return total;
    }
    
    public Integer getClienteId () {
        if (this.client == null) {
            return null;
        } 
        
        return this.client.getId();
    }
    
    public double getTotal () {
        return this.total;
    }
    
    public Integer getEmployeeId () {
        return this.employee.getId();
    }
    
    public Integer getId () {
        return this.id;
    }
}
