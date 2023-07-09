package filtro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import planta.Planta;

class PrecioTestCase {

	private Precio filtro;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		filtro  = new Precio(1700);
		
		planta1 = mock(Planta.class);
		planta2 = mock(Planta.class);
		planta3 = mock(Planta.class);
		
	}

	@Test
	void verificicacionDeInicializacionDeUnFiltroPorPrecio() {
		assertEquals(1700, this.filtro.getPrecioAFiltrar());
	}
	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorPrecio() {
		//Mockeando las plantas
		when(planta1.getPrecio()).thenReturn(400d);
		when(planta2.getPrecio()).thenReturn(250d);
		when(planta3.getPrecio()).thenReturn(1700d);
		
		//SetUp
		List<Planta> plantasAFiltrar  = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		List<Planta> plantasEsperadas = Arrays.asList(this.planta3);
		
		assertEquals(plantasEsperadas, this.filtro.filtrarPlantas(plantasAFiltrar));
	}

}