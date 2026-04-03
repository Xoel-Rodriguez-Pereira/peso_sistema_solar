package edu.teamrocket.peso_sistema_solar;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class PesoSistemaSolarTest {

	public static String[] planetas;

	@BeforeAll
	public static void CreacionArrayPlanetasSetup() {
		planetas = new String[8];
		int planetasIncluidos = 0;
		for (Planeta planeta : Planeta.values()) {
			planetas[planeta.ordinal()] = planeta.name();
			planetasIncluidos += 1;
		}
		assertEquals(Planeta.values().length, planetasIncluidos);
		assertFalse(Arrays.asList(planetas).contains(null));
	}

	@Test
	public void PlanetaConstructorTest() {
		// me aseguro de que los metodos de la api
		// de los Enum Types se comportan como espero
		Planeta planeta = Planeta.MERCURIO;
		assertInstanceOf(Planeta.class, planeta);
		assertEquals(0, planeta.ordinal());
		assertEquals("MERCURIO", planeta.name());
		assertEquals(Planeta.MERCURIO, Planeta.valueOf(planeta.name()));
		assertEquals(0, planeta.compareTo(Planeta.MERCURIO));
		assertEquals("MERCURIO", planeta.toString());
		assertTrue(planeta.equals(Planeta.MERCURIO));
		assertEquals(planeta, Planeta.values()[0]);
	}

	@Test
	public void PlanetaGetMasaTest() {
		Planeta planeta = Planeta.MERCURIO;
		assertEquals(3.303e+23, planeta.getMasa());
	}

	@Test
	public void PlanetaGetRadioTest() {
		Planeta planeta = Planeta.MERCURIO;
		assertEquals(2.4397e+6, planeta.getRadio());
	}

	@Test
	public void PlanetaNamesIteratorTest() {
		for (Planeta planeta : Planeta.values()) {
			assertTrue(Arrays.asList(planetas).contains(planeta.name()));
		}
	}

	@Test
	public void PesoSuperficieMercurioTest() {
		Planeta planeta = Planeta.MERCURIO;
		double pesoHumano = 175;
		assertEquals(66.107583, planeta.pesoSuperficie(pesoHumano), 0.001);
	}

	@Test
	public void ArrayPlanetasTerrestresTest() {

		String[] planetasTerrestres = new String[4];
		int planetasIncluidos = 0;

		for (int i = Planeta.MERCURIO.ordinal(); i < Planeta.JUPITER.ordinal(); i++) {
			planetasTerrestres[i] = Planeta.values()[i].name();
			planetasIncluidos += 1;
		}
		assertEquals(4, planetasIncluidos);
		assertFalse(Arrays.asList(planetas).contains(null));

		for (Planeta planeta : Planeta.getPlanetasTerrestres()) {
			assertTrue(Arrays.asList(planetasTerrestres).contains(planeta.name()));
		}
	}

	@Test
	public void ArrayGigantesGaseosos() {

		String[] gigantesGaseosos = new String[4];
		int planetasIncluidos = 0;

		byte index = 0;
		for (int i = Planeta.JUPITER.ordinal(); i <= Planeta.NEPTUNO.ordinal(); i++) {
			gigantesGaseosos[index] = Planeta.values()[i].name();
			planetasIncluidos += 1;
			index += 1;
		}
		assertEquals(4, planetasIncluidos);
		assertFalse(Arrays.asList(planetas).contains(null));

		for (Planeta planeta : Planeta.getGigantesGaseosos()) {
			assertTrue(Arrays.asList(gigantesGaseosos).contains(planeta.name()));
		}
	}
}
