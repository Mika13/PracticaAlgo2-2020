package tpalgo2;

import java.util.List;

public abstract class Operador implements Mensajeable {

	protected String idOperador;
	protected List<Conexion> conexiones;
	protected Consola consola;

	public abstract String getID();

	public abstract List<Conexion> getConexiones();

	public abstract void agregarConexion(Conexion conexion);

	public abstract void actualizarConexion(Conexion conexion);

}