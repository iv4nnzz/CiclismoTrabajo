/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controlador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import modelo.*;
import vista.Vista;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author 9spot
 */
class TestVista extends Vista {
    private Deque<Integer> menuQueue = new ArrayDeque<>();
    private Deque<String> textQueue = new ArrayDeque<>();
    private List<String> mensajes = new ArrayList<>();

    public void pushMenu(int opcion) { menuQueue.addLast(opcion); }
    public void pushText(String texto) { textQueue.addLast(texto); }
    public List<String> getMensajes() { return mensajes; }

    @Override
    public int mostrarMenu() {
        if (menuQueue.isEmpty()) return 7;
        return menuQueue.removeFirst();
    }

    @Override
    public String pedirTexto(String mensaje) {
        if (textQueue.isEmpty()) return null;
        return textQueue.removeFirst();
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    @Override
    public String elegirEquipoTexto(java.util.List<modelo.Equipo> equipos) {
        return super.elegirEquipoTexto(equipos);
    }

    @Override
    public String listarCompetidoresSimple(java.util.List<modelo.Equipo> equipos, int indiceEquipo) {
        return super.listarCompetidoresSimple(equipos, indiceEquipo);
    }
}

public class ControladorIT {

    @Test
    public void testFlujoAgregarEquipoAgregarCompetidorActualizarPuntosYSalir() {
        Competencia competencia = new Competencia("IntegracionTest");
        TestVista vista = new TestVista();

        vista.pushMenu(1);
        vista.pushMenu(2);
        vista.pushMenu(3);
        vista.pushMenu(7);

        vista.pushText("TeamTest");
        vista.pushText("PaisTest");

        vista.pushText("0");
        vista.pushText("Juan");
        vista.pushText("25");
        vista.pushText("Colombia");
        vista.pushText("10");
        vista.pushText("1.80");
        vista.pushText("75.0");

        vista.pushText("0");
        vista.pushText("0");
        vista.pushText("50");
        vista.pushText("n");

        Controlador controlador = new Controlador(competencia, vista);
        controlador.iniciar();

        boolean found = vista.getMensajes().stream().anyMatch(m -> m.contains("Puntos actualizados"));
        assertTrue(found, "Se debe mostrar mensaje de puntos actualizados");

        assertFalse(competencia.getEquipos().isEmpty());
        Competidor c = competencia.getEquipos().get(0).getCompetidores().get(0);
        assertEquals(50, c.getPuntos());
        assertEquals(1, c.getRankingMundial());
    }
}