/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Expresiones;

/**
 *
 * @author jesfrin
 */
public class Identificador extends Expresion{
    
    private String id;
    private String valor;
    
    public Identificador(int numeroDeLinea,int numeroDeColumna,String id,String valor){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
    }
    
    
    
    
}
