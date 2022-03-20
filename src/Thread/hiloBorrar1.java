package Thread;


import modelo.ClienteCRUD;

public class hiloBorrar1 extends Thread {
   private ClienteCRUD modelo;
    private long cc;

    public hiloBorrar1() {
    }

    public ClienteCRUD getModelo() {
        return modelo;
    }

    public void setModelo(ClienteCRUD modelo) {
        this.modelo = modelo;
    }

  
    public hiloBorrar1(ClienteCRUD modelo) {
        this.modelo = modelo;
     
    }
    
    @Override
    public void run(){
    
        
        modelo.borrarRegistro(cc);
     
        
    }


    public void recibedatos(long cc, ClienteCRUD modelo) {
          this.cc=cc;
        this.modelo=modelo;
    }
}


