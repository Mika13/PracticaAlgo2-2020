package tpalgo2;

import java.util.ArrayList;
import java.util.List;

public class Operador {

	private String idOperador;
	private List<Conexion> conexiones;
	private List<Mensaje> consola;

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

	public void actualizarConexion(Mensaje mensaje) {

		// ToDO: Actualizar el listado de Conexiones
		// Ver si el mensaje es de Tipo PING

	}

	public void enviarMensaje(Mensaje mensaje) {

	}

	public void recibirMensaje(Mensaje mensaje) {

	}

	public void reenviarMensaje(Mensaje mensaje) {

	}

	public List<Mensaje> getConsola() {
		return consola;
	}

	public void setConsola(List<Mensaje> consola) {
		this.consola = consola;
	}

	@Override
	public String toString() {
		return "\n \tNodo [id=" + this.idOperador + ", Conexiones=" + this.conexiones + "]";
	}

}