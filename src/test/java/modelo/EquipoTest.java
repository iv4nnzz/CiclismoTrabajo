/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import java.util.List;
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
public class EquipoTest {

    @Test
    public void testAgregarCompetidorYObtenerDatosEquipo() {
        Equipo equipo = new Equipo("Team A", "Colombia");
        assertTrue(equipo.getCompetidores().isEmpty());

        Competidor c = new Competidor("Pedro", 22, "Colombia", 20, 1.75, 70.0);
        equipo.agregarCompetidor(c);
        assertEquals(1, equipo.getCompetidores().size());

        String datos = equipo.obtenerDatosEquipo();
        assertTrue(datos.contains("Team A"));
        assertTrue(datos.contains("Pedro"));
    }

    @Test
    public void testAgregarCompetidorSobrecarga() {
        Equipo equipo = new Equipo("Team B", "México");
        equipo.agregarCompetidor("Carlos", 24, "México", 15, 1.78, 72.0);
        assertEquals(1, equipo.getCompetidores().size());
        assertEquals("Carlos", equipo.getCompetidores().get(0).getNombre());
    }
}