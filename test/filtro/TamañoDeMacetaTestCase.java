package filtro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import planta.Planta;
import planta.TipoDeMaceta;

class TamañoDeMacetaTestCase {
	
	private TamañoDeMaceta filtro;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		filtro  = new TamañoDeMaceta(TipoDeMaceta.M12);
		
		planta1 = mock(Planta.class);
		planta2 = mock(Planta.class);
		planta3 = mock(Planta.class);
		
	}

	@Test
	void verificicacionDeInicializacionDeUnFiltroPorTamañoDeMaceta() {
		assertEquals(TipoDeMaceta.M12, this.filtro.getTamañoAFiltrar());
	}
	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorTamañoDeMaceta() {
		//Mockeando las plantas
		when(planta1.getTamañoDeMaceta()).thenReturn(TipoDeMaceta.L3);
		when(planta2.getTamañoDeMaceta()).thenReturn(TipoDeMaceta.M12);
		when(planta3.getTamañoDeMaceta()).thenReturn(TipoDeMaceta.L3);
		
		//SetUp
		List<Planta> plantasAFiltrar  = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		List<Planta> plantasEsperadas = Arrays.asList(this.planta2);
		
		assertEquals(plantasEsperadas, this.filtro.filtrarPlantas(plantasAFiltrar));
	}

}
