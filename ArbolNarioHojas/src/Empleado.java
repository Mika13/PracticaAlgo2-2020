import java.util.List;

public class Empleado {

	double salarioBasico;
	List<Venta> ventas;
	String id;
	String nombre;

	boolean esVendedor;

	public Empleado(String id, String nombre, double salarioBasico, List<Venta> ventas, boolean esVendedor) {

		this.salarioBasico = salarioBasico;
		this.ventas = ventas;
		this.id = id;
		this.nombre = nombre;

		this.esVendedor = esVendedor;
	}

}
