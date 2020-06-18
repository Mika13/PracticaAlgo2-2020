package tpalgo2;

import java.util.ArrayList;
import java.util.List;

public class Operador {
	
    private String idOperador;
    private List<Conexion> conexiones;
 
    public Operador(String idOperador) {
        this.idOperador = idOperador;
    }
 
    public String getIdOperador() {
        return this.idOperador;
    }
 
    
 
    public List<Conexion> getConexiones() {
        return this.conexiones;
    }
 
    public void agregarConexion(Conexion conexion) {
        if (this.conexiones == null) {
            this.conexiones = new ArrayList<>();
        }
        this.conexiones.add(conexion);
    }
 
    @Override
    public String toString() {
        return "\n \tNodo [id=" + this.idOperador + ", Conexiones=" + this.conexiones + "]";
    }
}