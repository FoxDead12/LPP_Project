/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package home.cash;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dx3
 */
public class Cash extends javax.swing.JPanel {

    private home.Home mainHome;
    private ArrayList<Button> buttons = new ArrayList<>();
    
    public Cash(home.Home home) {
        initComponents();
        
        mainHome = home;
        jScrollPane1.getViewport().setBackground(Color.decode("#1976F0"));
        table_products.setShowGrid(false);
        table_products.setShowHorizontalLines(false);
        table_products.setShowVerticalLines(false);
        table_products.setGridColor(Color.decode("#1976F0"));
        table_products.setRowHeight(60);
        
        LoadButtons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_products = new javax.swing.JTable();
        buttons_scroller = new javax.swing.JScrollPane();
        buttons_container = new javax.swing.JPanel();

        jScrollPane1.setBackground(new java.awt.Color(25, 118, 240));
        jScrollPane1.setBorder(null);

        table_products.setBackground(new java.awt.Color(25, 118, 240));
        table_products.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        table_products.setForeground(new java.awt.Color(255, 255, 255));
        table_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Preço"
            }
        ));
        table_products.setEnabled(false);
        table_products.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(table_products);

        buttons_container.setLayout(new java.awt.GridLayout());
        buttons_scroller.setViewportView(buttons_container);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(buttons_scroller, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttons_scroller)
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents


    public void GetAllProducts () {
        
    }
    
    public void LoadButtons () {
        
        try {
            ResultSet result = mainHome.db.executeQuery("SELECT name FROM products;");
            Integer countLines = 0;
           
            while (result.next()) {
                Button button = new Button(result.getString("name"));
                buttons.add(button);
                buttons_container.add(button);
                countLines++;     
            }
            
            while (result.next()) {
                Button button = new Button(result.getString("name"));
                buttons.add(button);
                buttons_container.add(button);
                 countLines++;               
            }
            
            
            Integer numColum = 5;
            Integer numRows = (countLines / numColum) + 1;
            buttons_container.setLayout(new GridLayout(numColum, numRows));
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttons_container;
    private javax.swing.JScrollPane buttons_scroller;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_products;
    // End of variables declaration//GEN-END:variables
}