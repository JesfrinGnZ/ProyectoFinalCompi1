/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Etiquetas;

import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class Etiqueta {

    private String tipoDeEtiqueta;
    private ArrayList<AtributoDeEtiqueta> atributos;
    private ArrayList<String> cadenaDeTexto;
    private String texto;

    public Etiqueta(String tipoDeEtiqueta, ArrayList<AtributoDeEtiqueta> atributos, ArrayList<String> cadenaDeTexto) {
        this.tipoDeEtiqueta = tipoDeEtiqueta;
        copiarArrayList(atributos);
        this.cadenaDeTexto = cadenaDeTexto;
        this.texto = crearTexto();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    private void copiarArrayList(ArrayList<AtributoDeEtiqueta> atributos) {
        this.atributos = new ArrayList<>();
        for (AtributoDeEtiqueta atributo : atributos) {
            this.atributos.add(atributo);
        }
    }

    private String crearTexto() {
        String cadenaTotal = " ";
        for (int i = 0; i < cadenaDeTexto.size(); i++) {
            if (i == 0) {
                String string = cadenaDeTexto.get(i);
                cadenaTotal += string;
            } else {
                String string = cadenaDeTexto.get(i);
                cadenaTotal += " " + string;
            }

        }
        return cadenaTotal;
    }

    public String getTipoDeEtiqueta() {
        return tipoDeEtiqueta;
    }

    public void setTipoDeEtiqueta(String tipoDeEtiqueta) {
        this.tipoDeEtiqueta = tipoDeEtiqueta;
    }

    public ArrayList<AtributoDeEtiqueta> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<AtributoDeEtiqueta> atributos) {
        this.atributos = atributos;
    }

    public ArrayList<String> getCadenaDeTexto() {
        return cadenaDeTexto;
    }

    public void setCadenaDeTexto(ArrayList<String> cadenaDeTexto) {
        this.cadenaDeTexto = cadenaDeTexto;
    }

}
