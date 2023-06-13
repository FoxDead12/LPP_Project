/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package home.products;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * author dx3
 */
public class Product extends javax.swing.JPanel {

    private home.Home mainHome;
    private ArrayList<classes.business.Product> productList = new ArrayList<>();
    private ArrayList<RowToUpdate> rowToUpdate = new ArrayList<>();

    public Product(home.Home home) {
        initComponents();
        mainHome = home;

        jScrollPane1.getViewport().setBackground(Color.decode("#FFFFFF"));

        getAllProducts();

        saveChangesButton.setEnabled(false);
    }


    public Product(int int1, String string, double double1, int int2) {
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        saveChangesButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTable1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
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

        addButton.setBackground(new java.awt.Color(25, 118, 240));
        addButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Product");
        addButton.setBorder(null);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        saveChangesButton.setBackground(new java.awt.Color(25, 118, 240));
        saveChangesButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        saveChangesButton.setForeground(new java.awt.Color(255, 255, 255));
        saveChangesButton.setText("Save Changes");
        saveChangesButton.setBorder(null);
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 0, 51));
        deleteButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorder(null);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
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
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void add_productActionPerformed(java.awt.event.ActionEvent evt) {
        Create create = new Create(this);
        create.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void save_changesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed

        // Save updates
        try {
            saveChangesButton.setEnabled(false);
            ArrayList<String> valuesQuery = new ArrayList<>();
            for (RowToUpdate row : rowToUpdate) {

                String name = jTable1.getModel().getValueAt(row.index, 0).toString();
                double price = Double.parseDouble(jTable1.getModel().getValueAt(row.index, 1).toString());
                int quantity = Integer.parseInt(jTable1.getModel().getValueAt(row.index, 2).toString());

                valuesQuery.add("UPDATE products SET name = '" + name + "', price = " + price + ", quantity = " + quantity + " WHERE id = " + row.id + ";");
            }

            mainHome.db.updateQuery(String.join(" ", valuesQuery));
            rowToUpdate.clear();
            getAllProducts();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveChangesButtonActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRows().length == 0) {
            return;
        }

        try {
            ArrayList<String> valuesQuery = new ArrayList<>();

            for (int index : jTable1.getSelectedRows()) {
                classes.business.Product product = productList.get(index);
                valuesQuery.add("DELETE FROM products WHERE id = " + product.getId() + ";");
            }

            mainHome.db.updateQuery(String.join(" ", valuesQuery));
            getAllProducts();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    


    private void getAllProducts() {
        productList.clear();
        try {
            ResultSet result = mainHome.db.executeQuery("SELECT * FROM products ORDER BY name ASC");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Name");
            model.addColumn("Price");
            model.addColumn("Quantity");
            model.addTableModelListener(jTable1);

            jTable1.getTableHeader().setReorderingAllowed(false);

            while (result.next()) {
                classes.business.Product product = new classes.business.Product(result.getInt("id"), result.getString("name"), result.getDouble("price"), result.getInt("quantity"));
                productList.add(product);
            }

            for (classes.business.Product product : productList) {
                model.addRow(new Object[]{product.getName(), product.getPrice(), product.getQuantity()});
            }

            jTable1.setModel(model);

            jTable1.getModel().addTableModelListener(
                    new TableModelListener() {
                public void tableChanged(TableModelEvent evt) {
                    // Here goes your code "on cell update"
                    rowToUpdate.add(new RowToUpdate(evt.getFirstRow(), productList.get(evt.getFirstRow()).getId()));
                    if (!rowToUpdate.isEmpty()) {
                        saveChangesButton.setEnabled(true);
                    }
                }
            }
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createProduct(classes.business.Product product) {

        try {

            mainHome.db.updateQuery("INSERT INTO products (name, price, quantity) VALUES ('?', ?, ?)", product.getName(), String.valueOf(product.getPrice()), String.valueOf(product.getQuantity()));

            getAllProducts();

        } catch (Exception e) {
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton saveChangesButton;
    // End of variables declaration//GEN-END:variables


class RowToUpdate {

    public Integer index;
    public Integer id;

    RowToUpdate(Integer index, Integer id) {
        this.index = index;
        this.id = id;
    }
}}

    
