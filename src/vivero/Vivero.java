package vivero;

import java.util.Map;

import filtro.Filtro;
import planta.Planta;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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

	public void aumentarPrecioPorPorcentajePlantas(List<Planta> plantasAAumentar, int porcentajeAAumentar) {
		plantasAAumentar.stream()
		                .forEach(p -> p.aumentarPrecioPorPorcentaje(porcentajeAAumentar));
	}

	public void aumentarPrecioPorCantidadPlantas(List<Planta> plantasAAumentar, int cantidadAAumentar) {
		plantasAAumentar.stream()
		                .forEach(p -> p.aumentarPrecioPorCantidad(cantidadAAumentar));
		
	}

	public List<Planta> filtrarPlantas(Filtro filtro) {
		List<Planta> plantas = new ArrayList<Planta>(this.getPlantas().keySet());
		
		return filtro.filtrarPlantas(plantas);
	}

}
