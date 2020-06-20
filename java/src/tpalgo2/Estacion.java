package tpalgo2;

import java.util.ArrayList;
import java.util.List;

public class Estacion extends Operador {

	public Estacion(String idOperador) {
		this.idOperador = idOperador;

	}

	@Override
	public String getID() {
		return this.idOperador;
	}

	@Override
	public List<Conexion> getConexiones() {
		return this.conexiones;
	}

	@Override
	public void agregarConexion(Conexion conexion) {
		if (this.conexiones == null) {
			this.conexiones = new ArrayList<>();
		}
		this.conexiones.add(conexion);

	}

	@Override
	public void actualizarConexion(Conexion conexion) {
		// Buscar la conexion existente y actualizar su estado
	}
	

	@Override
	public void recibir(Mensaje mensaje) {
		// TODO Completar esto con condiciones TP pagina 4 / 5
		// Si mensaje no es Ping, Info o Datos, mostrar error

	}

	@Override
	public void enviar(Mensaje mensaje) {
		// TODO: Si mensaje no es Ping, Info o Datos, mostrar error
		// TODO Completar esto con condiciones TP pagina 4 / 5
		
		for (Conexion conexion : conexiones) {
			System.out.println("ESTACION - Enviando Mensaje Desde:" + this.getID() + " hasta: " + conexion.getDestino().getID());
			conexion.getDestino().enviar(mensaje);
		}
		

	}

	public void reenviar(Mensaje mensaje) {
// No está claro en el enunciado si se puede reenviar o no
	}


	@Override
	public String toString() {
		return "Estacion [ID=" + this.idOperador + "]\n - Conexiones: [ " + this.conexiones + "]\n";
	}
	
}
