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
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 *
 * @author jesfrin
 */
public class ElementosNavegadorPanel extends javax.swing.JPanel {

    private boolean seGuardo;
    private ArrayList<Variable> tablaDeVariables;
    private File ruta;
    /**
     * Creates new form ElementosNavegadorPanel
     * @param ruta
     */
    public ElementosNavegadorPanel(File ruta) {
        initComponents();
       this.seGuardo = false;
       this.ruta=ruta;
//        this.tablaDeVariables = new ArrayList<>();
//        this.instruccionesTextArea.setAlignmentX(0.5f);
//        this.instruccionesTextArea.append("HOLA MUNDO");
//        ManejadorDeTextArea m = new ManejadorDeTextArea(resultadosTextPane);
//        try {
//            m.pruebaDeEstilos();
//        } catch (BadLocationException ex) {
//            Logger.getLogger(ElementosNavegadorPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
        jPanel1 = new javax.swing.JPanel();
        numeroDeFilaLabel = new javax.swing.JLabel();
        numeroDeColumnaLabel = new javax.swing.JLabel();

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
        instruccionesTextArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                instruccionesTextAreaCaretUpdate(evt);
            }
        });
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

        numeroDeFilaLabel.setFont(new java.awt.Font("TlwgTypewriter", 0, 18)); // NOI18N
        numeroDeFilaLabel.setText("#Linea");

        numeroDeColumnaLabel.setFont(new java.awt.Font("TlwgTypewriter", 0, 18)); // NOI18N
        numeroDeColumnaLabel.setText("#Colmn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numeroDeColumnaLabel)
                    .addComponent(numeroDeFilaLabel))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(numeroDeFilaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroDeColumnaLabel)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(analizarButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(701, 701, 701))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(analizarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void instruccionesTextAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_instruccionesTextAreaCaretUpdate
        int pos = evt.getDot(); //mira los pasos del puntero
        try {
            int fila = instruccionesTextArea.getLineOfOffset(pos) + 1; //devuelve la fila
            int columna = pos - instruccionesTextArea.getLineStartOffset(fila - 1) + 1; //devuelve la columna
            this.numeroDeColumnaLabel.setText("#Colmn:" + " " + columna + "");
            this.numeroDeFilaLabel.setText("#Linea:" + " " + fila);

        } catch (BadLocationException exc) {
        }
    }//GEN-LAST:event_instruccionesTextAreaCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizarButton;
    private javax.swing.JTable debuggTable;
    private javax.swing.JTextArea instruccionesTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel numeroDeColumnaLabel;
    private javax.swing.JLabel numeroDeFilaLabel;
    private javax.swing.JTextPane resultadosTextPane;
    // End of variables declaration//GEN-END:variables

    public void analizarTexto(String texto) {
        AnalizadorDeCodigoEmbebido lex = new AnalizadorDeCodigoEmbebido(new BufferedReader(new StringReader(texto)));
        tablaDeVariables=new ArrayList<>();
        parser sintactico = new parser(lex, tablaDeVariables,new ManejadorDeTextArea(this.resultadosTextPane));//Recibe el manejador del 
        try {
            sintactico.parse();
        } catch (Exception ex) {
            Logger.getLogger(ElementosNavegadorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JTextArea getInstruccionesTextArea() {
        return instruccionesTextArea;
    }

    public void setInstruccionesTextArea(JTextArea instruccionesTextArea) {
        this.instruccionesTextArea = instruccionesTextArea;
    }

    public boolean isSeGuardo() {
        return seGuardo;
    }

    public void setSeGuardo(boolean seGuardo) {
        this.seGuardo = seGuardo;
    }

    public File getRuta() {
        return ruta;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
    }
    
    
}
