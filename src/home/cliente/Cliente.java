package home.cliente;

import classes.business.User;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Cliente extends javax.swing.JPanel {

    private home.Home mainHome;
    private ArrayList<classes.business.Cliente> clienteList = new ArrayList<>();
    private ArrayList<RowToUpdate> rowToUpdate = new ArrayList<>();
     
    public Cliente(home.Home home) {
        initComponents();
        mainHome = home;
        jScrollPane1.getViewport().setBackground(Color.decode("#FFFFFF"));
        
        GetAllClientes();
        
        save_changes.setEnabled(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add_cliente = new javax.swing.JButton();
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

            }
        ));
        jTable1.setDragEnabled(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane1.setViewportView(jTable1);

        add_cliente.setBackground(new java.awt.Color(25, 118, 240));
        add_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add_cliente.setForeground(new java.awt.Color(255, 255, 255));
        add_cliente.setText("Adicionar Cliente");
        add_cliente.setBorder(null);
        add_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_clienteActionPerformed(evt);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(add_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(add_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_clienteActionPerformed
       Create create = new Create(this);
        create.setVisible(true);
    }//GEN-LAST:event_add_clienteActionPerformed

    private void save_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_changesActionPerformed
        // TODO add your handling code here:
        try {
            save_changes.setEnabled(false);
            ArrayList<String> valuesQuery = new ArrayList<>();
            
            for (RowToUpdate row : rowToUpdate) {
                
                String name = jTable1.getModel().getValueAt(row.index, 0).toString();
                String nif = jTable1.getModel().getValueAt(row.index, 1).toString();
                String address = jTable1.getModel().getValueAt(row.index, 2).toString();
                
                valuesQuery.add("UPDATE clientes SET full_name = '" + name + "', nif = '" + nif + "', morada = '" + address + "', date_updated = now() WHERE nif = '" + nif + "';");
            }
            
            mainHome.db.updateQuery(String.join(" ", valuesQuery));
            rowToUpdate.clear();
            GetAllClientes();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }//GEN-LAST:event_save_changesActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        if (jTable1.getSelectedRows().length == 0) {
            return;
        }
        
        try {   
            ArrayList<String> valuesQuery = new ArrayList<>();
            
            for (Integer index : jTable1.getSelectedRows()) {
                classes.business.Cliente cliente = clienteList.get(index);
                valuesQuery.add("DELETE FROM clientes where nif = '" + cliente.getNif()+ "';");
            }
            
            mainHome.db.updateQuery(String.join(" ", valuesQuery));
            GetAllClientes();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void GetAllClientes () {
        clienteList.clear();
        try {
            ResultSet result = mainHome.db.executeQuery("SELECT full_name, nif, morada FROM clientes ORDER BY nif, full_name ASC");
            DefaultTableModel model = new DefaultTableModel(); 
            model.addColumn("Nome");
            model.addColumn("NIF");
            model.addColumn("Morada");
            model.addTableModelListener(jTable1);
            
            jTable1.getTableHeader().setReorderingAllowed(false);
            
            while (result.next()) {
                classes.business.Cliente cliente = new classes.business.Cliente(result.getString("full_name"), result.getString("nif"), result.getString("morada"));
                clienteList.add(cliente);
            }
            
            for (classes.business.Cliente cliente : clienteList) {
                model.addRow(new Object[]{cliente.getName(), cliente.getNif(), cliente.getAddres()});
            }
            
            jTable1.setModel(model);
            jTable1.getModel().addTableModelListener(
            new TableModelListener() 
            {
                public void tableChanged(TableModelEvent evt) 
                {
                    // here goes your code "on cell update"           
                    rowToUpdate.add(new RowToUpdate(evt.getFirstRow(), clienteList.get(evt.getFirstRow()).getNif()));
                    if (!rowToUpdate.isEmpty()) {
                        save_changes.setEnabled(true);
                    }
                }  
            });
             
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    public void CreateClient (classes.business.Cliente client) {
        
        try {
            
            mainHome.db.updateQuery("INSERT INTO clientes (full_name, nif, morada) VALUES ('?', '?', '?')", client.getName(), client.getNif(), client.getAddres());
            
            GetAllClientes();
        } catch (Exception e) {
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_cliente;
    private javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton save_changes;
    // End of variables declaration//GEN-END:variables
}

class RowToUpdate {
    
    public Integer index;
    public String nif;
       
    RowToUpdate (Integer index, String nif) {
        this.index = index;
        this.nif = nif;
    }
}