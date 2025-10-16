/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 9spot
 */

public class CompetidorTest {

    @Test
    public void testActualizarPuntosSimple() {
        Competidor c = new Competidor("Ana", 23, "Colombia", 5, 1.70, 60.0);
        assertEquals(0, c.getPuntos());
        c.actualizarPuntos(10);
        assertEquals(10, c.getPuntos());
        c.actualizarPuntos(5, true);
        assertEquals(15, c.getPuntos());
    }

    @Test
    public void testGettersSetters() {
        Competidor c = new Competidor("Luis", 30, "España", 8, 1.82, 78.0);
        assertEquals("Luis", c.getNombre());
        assertEquals(30, c.getEdad());
        assertEquals("España", c.getPais());
        assertEquals(8, c.getRankingMundial());

        c.setRankingMundial(3);
        assertEquals(3, c.getRankingMundial());

        c.setEstatura(1.85);
        c.setPeso(80.0);
        assertEquals(1.85, c.getEstatura());
        assertEquals(80.0, c.getPeso());
    }

    @Test
    public void testToStringContainsRelevantInfo() {
        Competidor c = new Competidor("Marta", 27, "Chile", 12, 1.66, 55.0);
        String s = c.toString();
        assertTrue(s.contains("Marta"));
        assertTrue(s.contains("Ranking mundial"));
        assertTrue(s.contains("Estatura"));
    }
}
