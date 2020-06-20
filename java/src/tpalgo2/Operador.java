package tpalgo2;

import java.util.ArrayList;
import java.util.List;

public class Operador implements Pedido, Respuesta{

	private String idOperador;
	private List<Conexion> conexiones;
	private Consola consola;

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


	@Override
	public String toString() {
		return "\n \tNodo [id=" + this.idOperador + ", Conexiones=" + this.conexiones + "]";
	}

	@Override
	public void PingRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InfoRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PingReply() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InfoReply() {
		// TODO Auto-generated method stub
		
	}

}