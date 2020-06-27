import java.util.ArrayList;
import java.util.List;

public class Main {

	public static EquipoComercial generarArbol() {

		/*---------------------------------------------------------------------------------------*/
		// Vendedor V11
		List<Venta> ventasv11 = new ArrayList<Venta>();

		Venta venta1_v11 = new Venta(100, true, 0);
		Venta venta2_v11 = new Venta(100, false, 1);
		Venta venta3_v11 = new Venta(100, false, 2);

		ventasv11.add(venta1_v11);
		ventasv11.add(venta2_v11);
		ventasv11.add(venta3_v11);

		Empleado vendedor11 = new Empleado("v11", "v11", 50, ventasv11, true);
		EquipoComercial equipoVendedor11 = new EquipoComercial(vendedor11, null);

		// Vendedor V12
		List<Venta> ventasv12 = new ArrayList<Venta>();
		Empleado vendedor12 = new Empleado("v12", "v12", 50, ventasv12, true);
		EquipoComercial equipoVendedor12 = new EquipoComercial(vendedor12, null);

		// Equipo EQ1
		List<Venta> ventasEQ1 = new ArrayList<Venta>();
		Empleado empleadoEquipo1 = new Empleado("eq1", "eq1", 50, ventasEQ1, false);

		List<EquipoComercial> eq1 = new ArrayList<>();
		eq1.add(equipoVendedor11);
		eq1.add(equipoVendedor12);

		EquipoComercial nodoEquipo1 = new EquipoComercial(empleadoEquipo1, eq1);
		/*---------------------------------------------------------------------------------------*/

		/*---------------------------------------------------------------------------------------*/
		// Vendedor V211
		List<Venta> ventasv211 = new ArrayList<Venta>();
		
		Venta venta1_v211 = new Venta(70, true, 0);
		Venta venta2_v211 = new Venta(60, true, 0);
		ventasv211.add(venta1_v211);
		ventasv211.add(venta2_v211);
		
		Empleado vendedor211 = new Empleado("v211", "v211", 50, ventasv211, true);
		EquipoComercial equipoVendedor211 = new EquipoComercial(vendedor211, null);

		// Vendedor V12
		List<Venta> ventasv212 = new ArrayList<Venta>();
		Empleado vendedor212 = new Empleado("v212", "v212", 50, ventasv212, true);
		EquipoComercial equipoVendedor212 = new EquipoComercial(vendedor212, null);

		// Equipo EQ1
		List<Venta> ventasEQ21 = new ArrayList<Venta>();
		Empleado empleadoEquipo21 = new Empleado("eq21", "eq21", 50, ventasEQ21, false);

		List<EquipoComercial> e21 = new ArrayList<>();
		e21.add(equipoVendedor211);
		e21.add(equipoVendedor212);

		EquipoComercial nodoEquipo21 = new EquipoComercial(empleadoEquipo21, e21);
		/*---------------------------------------------------------------------------------------*/

		// Vendedor v22
		List<Venta> ventasv22 = new ArrayList<Venta>();
		Empleado vendedor22 = new Empleado("v22", "v22", 50, ventasv22, true);
		EquipoComercial equipoVendedor22 = new EquipoComercial(vendedor22, null);

		// Equipo 2
		List<Venta> ventasEQ2 = new ArrayList<Venta>();
		Empleado empleadoEquipo2 = new Empleado("eq2", "eq2", 50, ventasEQ2, false);

		List<EquipoComercial> e2 = new ArrayList<>();
		e2.add(nodoEquipo21);
		e2.add(equipoVendedor22);

		EquipoComercial nodoEquipo2 = new EquipoComercial(empleadoEquipo2, e2);

		/*---------------------------------------------------------------------------------------*/

		// Vendedor v
		List<Venta> ventasv = new ArrayList<Venta>();
		Empleado vendedor = new Empleado("v", "v", 50, ventasv, true);
		EquipoComercial equipoVendedor = new EquipoComercial(vendedor, null);

		/*---------------------------------------------------------------------------------------*/

		List<Venta> ventasD = new ArrayList<Venta>();
		Empleado empleadoD = new Empleado("D", "D", 50, ventasD, false);

		List<EquipoComercial> eD = new ArrayList<>();
		eD.add(nodoEquipo1);
		eD.add(nodoEquipo2);
		eD.add(equipoVendedor);

		EquipoComercial ec = new EquipoComercial(empleadoD, eD);

		return ec;
	}

