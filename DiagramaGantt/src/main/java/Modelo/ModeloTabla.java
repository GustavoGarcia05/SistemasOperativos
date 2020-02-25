/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logica.Nodo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class ModeloTabla extends DefaultTableModel {

    private String[] columnas = {"Proceso", "T. Llegada", "T. Rafaga", "T. Comienzo", "T. Final", "T. Retorno", "T. Espera"};

    public ModeloTabla() {
        for (int i = 0; i < columnas.length; i++) {
            addColumn(columnas[i]);
        }


    }
    
    public void agregarFila(Nodo n){
        String[] datos= {n.nombre, n.tLlegada+"",n.tRafaga+"",n.tComienzo+"",n.tFinal+"",n.tRetorno+"",n.tEspera+""};
        addRow(datos);
    }

}
