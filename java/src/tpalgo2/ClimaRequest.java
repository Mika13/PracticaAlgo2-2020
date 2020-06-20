package tpalgo2;

public class ClimaRequest extends Mensaje {

	public ClimaRequest(int id, String idOperadorOrigen, String idOperadorDestino, String contenido) {

		this.id = id;
		this.idOperadorOrigen = idOperadorOrigen;
		this.idOperadorDestino = idOperadorDestino;
		
		// TODO: Validar los contenidos posibles ("Temperatura, Humedad, Nubosidad, Presion, Todas")
		this.contenido = contenido;

	}

}
