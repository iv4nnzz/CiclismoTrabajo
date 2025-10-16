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
public class CompetenciaTest {

    @Test
    public void testGenerarReporteVacioYConEquipos() {
        Competencia comp = new Competencia("Evento X");
        String r1 = comp.generarReporte();
        assertTrue(r1.contains("No hay equipos registrados") || r1.contains("No hay equipos"));

        Equipo e = new Equipo("E1", "Colombia");
        e.agregarCompetidor(new Competidor("A", 21, "Col", 10, 1.7, 60));
        comp.agregarEquipo(e);
        String r2 = comp.generarReporte();
        assertTrue(r2.contains("E1"));
        assertTrue(r2.contains("A"));
    }

    @Test
    public void testActualizarRankingsGlobalOrdenYPuntosYEmpates() {
        Competencia comp = new Competencia("Evento Y");
        Equipo e1 = new Equipo("E1", "C1");
        Equipo e2 = new Equipo("E2", "C2");

        Competidor c1 = new Competidor("P1", 25, "C1", 10, 1.8, 75);
        Competidor c2 = new Competidor("P2", 26, "C2", 12, 1.75, 70);
        Competidor c3 = new Competidor("P3", 27, "C3", 20, 1.70, 68);

        c1.setPuntos(50);
        c2.setPuntos(50); 
        c3.setPuntos(30);

        e1.agregarCompetidor(c1);
        e1.agregarCompetidor(c3);
        e2.agregarCompetidor(c2);

        comp.agregarEquipo(e1);
        comp.agregarEquipo(e2);

        comp.actualizarRankingsGlobal();

        assertEquals(c1.getRankingMundial(), c2.getRankingMundial());
        assertEquals(1, c1.getRankingMundial());
        assertEquals(3, c3.getRankingMundial());
    }
}