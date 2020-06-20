package tpalgo2;

public class Main {

	public static RedSatelital getRed() {
		// Satelites C1, C2, C3 = Orbita GEO
		SateliteComunicaciones c1 = new SateliteComunicaciones("C1");
		SateliteComunicaciones c2 = new SateliteComunicaciones("C2");
		SateliteComunicaciones c3 = new SateliteComunicaciones("C3");

		// Satelites
		// M1 = Orbita Baja (LEO)
		SateliteMetereologico m1 = new SateliteMetereologico("M1");
		// M2 = Orbita Media (MEO)
		SateliteMetereologico m2 = new SateliteMetereologico("M2");
		// M3 = Orbita Baja (LEO)
		SateliteMetereologico m3 = new SateliteMetereologico("M3");
		// M4 = Orbita Media (MEO)
		SateliteMetereologico m4 = new SateliteMetereologico("M4");

		// Estaciones terrestres
		Estacion e1 = new Estacion("E1");
		Estacion e2 = new Estacion("E2");
		Estacion e3 = new Estacion("E3");
		Estacion e4 = new Estacion("E4");

		c1.agregarConexion(new Conexion(c1, c2, 4000));
		c1.agregarConexion(new Conexion(c1, e1, 36000));
		c1.agregarConexion(new Conexion(c1, e2, 36000));

		c2.agregarConexion(new Conexion(c2, c1, 4000));
		c2.agregarConexion(new Conexion(c2, c3, 3000));
		c2.agregarConexion(new Conexion(c2, e2, 36000));
		c2.agregarConexion(new Conexion(c2, e3, 36000));

		c3.agregarConexion(new Conexion(c3, c2, 3000));
		c3.agregarConexion(new Conexion(c3, e4, 36000));

		m1.agregarConexion(new Conexion(m1, e1, 2000));

		m2.agregarConexion(new Conexion(m2, e2, 10000));

		m3.agregarConexion(new Conexion(m3, e2, 1500));
		m3.agregarConexion(new Conexion(m3, e3, 1500));

		m4.agregarConexion(new Conexion(m4, e3, 20000));
		m4.agregarConexion(new Conexion(m4, e4, 20000));

		e1.agregarConexion(new Conexion(e1, e2, 300));
		e1.agregarConexion(new Conexion(e1, m1, 2000));
		e1.agregarConexion(new Conexion(e1, c1, 36000));

		e2.agregarConexion(new Conexion(e2, e1, 300));
		e2.agregarConexion(new Conexion(e2, c1, 36000));
		e2.agregarConexion(new Conexion(e2, m2, 10000));
		e2.agregarConexion(new Conexion(e2, m3, 1500));

		e3.agregarConexion(new Conexion(e3, m3, 1500));
		e3.agregarConexion(new Conexion(e3, c2, 36000));
		e3.agregarConexion(new Conexion(e3, m4, 20000));

		e4.agregarConexion(new Conexion(e4, m4, 20000));
		e4.agregarConexion(new Conexion(e4, c3, 36000));

		RedSatelital graph = new RedSatelital();
		graph.addOperador(c1);
		graph.addOperador(c2);
		graph.addOperador(c3);

		graph.addOperador(m1);
		graph.addOperador(m2);
		graph.addOperador(m3);
		graph.addOperador(m4);

		graph.addOperador(e1);
		graph.addOperador(e2);
		graph.addOperador(e3);
		graph.addOperador(e4);

		return graph;
	}

	public static void main(String[] args) {
		// Creo grafo no dirigido
		RedSatelital redSatelital = getRed();
		System.out.println(redSatelital);

		// Operacion Ver Clima
		ClimaRequest climaReq = new ClimaRequest(0, "E1", "M3", "Temperatura");
		ClimaReply climaResp = redSatelital.getClima(climaReq);

	}

}
