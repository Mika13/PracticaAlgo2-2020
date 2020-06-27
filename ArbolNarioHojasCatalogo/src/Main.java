import java.util.ArrayList;
import java.util.List;

public class Main {

	public static CatalogoProductos generarArbol() {

		Producto p1 = new Producto("PRD-0001", "Producto 1", 10);
		Producto p1d = new Producto("PRD-0001", "Producto 1", 100);
		Producto p2 = new Producto("PRD-0002", "Producto 2", 10);
		Producto p2d = new Producto("PRD-0002", "Producto 2", 100);
		Producto p3 = new Producto("PRD-0003", "Producto 3", 10);
		Producto p4 = new Producto("PRD-0004", "Producto 4", 10);
		Producto p4d = new Producto("PRD-0004", "Producto 4", 100);
		Producto p5 = new Producto("PRD-0005", "Producto 5", 10);
		Producto p5d = new Producto("PRD-0005", "Producto 5", 100);
		Producto p6 = new Producto("PRD-0006", "Producto 6", 10);
		Producto p6d = new Producto("PRD-0006", "Producto 6", 11);

		List<Producto> listaProdCat1 = new ArrayList<Producto>();

		// listaProdCat1.add(p1);
		// listaProdCat1.add(p2);

		Categoria c1 = new Categoria(1, "C1", listaProdCat1);

		List<Producto> listaProdCat2 = new ArrayList<Producto>();

		// listaProdCat2.add(p1d);
		// listaProdCat2.add(p2d);
		// listaProdCat2.add(p3);

		Categoria c2 = new Categoria(2, "C2", listaProdCat2);

		List<Producto> listaProdCat21 = new ArrayList<Producto>();

		listaProdCat21.add(p3);
		listaProdCat21.add(p4);

		Categoria c21 = new Categoria(21, "C21", listaProdCat21);

		List<Producto> listaProdCat22 = new ArrayList<Producto>();

		listaProdCat22.add(p4d);
		listaProdCat22.add(p5);

		Categoria c22 = new Categoria(22, "C22", listaProdCat22);

		List<Producto> listaProdCat3 = new ArrayList<Producto>();

		listaProdCat3.add(p1d);
		listaProdCat3.add(p5d);
		listaProdCat3.add(p6);

		Categoria c3 = new Categoria(3, "C3", listaProdCat3);

		List<Producto> listaProdCat4 = new ArrayList<Producto>();

		listaProdCat4.add(p5);
		listaProdCat4.add(p6d);

		Categoria c4 = new Categoria(4, "C4", listaProdCat4);

		CatalogoProductos catProd21 = new CatalogoProductos(c21, null);
		CatalogoProductos catProd22 = new CatalogoProductos(c22, null);
		CatalogoProductos catProd3 = new CatalogoProductos(c3, null);
		CatalogoProductos catProd4 = new CatalogoProductos(c4, null);

		List<CatalogoProductos> listCatProdC2 = new ArrayList<CatalogoProductos>();

		listCatProdC2.add(catProd21);
		listCatProdC2.add(catProd22);

		CatalogoProductos catProdC2 = new CatalogoProductos(c2, listCatProdC2);

		List<CatalogoProductos> listCatProdC1 = new ArrayList<CatalogoProductos>();
		listCatProdC1.add(catProdC2);
		listCatProdC1.add(catProd3);
		listCatProdC1.add(catProd4);

		CatalogoProductos catProdC1 = new CatalogoProductos(c1, listCatProdC1);

		return catProdC1;

	}

	public static void productosValidos(CatalogoProductos catProd, List<Producto> productosValidos) {

		CatalogoProductos catProdHead;
		List<CatalogoProductos> proximos = new ArrayList<CatalogoProductos>();
		boolean encontrado = false;

		for (Producto producto : catProd.categoria.productos) {

			encontrado = false;

			for (Producto prdValidos : productosValidos) {

				if (prdValidos.idProd.equalsIgnoreCase(producto.idProd)) {
					encontrado = true;
					if (prdValidos.precioProd < producto.precioProd) {
						prdValidos.precioProd = producto.precioProd;
					}
				}

			}

			if (!encontrado) {
				// Esto es una copia, solo porque java pasa objetos por referencia
				Producto prdAux = new Producto(producto.idProd, producto.nombreProd, producto.precioProd);

				productosValidos.add(prdAux);
			}

		}

		if (catProd.subCategorias != null) {

			proximos.addAll(catProd.subCategorias);

			while (proximos.size() > 0) {

				catProdHead = proximos.get(0);
				productosValidos(catProdHead, productosValidos);
				proximos.remove(0);

			}

		}

	}

	public static CatalogoProductos eliminarDuplicados(CatalogoProductos catProd) {

		List<Producto> prodVal = new ArrayList<Producto>();

		productosValidos(catProd, prodVal);

		eliminarDuplicados2(catProd, prodVal);

		return catProd;
	}

	public static boolean esValido(List<Producto> prodVal, Producto prod) {

		boolean encontrado = false;

		for (Producto producto : prodVal) {

			if (producto.idProd.equalsIgnoreCase(prod.idProd) && producto.precioProd == prod.precioProd) {
				encontrado = true;

			}

		}

		return encontrado;

	}

	public static void eliminarDuplicados2(CatalogoProductos catProd, List<Producto> prodVal) {

		int indice = 0;
		boolean esProductoValido = false;
		List<CatalogoProductos> proximos = new ArrayList<CatalogoProductos>();
		CatalogoProductos head;
		List<Producto> productosAux = new ArrayList<Producto>(); // Esto es solo para Java, no hace falta en Pseudo

		if (catProd.subCategorias == null) {
			// Esto es una hoja

			productosAux.addAll(catProd.categoria.productos);  // Esto es solo para Java, no hace falta en Pseudo, usar catProd.categoria.productos directamente
			
			for (Producto producto : productosAux) {

				esProductoValido = esValido(prodVal, producto);
				
				System.out.println("EsProductoValido" + esProductoValido);

				if (!esProductoValido) {
					catProd.categoria.productos.remove(indice);
					indice = indice - 1;

				}
				indice = indice + 1;

			}

		} else {
			proximos.addAll(catProd.subCategorias);
			while (proximos.size() > 0) {
				head = proximos.get(0);
				eliminarDuplicados2(head, prodVal);
				proximos.remove(0); // tail
			}

		}

	}

	public static void imprimirArbol(CatalogoProductos catProd) {

		CatalogoProductos catProdHead;
		List<CatalogoProductos> proximos = new ArrayList<CatalogoProductos>();

		System.out.println("Categoria: " + catProd.categoria.idCat + " - " + catProd.categoria.nombreCat);

		for (Producto producto : catProd.categoria.productos) {
			System.out.println("  Producto: " + producto.idProd + " - Nombre: " + producto.nombreProd + " - Precio: "
					+ producto.precioProd);
		}

		if (catProd.subCategorias != null) {

			proximos.addAll(catProd.subCategorias);

			while (proximos.size() > 0) {

				catProdHead = proximos.get(0);
				imprimirArbol(catProdHead);
				proximos.remove(0);

			}

		}

	}

	public static void main(String[] args) {

		CatalogoProductos catalogo = generarArbol();

		CatalogoProductos catalogoSinDuplicados = eliminarDuplicados(catalogo);

		// Recorrer e Imprimir
		System.out.println("Imprimiendo arbol final");
		imprimirArbol(catalogoSinDuplicados);

	}

}
