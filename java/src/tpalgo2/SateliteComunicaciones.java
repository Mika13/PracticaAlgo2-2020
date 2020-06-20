package tpalgo2;

import java.util.ArrayList;
import java.util.List;

public class SateliteComunicaciones extends Satelite {
	private String Orbita;
	private String Tipo;

	public SateliteComunicaciones(String idOperador) {
		this.idOperador = idOperador;

	}

	@Override
	public void recibir(Mensaje mensaje) {
		// TODO Completar esto con condiciones TP pagina 4 / 5
		
		// Agrego mensaje a consola
		this.consola.agregarMensaje(mensaje);
		// Si el mensaje es para mi, dependiendo el tipo de mensaje ver que hacer
		if (mensaje.idOperadorDestino == this.idOperador) {
			// El mensaje es para mi
			
		} else {
			// El mensaje es para otro
		}
	}

	@Override
	public void enviar(Mensaje mensaje) {
		// TODO: Falta validar el tipo de mensaje
		
		for (Conexion conexion : conexiones) {
			System.out.println("SAT COM - Enviando Mensaje Desde:" + this.getID() + " hasta: " + conexion.getDestino().getID());
			conexion.getDestino().enviar(mensaje);
		}
		
		
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
		// TODO Recorrer el listado de conexiones y actualizar el estado

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
	public String toString() {
		return "Satelite de Comunicaciones [ID=" + this.idOperador + "]\n - Conexiones: [ " + this.conexiones + "]\n";
	}
	
}
