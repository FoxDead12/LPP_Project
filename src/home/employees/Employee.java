/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package home.employees;

import classes.business.Manager;
import classes.business.User;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dx3
 */
public class Employee extends javax.swing.JPanel {

    private home.Home mainHome;
    private ArrayList<User> usersList = new ArrayList<>();
    private ArrayList<RowToUpdate> rowToUpdate = new ArrayList<>();
    
    public Employee(home.Home home) {
        initComponents();
        mainHome = home;
        
        jScrollPane1.getViewport().setBackground(Color.decode("#FFFFFF"));
        
        GetAllEmployees();
        
        
        save_changes.setEnabled(false);
        jTable1.getModel().addTableModelListener(
            new TableModelListener() 
            {
                public void tableChanged(TableModelEvent evt) 
                {
                    // here goes your code "on cell update"           
                    rowToUpdate.add(new RowToUpdate(evt.getFirstRow(), usersList.get(evt.getFirstRow()).getEmail()));
                    if (!rowToUpdate.isEmpty()) {
                        save_changes.setEnabled(true);
                    }
                }  
            }
             
        );
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        save_changes = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTable1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(25, 118, 240));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Adicionar Empregado");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        save_changes.setBackground(new java.awt.Color(25, 118, 240));
        save_changes.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        save_changes.setForeground(new java.awt.Color(255, 255, 255));
        save_changes.setText("Guardar");
        save_changes.setBorder(null);
        save_changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_changesActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 0, 51));
        delete.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Apagar");
        delete.setBorder(null);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(save_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Create create = new Create(this);
        create.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void save_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_changesActionPerformed
        // TODO add your handling code here:
        
        //Save updates
        try {
            save_changes.setEnabled(false);
            ArrayList<String> valuesQuery = new ArrayList<>();
            for (RowToUpdate row : rowToUpdate) {
                
                String name = jTable1.getModel().getValueAt(row.index, 0).toString();
                String email = jTable1.getModel().getValueAt(row.index, 1).toString();
                String role = jTable1.getModel().getValueAt(row.index, 2).toString();
                
                if (role.toLowerCase().equals("gerente")) {
                    role = "manager";
                } else {
                    role = "employee";
                }
                
               valuesQuery.add("UPDATE users set full_name = '" + name +"', email = '" + email + "', role = '" + role + "', date_updated = now() where email = '" + row.email +"';");
            }
            
            mainHome.db.updateQuery(String.join(" ", valuesQuery));
            rowToUpdate.clear();
            GetAllEmployees();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_save_changesActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRows().length == 0) {
            return;
        }
        
        
        try {   
            ArrayList<String> valuesQuery = new ArrayList<>();
            
            for (Integer index : jTable1.getSelectedRows()) {
                User user = usersList.get(index);
                valuesQuery.add("DELETE FROM users where id = " + user.getId() + ";");
            }
            
            mainHome.db.updateQuery(String.join(" ", valuesQuery));
            GetAllEmployees();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void GetAllEmployees () {
        usersList.clear();
        try {
            ResultSet result = mainHome.db.executeQuery("SELECT full_name, email, role, id FROM users ORDER BY role, full_name ASC");
            DefaultTableModel model = new DefaultTableModel(); 
            model.addColumn("Nome");
            model.addColumn("Email");
            model.addColumn("Cargo");
            model.addTableModelListener(jTable1);
            
            jTable1.getTableHeader().setReorderingAllowed(false);
            
            while (result.next()) {
                User user;
                if (result.getString("role").equals("manager")) {
                    user = new Manager(result.getString("full_name"), result.getString("email"), result.getInt("id"));
                } else {
                    user = new classes.business.Employee(result.getString("full_name"), result.getString("email"), result.getInt("id"));
                }
                usersList.add(user);
            }
            
            for (User user : usersList) {
                model.addRow(new Object[]{user.getName(), user.getEmail(), user.ShowRole()});
            }
            
            jTable1.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void CreateEmployee (User user) {
        
        try {
        
            mainHome.db.updateQuery("INSERT INTO users (full_name, email, role, hash) VALUES ('?','?','?','?')", user.getName(), user.getEmail(), user.getRole(), user.getHash());
            
            GetAllEmployees();
        
        } catch (Exception e) {
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton save_changes;
    // End of variables declaration//GEN-END:variables
}


class RowToUpdate {
    
    public Integer index;
    public String email;
       
    RowToUpdate (Integer index, String email) {
        this.index = index;
        this.email = email;
    }
}