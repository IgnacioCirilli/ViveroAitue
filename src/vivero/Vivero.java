package vivero;

import java.util.Map;
import java.util.HashMap;

public class Vivero {
	
	private String nombre;
	private Map<String, Integer> plantas;
	
	public Vivero(String nombre) {
		this.setNombre(nombre);
		this.setPlantas(new HashMap<String, Integer>());
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, Integer> getPlantas() {
		return plantas;
	}

	private void setPlantas(Map<String, Integer> plantas) {
		this.plantas = plantas;
	}

	public void agregarPlanta(Planta planta) {
		this.getPlantas().put(planta.getNombre(), this.valorAdecuadoPara(planta));
	}
	
	private Integer valorAdecuadoPara(Planta planta) {
		Integer valorAdecuado = 1;
		String  keyABuscar    = planta.getNombre();
		
		if (this.getPlantas().containsKey(keyABuscar)) {
			valorAdecuado = this.getPlantas().get(keyABuscar) + 1;
		}
		
		return valorAdecuado;
	}

	public void eliminarPlanta(Planta planta) {
		String  keyABuscar    = planta.getNombre();
		
		if (this.getPlantas().containsKey(keyABuscar)) {
			this.getPlantas().put(keyABuscar, this.getPlantas().get(keyABuscar) - 1);
			this.eliminarKeySiCorresponde(keyABuscar);
		} else {
			throw new IllegalArgumentException("Error, la planta no se encuentra registrada.");
		}
		
	}
	
	private void eliminarKeySiCorresponde(String keyAExaminar) {
		if (this.getPlantas().get(keyAExaminar) == 0) {
			this.getPlantas().remove(keyAExaminar);
		}
	}
	
}
