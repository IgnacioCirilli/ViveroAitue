package vivero;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViveroTestCase {
	
	private Vivero vivero;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		vivero  = new Vivero("Aitue");
		
		planta1 = mock(Planta.class);
		planta2 = mock(Planta.class);
		planta3 = mock(Planta.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnVivero() {
		assertEquals("Aitue", this.vivero.getNombre());
		assertTrue(this.vivero.getPlantas().isEmpty());
	}
	
	@Test
	void verificacionDeAgregadoDeUnaPlantaAUnVivero() {
		//Mockeando la planta
		when(planta1.getNombre()).thenReturn("Ceibo");
		
		//Exercise
		this.vivero.agregarPlanta(this.planta1);
		
		assertFalse(this.vivero.getPlantas().isEmpty());
		assertTrue(this.vivero.getPlantas().containsKey("Ceibo"));
		assertEquals(1, this.vivero.getPlantas().get("Ceibo")); //esto debe cambiarse debido a que rompe encapsulamiento. usar mensaje cantidadDeStockDe(planta1) 
	}
	
	@Test
	void verificacionDeEliminadoDeUnaPlantaEnUnVivero() {
		//Mockeando la planta
		when(planta1.getNombre()).thenReturn("Ceibo");
		
		//SetUp
		this.vivero.agregarPlanta(this.planta1);
		
		//Exercise
		this.vivero.eliminarPlanta(this.planta1);
		
		assertTrue(this.vivero.getPlantas().isEmpty());
	}
	
	@Test
	void verificacionDeEliminadoDeUnaPlantaQueNoseEncuentraEnUnVivero() {
		//Mockeando la planta
		when(planta1.getNombre()).thenReturn("Ceibo");
		
		assertThrows(IllegalArgumentException.class, () -> {
			this.vivero.eliminarPlanta(this.planta1); //Esto funciona pero está afuera del coverage
		});
	}
	
	

}
