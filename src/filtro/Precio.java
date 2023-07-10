package filtro;

import java.util.List;

import planta.Planta;

public class Precio implements Filtro {
	
	private double precioAFiltrar;
	
	
	public Precio(double precioAFiltrar) {
		super();
		this.setPrecioAFiltrar(precioAFiltrar);
	}


	public double getPrecioAFiltrar() {
		return precioAFiltrar;
	}

	private void setPrecioAFiltrar(double precioAFiltrar) {
		this.precioAFiltrar = precioAFiltrar;
	}

	@Override
	public List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar) {
		return plantasAFiltrar.stream()
				              .filter(p -> p.getPrecio() == this.getPrecioAFiltrar())
				              .toList();
	}
	
	

}
