/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.errores;

import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ErrorLexico extends ErrorAnalisis{
    
    public ErrorLexico(int numeroDeLinea,int numeroDeColumna,String descripcion){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.descripcion=descripcion;
    }

    public int getNumeroDeLinea() {
        return numeroDeLinea;
    }

    public void setNumeroDeLinea(int numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    public int getNumeroDeColumna() {
        return numeroDeColumna;
    }

    public void setNumeroDeColumna(int numeroDeColumna) {
        this.numeroDeColumna = numeroDeColumna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
