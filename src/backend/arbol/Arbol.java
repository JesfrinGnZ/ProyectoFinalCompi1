/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.arbol;

import backend.AccionesMatematicas.*;

/**
 *
 * @author jesfrin
 */
public class Arbol {
    
    private Nodo nodoRaiz;
    private String recorrido="";
    
    public Arbol(Nodo nodoRaiz){
        this.nodoRaiz=nodoRaiz;
    }
    
    public void evaluar(){
        Nodo raiz = this.nodoRaiz;
        
    }
    //IDE
    //El primer nodo es raiz
    public void recorridoDeArbolEnPreorden(Nodo nodoActual){
        for (Object nodo : nodoActual.getNodosHijos()) {//Accediendo a los hijos del nodo padre
            Nodo n=(Nodo)nodo;
            if(n.getNodosHijos().isEmpty()){//Llegamos a hoja
                if(n.getTipo().equals("int")){
                }
            }
        }
    }
    
    
}
