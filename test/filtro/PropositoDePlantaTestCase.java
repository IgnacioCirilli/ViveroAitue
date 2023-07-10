package filtro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import planta.Planta;
import planta.Proposito;

class PropositoDePlantaTestCase {

	private PropositoDePlata filtro;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		filtro  = new PropositoDePlata(Proposito.MARIPOSA);
		
		planta1 = mock(Planta.class);
		planta2 = mock(Planta.class);
		planta3 = mock(Planta.class);
		
	}

	@Test
	void verificicacionDeInicializacionDeUnFiltroPorPropositoDePlanta() {
		assertEquals(Proposito.MARIPOSA, this.filtro.getPropositoAFiltrar());
	}
	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorPropositoDePlanta() {
		//Mockeando las plantas
		when(planta1.getPropositos()).thenReturn(Arrays.asList(Proposito.PICAFLOR));
		when(planta2.getPropositos()).thenReturn(Arrays.asList(Proposito.PICAFLOR, Proposito.MARIPOSA));
		when(planta3.getPropositos()).thenReturn(Arrays.asList(Proposito.MARIPOSA));
		
		//SetUp
		List<Planta> plantasAFiltrar  = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		List<Planta> plantasEsperadas = Arrays.asList(this.planta2, this.planta3);
		
		assertEquals(plantasEsperadas, this.filtro.filtrarPlantas(plantasAFiltrar));
	}

}
