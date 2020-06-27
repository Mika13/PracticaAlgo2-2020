import java.util.ArrayList;
import java.util.List;

public class Main {

	public static Contagios generarArbol() {

		Paciente pac1 = new Paciente(1001, 10, "Pac 1", 30, 3);
		Paciente pac2 = new Paciente(1002, 9, "Pac 2", 70, 3);
		Paciente pac3 = new Paciente(1003, 8, "Pac 3", 65, 1);
		Paciente pac4 = new Paciente(1004, 7, "Pac 4", 65, 1);
		Paciente pac5 = new Paciente(1005, 6, "Pac 5", 80, 2);
		Paciente pac6 = new Paciente(1006, 5, "Pac 6", 85, 2);
		Paciente pac7 = new Paciente(1007, 40, "Pac 7", 85, 2);

		List<Contagios> listaPac3 = new ArrayList<Contagios>();
		List<Contagios> listaPac4 = new ArrayList<Contagios>();
		List<Contagios> listaPac5 = new ArrayList<Contagios>();
		List<Contagios> listaPac6 = new ArrayList<Contagios>();
		List<Contagios> listaPac7 = new ArrayList<Contagios>();

		Contagios cP3 = new Contagios(pac3, listaPac3);
		Contagios cP4 = new Contagios(pac4, listaPac4);
		Contagios cP5 = new Contagios(pac5, listaPac5);
		Contagios cP6 = new Contagios(pac6, listaPac6);
		Contagios cP7 = new Contagios(pac7, listaPac7);

		List<Contagios> listaPac2 = new ArrayList<Contagios>();
		listaPac2.add(cP5);
		listaPac2.add(cP6);
		listaPac2.add(cP7);

		Contagios cP2 = new Contagios(pac2, listaPac2);

		List<Contagios> listaPac1 = new ArrayList<Contagios>();
		listaPac1.add(cP2);
		listaPac1.add(cP3);
		listaPac1.add(cP4);

		Contagios cont1 = new Contagios(pac1, listaPac1);

		return cont1;

	}

