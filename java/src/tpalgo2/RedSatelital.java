package tpalgo2;

import java.util.ArrayList;
import java.util.List;

public class RedSatelital {

	private List<Operador> operadores;

	public void addOperador(Operador node) {
		if (operadores == null) {
			operadores = new ArrayList<>();
		}
		operadores.add(node);
	}

	public List<Operador> getOperadors() {
		return operadores;
	}

	@Override
	public String toString() {
		return "Red Satelital [operadores=" + operadores + "]";
	}

	
	
	public ClimaReply getClima(ClimaRequest mensaje) {
		
		// TODO:
		// Recorrer grafo buscando Operador = Mensaje.idOperadorOrigen
		// Una vez encontrado, hacer operador.enviar(mensaje)
		
		return null;
		
	}

	
}