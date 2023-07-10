package filtro;

import java.util.List;

import planta.EstacionDeFloracion;
import planta.Planta;

public class Florecimiento implements Filtro {
	
	private EstacionDeFloracion estacionAFiltrar;
	
	
	public Florecimiento(EstacionDeFloracion estacionAFiltrar) {
		super();
		this.setEstacionAFiltrar(estacionAFiltrar);
	}


	public EstacionDeFloracion getEstacionAFiltrar() {
		return estacionAFiltrar;
	}

	private void setEstacionAFiltrar(EstacionDeFloracion estacionAFiltrar) {
		this.estacionAFiltrar = estacionAFiltrar;
	}


	@Override
	public List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar) {
		return plantasAFiltrar.stream()
				              .filter(p -> p.getEstacionesDeFloracion().contains(this.getEstacionAFiltrar()))
				              .toList();
	}

}
