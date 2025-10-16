/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

/**
 *
 * @author 9spot
 */
import java.util.ArrayList;
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
}
