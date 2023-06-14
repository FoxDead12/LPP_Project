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

        save_changes.setEnabled(false);
    }


    public Product(int int1, String string, double double1, int int2) {
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
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
                "Nome", "Preço", "Quantidade"
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

        AddButton.setBackground(new java.awt.Color(25, 118, 240));
        AddButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setText("Adicionar Produto");
        AddButton.setBorder(null);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Create create = new Create(this);
        create.setVisible(true);
    }                                        

    private void save_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed

        // Save updates
        try {
            save_changes.setEnabled(false);
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

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
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
    }                                            

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
                        save_changes.setEnabled(true);
                    }
                }
            }
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateProduct(classes.business.Product product) {

        try {

            mainHome.db.updateQuery("INSERT INTO products (name, price, quantity) VALUES ('?', ?, ?)", product.getName(), String.valueOf(product.getPrice()), String.valueOf(product.getQuantity()));

            getAllProducts();

        } catch (Exception e) {
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton save_changes;
    // End of variables declaration//GEN-END:variables


class RowToUpdate {

    public Integer index;
    public Integer id;

    RowToUpdate(Integer index, Integer id) {
        this.index = index;
        this.id = id;
    }
}}

    
