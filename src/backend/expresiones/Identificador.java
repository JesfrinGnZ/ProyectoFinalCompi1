/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expresiones;

/**
 *
 * @author jesfrin
 */
public class Identificador extends Expresion {


    private String id;

    public Identificador(int numeroDeLinea, int numeroDeColumna, String id) {
        this.numeroDeLinea = numeroDeLinea;
        this.numeroDeColumna = numeroDeColumna;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
