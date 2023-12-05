/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import model.Item;
import java.util.List;
import util.DatabaseConnector;

/**
 *
 * @author Admin
 */
public class ViewInventoryPanel extends javax.swing.JPanel {
//
//    /**
//     * Creates new form FormPanel
//     */
   private ArrayList<Item> users;
   private List<Item> listOfItems;

   public ViewInventoryPanel(Item newUser) {
        initComponents();
        refreshListOfItems();
        
    }

    public void setListOfItems(List<Item> listOfItems){
        this.listOfItems=listOfItems;
    }
    
    public void refreshListOfItems(){
        this.listOfItems = DatabaseConnector.getAllItemsWithCriteria(null);
        populateTable();
    }
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        categoryLabel = new javax.swing.JLabel();
        FilterButton = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("View Inventory");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Item Name", "Manufacturer", "SKU Number", "Category", "Warranty Status", "Active"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        categoryLabel.setText("Category");

        FilterButton.setText("Fetch");
        FilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterButtonActionPerformed(evt);
            }
        });

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Electronics", "Soft Toys", "Puzzles" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(categoryLabel)
                .addGap(28, 28, 28)
                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(FilterButton)
                        .addGap(300, 300, 300))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(246, 246, 246))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(FilterButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterButtonActionPerformed

        try {
            this.listOfItems = DatabaseConnector.getAllItemsWithCriteria(categoryComboBox.getSelectedItem().toString());
            populateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_FilterButtonActionPerformed

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FilterButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

//    private void populateData() {
//        firstNameDataLabel.setText(this.newUser.getFirstName()); //text field data
//        lastNameDataLabel.setText(this.newUser.getLastName()); //text field data
//        dobDataLabel.setText(this.newUser.getDob());
//        ageDataLabel.setText(this.newUser.getAge());
//        emailDataLabel.setText(this.newUser.getEmail());
//        messageDataLabel.setText(this.newUser.getMessage()); 
//        patientTypeDataLabel.setText(this.newUser.getPatientType()); // dropdown data
//        genderDataLabel.setText(this.newUser.getGender());
//        ImageIcon ii = new ImageIcon(this.newUser.getPath());
//        Image image = ii.getImage().getScaledInstance(70,80, Image.SCALE_SMOOTH);
//        imageDataLabel.setIcon(new ImageIcon(image));
//    }
    public void populateTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Item u : this.listOfItems) {
                Object[] row = new Object[7];
                row[0] = u.getId();
                row[1] = u.getItemName();
                row[2] = u.getManufacturer();
                row[3] = u.getSkuNo();
                row[4] = u.getWarranty();
                row[5] = u.getCategory();
                row[6] = u.getActive();
                model.addRow(row);
            }
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void clearFields() {
        listOfItems = null;
    }

   // @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
