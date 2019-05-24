/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jesfrin
 */
public class NavegadorFrame extends javax.swing.JFrame {

    private int numeroDePestana;

    /**
     * Creates new form NavegadorFrame
     */
    public NavegadorFrame() {
        initComponents();
        this.numeroDePestana = 1;
        contenedorTabbedPane1.add("Pestana" + numeroDePestana, new ElementosNavegadorPanel(null,"Pestana1",this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorTabbedPane1 = new javax.swing.JTabbedPane();
        cerrarPestanaButton = new javax.swing.JButton();
        nuevaPestanaButton = new javax.swing.JButton();
        analizarTodosButton = new javax.swing.JButton();
        GuardarComoButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrirArchivoMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cerrarPestanaButton.setText("Cerrar");
        cerrarPestanaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarPestanaButtonActionPerformed(evt);
            }
        });

        nuevaPestanaButton.setText("Nuevo");
        nuevaPestanaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaPestanaButtonActionPerformed(evt);
            }
        });

        analizarTodosButton.setText("Analizar todos");

        GuardarComoButton.setText("GuardarComo");
        GuardarComoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarComoButtonActionPerformed(evt);
            }
        });

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        abrirArchivoMenuItem.setText("Abrir");
        abrirArchivoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(abrirArchivoMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(874, Short.MAX_VALUE)
                .addComponent(nuevaPestanaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrarPestanaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GuardarComoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analizarTodosButton)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analizarTodosButton)
                    .addComponent(GuardarComoButton)
                    .addComponent(guardarButton)
                    .addComponent(cerrarPestanaButton)
                    .addComponent(nuevaPestanaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contenedorTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirArchivoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoMenuItemActionPerformed
        abrirArchivo();
    }//GEN-LAST:event_abrirArchivoMenuItemActionPerformed

    private void nuevaPestanaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPestanaButtonActionPerformed
        nuevaPestana(null);
    }//GEN-LAST:event_nuevaPestanaButtonActionPerformed

    private void cerrarPestanaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarPestanaButtonActionPerformed
        ElementosNavegadorPanel elemento = (ElementosNavegadorPanel) this.contenedorTabbedPane1.getSelectedComponent();
        if (elemento.isSeGuardo()) {
            this.contenedorTabbedPane1.remove(elemento);
        } else {
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea guardar el documento actual??");
            if (respuesta == 0) {//Si
                if (elemento.getRuta() == null) {
                    guardarComo(elemento.getInstruccionesTextArea(), elemento);
                } else {
                    guardar(elemento.getInstruccionesTextArea(), elemento, elemento.getRuta());
                }
            } else if (respuesta == 1) {//no
                this.contenedorTabbedPane1.remove(this.contenedorTabbedPane1.getSelectedComponent());
            }
        }

    }//GEN-LAST:event_cerrarPestanaButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        ElementosNavegadorPanel elemento = (ElementosNavegadorPanel) this.contenedorTabbedPane1.getSelectedComponent();
        if (elemento.getRuta() == null) {
            guardarComo(elemento.getInstruccionesTextArea(), elemento);
        } else {
            guardar(elemento.getInstruccionesTextArea(), elemento, elemento.getRuta());
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void GuardarComoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarComoButtonActionPerformed
        ElementosNavegadorPanel elemento = (ElementosNavegadorPanel) this.contenedorTabbedPane1.getSelectedComponent();
        guardarComo(elemento.getInstruccionesTextArea(), elemento);
    }//GEN-LAST:event_GuardarComoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarComoButton;
    private javax.swing.JMenuItem abrirArchivoMenuItem;
    private javax.swing.JButton analizarTodosButton;
    private javax.swing.JButton cerrarPestanaButton;
    private javax.swing.JTabbedPane contenedorTabbedPane1;
    private javax.swing.JButton guardarButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton nuevaPestanaButton;
    // End of variables declaration//GEN-END:variables

    private ElementosNavegadorPanel nuevaPestana(File ruta) {
        numeroDePestana++;
        ElementosNavegadorPanel elemento = new ElementosNavegadorPanel(ruta,"Pestana" + numeroDePestana,this);
        this.contenedorTabbedPane1.add("Pestana" + numeroDePestana, elemento);
        this.contenedorTabbedPane1.setSelectedComponent(elemento);
        return elemento;
    }

    public void abrirArchivo() {
        //Variablesde ayuda en lectura
        String aux;
        //Variables y objetos para archivos
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtroKok = new FileNameExtensionFilter("Archivos kok", "kok");
        file.setFileFilter(filtroKok);
        file.showOpenDialog(this);
        //abrimos el archivo seleccionado
        File archivo = file.getSelectedFile();
        if (archivo != null) {
            try {
                String texto = "";
                FileReader archivos = new FileReader(archivo);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    texto += aux;
                    System.out.println(aux);
                }
                ElementosNavegadorPanel nav = nuevaPestana(archivo);
                nav.getInstruccionesTextArea().setText(texto);

            } catch (Exception ex) {
                Logger.getLogger(NavegadorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void guardarComo(JTextArea textArea, ElementosNavegadorPanel panel) {
        try {
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();
            if (guarda != null) {
                //Eliminar el archivo actual
                FileWriter save = new FileWriter(guarda);//guardamos el archivo
                save.write(textArea.getText());
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                panel.setRuta(guarda);
                panel.setSeGuardo(true);
            }//Al ser archivo nullo no realizara accion
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void guardar(JTextArea textArea, ElementosNavegadorPanel panel, File guarda) {
        try {
            //Eliminar el archivo actual
            FileWriter save = new FileWriter(guarda);//guardamos el archivo
            save.write(textArea.getText());
            save.close();
            JOptionPane.showMessageDialog(null,
                    "El archivo se a guardado Exitosamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            panel.setRuta(guarda);
            panel.setSeGuardo(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
