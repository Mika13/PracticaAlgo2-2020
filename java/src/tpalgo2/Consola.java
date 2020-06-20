package tpalgo2;

import java.util.List;

public class Consola {

	private List<Mensaje> mensajes;

	public void borrarConsola() {
		this.mensajes.clear();
	}
	
	public void agregarMensaje(Mensaje msj) {
		this.mensajes.add(msj);
	}
	
	public void imprimirConsola() {
		// Recorrer lista e imprimir
	}

}
