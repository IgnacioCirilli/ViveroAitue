package vivero;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planta {
	
	private String nombre;
	private String nombreCientifico;
	private TipoDeMaceta tamañoDeMaceta;
	private TipoDePlanta tipoDePlanta;
	private List<EstacionDeFloracion> estacionesDeFloracion;
	private double precio;
	private boolean esParaSombra;
	private boolean esMedicinal;
	private List<Proposito> propositos;
	private Vivero vivero;

	public Planta(String nombre, String nombreCientifico, TipoDeMaceta tamañoDeMaceta, TipoDePlanta tipDePlanta,
			      List<EstacionDeFloracion> estacionDeFloracion, double precio, boolean esParaSombra, boolean esMedicinal,
			      List<Proposito> propositos, Vivero vivero) {
		super();
		this.setNombre(nombre);
		this.setNombreCientifico(nombreCientifico);
		this.setTamañoDeMaceta(tamañoDeMaceta);
		this.setTipoDePlanta(tipDePlanta);
		
		List<EstacionDeFloracion> estaciones = new ArrayList<>(2);
		estaciones.addAll(estacionDeFloracion);
		this.setEstacionesDeFloracion(estaciones);
		
		this.setPrecio(precio);
		this.setEsParaSombra(esParaSombra);
		this.setEsMedicinal(esMedicinal);
		
		
		List<Proposito> propositosList = new ArrayList<>(2);
		propositosList.addAll(propositos);
		this.setPropositos(propositosList);
		
		this.setVivero(vivero);
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	private void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public TipoDeMaceta getTamañoDeMaceta() {
		return tamañoDeMaceta;
	}

	private void setTamañoDeMaceta(TipoDeMaceta tamañoDeMaceta) {
		this.tamañoDeMaceta = tamañoDeMaceta;
	}

	public TipoDePlanta getTipoDePlanta() {
		return tipoDePlanta;
	}

	private void setTipoDePlanta(TipoDePlanta tipDePlanta) {
		this.tipoDePlanta = tipDePlanta;
	}

	public List<EstacionDeFloracion> getEstacionesDeFloracion() {
		return estacionesDeFloracion;
	}

	private void setEstacionesDeFloracion(List<EstacionDeFloracion> estacionesDeFloracion) {
		this.estacionesDeFloracion = estacionesDeFloracion;
	}

	public double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEsParaSombra() {
		return esParaSombra;
	}

	private void setEsParaSombra(boolean esParaSombra) {
		this.esParaSombra = esParaSombra;
	}

	public boolean isEsMedicinal() {
		return esMedicinal;
	}

	private void setEsMedicinal(boolean esMedicinal) {
		this.esMedicinal = esMedicinal;
	}

	public List<Proposito> getPropositos() {
		return propositos;
	}

	private void setPropositos(List<Proposito> propositos) {
		this.propositos = propositos;
	}

	public Vivero getVivero() {
		return vivero;
	}

	private void setVivero(Vivero vivero) {
		this.vivero = vivero;
	}

	public void aumentarPrecioPorPorcentaje(int porcentajeASubir) {
		double nuevoPrecio = this.getPrecio() + ((this.getPrecio() * porcentajeASubir) / 100);
		
		this.setPrecio(nuevoPrecio);
	}

	public void aumentarPrecioPorCantidad(int precio) {
		this.setPrecio(this.getPrecio() + precio);
	}

	public void aumentarStockDeMi(int cantAAumentar) {
		this.getVivero().agregarPlanta(this, cantAAumentar);
	}
	
	public void disminuirStockDeMi(int cantADisminuir) {
		this.getVivero().eliminarPlanta(this, cantADisminuir);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planta planta = (Planta) o;
        return Objects.equals(nombre, planta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }









}
