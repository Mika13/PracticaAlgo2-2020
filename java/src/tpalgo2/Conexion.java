package tpalgo2;

public class Conexion {

    private Operador origen;
    private Operador destino;
    private double distancia;
 
    public Conexion(Operador origin, Operador destination, double distance) {
        this.origen = origin;
        this.destino = destination;
        this.distancia = distance;
    }
 
    
 
    public Operador getOrigen() {
		return origen;
	}



	public void setOrigen(Operador origen) {
		this.origen = origen;
	}



	public Operador getDestino() {
		return destino;
	}



	public void setDestino(Operador destino) {
		this.destino = destino;
	}



	public double getDistancia() {
		return distancia;
	}



	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}



	@Override
    public String toString() {
        return "\n Conexion [origen=" + origen.getIdOperador() + ", destino=" + destino.getIdOperador() + ", distancia="
                + this.distancia + "]";
    }
 
}
