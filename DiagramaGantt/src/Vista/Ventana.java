/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control;
import Logica.Cola;
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

        //setExtendedState(MAXIMIZED_BOTH);
        setSize(dimensionPantalla().width-40, dimensionPantalla().height-40);
        setLocationRelativeTo(null);
        setLayout(null);

        inicializarPaneles();
        inicializarPanelDatos();
        inicializarPanelTabla();
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

        panelGrafica.setBounds(0, getHeight() / 2, getWidth() - 20, getHeight() / 2 - 40);

    }

    private JLabel jlProceso;
    private JLabel jlLlegada;
    private JLabel jlRafaga;

    private JTextField jtfProceso;
    private JTextField jtfEspera;
    private JTextField jtfRafaga;

    private JButton btnRegistrar;
    
    private JTable tablaRegistros;
    
    private void inicializarPanelDatos() {

        jlProceso = new JLabel("Proceso:");
        jlLlegada = new JLabel("T. Llegada:");
        jlRafaga = new JLabel("Rafaga:");

        jtfProceso = new JTextField(10);
        jtfEspera = new JTextField(10);
        jtfRafaga = new JTextField(10);

        panelDatos.add(jlProceso);
        panelDatos.add(jtfProceso);
        panelDatos.add(jlLlegada);
        panelDatos.add(jtfEspera);
        panelDatos.add(jlRafaga);
        panelDatos.add(jtfRafaga);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(c);        

        panelDatos.add(btnRegistrar);
        
        tablaRegistros = new JTable(new ModeloTabla());
        JScrollPane scroll = new JScrollPane(tablaRegistros);
        panelDatos.add(scroll);
        

    }

    private JTable tabla;
    private JButton btnGraficar;

    private void inicializarPanelTabla() {
        tabla = new JTable(new ModeloTabla());
        JScrollPane scroll = new JScrollPane(tabla);

        btnGraficar = new JButton("Graficar");
        btnGraficar.addActionListener(c);

        panelTabla.add(scroll);
        panelTabla.add(btnGraficar);
    }

    private Lienzo diagramaGantt;

    public void inicializarPanelGrafico() {
        diagramaGantt = new Lienzo();
        panelGrafica.add(diagramaGantt);

    }

    public Lienzo getDiagramaGantt() {
        return diagramaGantt;
    }
    
    public ModeloTabla obtenerModeloTabla() {
        return (ModeloTabla) tabla.getModel();
    }
    public ModeloTabla obtenerModeloTablaRegistro() {
        return (ModeloTabla) tablaRegistros.getModel();
    }

    private Dimension dimensionPantalla() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return d;
    }

    public void limpiarCampos() {
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

    public JButton getBtnGraficar() {
        return btnGraficar;
    }

}
