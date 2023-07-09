package filtro;

import java.util.List;

import planta.Planta;

public class Medicinal implements Filtro {

	@Override
	public List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar) {
		return plantasAFiltrar.stream()
				              .filter(p -> p.isEsMedicinal())
				              .toList();
	}

}