	public static void calcularSalario(EquipoComercial ec, int mes, double porDir, double porVend, double porLim,
			List<SalarioEmpleado> salarios) {

		double sumaTotal = calcularSalario2(ec, mes, porDir, porVend, porLim, salarios, porDir);
		System.out.println("Suma Total de Ventas: " + sumaTotal);   // Acumulado de las hojas

	}

	public static double calcularSumaVentas(List<Venta> ventasVendedor, int mes) {

		double sumaVentas = 0;

		for (Venta ventas : ventasVendedor) {

			if (ventas.esContado) {
				sumaVentas = sumaVentas + ventas.importe;
			} else {
				if (ventas.mes == mes) {
					sumaVentas = sumaVentas + ventas.importe;
				}
			}

		}

		return sumaVentas;

	}

	public static double calcularSalario2(EquipoComercial ec, int mes, double porDir, double porVend, double porLim,
			List<SalarioEmpleado> salarios, double porJefe) {

		List<EquipoComercial> proximos = new ArrayList<EquipoComercial>();
		EquipoComercial equipoComercialHead;
		double ventasAcum;
		double porAux;

		if (ec.empleado.esVendedor) {

			// Calculo salario de Empleado

			double sumaVentas = 0;
			sumaVentas = calcularSumaVentas(ec.empleado.ventas, mes);
			// System.out.println("Suma Ventas de: " + ec.empleado.nombre + " " +
			// sumaVentas);
			double salario = ec.empleado.salarioBasico + (porVend * (sumaVentas));

			SalarioEmpleado salarioEmpleado = new SalarioEmpleado(ec.empleado.nombre, salario);
			salarios.add(salarioEmpleado);

			return sumaVentas;

		} else {

			proximos.addAll(ec.equipo);
			ventasAcum = 0;
			porAux = porJefe / 2;

			if (porAux < porLim) {
				porAux = porLim;
			}

			while (proximos.size() > 0) {

				equipoComercialHead = proximos.get(0);

				// System.out.println("Antes de la rec:" + equipoComercialHead.empleado.nombre);

				ventasAcum = ventasAcum + calcularSalario2(equipoComercialHead, mes, porDir, porVend, porLim, salarios, porAux);
				// System.out.println("Ventas Acumuladas: " + ventasAcum);
				proximos.remove(0); // tail

			}

			// System.out.println("Estoy calculando el sueldo de " + ec.empleado.nombre + "
			// SB: " + ec.empleado.salarioBasico + " Ventas:" + ventasAcum);
			double salarioJefe = (porJefe * ventasAcum) + ec.empleado.salarioBasico;

			SalarioEmpleado salarioEmpleado = new SalarioEmpleado(ec.empleado.nombre, salarioJefe);
			salarios.add(salarioEmpleado);

			return ventasAcum;

		}

	}

	public static void main(String[] args) {
		System.out.println("Inicio de ejecución");

		EquipoComercial ec = generarArbol();

		List<SalarioEmpleado> salarios = new ArrayList<SalarioEmpleado>();

		calcularSalario(ec, 1, 0.5, 0.2, 0.05, salarios);

		for (SalarioEmpleado salarioEmpleado : salarios) {
			System.out.println("Nombre: " + salarioEmpleado.nombre + " - Salario: " + salarioEmpleado.salario);

		}

	}

}
