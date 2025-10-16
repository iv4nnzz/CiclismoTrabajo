/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

/**
 *
 * @author 9spot
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Competencia {
    private String nombreEvento;
    private List<Equipo> equipos;

    public Competencia(String nombreEvento) {
        this.nombreEvento = nombreEvento;
        this.equipos = new ArrayList<>();
    }

    public String getNombreEvento() { return nombreEvento; }
    public void setNombreEvento(String nombreEvento) { this.nombreEvento = nombreEvento; }

    public List<Equipo> getEquipos() { return equipos; }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de la competencia: ").append(nombreEvento).append("\n\n");
        if (equipos.isEmpty()) {
            sb.append("No hay equipos registrados.\n");
        } else {
            for (Equipo e : equipos) {
                sb.append(e.obtenerDatosEquipo()).append("\n");
            }
        }
        return sb.toString();
    }

    public void actualizarRankingsGlobal() {
        List<Competidor> todos = new ArrayList<>();
        for (Equipo e : equipos) {
            todos.addAll(e.getCompetidores());
        }

        Collections.sort(todos, new Comparator<Competidor>() {
            @Override
            public int compare(Competidor o1, Competidor o2) {
                return Integer.compare(o2.getPuntos(), o1.getPuntos());
            }
        });

        int indice = 0;
        int rankingActual = 0;
        Integer puntosPrev = null;

        for (Competidor c : todos) {
            indice++;
            if (puntosPrev != null && c.getPuntos() == puntosPrev) {
                c.setRankingMundial(rankingActual);
            } else {
                rankingActual = indice;
                c.setRankingMundial(rankingActual);
            }
            puntosPrev = c.getPuntos();
        }
    }
}
