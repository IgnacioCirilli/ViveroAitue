package vivero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViveroTestCase {
	
	private Vivero vivero;

	@BeforeEach
	void setUp() {
		
		vivero = new Vivero("Aitue");
		
	}

	@Test
	void verificacionDeInicializacionDeUnVivero() {
		assertEquals("Aitue", this.vivero.getNombre());
	}

}
