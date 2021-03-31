/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1.UI;

import com.carlos.app_cliente_proyecto1.EDD.Pila;
import com.carlos.app_cliente_proyecto1.HttpMethods.RealizarConsulta;
import com.carlos.app_cliente_proyecto1.Lexer.lexerIndigo;
import com.carlos.app_cliente_proyecto1.Objetos.Tabla;
import com.carlos.app_cliente_proyecto1.Objetos.mensaje;
import com.carlos.app_cliente_proyecto1.Parser.parserIndigo;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benjamin
 */
public class consultasDatos extends javax.swing.JInternalFrame {

    private RealizarConsulta api = new RealizarConsulta();
    private List<Tabla> tablasInfo;
    private int maxCount;
    private int localCount = 0;

    /**
     * Creates new form consultasDatos
     */
    public consultasDatos() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        editorTexto = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelColumna = new javax.swing.JLabel();
        labelLinea = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        resNormal = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        labelCansulta = new javax.swing.JLabel();
        btnSigTab = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        btnCopiar = new javax.swing.JMenuItem();
        btnPegar = new javax.swing.JMenuItem();
        btnCortar = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);

        editorTexto.setColumns(20);
        editorTexto.setRows(5);
        editorTexto.setTabSize(3);
        editorTexto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editorTextoCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(editorTexto);

        jLabel3.setText("Linea:");

        jLabel4.setText("Columna:");

        labelColumna.setText("1");

        labelLinea.setText("1");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        tablaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaConsultas);

        resNormal.setEditable(false);
        resNormal.setColumns(20);
        resNormal.setRows(5);
        resNormal.setTabSize(3);
        resNormal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                resNormalCaretUpdate(evt);
            }
        });
        jScrollPane5.setViewportView(resNormal);

        jLabel1.setText("Consulta: ");

        labelCansulta.setText("consulta");

        btnSigTab.setText("siguiente tabla");
        btnSigTab.setEnabled(false);
        btnSigTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigTabActionPerformed(evt);
            }
        });

        jLabel2.setText("Mensajes del Servidor:");

        jMenu2.setText("Edicion");

        btnCopiar.setText("Copiar");
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });
        jMenu2.add(btnCopiar);

        btnPegar.setText("Pegar");
        btnPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegarActionPerformed(evt);
            }
        });
        jMenu2.add(btnPegar);

        btnCortar.setText("Cortar");
        btnCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCortarActionPerformed(evt);
            }
        });
        jMenu2.add(btnCortar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLinea)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelColumna)
                        .addGap(163, 163, 163)
                        .addComponent(btnEnviar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCansulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSigTab))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labelLinea)
                            .addComponent(jLabel4)
                            .addComponent(labelColumna)
                            .addComponent(btnEnviar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelCansulta)
                            .addComponent(btnSigTab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editorTextoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editorTextoCaretUpdate
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
            ex.printStackTrace();
        }
    }//GEN-LAST:event_editorTextoCaretUpdate

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        String envio = editorTexto.getText();
        String respuesta = api.envioInfo(envio);
        lecturaMensaje(respuesta);
    }//GEN-LAST:event_btnEnviarActionPerformed
    private void lecturaMensaje(String respuesta) {
        try {
            lexerIndigo lex = new lexerIndigo(new StringReader(respuesta));
            parserIndigo parser = new parserIndigo(lex);
            parser.parse();

            List<mensaje> res1 = parser.getErrLex();
            List<mensaje> res2 = parser.getErrSin();
            List<mensaje> res3 = parser.getMsjUser();

            String contenido = "";

            for (int i = (res1.size() - 1); i >= 0; i--) {
                contenido = contenido + res1.get(i).getMensaje() + "\n";
            }

            for (int i = (res2.size() - 1); i >= 0; i--) {
                contenido = contenido + res2.get(i).getMensaje() + "\n";
            }

            for (int i = (res3.size() - 1); i >= 0; i--) {
                contenido = contenido + res3.get(i).getMensaje() + "\n";
            }
            resNormal.setText(contenido);
            if (contenido.isEmpty()) {
                Pila tmporal = parser.getTablas();
                tmporal.imprimirPila();
                tablasInfo = new ArrayList<>();
                while (!tmporal.isEmpty()) {
                    tablasInfo.add((Tabla) tmporal.pop());
                }

                if (tablasInfo.size() > 0) {
                    this.btnSigTab.setEnabled(true);
                    this.localCount=0;
                    this.cargarTablas();
                } else {
                    this.btnSigTab.setEnabled(false);
                }
            }else{
                this.localCount=0;
                this.btnSigTab.setEnabled(false);
                this.limpiarTabla();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarTablas() {
        this.maxCount = tablasInfo.size();
        Tabla currentTable = tablasInfo.get(localCount);
        this.labelCansulta.setText(currentTable.getNombreTabla());
        DefaultTableModel model = new DefaultTableModel();
        this.tablaConsultas.setModel(model);

        List<String> header = currentTable.getFilas().get(0);
        for (String string : header) {
            model.addColumn(string);
        }

        if (currentTable.getFilas().size() > 1) {
            int cont = 1;
            for (List<String> fila : currentTable.getFilas()) {
                if (cont != 1) {
                    String[] rowtab = new String[fila.size()];
                    rowtab = fila.toArray(rowtab);
                    model.addRow(rowtab);
                }
                cont++;
            }
        }
    }
    
    private void limpiarTabla(){
        this.labelCansulta.setText("Vacio");
        DefaultTableModel model = new DefaultTableModel();
        this.tablaConsultas.setModel(model);
    }


    private void resNormalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_resNormalCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_resNormalCaretUpdate

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
        // TODO add your handling code here:
        this.editorTexto.copy();
    }//GEN-LAST:event_btnCopiarActionPerformed

    private void btnPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegarActionPerformed
        // TODO add your handling code here:
        this.editorTexto.paste();
    }//GEN-LAST:event_btnPegarActionPerformed

    private void btnCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCortarActionPerformed
        // TODO add your handling code here:
        this.editorTexto.cut();
    }//GEN-LAST:event_btnCortarActionPerformed

    private void btnSigTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigTabActionPerformed
        // TODO add your handling code here:
        localCount++;
        if (localCount == maxCount) {
            localCount = 0;
            this.cargarTablas();
        }else{
            this.cargarTablas();
        }
    }//GEN-LAST:event_btnSigTabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCopiar;
    private javax.swing.JMenuItem btnCortar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JMenuItem btnPegar;
    private javax.swing.JButton btnSigTab;
    private javax.swing.JTextArea editorTexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelCansulta;
    private javax.swing.JLabel labelColumna;
    private javax.swing.JLabel labelLinea;
    private javax.swing.JTextArea resNormal;
    private javax.swing.JTable tablaConsultas;
    // End of variables declaration//GEN-END:variables
}