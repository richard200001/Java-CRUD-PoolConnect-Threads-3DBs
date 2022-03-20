package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteCRUD {
    private PreparedStatement pst;
    public List<String> salida=new ArrayList<>();
    public ClienteCRUD(){
        Connection connect = null;
    }
       
    public void ingresarRegistro(Cliente unCliente){
       
        String sql ="INSERT INTO cliente VALUES(?,?)";
        for (int i = 1; i <= 3; i++) {
        Connection connect = null;
            try{
                        Conexion.getDecidirDB(i);//decido a que base de datos conectarme
                        connect = Conexion.getInstance().getConnection();//me conecto a la base de datos
                        pst = connect.prepareStatement(sql);
                        pst.setLong(1,unCliente.getId());
                        pst.setString(2,unCliente.getNombre());
                        int rowsInserted = pst.executeUpdate();
                        if ( rowsInserted > 0) {
                            salida.add("Se ingresó el cliente: "+unCliente.getNombre()+" con exito");
                            System.out.println("añadiendo primer item");
                        }


            }catch(SQLException ex){
                salida.add("No se puedo ingresar el cliente: "+unCliente.getNombre()+ ex.getMessage());
                System.out.println("añadiendo primer item");
            }
        }
    }
    
    
    
    
    public List<Cliente> mostrarRegistros(int num){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY cc ASC";
        Connection connect = null;
        try{
            Conexion.getDecidirDB(num);
            connect = Conexion.getInstance().getConnection();
            pst = connect.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery(sql);
            while (resultado.next()){
                long id = resultado.getLong(1);
                String nombre = resultado.getString(2);
                lista.add(new Cliente(id,nombre));
            }
        }catch(SQLException ex)
        {
            System.out.println("No se pudo traer datos: "+ex);
        }
        return lista;
    }
    
    
    public List<Cliente> mostrarRegistroGlobal(){
           List<Integer> lista= new ArrayList<>();
           int cont=0;
       for (int i = 1; i <= 3; i++) {
            List<Cliente> cliente=mostrarRegistros(i);
           lista.add(cliente.size());
        }
            if(cont%3==0){
               return  mostrarRegistros(1);
            }
            if(lista.get(0)<lista.get(1)){
             return   mostrarRegistros(lista.get(1));
            }
            if(lista.get(2)<lista.get(1)){
             return   mostrarRegistros(lista.get(1));
            }
            if(lista.get(0)>lista.get(1)){
              return  mostrarRegistros(lista.get(0));
            }
            if(lista.get(0)>lista.get(2)){
              return  mostrarRegistros(lista.get(0));
            }
            if(lista.get(2)>lista.get(1)){
                return mostrarRegistros(lista.get(2));
            }
             if(lista.get(2)>lista.get(0)){
                return mostrarRegistros(lista.get(2));
            }
        return null;
    }
   
    public void actualizarRegistro(Cliente unCliente){
        
        String sql ="UPDATE cliente SET nombre=? WHERE cc=?";
        System.out.println("Actualizar");
        for (int i = 1; i <= 3; i++) {
        Connection connect = null;
            try{
                Conexion.getDecidirDB(i);
                connect = Conexion.getInstance().getConnection();
                pst = connect.prepareStatement(sql);
                pst.setString(1,unCliente.getNombre());
                pst.setLong(2,unCliente.getId());
                int rowsInserted = pst.executeUpdate();
                if ( rowsInserted > 0) {
                    salida.add("Actualización exitosa!");
                    System.out.println("Pasó por actualizar");
                }
            }catch(SQLException ex){
                salida.add("No se puedo actualizar: "+ ex.getMessage());
            }
        }
    }
    
   
    public void borrarRegistro(long id){
       
        
        String sql ="DELETE FROM cliente WHERE cc=?";
        for (int i = 1; i <= 3; i++) {
        Connection connect = null;
            try{

                    Conexion.getDecidirDB(i);
                    connect = Conexion.getInstance().getConnection();
                    pst = connect.prepareStatement(sql);
                    pst.setLong(1,id);
                    int rowsInserted = pst.executeUpdate();

                    if ( rowsInserted > 0) {
                        salida.add("Borrado exitoso!");
                        System.out.println("añadiendo primer item");
                    }


            }catch(SQLException ex){
                salida.add("No se pudo borrar: "+ ex.getMessage());
                System.out.println("añadiendo primer item");
            }
        }
    }
    
    
    public void observadorDeVariableSalida(){
            int cont=0;
            for (int i = 1; i <= 3; i++) {
            List<Cliente> cliente=mostrarRegistros(i);
           cont = cliente.size();
        }
            if(cont%3==0){
                
                System.out.println("pasó por el segundo condicional");
                JOptionPane.showMessageDialog(null, salida.get(0));
                 salida.removeAll(salida);
            }else{
                JOptionPane.showMessageDialog(null, salida.get(0)+" DB1");
                JOptionPane.showMessageDialog(null, salida.get(1)+" DB2");
                JOptionPane.showMessageDialog(null, salida.get(2)+" DB3");
            salida.removeAll(salida);
            }

    }
    
}
