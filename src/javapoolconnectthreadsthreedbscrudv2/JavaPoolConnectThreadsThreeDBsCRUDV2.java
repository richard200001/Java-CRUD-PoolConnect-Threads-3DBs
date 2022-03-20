
package javapoolconnectthreadsthreedbscrudv2;

import controlador.ControladorCliente;
import modelo.ClienteCRUD;
import vista.ClienteVistaGUI;


public class JavaPoolConnectThreadsThreeDBsCRUDV2 {

    public static void main(String[] args) {
       ClienteVistaGUI vista = new ClienteVistaGUI();
        ClienteCRUD modelo = new ClienteCRUD();
        ControladorCliente controlador = new ControladorCliente(vista,modelo);
    }
    
}
