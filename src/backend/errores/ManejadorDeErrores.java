/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.errores;

import frontend.gui.ErroresJDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeErrores {

    private ArrayList<ErrorAnalisis> errores;
    private String nombreDeArchivo;
    private String textoFinal;
    private File rutaDeArchivo;

    public ManejadorDeErrores(ArrayList<ErrorAnalisis> errores, String nombreDeArchivo, File ruta) {
        this.errores = errores;
        this.nombreDeArchivo = nombreDeArchivo;
        this.rutaDeArchivo = ruta;
    }

    public String generarListadoDeErrores() {
        String cadena = "<errores>\n";
        for (ErrorAnalisis error : errores) {
            if (error instanceof ErrorLexico) {
                ErrorLexico err = ((ErrorLexico) error);
                cadena += "\t<error>\n";
                cadena += "\t\t<linea>" + err.getNumeroDeLinea() + "</linea>\n";
                cadena += "\t\t<columna>" + err.getNumeroDeColumna() + "</columna>\n";
                cadena += "\t\t<descripcion>" + "Lexico:" + err.getDescripcion() + "</descripcion>\n";
                cadena += "\t\t<archivo>" + nombreDeArchivo + "</archivo>\n";
                cadena += "\t<error>\n";
            } else if (error instanceof ErrorSintactico) {
                ErrorSintactico err = ((ErrorSintactico) error);
                cadena += "\t<error>\n";
                cadena += "\t\t<linea>" + err.getNumeroDeLinea() + "</linea>\n";
                cadena += "\t\t<columna>" + err.getNumeroDeColumna() + "</columna>\n";
                cadena += "\t\t<descripcion>" + "Sintactico:" + err.getDescripcion() + "</descripcion>\n";
                cadena += "\t\t<archivo>" + nombreDeArchivo + "</archivo>\n";
                cadena += "\t<error>\n";
            } else if (error instanceof ErrorSemantico) {
                ErrorSemantico err = ((ErrorSemantico) error);
                cadena += "\t<error>\n";
                cadena += "\t\t<linea>" + err.getNumeroDeLinea() + "</linea>\n";
                cadena += "\t\t<columna>" + err.getNumeroDeColumna() + "</columna>\n";
                cadena += "\t\t<descripcion>" + err.getDescripcion() + "</descripcion>\n";
                cadena += "\t\t<archivo>" + "Semantico:" + nombreDeArchivo + "</archivo>\n";
                cadena += "\t<error>\n";
            }
        }
        cadena += "</errores>";

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(rutaDeArchivo + "/error" + nombreDeArchivo, false));
            bf.append(cadena);
            bf.close();
            //JOptionPane.showMessageDialog(this, "Se genero el archivo html en la ruta:" + rutaDeArchivo+"/error"+nombreDeArchivo);
        } catch (Exception ex) {
            //Logger.getLogger(LectorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }

    public String generarListadoPorTipo() {
        String cadena = "<errores>";
        cadena += "\t<LEXICOS>\n";
        for (ErrorAnalisis error : errores) {
            if (error instanceof ErrorLexico) {
                ErrorLexico err = ((ErrorLexico) error);
                cadena += "\t\t<error>\n";
                cadena += "\t\t\t<linea>" + err.getNumeroDeLinea() + "</linea>\n";
                cadena += "\t\t\t<columna>" + err.getNumeroDeColumna() + "</columna>\n";
                cadena += "\t\t\t<descripcion>" + err.getDescripcion() + "</descripcion>\n";
                cadena += "\t\t\t<archivo>" + nombreDeArchivo + "</archivo>\n";
                cadena += "\t\t<error>\n";
            }
        }
        cadena += "\t</LEXICOS>\n";
        cadena += "\t<SINTACTICOS>\n";
        for (ErrorAnalisis error : errores) {
            if (error instanceof ErrorSintactico) {
                ErrorSintactico err = ((ErrorSintactico) error);
                cadena += "\t\t<error>\n";
                cadena += "\t\t\t<linea>" + err.getNumeroDeLinea() + "</linea>\n";
                cadena += "\t\t\t<columna>" + err.getNumeroDeColumna() + "</columna>\n";
                cadena += "\t\t\t<descripcion>" + "Sintactico:" + err.getDescripcion() + "</descripcion>\n";
                cadena += "\t\t\t<archivo>" + nombreDeArchivo + "</archivo>\n";
                cadena += "\t\t<error>\n";
            }
        }
        cadena += "\t</SINTACTICOS>\n";
        cadena += "\t<SEMANTICOS>\n";
        for (ErrorAnalisis error : errores) {
            if (error instanceof ErrorSemantico) {
                ErrorSemantico err = ((ErrorSemantico) error);
                cadena += "\t\t<error>\n";
                cadena += "\t\t\t<linea>" + err.getNumeroDeLinea() + "</linea>\n";
                cadena += "\t\t\t<columna>" + err.getNumeroDeColumna() + "</columna>\n";
                cadena += "\t\t\t<descripcion>" + err.getDescripcion() + "</descripcion>\n";
                cadena += "\t\t\t<archivo>" + "Semantico:" + nombreDeArchivo + "</archivo>\n";
                cadena += "\t\t<error>\n";
            }
        }
        cadena += "\t</SEMANTICOS>\n";
        cadena += "</errores>";
         try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(rutaDeArchivo+"/error"+nombreDeArchivo, false));
            bf.append(cadena);
            bf.close();
            //JOptionPane.showMessageDialog(this, "Se genero el archivo html en la ruta:" + rutaDeArchivo+"/error"+nombreDeArchivo);
        } catch (Exception ex) {
            //Logger.getLogger(LectorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }

}
