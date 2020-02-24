/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.print.DocFlavor;
import javax.swing.JTable;
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

        String[] datos = {"a", "1", "0", "3", "2", "4", "6"};
        
        for (int i = 0; i < 100; i++) {
            addRow(datos);
        }

    }

}