	public static void main(String[] args) {
		System.out.println("*** Inicio de Ejecucion ***");

		/*
		 * Arbol de Ejemplo
		 * 
		 * 
		 * 1 / | \ 2 3 4 / | \ 5 6 7
		 */
		// ----------------------------------------------------------------------------------
		// Arbol de Contagios
		// ----------------------------------------------------------------------------------

		Contagios cont1 = generarArbol();

		// ----------------------------------------------------------------------------------
		// Punto 1 = Alta Pacientes
		// ----------------------------------------------------------------------------------

		List<Paciente> pacAlta = new ArrayList<Paciente>();
		altaPacientes(cont1, pacAlta);

		System.out.println("*** Alta Pacientes ***");
		for (int i = 0; i < pacAlta.size(); i++) {
			System.out.println(pacAlta.get(i).nombreyApp);
		}

		// ----------------------------------------------------------------------------------
		// Punto 2 - Validar Dias
		// ----------------------------------------------------------------------------------
		cont1 = generarArbol();
		System.out.println("*** Validar Dias***");
		System.out.println(validarDias(cont1));

		// ----------------------------------------------------------------------------------
		// Punto 3 - Contagios Riesgo
		// ----------------------------------------------------------------------------------
		cont1 = generarArbol();
		System.out.println("*** Contagios Riesgo***");
		System.out.println(contagiosRiesgo(cont1, 1002));

		// ----------------------------------------------------------------------------------
		// Punto 4 - Zonas de Riesgo
		// ----------------------------------------------------------------------------------
		cont1 = generarArbol();
		List<ZonaCantidad> listaZonaCant = new ArrayList<ZonaCantidad>();

		for (int i = 0; i < 11; i++) {
			ZonaCantidad aux = new ZonaCantidad(i, 0);
			listaZonaCant.add(aux);
		}

		cont1 = generarArbol();
		zonasRiesgo(cont1, listaZonaCant);

		// Ordenar de Mayor a Menor
		ZonaCantidad max1 = new ZonaCantidad(0, 0);
		ZonaCantidad max2 = new ZonaCantidad(0, 0);
		ZonaCantidad max3 = new ZonaCantidad(0, 0);

		for (int i = 0; i < listaZonaCant.size(); i++) {

			if (listaZonaCant.get(i).cantidadPR > max1.cantidadPR) {

				if (max2.cantidadPR > max3.cantidadPR) {
					max3 = max2;
				}

				max2 = max1;
				max1 = listaZonaCant.get(i);

			} else {

				if (listaZonaCant.get(i).cantidadPR > max2.cantidadPR) {

					max3 = max2;
					max2 = listaZonaCant.get(i);

				} else {

					if (listaZonaCant.get(i).cantidadPR > max3.cantidadPR) {

						max3 = listaZonaCant.get(i);

					}

				}

			}

		}

		System.out.println("Maximo 1: Zona " + max1.zona + " - Cantidad: " + max1.cantidadPR);
		System.out.println("Maximo 2: Zona " + max2.zona + " - Cantidad: " + max2.cantidadPR);
		System.out.println("Maximo 3: Zona " + max3.zona + " - Cantidad: " + max3.cantidadPR);

		// ----------------------------------------------------------------------------------
		// Imprimo la lista de zonas completa
		// ----------------------------------------------------------------------------------

		for (int i = 0; i < 10; i++) {
			System.out.println("Zona: " + listaZonaCant.get(i).zona + " - Cantidad:" + listaZonaCant.get(i).cantidadPR);
		}

		// ----------------------------------------------------------------------------------
		// --- OTRA FORMA DE HACER LO MISMO
		// ----------------------------------------------------------------------------------
		// Maximo de lista usando recursividad
		// ----------------------------------------------------------------------------------

		ZonaCantidad maxima = new ZonaCantidad(0, 0);
		List<ZonaCantidad> listAux1 = new ArrayList<ZonaCantidad>();
		List<ZonaCantidad> listAux2 = new ArrayList<ZonaCantidad>();

		listAux1.addAll(listaZonaCant);
		listAux2.addAll(listaZonaCant);

		maxima = maximo(listaZonaCant);

		maxima.zona = maxima.zona;
		maxima.cantidadPR = maxima.cantidadPR;

		System.out.println("1er Maximo (Nuevo): Zona " + maxima.zona + " - Cantidad: " + maxima.cantidadPR);

		listAux1.remove(maxima);
		// Borro ese maximo de esta lista aux tambien!
		listAux2.remove(maxima);
		maxima = maximo(listAux1);

		maxima.zona = maxima.zona;
		maxima.cantidadPR = maxima.cantidadPR;

		System.out.println("2do Maximo (Nuevo): Zona " + maxima.zona + " - Cantidad: " + maxima.cantidadPR);

		listAux2.remove(maxima);

		maxima = maximo(listAux2);

		maxima.zona = maxima.zona;
		maxima.cantidadPR = maxima.cantidadPR;

		System.out.println("3er Maximo (Nuevo): Zona " + maxima.zona + " - Cantidad: " + maxima.cantidadPR);

	}

	// Recorre POST-ORDER (Profundidad)
	// La lista pasa por referencia en java
	public static void altaPacientes(Contagios cont1, List<Paciente> pacAlta) {

		List<Contagios> ts = new ArrayList<Contagios>();
		Contagios t2;
		List<Paciente> ys = new ArrayList<Paciente>();

		pacAlta.clear();

		ts = cont1.contagiosSuc;

		while (ts.size() > 0) {
			t2 = ts.get(0);
			ts.remove(0);
			altaPacientes(t2, ys);
			pacAlta.addAll(ys);
			ys.clear();
		}

		if (cont1.pac.diasContagio >= 0) {
			pacAlta.add(cont1.pac);
		}

	}

	/*
	 * /// Recorre primero en profundidad, luego hacia derecha (PRE-ORDER) public
	 * static void altaPacientes(Contagios cont1, List<Paciente> pacAlta) {
	 * 
	 * Paciente pac_aux; Contagios co_aux; List<Contagios> prox_aux = new
	 * ArrayList<Contagios>();
	 * 
	 * if (cont1.pac.diasContagio >= 0) { pac_aux = cont1.pac; pacAlta.add(pac_aux);
	 * }
	 * 
	 * 
	 * prox_aux = cont1.contagiosSuc;
	 * 
	 * while (prox_aux.size() > 0) { co_aux = prox_aux.get(0); altaPacientes(co_aux,
	 * pacAlta); prox_aux.remove(0);
	 * 
	 * }
	 * 
	 * }
	 */

