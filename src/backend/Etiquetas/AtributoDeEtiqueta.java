/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Etiquetas;

/**
 *
 * @author jesfrin
 */
public class AtributoDeEtiqueta {

    private String tipo;
    private String valor;
    private int numeroDeLinea;
    private int numeroDeColumna;

    public AtributoDeEtiqueta(int numeroDeLinea,int numeroDeColumna,String tipo,String valor){
        this.tipo=tipo;
        this.valor=valor;
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
