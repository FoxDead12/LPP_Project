/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.business;

public class Cliente {
    private String full_name = "";
    private String nif = "";
    private String address = "";
    
    public Cliente (String full_name, String nif, String address) {
        this.full_name = full_name;
        this.nif = nif;
        this.address = address;
    }
    
    public String getName () {
        return this.full_name;
    }
    
    public String getNif () {
        return this.nif;
    }
    
    public String getAddres () {
        return this.address;
    }
}
