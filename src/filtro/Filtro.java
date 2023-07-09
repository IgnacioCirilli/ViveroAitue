package filtro;

import java.util.List;

import planta.Planta;

public interface Filtro {
	
	public abstract List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar);

}
