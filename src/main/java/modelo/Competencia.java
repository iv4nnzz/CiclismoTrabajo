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

}
