package filtro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import planta.Planta;

class MedicinalTestCase {

	private Medicinal filtro;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		filtro  = new Medicinal();
		
		planta1 = mock(Planta.class);
		planta2 = mock(Planta.class);
		planta3 = mock(Planta.class);
		
	}
	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorMedicinal() {
		//Mockeando las plantas
		when(planta1.isEsMedicinal()).thenReturn(false);
		when(planta2.isEsMedicinal()).thenReturn(true);
		when(planta3.isEsMedicinal()).thenReturn(true);
		
		//SetUp
		List<Planta> plantasAFiltrar  = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		List<Planta> plantasEsperadas = Arrays.asList(this.planta2, this.planta3);
		
		assertEquals(plantasEsperadas, this.filtro.filtrarPlantas(plantasAFiltrar));
	}

}
