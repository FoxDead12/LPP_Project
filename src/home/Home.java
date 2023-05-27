package home;

import classes.DataBase;
import classes.business.Manager;
import classes.business.User;
import home.employees.Employee;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

public class Home extends javax.swing.JFrame {
    
    public DataBase db = new DataBase();
    private Menu[] menus = null;
    public User user = null;
    private String currentMenu = "";
    private ArrayList<String> menusOpen = new ArrayList<>();
    
    public Home(User userComming) {
        initComponents();
        db.createConnection();

        //Set User
        user = new Manager("David Xavier", "davidxavier7512@gmail.com");
        
        //Load Default Components Values
        loadDefaultComponents();
        LoadMenu();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        frameController = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LPP_Project");

        jPanel1.setBackground(new java.awt.Color(25, 118, 240));

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LPP Project");

        scrollPanel.setBackground(new java.awt.Color(25, 118, 240));
        scrollPanel.setBorder(null);
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setOpaque(false);

        jList1.setBackground(new java.awt.Color(25, 118, 240));
        jList1.setBorder(null);
        jList1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setOpaque(false);
        jList1.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jList1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jList1PropertyChange(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        scrollPanel.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanel))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addContainerGap())
        );

        frameController.setBackground(new java.awt.Color(255, 255, 255));
        frameController.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                frameControllerHierarchyChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(frameController, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(frameController)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jList1PropertyChange
    }//GEN-LAST:event_jList1PropertyChange

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if (menus.length > 0) { ChangeMenu(jList1.getSelectedValue()); }
    }//GEN-LAST:event_jList1ValueChanged

    private void frameControllerHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_frameControllerHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_frameControllerHierarchyChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(null).setVisible(true);
            }
        });       
    }

    private void loadDefaultComponents () {
        scrollPanel.getViewport().setBackground(Color.decode("#1976F0"));
        jList1.setFixedCellHeight(80);
        jList1.setBounds(50,0,0,0);
        jLabel1.setText("Perfil, " + user.getName());
    }
    
    private void LoadMenu () {

        Menu menu1 = new Menu("Home", new String[]{"manager"});
        Menu menu2 = new Menu("Produtos", new String[]{"manager"});
        Menu menu3 = new Menu("Vendas", new String[]{"manager"});
        Menu menu4 = new Menu("Empregados", new String[]{"manager"});
        Menu menu5 = new Menu("Caixa", new String[]{"manager", "employee"});
        menus = new Menu[]{menu1, menu2, menu3, menu4, menu5};
        
        DefaultListModel demoList = new DefaultListModel();

        for(Menu men : menus) {
            Boolean menuValid = false;
            for (String role: men.roles) {
                if (user.getRole().equals(role)) {menuValid = true;}
            }
            
            if (menuValid) {
                demoList.addElement(men.name);
            }
        }
        
        jList1.setModel(demoList);
        jList1.setSelectedIndex(0);
    }
    
    private void ChangeMenu (String menu) {
        
        if (menusOpen.contains(menu)) {
            frameController.setSelectedIndex(menusOpen.indexOf(menu));
            return;
        }
        
        if (currentMenu != menu) {
            // set new menu
            currentMenu = menu;
            Menu menuObject = null;
            for (Menu m : menus) {
                if (m.name.equals(menu)) {
                    menuObject = m;
                }
            }
            
            JPanel panel = GenerateJFrame(menuObject);
            menusOpen.add(menu);
            frameController.add(menu, panel);   
            frameController.setSelectedIndex((frameController.getTabCount() - 1));
        }
    }
    
    private JPanel GenerateJFrame (Menu menu) {
        JPanel panel = null;
        
        try {  
            switch (menu.name) {
                case "Home" :
                    panel = new home.home.Home(this);
                    break;
                case "Empregados":
                    panel = new Employee(this);
                    break;
                default:
                    throw new Exception("Invalid Menu");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        return panel;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane frameController;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
