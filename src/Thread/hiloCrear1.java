package Thread;

import modelo.Cliente;
import modelo.ClienteCRUD;


public class hiloCrear1 extends Thread {
   private ClienteCRUD modelo;
  
    private String nombre;
    private long cc;

    public hiloCrear1() {
    }

    public ClienteCRUD getModelo() {
        return modelo;
    }

    public void setModelo(ClienteCRUD modelo) {
        this.modelo = modelo;
    }

  
    public hiloCrear1(ClienteCRUD modelo) {
        this.modelo = modelo;
     
    }
    
    @Override
    public void run(){
    
        Cliente unCli= new Cliente(cc,nombre);
        modelo.ingresarRegistro(unCli);
       
        
    }
    
    public void recibedatos(String nombre, long cc,ClienteCRUD modelo){
        this.nombre=nombre;
        this.cc=cc;
        this.modelo=modelo;
    }
}
