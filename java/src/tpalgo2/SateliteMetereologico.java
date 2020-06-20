package tpalgo2;

import java.util.ArrayList;
import java.util.List;

public class SateliteMetereologico extends Satelite {
	public SateliteMetereologico(String idOperador) {
		this.idOperador = idOperador;

	}

	@Override
	public void recibir(Mensaje mensaje) {
		//TODO Completar esto con condiciones TP pagina 4 / 5
	}

	@Override
	public void enviar(Mensaje mensaje) {
		// TODO: Falta validar el tipo de mensaje
		for (Conexion conexion : conexiones) {
			System.out.println("SAT MET - Enviando Mensaje Desde:" + this.getID() + " hasta: " + conexion.getDestino().getID());
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
		return "Satelite Metereologico [ID=" + this.idOperador + "]\n - Conexiones: [ " + this.conexiones + "]\n";
	}

}
