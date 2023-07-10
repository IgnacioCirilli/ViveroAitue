package filtro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import planta.EstacionDeFloracion;
import planta.Planta;

class FlorecimientoTestCase {

	private Florecimiento filtro;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		filtro  = new Florecimiento(EstacionDeFloracion.OTOÑO);
		
		planta1 = mock(Planta.class);
		planta2 = mock(Planta.class);
		planta3 = mock(Planta.class);
		
	}

	@Test
	void verificicacionDeInicializacionDeUnFiltroPorFlorecimiento() {
		assertEquals(EstacionDeFloracion.OTOÑO, this.filtro.getEstacionAFiltrar());
	}
	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorFlorecimiento() {
		//Mockeando las plantas
		when(planta1.getEstacionesDeFloracion()).thenReturn(Arrays.asList(EstacionDeFloracion.INVIERNO, EstacionDeFloracion.OTOÑO));
		when(planta2.getEstacionesDeFloracion()).thenReturn(Arrays.asList(EstacionDeFloracion.PRIMAVERA));
		when(planta3.getEstacionesDeFloracion()).thenReturn(Arrays.asList(EstacionDeFloracion.OTOÑO, EstacionDeFloracion.PRIMAVERA));
		
		//SetUp
		List<Planta> plantasAFiltrar  = Arrays.asList(this.planta1, this.planta2, this.planta3);
		
		List<Planta> plantasEsperadas = Arrays.asList(this.planta1, this.planta3);
		
		assertEquals(plantasEsperadas, this.filtro.filtrarPlantas(plantasAFiltrar));
	}

}