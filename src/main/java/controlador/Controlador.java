/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controlador;

/**
 *
 * @author 9spot
 */
import modelo.*;
import vista.Vista;

public class Controlador {
    private Competencia competencia;
    private Vista vista;

    public Controlador(Competencia competencia, Vista vista) {
        this.competencia = competencia;
        this.vista = vista;
    }

    public void iniciar() {
        boolean seguir = true;
        while (seguir) {
            int opcion = vista.mostrarMenu();

            if (opcion == 1) {
                manejarAgregarEquipo();
            } else if (opcion == 2) {
                manejarAgregarCompetidor();
            } else if (opcion == 3) {
                manejarActualizarPuntos();
            } else if (opcion == 4) {
                manejarFinalizarEvento();
            } else if (opcion == 5) {
                manejarGenerarReporte();
            } else if (opcion == 6) {
                manejarMostrarCompetidoresEquipo();
            } else if (opcion == 7) {
                seguir = false;
            } else {
                vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void manejarAgregarEquipo() {
        String nombre = vista.pedirTexto("Nombre del equipo:");
        if (nombre == null || nombre.trim().isEmpty()) { vista.mostrarMensaje("Operación cancelada."); return; }
        String pais = vista.pedirTexto("País del equipo:");
        if (pais == null || pais.trim().isEmpty()) { vista.mostrarMensaje("Operación cancelada."); return; }
        Equipo e = new Equipo(nombre.trim(), pais.trim());
        competencia.agregarEquipo(e);
        vista.mostrarMensaje("Equipo agregado: " + nombre);
    }

    private void manejarAgregarCompetidor() {
        if (competencia.getEquipos().isEmpty()) {
            vista.mostrarMensaje("No hay equipos. Primero agregue un equipo.");
            return;
        }
        String lista = vista.elegirEquipoTexto(competencia.getEquipos());
        String sel = vista.pedirTexto("Ingrese el índice del equipo:\n" + lista);
        if (sel == null) { vista.mostrarMensaje("Cancelado."); return; }
        int idx;
        try {
            idx = Integer.parseInt(sel);
            if (idx < 0 || idx >= competencia.getEquipos().size()) {
                vista.mostrarMensaje("Índice inválido.");
                return;
            }
        } catch (Exception ex) {
            vista.mostrarMensaje("Índice inválido.");
            return;
        }

        String nombre = vista.pedirTexto("Nombre del competidor:");
        if (nombre == null || nombre.trim().isEmpty()) { vista.mostrarMensaje("Operación cancelada."); return; }
        int edad = pedirEntero("Edad del competidor:");
        String pais = vista.pedirTexto("País del competidor:");
        if (pais == null || pais.trim().isEmpty()) { vista.mostrarMensaje("Operación cancelada."); return; }
        int ranking = pedirEntero("Ranking mundial (número):");
        double estatura = pedirDouble("Estatura (metros):");
        double peso = pedirDouble("Peso (kg):");

        Competidor c = new Competidor(nombre.trim(), edad, pais.trim(), ranking, estatura, peso);
        competencia.getEquipos().get(idx).agregarCompetidor(c);
        vista.mostrarMensaje("Competidor agregado al equipo " + competencia.getEquipos().get(idx).getNombre());
    }

    private void manejarActualizarPuntos() {
        if (competencia.getEquipos().isEmpty()) {
            vista.mostrarMensaje("No hay equipos.");
            return;
        }

        String lista = vista.elegirEquipoTexto(competencia.getEquipos());
        String sel = vista.pedirTexto("Ingrese el índice del equipo:\n" + lista);
        if (sel == null) { vista.mostrarMensaje("Cancelado."); return; }

        int idx;
        try {
            idx = Integer.parseInt(sel);
            if (idx < 0 || idx >= competencia.getEquipos().size()) { vista.mostrarMensaje("Índice inválido."); return; }
        } catch (Exception ex) { vista.mostrarMensaje("Índice inválido."); return; }

        Equipo equipo = competencia.getEquipos().get(idx);
        if (equipo.getCompetidores().isEmpty()) {
            vista.mostrarMensaje("El equipo no tiene competidores.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < equipo.getCompetidores().size(); i++) {
            sb.append(i).append(". ").append(equipo.getCompetidores().get(i).getNombre()).append("\n");
        }
        String selComp = vista.pedirTexto("Seleccione competidor por índice:\n" + sb.toString());
        if (selComp == null) { vista.mostrarMensaje("Cancelado."); return; }
        int idxComp;
        try {
            idxComp = Integer.parseInt(selComp);
            if (idxComp < 0 || idxComp >= equipo.getCompetidores().size()) { vista.mostrarMensaje("Índice inválido."); return; }
        } catch (Exception ex) { vista.mostrarMensaje("Índice inválido."); return; }

        int puntos = pedirEntero("Puntos obtenidos por el competidor (entero):");

        String mostrar = vista.pedirTexto("¿Mostrar detalle de la actualización? (s/n):");
        boolean mostrarDetalle = mostrar != null && mostrar.trim().equalsIgnoreCase("s");

        Competidor c = equipo.getCompetidores().get(idxComp);
        if (mostrarDetalle) {
            c.actualizarPuntos(puntos, true);
        } else {
            c.actualizarPuntos(puntos);
        }

        competencia.actualizarRankingsGlobal();

        vista.mostrarMensaje("Puntos actualizados.\nCompetidor: " + c.getNombre()
                + "\nNuevo ranking: " + c.getRankingMundial() + ", Puntos: " + c.getPuntos());
    }

}

