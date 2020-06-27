import java.util.List;

public class Categoria {

	int idCat;
	String nombreCat;

	List<Producto> productos;

	public Categoria(int idCat, String nombreCat, List<Producto> productos) {
		this.idCat = idCat;
		this.nombreCat = nombreCat;
		this.productos = productos;
	}

}
