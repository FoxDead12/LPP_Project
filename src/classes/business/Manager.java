/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.business;

/**
 *
 * @author dx3
 */
public class Manager extends User {
    
    public Manager(String full_name, String email) {
        super(full_name, email, "manager");
    }
    
    public Manager(String full_name, String email, Integer id) {
        super(full_name, email, "manager", id);
    }
    
    public Manager(String full_name, String email, String hash) {
        super(full_name, email, "manager", hash);
    }
    
    @Override
    public String ShowRole() {
        return "Gerente";
    }
}
