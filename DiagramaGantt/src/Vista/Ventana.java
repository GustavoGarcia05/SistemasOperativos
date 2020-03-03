/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control;
import Modelo.ModeloTabla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame implements Runnable {

    private Control c;
    private Thread hilo;

    public Ventana() {
        c = new Control(this);
        hilo = new Thread(this, "Paneles");

        setExtendedState(MAXIMIZED_BOTH);
        setSize(dimensionPantalla().width, dimensionPantalla().height);
        setLocationRelativeTo(null);
        setLayout(null);

        inicializarPaneles();
        inicializarPanelDatos();
        inicializarTabla();
        
        inicializarPanelGrafico();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        hilo.start();
    }

    private JPanel panelTabla;
    private JPanel panelDatos;
    private ScrollPane panelGrafica;

    private void inicializarPaneles() {


        panelDatos = new JPanel();
        panelTabla = new JPanel();
        panelGrafica = new ScrollPane();
     

        actualizarTamanioPaneles();

        panelDatos.setBackground(Color.GRAY);
        panelTabla.setBackground(Color.darkGray);
        panelGrafica.setBackground(Color.lightGray);

        add(panelDatos);
        add(panelTabla);
        add(panelGrafica);
        

    }

    private void actualizarTamanioPaneles() {

        panelDatos.setBounds(0, 0, getWidth() / 2, getHeight() / 2);
        
        panelTabla.setBounds(getWidth() / 2, 0, getWidth() / 2, getHeight() / 2);

        panelGrafica.setBounds(0, getHeight() / 2, getWidth(), getHeight() / 2);

    }
    
    private JLabel jlProceso;
    private JLabel jlEspera;
    private JLabel jlRafaga;
    
    private JTextField jtfProceso;
    private JTextField jtfEspera;
    private JTextField jtfRafaga;
    
    private JButton btnRegistrar;
    
    private void inicializarPanelDatos(){
        
        jlProceso = new JLabel("Proceso:");
        jlEspera = new JLabel("T. Espera:");
        jlRafaga = new JLabel("Rafaga:");
        
        jtfProceso = new JTextField(10);
        jtfEspera = new JTextField(10);
        jtfRafaga = new JTextField(10);
        
        panelDatos.add(jlProceso);
        panelDatos.add(jtfProceso);
        panelDatos.add(jlEspera);
        panelDatos.add(jtfEspera);
        panelDatos.add(jlRafaga);
        panelDatos.add(jtfRafaga);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(c);
        
        panelDatos.add(btnRegistrar);
    }
    
    private JTable tabla;
    
    private void inicializarTabla(){
        tabla = new JTable(new ModeloTabla());
        JScrollPane scroll= new JScrollPane(tabla);
        panelTabla.add(scroll);
    }
    
    
    private void inicializarPanelGrafico(){

        panelGrafica.add(new Lienzo());
        
    }
   
    public ModeloTabla obtenerModeloTabla(){
        return (ModeloTabla) tabla.getModel();
    }
    private Dimension dimensionPantalla() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return d;
    }
    
    public void limpiarCampos(){
        jtfProceso.setText("");
        jtfRafaga.setText("");
        jtfEspera.setText("");
    }

    @Override
    public void run() {
        while (true) {
             actualizarTamanioPaneles();
             
             
        }
    }

    public JTextField getJtfProceso() {
        return jtfProceso;
    }

    public JTextField getJtfEspera() {
        return jtfEspera;
    }

    public JTextField getJtfRafaga() {
        return jtfRafaga;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }


    
}