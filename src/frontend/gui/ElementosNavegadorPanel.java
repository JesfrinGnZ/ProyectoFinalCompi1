/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.gui;

import backend.generacionHtml.AnalizadorDeCodigoEmbebido;
import backend.generacionHtml.parser;
import backend.tablaDeSimbolos.Variable;
import frontend.manejadoresDeGui.ManejadorDeTextArea;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author jesfrin
 */
public class ElementosNavegadorPanel extends javax.swing.JPanel {

    private boolean seGuardo;
    private ArrayList<Variable> tablaDeVariables;

    /**
     * Creates new form ElementosNavegadorPanel
     */
    public ElementosNavegadorPanel() {
        initComponents();
        this.seGuardo = true;
        this.tablaDeVariables = new ArrayList<>();
        this.instruccionesTextArea.setAlignmentX(0.5f);
        this.instruccionesTextArea.append("HOLA MUNDO");
        ManejadorDeTextArea m = new ManejadorDeTextArea(resultadosTextPane);
        try {
            m.pruebaDeEstilos();
        } catch (BadLocationException ex) {
            Logger.getLogger(ElementosNavegadorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        debuggTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        instruccionesTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultadosTextPane = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        analizarButton = new javax.swing.JButton();

        debuggTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(debuggTable);

        instruccionesTextArea.setColumns(20);
        instruccionesTextArea.setRows(5);
        instruccionesTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                instruccionesTextAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(instruccionesTextArea);

        jScrollPane3.setViewportView(resultadosTextPane);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        analizarButton.setText("Analizar");
        analizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(analizarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(701, 701, 701))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(analizarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void instruccionesTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_instruccionesTextAreaKeyPressed
        this.seGuardo = false;
    }//GEN-LAST:event_instruccionesTextAreaKeyPressed

    private void analizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarButtonActionPerformed
        String texto = this.instruccionesTextArea.getText();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existe texto para analizar");
        } else {
            analizarTexto(texto);
        }
    }//GEN-LAST:event_analizarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizarButton;
    private javax.swing.JTable debuggTable;
    private javax.swing.JTextArea instruccionesTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane resultadosTextPane;
    // End of variables declaration//GEN-END:variables

    public void analizarTexto(String texto) {
        AnalizadorDeCodigoEmbebido lex = new AnalizadorDeCodigoEmbebido(new BufferedReader(new StringReader(texto)));
        tablaDeVariables=new ArrayList<>();
        parser sintactico = new parser(lex, tablaDeVariables);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            Logger.getLogger(ElementosNavegadorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
