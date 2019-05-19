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
public class OperacionBinaria extends ExpresionMatematica{
    
    
    public OperacionBinaria(int numeroDeLinea, int numeroDeColumna,ExpresionMatematica ex1,ExpresionMatematica ex2,String operacion){
        this.operacion=operacion;
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.ex1=ex1;
        this.ex2=ex2;
    }
    
    private String operacion;
    private ExpresionMatematica ex1;
    private ExpresionMatematica ex2;
    //private double result;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public ExpresionMatematica getEx1() {
        return ex1;
    }

    public void setEx1(ExpresionMatematica ex1) {
        this.ex1 = ex1;
    }

    public ExpresionMatematica getEx2() {
        return ex2;
    }

    public void setEx2(ExpresionMatematica ex2) {
        this.ex2 = ex2;
    }

//    public double getResult() {
//        return result;
//    }
//
//    public void setResult(double result) {
//        this.result = result;
//    }

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
