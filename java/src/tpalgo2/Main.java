package tpalgo2;

public class Main {

	public static RedSatelital getRed() {
		// Satelites C1, C2, C3 = Orbita GEO
		Operador c1 = new Operador("C1");
		Operador c2 = new Operador("C2");
		Operador c3 = new Operador("C3");

		// Satelites
		// M1 = Orbita Baja (LEO)
		Operador m1 = new Operador("M1");
		// M2 = Orbita Media (MEO)
		Operador m2 = new Operador("M2");
		// M3 = Orbita Baja (LEO)
		Operador m3 = new Operador("M3");
		// M4 = Orbita Media (MEO)
		Operador m4 = new Operador("M4");

		// Estaciones terrestres
		Operador e1 = new Operador("E1");
		Operador e2 = new Operador("E2");
		Operador e3 = new Operador("E3");
		Operador e4 = new Operador("E4");

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
	}

}
