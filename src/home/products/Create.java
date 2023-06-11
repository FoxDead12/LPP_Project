package home.products;

import classes.business.Product;

/**
 * Class for creating products.
 */
public class Create extends javax.swing.JFrame {

    private home.products.Product mainProduct;
    
    public Create(home.products.Product main) {

        
        mainProduct = main;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create(null).setVisible(true);
            }
        });
    }

    // ... Variables declaration and end of the class ...
}
