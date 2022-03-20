package controlador;

import Thread.hiloActualizar1;
import Thread.hiloBorrar1;
import Thread.hiloCrear1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ClienteCRUD;
import vista.ClienteVistaGUI;

public class ControladorCliente implements ActionListener, ItemListener {
    ClienteVistaGUI vista;
    ClienteCRUD modelo;
    public hiloCrear1 hilo;
    public hiloBorrar1 hilo3;
    public hiloActualizar1 hilo5;
    
    public ControladorCliente(ClienteVistaGUI vista,ClienteCRUD modelo, hiloCrear1 hilo){
        this.vista = vista;
        this.modelo = modelo;
        this.hilo = hilo;
        vista.asignarEscuchas(this);
        vista.escuchaCoboBox(this);
    }

    public ControladorCliente(ClienteVistaGUI vista, ClienteCRUD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.hilo = hilo;
        vista.asignarEscuchas(this);
        vista.escuchaCoboBox(this);
    }

    

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getbIngresar())
        {
          
            try {
                vista.mostrarSalida1();
                hilo = new hiloCrear1();
                hilo.recibedatos(vista.getNombre(), Long.parseLong(vista.getcc()), modelo);
                hilo.start();
                sleep(2000);
                modelo.observadorDeVariableSalida();
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource() == vista.getbActu())
        {
           try {
                
                hilo5 = new hiloActualizar1();
                hilo5.recibedatos(vista.getNombre(), Long.parseLong(vista.getcc()), modelo);
                hilo5.start();
                sleep(2000);
                modelo.observadorDeVariableSalida();
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource() == vista.getbBorrar())
        {
          try{
                hilo3 = new hiloBorrar1();
                hilo3.recibedatos( Long.parseLong(vista.getcc()), modelo);
                hilo3.start();
                System.out.println("hice el primer hilo");
                sleep(1000);
                modelo.observadorDeVariableSalida();
                 } catch (InterruptedException ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource() == vista.getbMostrar())
        {
            vista.borrar();
            vista.mostrarCampos(modelo.mostrarRegistroGlobal());
        }
        if(ae.getSource() == vista.getBlimpiar())
        {
            vista.borrar();
        }
        if(ae.getSource() == vista.getBfiltro())
        {
           vista.borrar();
           vista.filtro(modelo.mostrarRegistroGlobal());
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == vista.getListaDesplegable()){
            
            String seleccionado=(String)vista.getListaDesplegable().getSelectedItem();
            System.out.println(seleccionado);
            vista.cambiarColorDePanel(vista.getpDatos(), vista.getlCc(), vista.getlNombre(), seleccionado, vista.getBfiltro(), vista.getBlimpiar(),vista.getbActu(),vista.getbBorrar(),vista.getbIngresar(),vista.getbMostrar(),vista.getListaDesplegable());
        }
    }
}
