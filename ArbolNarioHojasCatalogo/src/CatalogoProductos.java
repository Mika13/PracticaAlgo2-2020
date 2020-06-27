import java.util.List;

public class CatalogoProductos {
	
	
	Categoria categoria;
	List<CatalogoProductos> subCategorias;

	public CatalogoProductos(Categoria categoria, List<CatalogoProductos> subCategorias) {

		this.categoria = categoria;
		this.subCategorias = subCategorias;
	}
	
	

}
