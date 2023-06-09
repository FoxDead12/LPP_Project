/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package home.sels;

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
public class Sels extends javax.swing.JPanel {

    private home.Home mainHome;
    private ArrayList<classes.business.Sales> selsList = new ArrayList<>();

    public Sels(home.Home home) {
        initComponents();
        mainHome = home;
        jScrollPane1.getViewport().setBackground(Color.decode("#FFFFFF"));

        GetAllSels();
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
        jTable1 = new javax.swing.JTable();
        see_changes = new javax.swing.JButton();

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

        see_changes.setBackground(new java.awt.Color(25, 118, 240));
        see_changes.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        see_changes.setForeground(new java.awt.Color(255, 255, 255));
        see_changes.setText("Ver Venda/s");
        see_changes.setBorder(null);
        see_changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                see_changesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(see_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(see_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void see_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_see_changesActionPerformed
        if (jTable1.getSelectedRows().length == 0) {
            return;
        }
        
        try {   
            ArrayList<String> valuesQuery = new ArrayList<>();
            
            for (Integer index : jTable1.getSelectedRows()) {
                Integer id = selsList.get(index).getId();
                See create = new See(id, mainHome);
                create.setVisible(true);
            }
            
            GetAllSels();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_see_changesActionPerformed

    private void GetAllSels () {
        selsList.clear();
        
        try {
            ResultSet result = mainHome.db.executeQuery("SELECT s.id ,total, u.full_name as employee_name, c.full_name as cliente_name  FROM sales s INNER JOIN users u \n" +
                                                        "ON s.employee_id = u.id left join clientes c on c.id = s.client_id ORDER BY s.date_created asc;");
            DefaultTableModel model = new DefaultTableModel(); 
            model.addColumn("Total");
            model.addColumn("Empregado");
            model.addColumn("Cliente");
            model.addTableModelListener(jTable1);
            jTable1.getTableHeader().setReorderingAllowed(false);
            
            while (result.next()) {
                selsList.add(new classes.business.Sales(null, null, null, result.getInt("id")));
                model.addRow(new Object[]{result.getString("total") + "€", result.getString("employee_name"), result.getString("cliente_name")});
            }
            
            jTable1.setModel(model);            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton see_changes;
    // End of variables declaration//GEN-END:variables
}
