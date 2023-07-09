package filtro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import planta.Planta;
import planta.TipoDePlanta;

class CategoriaTestCase {
	
	private Categoria filtro;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		filtro  = new Categoria(TipoDePlanta.HERBACEA);
		
		planta1 = mock(Planta.class);
		planta2 = mock(Planta.class);
		planta3 = mock(Planta.class);
		
	}

	@Test
	void verificicacionDeInicializacionDeUnFiltroPorCategoria() {
		assertEquals(TipoDePlanta.HERBACEA, this.filtro.getTipoDePlantaAFiltrar());
	}
	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorCategoria() {
		//Mockeando las plantas
		when(planta1.getTipoDePlanta()).thenReturn(TipoDePlanta.HERBACEA);
		when(planta2.getTipoDePlanta()).thenReturn(TipoDePlanta.ARBUSTO);
		when(planta3.getTipoDePlanta()).thenReturn(TipoDePlanta.HERBACEA);
		
		//SetUp
		List<Planta> plantasAFiltrar  = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		List<Planta> plantasEsperadas = Arrays.asList(this.planta1, this.planta3);
		
		assertEquals(plantasEsperadas, this.filtro.filtrarPlantas(plantasAFiltrar));
	}

}
