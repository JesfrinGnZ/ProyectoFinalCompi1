/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expresionesConCadenas;

/**
 *
 * @author jesfrin
 */
public class OperacionBinariaCadena extends ExpresionConCadena{

    

    private ExpresionConCadena ex1;
    private ExpresionConCadena ex2;
    
    public OperacionBinariaCadena(int numeroDeLinea,int numeroDeColumna, ExpresionConCadena ex1,ExpresionConCadena ex2){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.ex1=ex1;
        this.ex2=ex2;
    }

    public ExpresionConCadena getEx1() {
        return ex1;
    }

    public void setEx1(ExpresionConCadena ex1) {
        this.ex1 = ex1;
    }

    public ExpresionConCadena getEx2() {
        return ex2;
    }

    public void setEx2(ExpresionConCadena ex2) {
        this.ex2 = ex2;
    }

    @Override
    public int getNumeroDeLinea() {
        return numeroDeLinea;
    }

    @Override
    public void setNumeroDeLinea(int numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    @Override
    public int getNumeroDeColumna() {
        return numeroDeColumna;
    }

    @Override
    public void setNumeroDeColumna(int numeroDeColumna) {
        this.numeroDeColumna = numeroDeColumna;
    }
    
    
}
