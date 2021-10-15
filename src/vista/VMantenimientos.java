/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Mantenimientos;
import java.awt.Image;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DANNY
 */
public class VMantenimientos extends javax.swing.JFrame {

    /**
     * Creates new form VMantenimientos
     */
    public VMantenimientos() {
        initComponents();
         ImageIcon imagen = new ImageIcon("src/IMAGENES/total.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblTotal.getWidth(),lblTotal.getHeight(),Image.SCALE_DEFAULT));
        lblTotal.setIcon(icono);
        this.repaint();
        //***********************
        mostratabla();
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        calFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnVercliente = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtDetalle = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMantenimientos = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 206, -1, -1));
        jPanel1.add(calFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 356, 251, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Costo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 288, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 356, -1, -1));

        btnVercliente.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        btnVercliente.setText("Ver Mantenimiento");
        btnVercliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerclienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnVercliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 414, -1, -1));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 145, 151, 25));

        txtDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetalleActionPerformed(evt);
            }
        });
        jPanel1.add(txtDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 194, 261, 50));
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 289, 149, 25));

        tblMantenimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "detalle", "costo", "fecha"
            }
        ));
        tblMantenimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMantenimientosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMantenimientos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 474, 748, 173));

        btnRegistrar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/btnGuardad.png"))); // NOI18N
        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 144, 147, -1));

        btnModificar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/btnModificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 203, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/btnEliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 272, 147, -1));

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        jLabel1.setText("Reguistro de Mantenimientos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 144, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazdiseño/boton menu.png"))); // NOI18N
        jButton1.setText("Menú");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 34, 97, 49));

        jButton2.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/bntClear.png"))); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 339, 147, -1));
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetalleActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Mantenimientos coca = new Mantenimientos(txtCodigo.getText(), txtDetalle.getText(), txtCosto.getText(), calFecha.getDate());
        if (coca.insertar()) {
            JOptionPane.showMessageDialog(rootPane, "REGISTRO GUARDADO");

            mostratabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al guardar");

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int seleccionado = tblMantenimientos.getSelectedRow();
        int respuesta = 0;

        if (seleccionado != -1) {
            Mantenimientos coca = new Mantenimientos(txtCodigo.getText(), txtDetalle.getText(), txtCosto.getText(), calFecha.getDate());
            respuesta = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea modificar el registro", "mesanje de confirmacion", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {

                if (coca.modificar()) {
                    JOptionPane.showMessageDialog(rootPane, "Registro guardado");
                    mostratabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error al guardar");
                }
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int seleccionado = tblMantenimientos.getSelectedRow();
        int respuesta = 0;

        if (seleccionado != -1) {
            Mantenimientos coca = new Mantenimientos(txtCodigo.getText(), txtDetalle.getText(), txtCosto.getText(), calFecha.getDate());
            respuesta = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea eliminar ", "mesanje de confirmacion", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {

                if (coca.eliminar()) {
                    JOptionPane.showMessageDialog(rootPane, "Registro guardado");
                    mostratabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error al guardar");
                }
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblMantenimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMantenimientosMouseClicked

        int seleccionado = tblMantenimientos.getSelectedRow();
        mostrarDatos(seleccionado);
    }//GEN-LAST:event_tblMantenimientosMouseClicked

    private void btnVerclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerclienteActionPerformed

        VServicios seviciosclientes = new VServicios();
        seviciosclientes.setVisible(true);
        VServicios.txtCodigo1.setText(txtCodigo.getText());
        VServicios.txtDetalle.setText(txtDetalle.getText());
        VServicios.txtCosto.setText(txtCosto.getText());
        VServicios.calFecha.setDate(calFecha.getDate());

        this.dispose();
    }//GEN-LAST:event_btnVerclienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu rojo = new Menu();
        rojo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   limpiarCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VMantenimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VMantenimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVercliente;
    private com.toedter.calendar.JDateChooser calFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblMantenimientos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDetalle;
    // End of variables declaration//GEN-END:variables

    //BUSCAR CLIENTES EN LA BASE DE DATOS
    public void mostrarResultadoBusqueda(String dato) {

        Mantenimientos coca = new Mantenimientos();
        List<Mantenimientos> lista = coca.mostrarDatos();
        txtCodigo.setText(lista.get(0).getCodigo());
        txtDetalle.setText(lista.get(0).getDetalle());
        txtCosto.setText(lista.get(0).getCosto());
        calFecha.setDate(lista.get(0).getFecha());

    }
//BUSCAR CLIENTES EN LA BASE DE DATOS

    //MODIFICAR CLIENTES EN LA BASE DE DATOS
    public void mostratabla() {

        Mantenimientos coca = new Mantenimientos();
        java.util.List<Mantenimientos> lista = coca.mostrarDatos();
        String matriz[][] = new String[lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = lista.get(i).getCodigo();
            matriz[i][1] = lista.get(i).getDetalle();
            matriz[i][2] = lista.get(i).getCosto();
            matriz[i][3] = lista.get(i).getFecha().toString();

        }
        tblMantenimientos.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "codigo ", "detalle", "costo", "fecha"
                }
        ));
    }
//MOFICAR CLIENTES EN LA BASE DE DATOS

//MOFICAR CLIENTES EN LA BASE DE DATOS
    public void limpiarCampos() {
        txtCodigo.setText("");
        txtDetalle.setText("");
        txtCosto.setText("");
        calFecha.setDate(null);

    }
//MOFICAR CLIENTES EN LA BASE DE DATOS

    //ELIMINAR EN LA BASE DE DATOS
    public void mostrarDatos(int seleccionado) {
        Mantenimientos coca = new Mantenimientos();
        List<Mantenimientos> lista = coca.mostrarDatos();
        txtCodigo.setText(lista.get(seleccionado).getCodigo());
        txtDetalle.setText(lista.get(seleccionado).getDetalle());
        txtCosto.setText(lista.get(seleccionado).getCosto());
        calFecha.setDate(lista.get(seleccionado).getFecha());

    }
    //ELIMINAR EN LA BASE DE DATOS
    
    public void mostrarvista(){
         VServicios.txtCodigo1.setText(txtCodigo.getText());
        VServicios.txtDetalle.setText(txtDetalle.getText());
        VServicios.txtCosto.setText(txtCosto.getText());
        VServicios.calFecha.setDate(calFecha.getDate());   
        
        
    }

}
