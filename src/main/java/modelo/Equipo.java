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

public class Equipo {
    private String nombre;
    private String pais;
    private List<Competidor> competidores;

    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.competidores = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public List<Competidor> getCompetidores() { return competidores; }

    public void agregarCompetidor(Competidor c) {
        competidores.add(c);
    }

    public void agregarCompetidor(String nombre, int edad, String pais, int ranking, double estatura, double peso) {
        Competidor c = new Competidor(nombre, edad, pais, ranking, estatura, peso);
        competidores.add(c);
    }

    public String obtenerDatosEquipo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo: ").append(nombre).append(" (").append(pais).append(")\n");
        if (competidores.isEmpty()) {
            sb.append("  No tiene competidores aún.\n");
        } else {
            for (Competidor c : competidores) {
                sb.append("  - ").append(c.obtenerDatos(true)).append("\n");
            }
        }
        return sb.toString();
    }
}
