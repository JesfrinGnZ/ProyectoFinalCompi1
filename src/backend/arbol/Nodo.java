/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.arbol;

import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class Nodo<T> {
    
    private T objeto;
    private String tipo;//Para saber que accion reealizar
    private String valor;//Valor RESULT
    private Nodo padre;
    private ArrayList<Nodo> nodosHijos;

    public Nodo(String tipo,String valor){//Nodo hojas
        this.tipo=tipo;
        this.valor=valor;
        this.nodosHijos=null;
    }
    
    public Nodo(T objeto){//Nodo interno
        this.objeto=objeto;
        this.nodosHijos=new ArrayList<>();
    }
    
    public Nodo(String tipo, String valor,Nodo padre) {
        this.tipo = tipo;
        this.valor = valor;
        this.padre=padre;
        this.nodosHijos=new ArrayList<>();
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
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

    public ArrayList<Nodo> getNodosHijos() {
        return nodosHijos;
    }

    public void setNodosHijos(ArrayList<Nodo> nodosHijos) {
        this.nodosHijos = nodosHijos;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
    
    
}
