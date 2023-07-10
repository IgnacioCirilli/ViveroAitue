package filtro;

import java.util.List;

import planta.Planta;
import planta.Proposito;

public class PropositoDePlata implements Filtro {
	
	private Proposito propositoAFiltrar;
	
	
	public PropositoDePlata(Proposito propositoAFiltrar) {
		super();
		this.setPropositoAFiltrar(propositoAFiltrar);
	}


	public Proposito getPropositoAFiltrar() {
		return propositoAFiltrar;
	}

	private void setPropositoAFiltrar(Proposito propositoAFiltrar) {
		this.propositoAFiltrar = propositoAFiltrar;
	}


	@Override
	public List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar) {
		return plantasAFiltrar.stream()
                              .filter(p -> p.getPropositos().contains(this.getPropositoAFiltrar()))
                              .toList();
	} 

}
