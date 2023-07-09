package filtro;

import java.util.List;

import planta.Planta;

public class Sombra implements Filtro {

	@Override
	public List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar) {
		return plantasAFiltrar.stream()
	                          .filter(p -> p.isEsParaSombra())
	                          .toList();
	}

}
