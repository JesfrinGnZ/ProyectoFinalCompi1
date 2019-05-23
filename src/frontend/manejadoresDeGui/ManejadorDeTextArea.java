/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.manejadoresDeGui;

import backend.Etiquetas.AtributoDeEtiqueta;
import backend.Etiquetas.Etiqueta;
import frontend.ManejadoresDeEtiquetas.ManejadorDeParrafo;
import java.awt.Color;
import java.awt.Font;
import java.security.KeyStore;
import java.util.ArrayList;
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
    private boolean errorEnAccion;
    private Color linkColor;
    private Color bgColor;
    private Color textColor;
    private ArrayList<Etiqueta> etiquetas;

    public ManejadorDeTextArea(JTextPane areaDeTexto) {
        this.areaDeTexto = areaDeTexto;
        this.linkColor = Color.RED;
        this.bgColor = Color.WHITE;
        this.textColor = Color.BLACK;
        this.errorEnAccion = false;
        this.etiquetas = new ArrayList<>();
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void manejarEtiqueta() {
        int n = this.areaDeTexto.getStyledDocument().getLength();
        SimpleAttributeSet atributos;
        for (Etiqueta etiqueta : etiquetas) {
            switch (etiqueta.getTipoDeEtiqueta()) {
                case "title":
                    System.out.println("Est titulo:" + etiqueta.getAtributos().size() + " Texto:" + etiqueta.getTexto());
                    break;
                case "p":
                    System.out.println("Es parrafo:" + etiqueta.getAtributos().size() + " Texto:" + etiqueta.getTexto());
                    ManejadorDeParrafo manP=new ManejadorDeParrafo(etiqueta, this);
                    atributos=manP.buscarAlineacion();
                    break;
            }
        }
    }

    public void anadirTexto() {

    }
//------------------------------------------Cambio de color para el fondo-------------------------------------

    public void atributosDeBody(ArrayList<AtributoDeEtiqueta> atributos) {
        for (AtributoDeEtiqueta atributo : atributos) {
            String tipo = atributo.getTipo().toLowerCase();
            switch (tipo) {
                case "bgcolor":
                    this.bgColor = asignarColor(atributo.getValor(), Color.WHITE);
                    break;
                case "text":
                    this.textColor = asignarColor(atributo.getValor(), Color.BLACK);
                    break;
                case "link":
                    this.linkColor = asignarColor(atributo.getValor(), Color.RED);
                    break;
                default:
                    System.out.println("ERROR ATRIBUTO NO VALIDO");
                    this.errorEnAccion = true;
                    break;
            }
        }
    }

//------------------------------------------Cambio de color para el fondo-------------------------------------
    public Color asignarColor(String color, Color colorPorDefecto) {
        color = color.toLowerCase();
        switch (color) {
            case "black":
                return Color.black;
            case "olive":
                return Color.decode("#808000");
            case "teal":
                return Color.decode("#008080");
            case "red":
                return Color.red;
            case "blue":
                return Color.blue;
            case "maroon":
                return Color.decode("#800000");
            case "navy":
                return Color.decode("#000080");
            case "gray":
                return Color.gray;
            case "lime":
                return Color.decode("#00ff00");
            case "fuchsia":
                return Color.decode("#ca2c92");
            case "green":
                return Color.green;
            case "purple":
                return Color.decode("#800080");
            case "silver":
                return Color.decode("#c0c0c0");
            case "yellow":
                return Color.yellow;
            case "aqua":
                return Color.decode("#00ffff");
            default:
                try {
                    Color nuevoColor = Color.decode(color);
                    return nuevoColor;
                } catch (Exception e) {
                    return colorPorDefecto;
                }
        }

    }

//--------------------------------------------Cambio de color para letra----------------------------------------    
    public void setTextColor(Color color) {
        this.areaDeTexto.setForeground(color);
    }

//--------------------------------------------Cambio de color para los links-------------------------------------
    public void setLinkColor(Color color) {
        this.linkColor = color;
    }

//--------------------------------------------Alineacion de texto-----------------------------------------------------
    public void wrightCenter(String texto) {
        this.areaDeTexto.setAlignmentX(0.5f);

    }

//------------------------------------------Aplicacion de estilos------------------------------------------------    
    public void pruebaDeEstilos() throws BadLocationException {
        String cadena1 = "cadena1\n";
        String cadena2 = "cadena2\n";
        SimpleAttributeSet atributos = new SimpleAttributeSet();
        StyleConstants.setBold(atributos, true);
        StyleConstants.setForeground(atributos, Color.BLUE);
        StyleConstants.setAlignment(atributos, StyleConstants.ALIGN_CENTER);
        //Insertar texto
        this.areaDeTexto.getStyledDocument().insertString(0, cadena1, atributos);
        //Se agrega la alineacion
        this.areaDeTexto.getStyledDocument().setParagraphAttributes(0, this.areaDeTexto.getStyledDocument().getLength(), atributos, false);

        //Vuelta a valores por defecto
        //Contenedor de atributos
        SimpleAttributeSet atributo2 = new SimpleAttributeSet();
        //Se inserta texto desde la posicion anterior
        int n = this.areaDeTexto.getStyledDocument().getLength();
        this.areaDeTexto.getStyledDocument().insertString(n, cadena2, atributo2);
        StyleConstants.setAlignment(atributo2, StyleConstants.ALIGN_RIGHT);
        //StyleConstants.setItalic(atributo2, true);
        //StyleConstants.setBold(atributo2, true);
        StyleConstants.setFontSize(atributo2, 30);
        StyleConstants.setFontFamily(atributo2, "Nakula");
//Se agreaga la alineacion desde la posicion anterior hasta el nuevo tamano
        this.areaDeTexto.getStyledDocument().setParagraphAttributes(n, this.areaDeTexto.getStyledDocument().getLength(), atributo2, true);

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
                        String miTexto = "Este es un texto de n letras";
                        this.areaDeTexto.getStyledDocument().insertString(0, "Este es un texto de unas cuantas letras ", at);
                        StyledDocument doc = this.areaDeTexto.getStyledDocument();
                        StyledDocument doc2 = doc;
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
