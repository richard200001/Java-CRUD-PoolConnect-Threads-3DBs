package Thread;


import modelo.Cliente;
import modelo.ClienteCRUD;

public class hiloActualizar1 extends Thread {
    private ClienteCRUD modelo;
  
    private String nombre;
    private long cc;
    public hiloActualizar1() {
    }
  
    public hiloActualizar1(ClienteCRUD modelo) {
        this.modelo = modelo;
     
    }
    
    @Override
    public void run(){
    
        
       Cliente unCli= new Cliente(cc,nombre);
        modelo.actualizarRegistro(unCli);
     
        
    }


    public void recibedatos(String nombre, long cc,ClienteCRUD modelo){
        this.nombre=nombre;
        this.cc=cc;
        this.modelo=modelo;
    }
}

