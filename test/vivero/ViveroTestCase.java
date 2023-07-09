package vivero;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import planta.Planta;

class ViveroTestCase {
	
	private Vivero vivero;
	
	private Planta planta1;
	private Planta planta2;
	private Planta planta3;

	@BeforeEach
	void setUp() {
		
		vivero  = new Vivero("Aitue");
		
		planta1 = new Planta("Ceibo"); 
		planta2 = new Planta("Margarita"); 
		planta3 = new Planta("Ceibo"); 
		
	}

	@Test
	void verificacionDeInicializacionDeUnVivero() {
		assertEquals("Aitue", this.vivero.getNombre());
		assertTrue(this.vivero.getPlantas().isEmpty());
	}
	
	@Test
	void verificacionDeAgregadoDeUnaPlantaAUnVivero() {		
		//Exercise
		this.vivero.agregarPlanta(this.planta1, 1);
		this.vivero.agregarPlanta(this.planta2, 1);
		this.vivero.agregarPlanta(this.planta3, 1);
		
		assertFalse(this.vivero.getPlantas().isEmpty());
		assertTrue(this.vivero.getPlantas().containsKey(this.planta1));
		assertEquals(2, this.vivero.getPlantas().size());
		assertEquals(2, this.vivero.getPlantas().get(this.planta1));  
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
	void verificacionDeEliminadoDeUnaPlantaQueNoseEncuentraEnUnVivero() {		
		assertThrows(IllegalArgumentException.class, () -> {
			this.vivero.eliminarPlanta(this.planta1, 1); //Esto funciona pero está afuera del coverage
		});
	}
	
//	@Test
//	void verificacionDeAumentoDelPrecioPorPorcentajeDeCiertasPlantasDeUnVivero() {
//		
//	}
	
	

}
