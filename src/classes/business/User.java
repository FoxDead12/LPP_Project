/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.business;

/**
 *
 * @author dx3
 */
public class User implements IUser {
    
    private String full_name = "";
    private String email = "";
    private String role = "";
    private String hash = "";
    private Integer id = null;
    
    public User (String full_name, String email, String role) {
        this.email = email;
        this.full_name = full_name;
        this.role = role;
    }
    
    public User (String full_name, String email, String role, Integer id) {
        this.email = email;
        this.full_name = full_name;
        this.role = role;
        this.id = id;
    }
    
    public User (String full_name, String email, String role, String hash) {
        this.email = email;
        this.full_name = full_name;
        this.role = role;
        this.hash = hash;
    }

    @Override
    public String getName() {
        return this.full_name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public String ShowRole() {
        return "User";
    }

    @Override
    public String getHash() {
        return this.hash;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
