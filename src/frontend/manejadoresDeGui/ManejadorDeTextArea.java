/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.manejadoresDeGui;

import java.awt.Color;
import java.awt.Font;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeTextArea {

    private final JTextPane areaDeTexto;
    private Color colorDeLinks;

    public ManejadorDeTextArea(JTextPane areaDeTexto) {
        this.areaDeTexto = areaDeTexto;
    }

//------------------------------------------Cambio de color para el fondo-------------------------------------
    public void setBgColor(String color, boolean esHexadecimal) {
        if (esHexadecimal) {
            Color nuevoColor = Color.decode(color);
            this.areaDeTexto.setBackground(nuevoColor);
        } else {
            color = color.toLowerCase();
            switch (color) {
                case "black":
                    this.areaDeTexto.setBackground(Color.black);
                    break;
                case "olive":
                    this.areaDeTexto.setBackground(Color.decode("#808000"));
                    break;
                case "teal":
                    this.areaDeTexto.setBackground(Color.decode("#008080"));
                    break;
                case "red":
                    this.areaDeTexto.setBackground(Color.red);
                    break;
                case "blue":
                    this.areaDeTexto.setBackground(Color.blue);
                    break;
                case "maroon":
                    this.areaDeTexto.setBackground(Color.decode("#800000"));
                    break;
                case "navy":
                    this.areaDeTexto.setBackground(Color.decode("#000080"));
                    break;
                case "gray":
                    this.areaDeTexto.setBackground(Color.gray);
                    break;
                case "lime":
                    this.areaDeTexto.setBackground(Color.decode("#00ff00"));
                    break;
                case "fuchsia":
                    this.areaDeTexto.setBackground(Color.decode("#ca2c92"));
                    break;
                case "green":
                    this.areaDeTexto.setBackground(Color.green);
                    break;
                case "purple":
                    this.areaDeTexto.setBackground(Color.decode("#800080"));
                    break;
                case "silver":
                    this.areaDeTexto.setBackground(Color.decode("#c0c0c0"));
                    break;
                case "yellow":
                    this.areaDeTexto.setBackground(Color.yellow);
                    break;
                case "aqua":
                    this.areaDeTexto.setBackground(Color.decode("#00ffff"));
                    break;
            }
        }

    }

//--------------------------------------------Cambio de color para letra----------------------------------------    
    public void setTextColor(Color color) {
        this.areaDeTexto.setForeground(color);
    }

//--------------------------------------------Cambio de color para los links-------------------------------------
    public void setLinkColor(Color color) {
        this.colorDeLinks = color;
    }

//--------------------------------------------Alineacion de texto-----------------------------------------------------
    public void wrightCenter(String texto) {
        this.areaDeTexto.setAlignmentX(0.5f);

    }

//------------------------------------------Aplicacion de estilos------------------------------------------------    
    
    public void pruebaDeEstilos() throws BadLocationException{
        String cadena1="cadena1\n";
        String cadena2="cadena2\n";
        SimpleAttributeSet atributos = new SimpleAttributeSet();
        StyleConstants.setBold(atributos, true);
        StyleConstants.setForeground(atributos, Color.BLUE);
        StyleConstants.setAlignment(atributos, StyleConstants.ALIGN_CENTER);
        //Insertar texto
        this.areaDeTexto.getStyledDocument().insertString(0, cadena1, atributos);
        //Se agrega la alineacion
        this.areaDeTexto.getStyledDocument().setParagraphAttributes(0,this.areaDeTexto.getStyledDocument().getLength(), atributos, false);
        
        //Vuelta a valores por defecto
        //Contenedor de atributos
        SimpleAttributeSet atributo2 = new SimpleAttributeSet();
        //Se inserta texto desde la posicion anterior
        this.areaDeTexto.getStyledDocument().insertString(cadena1.length(), cadena2, atributo2);
        StyleConstants.setAlignment(atributo2, StyleConstants.ALIGN_RIGHT);
        //StyleConstants.setItalic(atributo2, true);
        //StyleConstants.setBold(atributo2, true);
        StyleConstants.setFontSize(atributo2, 30);
        StyleConstants.setFontFamily(atributo2, "Nakula");
//Se agreaga la alineacion desde la posicion anterior hasta el nuevo tamano
        this.areaDeTexto.getStyledDocument().setParagraphAttributes(cadena1.length(),this.areaDeTexto.getStyledDocument().getLength(), atributo2, true);
        
//atributos.removeAttribute(atributos.getAttribute("Bold"));
    }
    
    
    public void aplicarEstilo(String tipoDeEstilo) {

        switch (tipoDeEstilo) {
            case "negrilla":
                SimpleAttributeSet at = new SimpleAttributeSet();
                /**
                 * ***********************************************Color********************************************
                 */
                //               Style style = this.areaDeTexto.addStyle(null, null);
//                StyleConstants.setForeground(at, Color.red);
//                this.areaDeTexto.setLogicalStyle(style);

                /**
                 * ***********************************************Estilos********************************************
                 */
                StyleConstants.setBold(at, true);//Negrilla
                //StyleConstants.setUnderline(at, true);//Subrayado
                //StyleConstants.setItalic(at, true);//Italica
                //StyleConstants.setStrikeThrough(at, true);//Tachado
                //StyleConstants.setSubscript(at, true);//SubIndice
                //StyleConstants.setSuperscript(at, true);//SuperIndice
                /**
                 * ***********************************************Alineacion********************************************
                 */
                 {
                    try {
                        //http://www.chuidiang.org/java/ejemplos/JEditorPane-JTextPane/JEditorPane-JTextPane.php
                        String miTexto ="Este es un texto de n letras";
                        this.areaDeTexto.getStyledDocument().insertString(0, "Este es un texto de unas cuantas letras ", at);
                        StyledDocument doc = this.areaDeTexto.getStyledDocument();
                        StyledDocument doc2=doc;
                        StyleConstants.setAlignment(at, StyleConstants.ALIGN_RIGHT);
                        doc.setParagraphAttributes(0, 0, at, true);
                        doc.setParagraphAttributes(0, 0, at, true);
                        at.removeAttribute(StyleConstants.Bold);
                        this.areaDeTexto.getStyledDocument().insertString(0, "Prueba de texto no ", at);

//                        this.areaDeTexto.getStyledDocument().insertString(this.areaDeTexto.getStyledDocument().getLength(), "Estoy a la izquierda??", at);
//                        StyleConstants.setAlignment(at, StyleConstants.ALIGN_LEFT);
//                        doc.setParagraphAttributes(miTexto.length(), this.areaDeTexto.getStyledDocument().getLength(), at, false);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(ManejadorDeTextArea.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
        }
    }

}
