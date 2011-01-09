/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentasView.java
 *
 * Created on Aug 26, 2010, 3:34:40 PM
 */

package com.jstore.views;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import com.jstore.JStoreApp;
import com.jstore.components.AskNumberDialog;
import com.jstore.components.EntityJTextField;
import com.jstore.components.EntityTableModel;
import com.jstore.domain.Cliente;
import com.jstore.domain.Factura;
import com.jstore.domain.FacturaDetalle;
import com.jstore.domain.FacturaDetallePK;
import com.jstore.domain.Producto;
import com.jstore.domain.Proveedor;

/**
 *
 * @author phasnox
 */
public class VentasView extends javax.swing.JPanel {
    
    EntityManager em = JStoreApp.getApplication().getEntityManager();
    
    //This is for data access
    Producto productoDAO = new Producto();
    Cliente clienteDAO = new Cliente();
    Factura facturaDAO = new Factura();
    
    //The actual invoice
    Factura factura = new Factura();

    /** Creates new form VentasView */
    public VentasView() {
        initComponents();

        //Setea el EntityManager em
        productoDAO.setEm(em);
        clienteDAO.setEm(em);
        facturaDAO.setEm(em);

        

        filterProductoSearch();
        initDetalleTable();
        ((EntityJTextField)txtCliente).setDataManager(clienteDAO);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productosTable = new org.jdesktop.swingx.JXTable();
        searchProductoTxt = new org.jdesktop.swingx.JXTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalleTable = new org.jdesktop.swingx.JXTable();
        jLabel4 = new javax.swing.JLabel();
        insertarButton = new org.jdesktop.swingx.JXButton();
        eliminarButton = new org.jdesktop.swingx.JXButton();
        guardarButton = new org.jdesktop.swingx.JXButton();
        totalTxt = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        txtCliente = new EntityJTextField();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jstore.JStoreApp.class).getContext().getResourceMap(VentasView.class);
        setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title"))); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        productosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        productosTable.setEditable(false);
        productosTable.setName("productosTable"); // NOI18N
        productosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosTableMouseClicked(evt);
            }
        });
        productosTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productosTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(productosTable);

        searchProductoTxt.setText(resourceMap.getString("searchProductoTxt.text")); // NOI18N
        searchProductoTxt.setName("searchProductoTxt"); // NOI18N
        searchProductoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchProductoTxtKeyTyped(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchProductoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        detalleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        detalleTable.setName("detalleTable"); // NOI18N
        detalleTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                detalleTablePropertyChange(evt);
            }
        });
        detalleTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                detalleTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(detalleTable);

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        insertarButton.setText(resourceMap.getString("insertarButton.text")); // NOI18N
        insertarButton.setName("insertarButton"); // NOI18N
        insertarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText(resourceMap.getString("eliminarButton.text")); // NOI18N
        eliminarButton.setName("eliminarButton"); // NOI18N
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        guardarButton.setText(resourceMap.getString("guardarButton.text")); // NOI18N
        guardarButton.setName("guardarButton"); // NOI18N
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        totalTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        totalTxt.setName("totalTxt"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title"))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N

        txtCliente.setText(resourceMap.getString("txtCliente.text")); // NOI18N
        txtCliente.setName("txtCliente"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detalleTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_detalleTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_detalleTablePropertyChange

    private void productosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosTableMouseClicked

        if(evt.getClickCount()==2){
            addProduct();
        }
    }//GEN-LAST:event_productosTableMouseClicked

    @SuppressWarnings("static-access")
    private void productosTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productosTableKeyPressed
        
        if(evt.getKeyCode() == evt.VK_ENTER){
         addProduct();
        }

    }//GEN-LAST:event_productosTableKeyPressed

    private void insertarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarButtonActionPerformed

        addProduct();

    }//GEN-LAST:event_insertarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed

        deleteSelectedRow(detalleTable);
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void detalleTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_detalleTableKeyPressed

        if(evt.getKeyCode()==evt.VK_DELETE & !detalleTable.isEditing()){
            deleteSelectedRow(detalleTable);
        }
    }//GEN-LAST:event_detalleTableKeyPressed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        //test();
        saveFactura();
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void searchProductoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductoTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchProductoTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTable detalleTable;
    private org.jdesktop.swingx.JXButton eliminarButton;
    private org.jdesktop.swingx.JXButton guardarButton;
    private org.jdesktop.swingx.JXButton insertarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable productosTable;
    private org.jdesktop.swingx.JXTextField searchProductoTxt;
    private javax.swing.JFormattedTextField totalTxt;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables

    private void filterProductoSearch() {
        Map cols = new LinkedHashMap();
        cols.put("Nombre", "nombre");
        cols.put("Costo", "costo");

        Map criterias = new HashMap();
        criterias.put("nombre", searchProductoTxt.getText() + "%");
        List productos = productoDAO.findLikeCriteria(criterias);
        EntityTableModel model = new EntityTableModel();
        
        model.setValues(cols, productos);
        productosTable.setModel(model);
    }

    public void addProduct(){

        //Get cantidad
        JFrame mainFrame = JStoreApp.getApplication().getMainFrame();
        AskNumberDialog dialog = new AskNumberDialog(mainFrame, true, "Cantidad?");

        if(dialog.getAnswer()){
            //Get the selected index
            int selected = productosTable.getSelectionModel().getMinSelectionIndex();
            int index = productosTable.convertRowIndexToModel(selected);
            //Get the selected product
            EntityTableModel productTableModel = (EntityTableModel)productosTable.getModel();
            Producto selectedproduct = (Producto)productTableModel.getBeanAt(index);

            //DetalleFactura
            int cantidad = dialog.getNumber().intValue();
            FacturaDetalle detalle = new FacturaDetalle();

            detalle.setFactura(factura);
            detalle.setCantidad(cantidad);
            detalle.setCosto(selectedproduct.getCosto());
            detalle.setProducto(selectedproduct);
//            detalle.setImpuestos(productoDAO.getCosto()*productoDAO.getImpuestos());
            detalle.setSubtotal(detalle.getCantidad()*detalle.getCosto());
            detalle.setTotal(detalle.getSubtotal());

            //add product
            EntityTableModel dtm = (EntityTableModel) detalleTable.getModel();
            dtm.addRow(detalle);

            //recalcular total
            updateTotal();
        }
        
    }

    private void deleteSelectedRow(JXTable table) {
        int selected = table.getSelectionModel().getMinSelectionIndex();
        int index = table.convertRowIndexToModel(selected);

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.removeRow(index);
        updateTotal();
    }

    private Double getVentaTotal() {
        Double total = new Double(0);

        int numrows = 0;
        DefaultTableModel dtm = (DefaultTableModel) detalleTable.getModel();
        numrows = dtm.getRowCount();

        for(int i=0; i<numrows; i++){

            total = total + (Double)dtm.getValueAt(i, 3);
        }
        

        return total;
    }

    private void updateTotal() {
        Double total = getVentaTotal();
        try {
            totalTxt.setValue(total);
            totalTxt.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(VentasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveFactura() {
        
        Double impuestos = new Double(0);
        Double total = ((Number)totalTxt.getValue()).doubleValue();
        Double subtotal = ((Number)totalTxt.getValue()).doubleValue();

        factura.setFechaEmision(Calendar.getInstance().getTime());
        factura.setCliente(em.getReference(Cliente.class, 3));
        factura.setSubtotal(subtotal);
        factura.setImpuestos(impuestos);
        factura.setTotal(total);

       try{

            EntityTableModel dtm = (EntityTableModel) detalleTable.getModel();
            List <FacturaDetalle> items = dtm.getBeans();
            factura.setFacturaDetalleList(items);
            
            facturaDAO.persist(factura);
            em.getTransaction().commit();
           }
           catch(Exception e){
               e.printStackTrace();
                em.getTransaction().rollback();
           }
        clearForm();
    }

    private void initDetalleTable() {
        Map columns = new LinkedHashMap();
        //column_name, property_value
        columns.put("Producto", "producto.nombre");
        columns.put("Cantidad", "cantidad");
        columns.put("Subtotal", "subtotal");
        columns.put("Total", "total");

        EntityTableModel etm = new EntityTableModel(columns);
        detalleTable.setModel(etm);

    }

    private void test() {
//        Proveedor pd = new Proveedor();
//        pd.setEm(em);
//        List productos = new ArrayList();
//
//        Producto p1 = new Producto();
//        p1.setNombre("p1");
//        p1.setProveedor(pd);
//
//        Producto p2 = new Producto();
//        p2.setNombre("p2");
//        p2.setProveedor(pd);
//
//        Producto p3 = new Producto();
//        p3.setNombre("p3");
//        p3.setProveedor(pd);
//
//        productos.add(p1);
//        productos.add(p2);
//        productos.add(p3);
//
//        pd.setProductoList(productos);
//        pd.persist(pd);
//        em.getTransaction().commit();

    }

    private void clearForm() {
        EntityTableModel etm = (EntityTableModel)detalleTable.getModel();
        etm.clearRows();
        detalleTable.setModel(etm);
        updateTotal();
        factura = new Factura();
    }


}
