package filtro;

import java.util.List;

import planta.Planta;
import planta.TipoDePlanta;

public class Categoria implements Filtro {
	
	private TipoDePlanta tipoDePlantaAFiltrar;
	
	
	public Categoria(TipoDePlanta tipoDePlantaAFiltrar) {
		super();
		this.setTipoDePlantaAFiltrar(tipoDePlantaAFiltrar);
	}


	public TipoDePlanta getTipoDePlantaAFiltrar() {
		return tipoDePlantaAFiltrar;
	}

	private void setTipoDePlantaAFiltrar(TipoDePlanta tipoDePlantaAFiltrar) {
		this.tipoDePlantaAFiltrar = tipoDePlantaAFiltrar;
	}


	@Override
	public List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar) {
		return plantasAFiltrar.stream()
				              .filter(p -> p.getTipoDePlanta().equals(this.getTipoDePlantaAFiltrar()))
				              .toList();
	}

}
