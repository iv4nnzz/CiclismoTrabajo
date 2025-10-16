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