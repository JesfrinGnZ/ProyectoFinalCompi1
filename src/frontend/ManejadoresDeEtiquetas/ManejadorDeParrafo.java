/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.ManejadoresDeEtiquetas;

import backend.Etiquetas.AtributoDeEtiqueta;
import backend.Etiquetas.Etiqueta;
import frontend.manejadoresDeGui.ManejadorDeTextArea;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeParrafo {

    private Etiqueta etiqueta;

    public ManejadorDeParrafo(Etiqueta etiqueta, ManejadorDeTextArea manejador) {
        this.etiqueta = etiqueta;
    }

    public SimpleAttributeSet buscarAlineacion() {
        AtributoDeEtiqueta atributo = this.etiqueta.getAtributos().get(0);
        String alineacion = atributo.getValor().toLowerCase();
        SimpleAttributeSet conjuntoDeAtributos = new SimpleAttributeSet();
        switch (alineacion) {
            case "left":
                StyleConstants.setAlignment(conjuntoDeAtributos, StyleConstants.ALIGN_CENTER);
                break;
            case "right":
                StyleConstants.setAlignment(conjuntoDeAtributos, StyleConstants.ALIGN_RIGHT);
                break;
            case "justified":
                StyleConstants.setAlignment(conjuntoDeAtributos, StyleConstants.ALIGN_JUSTIFIED);
                break;
        }
        return conjuntoDeAtributos;
    }
}
