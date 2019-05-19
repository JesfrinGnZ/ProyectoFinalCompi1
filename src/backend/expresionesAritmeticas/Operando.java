/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expresionesAritmeticas;

/**
 *
 * @author jesfrin
 */
public class Operando extends ExpresionMatematica{
    
    public int valor;//Result
    
    public Operando(int numeroDeColumna,int numeroDeLinea,String valor){
        this.numeroDeColumna=numeroDeColumna;
        this.numeroDeLinea=numeroDeLinea;
        this.valor=Integer.valueOf(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
