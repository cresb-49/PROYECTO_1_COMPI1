/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1.UI;

import com.carlos.app_cliente_proyecto1.HttpMethods.ExportFormulario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin
 */
public class exportarFomulario extends javax.swing.JInternalFrame {

    /**
     * Creates new form exportarFomulario
     */
    public exportarFomulario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idForm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelServidor = new javax.swing.JTextArea();
        btnGuardarArchivo = new javax.swing.JButton();
        btnSolicitarForm = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("EXPORTAR FORMULARIO DEL SERVIDOR");

        jLabel2.setText("Ingrese el id del fomulario que necesita exportar");

        jLabel3.setText("Id Formulario:");

        jLabel5.setText("Respuesta del Servidor");

        panelServidor.setEditable(false);
        panelServidor.setColumns(20);
        panelServidor.setRows(5);
        panelServidor.setTabSize(3);
        jScrollPane1.setViewportView(panelServidor);

        btnGuardarArchivo.setText("Guardar Archivo");
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });

        btnSolicitarForm.setText("Solicitar Formulario");
        btnSolicitarForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(idForm, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(btnGuardarArchivo)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSolicitarForm)
                        .addGap(106, 106, 106)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSolicitarForm)
                        .addGap(35, 35, 35)
                        .addComponent(btnGuardarArchivo)
                        .addGap(73, 73, 73))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed

    private void btnSolicitarFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarFormActionPerformed
        // TODO add your handling code here:

        String id = idForm.getText();

        if (id == null) {
            JOptionPane.showMessageDialog(this, "Escriba el id del formulario !!!!");
        } else {
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Escriba el id del formulario !!!!");
            } else {
                this.solicitarForm(id);
            }
        }

    }//GEN-LAST:event_btnSolicitarFormActionPerformed
    
    private void solicitarForm(String id){
        ExportFormulario export = new ExportFormulario();
        try {        
            String res = export.exportForm(id);
            if(res==null){
                this.panelServidor.setText("Servidor no disponible!!!");
            }else{
                this.panelServidor.setText(res);
            }
            
        } catch (IOException ex) {
            System.out.println("Erro en peticion de formulario cliente");
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JButton btnSolicitarForm;
    private javax.swing.JTextField idForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea panelServidor;
    // End of variables declaration//GEN-END:variables
}
