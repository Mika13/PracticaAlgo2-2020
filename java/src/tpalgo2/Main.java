package tpalgo2;

public class Main {
	
	//Prueba

    public static RedSatelital getRed() {
    	// Satelites C1, C2, C3 = Orbita GEO
        Operador c1 = new Operador(1);
        Operador c2 = new Operador(2);
        Operador c3 = new Operador(3);
        
        // Satelites 
        // M1 = Orbita Baja (LEO)
        Operador m1 = new Operador(4);
        // M2 = Orbita Media (MEO)
        Operador m2 = new Operador(5);
        // M3 = Orbita Baja (LEO)
        Operador m3 = new Operador(6);
        // M4 = Orbita Media (MEO)        
        Operador m4 = new Operador(7);
        
        // Estaciones terrestres
        Operador e1 = new Operador(8);
        Operador e2 = new Operador(9);
        Operador e3 = new Operador(10);
        Operador e4 = new Operador(11);
        
        
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
        
        e2.agregarConexion(new Conexion(e2, e1, 300));
        e2.agregarConexion(new Conexion(e2, e3, 200));
        
        
        e3.agregarConexion(new Conexion(e3, e2, 200));
        e3.agregarConexion(new Conexion(e3, e4, 400));
        
        e4.agregarConexion(new Conexion(e4, e3, 400));
        
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
    	RedSatelital redSatelital = getRed();
        System.out.println(redSatelital);
    }
	
	
	
}
