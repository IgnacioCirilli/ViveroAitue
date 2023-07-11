package vivero;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filtro.Filtro;
import planta.EstacionDeFloracion;
import planta.Planta;
import planta.Proposito;
import planta.TipoDeMaceta;
import planta.TipoDePlanta;

class ViveroTestCase {
	
	private Vivero vivero;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;
	
	private List<EstacionDeFloracion> estaciones1;
	private List<EstacionDeFloracion> estaciones2;
	
	private List<Proposito> propositos1;
	private List<Proposito> propositos2;
	
	private Filtro filtro;
	

	@BeforeEach
	void setUp() {
		
		vivero  = new Vivero("Aitue");
		
		estaciones1 = Arrays.asList(EstacionDeFloracion.VERANO, EstacionDeFloracion.OTOÑO);
		propositos1 = Arrays.asList(Proposito.ORNAMENTAL);
		planta1 = new Planta("Ceibo", "Erythrina crista galli", TipoDeMaceta.L3, TipoDePlanta.ARBOL, 
	                          this.estaciones1, 2000, false, false, this.propositos1, this.vivero);
		
		estaciones2 = Arrays.asList(EstacionDeFloracion.INVIERNO);
		propositos2 = Arrays.asList(Proposito.PICAFLOR);
		planta2 = new Planta("Pilarcito", "Gyptis tanacetifolia", TipoDeMaceta.L1, TipoDePlanta.HERBACEA,
				             this.estaciones2, 600, true, false, this.propositos2, this.vivero); 
		
		
		planta3 = new Planta("Ceibo", "Erythrina crista galli", TipoDeMaceta.L3, TipoDePlanta.ARBOL, 
                              this.estaciones1, 2000, false, false, this.propositos1, this.vivero);
		
		filtro = mock(Filtro.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnVivero() {
		assertEquals("Aitue", this.vivero.getNombre());
		assertTrue(this.vivero.getPlantas().isEmpty());
	}
	
	@Test
	void verificacionDeAgregadoDeUnaPlantaAUnVivero() {		
		//Exercise
		this.vivero.agregarPlanta(this.planta1, 4);
		this.vivero.agregarPlanta(this.planta2, 1);
		this.vivero.agregarPlanta(this.planta3, 2);
		
		assertFalse(this.vivero.getPlantas().isEmpty());
		assertTrue(this.vivero.getPlantas().containsKey(this.planta1));
		assertEquals(2, this.vivero.getPlantas().size());
		assertEquals(6, this.vivero.getPlantas().get(this.planta1));  
	}
	
	@Test
	void verificacionDeEliminadoDeUnaPlantaEnUnVivero() {		
		//SetUp
		this.vivero.agregarPlanta(this.planta1, 1);
		
		//Exercise
		this.vivero.eliminarPlanta(this.planta1, 1);
		
		assertTrue(this.vivero.getPlantas().isEmpty());
	}
	
	@Test
	void verificacionDeEliminadoDeUnaPlantaQueHayMasDeUnaEnUnVivero() {		
		//SetUp
		this.vivero.agregarPlanta(this.planta1, 1);
		this.vivero.agregarPlanta(this.planta3, 1);
		
		//Exercise
		this.vivero.eliminarPlanta(this.planta1, 1);
		
		assertFalse(this.vivero.getPlantas().isEmpty());
		assertTrue(this.vivero.getPlantas().containsKey(this.planta1));
		assertEquals(1, this.vivero.getPlantas().size());
	}
	
	@Test
	void verificacionDeEliminadoDeUnaPlantaQueNoseEncuentraEnUnVivero() {		
		assertThrows(IllegalArgumentException.class, () -> {
			this.vivero.eliminarPlanta(this.planta1, 1); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionDeAumentoDelPrecioPorPorcentajeDeCiertasPlantasDeUnVivero() {
		//SetUp
		List<Planta> plantasAAumentar = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		//Exercise
		this.vivero.aumentarPrecioPorPorcentajePlantas(plantasAAumentar, 25);
		
		assertEquals(2500, this.planta1.getPrecio());
		assertEquals(750, this.planta2.getPrecio());
		assertEquals(2500, this.planta3.getPrecio());
	}
	
	@Test
	void verificacionDeAumentoDelPrecioPorCantidadDeCiertasPlantasDeUnVivero() {
		//SetUp
		List<Planta> plantasAAumentar = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		//Exercise
		this.vivero.aumentarPrecioPorCantidadPlantas(plantasAAumentar, 250);
		
		assertEquals(2250, this.planta1.getPrecio());
		assertEquals(850, this.planta2.getPrecio());
		assertEquals(2250, this.planta3.getPrecio());
	}
	
	@Test
	void verificacionDeFiltradoDePlantasDeUnVivero() {
		//SetUp
		this.vivero.agregarPlanta(planta1, 1);
		this.vivero.agregarPlanta(planta2, 1);
		this.vivero.agregarPlanta(planta3, 1);
		
		List<Planta> plantasAFiltrar  = Arrays.asList(this.planta1, this.planta2);
		
		List<Planta> plantasEsperadas = Arrays.asList(this.planta1);
		
		//Mockeando el filtro
		when(filtro.filtrarPlantas(plantasAFiltrar)).thenReturn(plantasEsperadas);
		
		assertEquals(plantasEsperadas, this.vivero.filtrarPlantas(this.filtro));
		verify(filtro, times(1)).filtrarPlantas(plantasAFiltrar);
	}
	
}
