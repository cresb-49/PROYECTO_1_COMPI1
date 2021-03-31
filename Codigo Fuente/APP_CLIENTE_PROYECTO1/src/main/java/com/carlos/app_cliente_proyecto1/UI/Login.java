/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1.UI;

import com.carlos.app_cliente_proyecto1.HttpMethods.peticionLogin;
import com.carlos.app_cliente_proyecto1.Lexer.lexerIndigo;
import com.carlos.app_cliente_proyecto1.Objetos.mensaje;
import com.carlos.app_cliente_proyecto1.Objetos.usuario;
import com.carlos.app_cliente_proyecto1.Parser.parserIndigo;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author benjamin
 */
public class Login extends javax.swing.JDialog {

    private boolean log = false;
    private usuario currentUser = null;

    /**
     * Creates new form Login
     */
    public Login(java.awt.Frame parent, boolean modal, usuario currentUser) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.currentUser = currentUser;
    }

    public boolean isLog() {
        return log;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        BotonEnviar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelLinea = new javax.swing.JLabel();
        labelColumna = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loginTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        respuestas = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotonEnviar.setText("ENVIAR");
        BotonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviarActionPerformed(evt);
            }
        });

        btnIngresar.setText("INGRESAR");
        btnIngresar.setEnabled(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel3.setText("Linea:");

        jLabel4.setText("Columna:");

        labelLinea.setText("1");

        labelColumna.setText("1");

        loginTextArea.setColumns(20);
        loginTextArea.setRows(5);
        loginTextArea.setTabSize(3);
        loginTextArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                loginTextAreaCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(loginTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(BotonEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnIngresar)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLinea)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelColumna)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(labelLinea)
                    .addComponent(labelColumna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonEnviar)
                    .addComponent(btnIngresar))
                .addGap(23, 23, 23))
        );

        jLabel1.setText("Ingrese la instruccion para ingresar al sistema");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        respuestas.setEditable(false);
        respuestas.setColumns(20);
        respuestas.setRows(5);
        respuestas.setTabSize(3);
        jScrollPane2.setViewportView(respuestas);

        jLabel2.setText("Respuesta del Servidor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviarActionPerformed
        // TODO add your handling code here:

        if (loginTextArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba la peticion de ingreso al sistema!!!");
        } else {
            enviarSolicitud();
        }

    }//GEN-LAST:event_BotonEnviarActionPerformed

    private void loginTextAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_loginTextAreaCaretUpdate
        // TODO add your handling code here:
        JTextArea editArea = (JTextArea) evt.getSource();
        int linea = 1;
        int columna = 1;
        try {
            int caretpos = editArea.getCaretPosition();
            linea = editArea.getLineOfOffset(caretpos);
            columna = caretpos - editArea.getLineStartOffset(linea);

            // Ya que las líneas las cuenta desde la 0
            linea += 1;
            if (columna == 0) {
                columna = 1;
            }

            labelLinea.setText(String.valueOf(linea));
            labelColumna.setText(String.valueOf(columna));

        } catch (Exception ex) {
        }
        //System.err.println("Linea: " + linea + " Columna: " + columna);
    }//GEN-LAST:event_loginTextAreaCaretUpdate

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        log = true;
        this.dispose();
    }//GEN-LAST:event_btnIngresarActionPerformed
    private usuario getCurrentUser() {
        lexerIndigo lex = new lexerIndigo(new StringReader(loginTextArea.getText()));
        parserIndigo parser = new parserIndigo(lex);
        try {
            parser.parse();
            return parser.getLogUser();
        } catch (Exception ex) {
            System.err.println("Error irrcuperable indigo");
            ex.printStackTrace();
        }
        return null;
    }

    private void enviarSolicitud() {
        String cadenasEnvio = loginTextArea.getText();
        peticionLogin log = new peticionLogin();
        String retorno = log.iniciarSesion(cadenasEnvio);
        if (retorno == null) {
            respuestas.setText("El servidor no esta disponible!!!");
        } else {
            respuestas.setText(retorno);
            StringReader reader = new StringReader(retorno);
            lexerIndigo lex = new lexerIndigo(reader);
            parserIndigo parser = new parserIndigo(lex);
            try {
                parser.parse();
                verificacionMensaje(parser);
            } catch (Exception ex) {
                System.err.println("Error irrcuperable indigo");
                ex.printStackTrace();
            }
        }
    }

    private void verificacionMensaje(parserIndigo parser) {
        if (parser.getMsjUser().size() == 1) {
            mensaje mens = parser.getMsjUser().get(0);
            if (mens.getMensaje().equals("Solicitud Aceptada!!:)")) {
                btnIngresar.setEnabled(true);
                this.currentUser = getCurrentUser();
            } else {
                btnIngresar.setEnabled(false);
            }
        } else {
            btnIngresar.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEnviar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelColumna;
    private javax.swing.JLabel labelLinea;
    private javax.swing.JTextArea loginTextArea;
    private javax.swing.JTextArea respuestas;
    // End of variables declaration//GEN-END:variables
}