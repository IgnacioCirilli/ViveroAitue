package filtro;

import java.util.List;

import planta.Planta;
import planta.TipoDeMaceta;

public class TamañoDeMaceta implements Filtro {
	
	private TipoDeMaceta tamañoAFiltrar;
	

	public TamañoDeMaceta(TipoDeMaceta tamañoAFiltrar) {
		super();
		this.setTamañoAFiltrar(tamañoAFiltrar);
	}

	
	public TipoDeMaceta getTamañoAFiltrar() {
		return tamañoAFiltrar;
	}

	private void setTamañoAFiltrar(TipoDeMaceta tamañoAFiltrar) {
		this.tamañoAFiltrar = tamañoAFiltrar;
	}


	@Override
	public List<Planta> filtrarPlantas(List<Planta> plantasAFiltrar) {
		return plantasAFiltrar.stream()
				              .filter(p -> p.getTamañoDeMaceta().equals(this.getTamañoAFiltrar()))
				              .toList();
	}

}
