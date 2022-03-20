package modelo;

public class Cliente {
    private long id;
    private String nombre;
    
    public Cliente(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return id+"\t"+nombre+"\t";
    }
}
