/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.business;

/**
 *
 * @author dx3
 */
public class Employee extends User {
    
    public Employee(String full_name, String email) {
        super(full_name, email, "employee");
    }
    
    public Employee(String full_name, String email, Integer id) {
        super(full_name, email, "employee", id);
    }
    
    public Employee(String full_name, String email, String hash) {
        super(full_name, email, "employee", hash);
    }
    
    @Override
    public String ShowRole() {
        return "Empregado";
    }
}
