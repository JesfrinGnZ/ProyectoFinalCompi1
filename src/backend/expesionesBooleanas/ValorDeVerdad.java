/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expesionesBooleanas;

/**
 *
 * @author jesfrin
 */
public class ValorDeVerdad extends ExpresionBooleana{
    
    private String valorDeVerdad;
    
    public ValorDeVerdad(int numeroDeLinea,int numeroDeColumna,String valorDeVerdad){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.valorDeVerdad=valorDeVerdad;
    }

    public String getValorDeVerdad() {
        return valorDeVerdad;
    }

    public void setValorDeVerdad(String valorDeVerdad) {
        this.valorDeVerdad = valorDeVerdad;
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
    
    
}
