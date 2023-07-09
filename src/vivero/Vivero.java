package vivero;

import java.util.Map;

import planta.Planta;

import java.util.HashMap;

public class Vivero {
	
	private String nombre;
	private Map<Planta, Integer> plantas;
	
	public Vivero(String nombre) {
		this.setNombre(nombre);
		this.setPlantas(new HashMap<Planta, Integer>());
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<Planta, Integer> getPlantas() {
		return plantas;
	}

	private void setPlantas(Map<Planta, Integer> plantas) {
		this.plantas = plantas;
	}

	public void agregarPlanta(Planta planta, int cantidad) {
        int cantidadActual = this.getPlantas().getOrDefault(planta, 0);
        cantidadActual += cantidad;
        
        this.getPlantas().put(planta, cantidadActual);
    }
	
	public void eliminarPlanta(Planta planta, int cantidad) {
        if (this.getPlantas().containsKey(planta)) {
            int cantidadActual = this.getPlantas().get(planta);
            cantidadActual -= cantidad;

            if (cantidadActual <= 0) {
                this.getPlantas().remove(planta);
            } else {
                this.getPlantas().put(planta, cantidadActual);
            }

		} else {
			throw new IllegalArgumentException("Error, la planta no se encuentra registrada.");
		}
	}

}