	public static boolean validarDias(Contagios cont1) {

		return validarDias1(cont1.contagiosSuc, cont1.pac.diasContagio);

	}

	public static boolean validarDias1(List<Contagios> contagiosSuc, int diasPadre) {

		List<Contagios> ts = new ArrayList<Contagios>();
		Contagios t2;

		// Copia de listas
		ts = contagiosSuc;

		boolean resultadoAux = true;

		while (ts.size() > 0) {
			t2 = ts.get(0); // Cabeza -> T2
			ts.remove(0); // Cola TS
			System.out.println("Validar dias de: " + t2.pac.nombreyApp + " - Dias Padre: " + diasPadre);
			resultadoAux = validarDias1(t2.contagiosSuc, t2.pac.diasContagio);

			if (t2.pac.diasContagio >= diasPadre && resultadoAux) {
				resultadoAux = true;
			} else {
				resultadoAux = false;
			}

		}

		// Lista vacia es verdadero
		return resultadoAux;

	}

	public static int contagiosRiesgo(Contagios cont1, int historiaClinica) {

		// Recorrer arbol hasta encontrar Nodo
		Contagios cP = encontrarPaciente(cont1, historiaClinica);
		System.out.println(cP.pac.nombreyApp);

		// Recorrer subarbol y verificar que edad sea mayor a 65, agregando 1 al

		int cantidadContagios = contagiosRiesgo2(cP);

		if (cP.pac.edad >= 65) {
			cantidadContagios = cantidadContagios - 1;
		}

		return cantidadContagios;

	}

	public static Contagios encontrarPaciente(Contagios cont1, int hc) {

		List<Contagios> ts = new ArrayList<Contagios>();
		Contagios t2;

		if (cont1.pac.nroHistoriaClinica == hc) {
			System.out.println("El paciente es: " + cont1.pac.nombreyApp);
			return cont1;
		} else {

			ts = cont1.contagiosSuc;

			while (ts.size() > 0) {
				t2 = ts.get(0);
				ts.remove(0);
				return encontrarPaciente(t2, hc);

			}

		}
		// Para el caso de nodo vacio
		System.out.println("No encontre paciente retorno nulo! ");
		return null;

	}

	public static int contagiosRiesgo2(Contagios cont1) {

		List<Contagios> ts = new ArrayList<Contagios>();
		Contagios t2;
		int contAux = 0;

		if (cont1.pac.edad >= 65) {
			contAux = contAux + 1;
		}

		ts = cont1.contagiosSuc;

		while (ts.size() > 0) {
			t2 = ts.get(0);
			ts.remove(0);
			contAux = contAux + contagiosRiesgo2(t2);

		}

		return contAux;

	}

	public static void zonasRiesgo(Contagios cont1, List<ZonaCantidad> zonaCant) {

		List<Contagios> ts = new ArrayList<Contagios>();
		Contagios t2;

		if (cont1.pac.edad >= 65) {

			ZonaCantidad aux;

			aux = zonaCant.get(cont1.pac.zonaResidencia);

			aux.cantidadPR = aux.cantidadPR + 1;

			// Modifico la lista con el valor actualizado
			zonaCant.set(cont1.pac.zonaResidencia, aux);

		}

		ts = cont1.contagiosSuc;

		while (ts.size() > 0) {
			t2 = ts.get(0);
			ts.remove(0);
			zonasRiesgo(t2, zonaCant);

		}

	}

	public static ZonaCantidad maximo(List<ZonaCantidad> zonaCant) {

		zonaCant.remove(0);

		ZonaCantidad x = maximo2(zonaCant, zonaCant.get(0));

		return x;

	}

	public static ZonaCantidad maximo2(List<ZonaCantidad> xs, ZonaCantidad x) {

		ZonaCantidad y;

		if (xs.size() == 0) {
			return x;
		} else {

			y = xs.get(0);
			xs.remove(0);

			if (x.cantidadPR > y.cantidadPR) {
				return maximo2(xs, x);
			} else {
				return maximo2(xs, y);
			}

		}

	}

}