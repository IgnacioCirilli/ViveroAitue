package planta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vivero.Vivero;

class PlantaTestCase {
	
	private Planta planta;
	
	private List<EstacionDeFloracion> estaciones;
	
	private List<Proposito> propositos;
	
	private Vivero vivero;

	@BeforeEach
	void setUp() {
		
		vivero = mock(Vivero.class);
		
		estaciones = Arrays.asList(EstacionDeFloracion.VERANO, EstacionDeFloracion.OTOÑO);
		
		propositos = Arrays.asList(Proposito.ORNAMENTAL);
		
		planta = new Planta("Ceibo", "Erythrina crista galli", TipoDeMaceta.L3, TipoDePlanta.ARBOL, 
				             this.estaciones, 2000, false, false, this.propositos, this.vivero);
		
	}


	@Test
	void verificacionDeInicializacionDeUnaPlanta() {
		//Mockeando el Vivero
		when(vivero.getNombre()).thenReturn("Aitue");
		
		assertEquals("Ceibo", this.planta.getNombre());
		assertEquals("Erythrina crista galli", this.planta.getNombreCientifico());
		assertEquals(TipoDeMaceta.L3, this.planta.getTamañoDeMaceta());
		assertEquals(TipoDePlanta.ARBOL, this.planta.getTipoDePlanta());
		assertEquals(this.estaciones, this.planta.getEstacionesDeFloracion());
		assertEquals(2000, this.planta.getPrecio());
		assertEquals(false, this.planta.isEsParaSombra());
		assertEquals(false, this.planta.isEsMedicinal());
		assertEquals(this.propositos, this.planta.getPropositos());
		assertEquals("Aitue", this.planta.getVivero().getNombre());
	}
	
	@Test
	void verificacionDeAumentoDePrecioPorPorcentajeDeUnaPlanta() {
		//Exercise
		this.planta.aumentarPrecioPorPorcentaje(20);
		
		assertEquals(2400, this.planta.getPrecio());
	}
	
	@Test
	void verificacionDeAumentoDePrecioPorCantidadDeUnaPlanta() {
		//Exercise
		this.planta.aumentarPrecioPorCantidad(600);
		
		assertEquals(2600, this.planta.getPrecio());
	}
	
	@Test
	void verificacionDeAumentoDeSotckDeUnaPlantaEnUnVivero() {
		//Exercise
		this.planta.aumentarStockDeMi(3);
		
		//Verify
		verify(this.vivero, times(1)).agregarPlanta(this.planta, 3);
	}
	
	@Test
	void verificacionDeDisminucionDeSotckDeUnaPlantaEnUnVivero() {
		//Exercise
		this.planta.disminuirStockDeMi(2);
		
		//Verify
		verify(this.vivero, times(1)).eliminarPlanta(planta, 2);
	}

}
