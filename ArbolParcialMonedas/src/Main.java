import java.util.ArrayList;
import java.util.List;

public class Main {

	public static boolean esJugadaValida(Jugada j, int pj1, int pj2) {

		if ((j.lanzamiento1.equalsIgnoreCase("CA") && j.lanzamiento2.equalsIgnoreCase("CA"))
				|| (j.lanzamiento1.equalsIgnoreCase("CE") && j.lanzamiento2.equalsIgnoreCase("CE"))) {
			pj1 = pj1 + 1;
			pj2 = pj2 - 1;
			if (pj2 < 0) {
				return false;
			} else {
				return true;
			}
		} else if ((j.lanzamiento1.equalsIgnoreCase("CA") && j.lanzamiento2.equalsIgnoreCase("CE"))
				|| (j.lanzamiento1.equalsIgnoreCase("CE") && j.lanzamiento2.equalsIgnoreCase("CA"))) {
			pj1 = pj1 - 1;
			pj2 = pj2 + 1;
			if (pj1 < 0) {
				return false;
			} else {
				return true;
			}
		}

		return false;

	}

	public static PartidoMoneda simularPartidos(int pj1, int pj2, int cantJMax, Jugada jugadaActual) {

		boolean esJValida = false;

		if (jugadaActual.nivel + 1 <= cantJMax) {

			List<PartidoMoneda> proximasJugadas = new ArrayList<PartidoMoneda>();

			// J1 - CA-CA
			Jugada j1_ca_ca = new Jugada("CA", "CA", jugadaActual.nivel + 1);
			// J1 - CA-CE
			Jugada j1_ca_ce = new Jugada("CA", "CE", jugadaActual.nivel + 1);
			// J1 - CE-CA
			Jugada j1_ce_ca = new Jugada("CE", "CA", jugadaActual.nivel + 1);
			// J1 - CE-CE
			Jugada j1_ce_ce = new Jugada("CE", "CE", jugadaActual.nivel + 1);

			esJValida = esJugadaValida(j1_ca_ca, pj1, pj2);
			// System.out.println("Jugada CA-CA es:" + esJValida + " - Nivel: " +
			// jugadaActual.nivel);
			if (esJValida) {
				PartidoMoneda pm_ca_ca = simularPartidos(pj1 + 1, pj2 - 1, cantJMax, j1_ca_ca);
				if (pm_ca_ca != null) {
					proximasJugadas.add(pm_ca_ca);
				}

			}

			esJValida = esJugadaValida(j1_ca_ce, pj1, pj2);
			// System.out.println("Jugada CA-CE es:" + esJValida + " - Nivel: " +
			// jugadaActual.nivel);
			if (esJValida) {
				PartidoMoneda pm_ca_ce = simularPartidos(pj1 - 1, pj2 + 1, cantJMax, j1_ca_ce);
				if (pm_ca_ce != null) {
					proximasJugadas.add(pm_ca_ce);
				}

			}

			esJValida = esJugadaValida(j1_ce_ca, pj1, pj2);
			// System.out.println("Jugada CE-CA es:" + esJValida + " - Nivel: " +
			// jugadaActual.nivel);
			if (esJValida) {
				PartidoMoneda pm_ce_ca = simularPartidos(pj1 - 1, pj2 + 1, cantJMax, j1_ce_ca);
				if (pm_ce_ca != null) {
					proximasJugadas.add(pm_ce_ca);
				}

			}

			esJValida = esJugadaValida(j1_ce_ce, pj1, pj2);
			// System.out.println("Jugada CE-CE es:" + esJValida + " - Nivel: " +
			// jugadaActual.nivel);
			if (esJValida) {
				PartidoMoneda pm_ce_ce = simularPartidos(pj1 + 1, pj2 - 1, cantJMax, j1_ce_ce);
				if (pm_ce_ce != null) {
					proximasJugadas.add(pm_ce_ce);
				}

			}

			PartidoMoneda pm1 = new PartidoMoneda(pj1, pj2, jugadaActual, proximasJugadas);

			return pm1;

		} else {
			return null;
		}

	}

	public static void empatesPosibles(PartidoMoneda pm, List<String> lempates) {

		List<String> lparcial = new ArrayList<String>();

		lempates.clear();
		lparcial.clear();

		empatesPosibles2(pm, lparcial, lempates);

		lparcial.clear(); // Destruir para liberar memoria

	}

	public static void empatesPosibles2(PartidoMoneda pm, List<String> lparcial, List<String> lempates) {

		List<PartidoMoneda> proxAux = new ArrayList<PartidoMoneda>();
		PartidoMoneda pmHead;
		
		List<String> lactual = new ArrayList<String>();
		String jugadaTexto;

		if (pm != null) {
			if (pm.jugadas.size() == 0) {

				if (pm.puntosJ1 == pm.puntosJ2) {

					lactual.addAll(lparcial);

					lactual.add("Resultado Final: Nivel " + pm.j.nivel + " - Lanzamiento 1: " + pm.j.lanzamiento1
							+ " - Lanzamiento 2: " + pm.j.lanzamiento2 + " - Puntos J1:" + pm.puntosJ1 + " - Puntos J2:"
							+ pm.puntosJ2);

					lempates.addAll(lactual);

				}

			}

			proxAux.addAll(pm.jugadas);

			while (proxAux.size() > 0) {

				pmHead = proxAux.get(0);

				jugadaTexto = "Nivel " + pmHead.j.nivel + " - Lanzamiento 1: " + pmHead.j.lanzamiento1 + " - Lanzamiento 2: "
						+ pmHead.j.lanzamiento2 + " - Puntos J1:" + pmHead.puntosJ1 + " - Puntos J2:" + pmHead.puntosJ2;

				
				lactual.addAll(lparcial);
				lactual.add(jugadaTexto);
				
				// Recursividad
				empatesPosibles2(pmHead, lactual, lempates);

				proxAux.remove(0); // tail
				
				lactual.clear();

			}

		}



	}

	public static void main(String[] args) {

		Jugada jugadaActual = new Jugada("", "", 0);
		PartidoMoneda arbol = simularPartidos(1, 1, 3, jugadaActual);

		List<String> lempates = new ArrayList<String>();

		empatesPosibles(arbol, lempates);

		System.out.println("Ramas");

		for (String rama : lempates) {

			System.out.println(rama);

		}

	}

}
