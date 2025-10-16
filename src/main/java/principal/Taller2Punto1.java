/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

/**
 *
 * @author 9spot
 */
import modelo.*;
import controlador.Controlador;
import vista.Vista;

public class Taller2Punto1 {

    public static void main(String[] args) {
        Competencia competencia = new Competencia("Mundial Ciclismo Pista - Cali");
        Vista vista = new Vista();
        Controlador controlador = new Controlador(competencia, vista);

        Equipo equipoA = new Equipo("Velocistas COL", "Colombia");
        Equipo equipoB = new Equipo("Sprint Team ESP", "España");

        Competidor c1 = new Competidor("Andrés Pérez", 24, "Colombia", 15, 1.78, 72.0);
        Competidor c2 = new Competidor("María López", 22, "Colombia", 20, 1.65, 60.0);
        Competidor c3 = new Competidor("Jorge Martín", 27, "España", 10, 1.80, 75.0);

        equipoA.agregarCompetidor(c1);
        equipoA.agregarCompetidor(c2);
        equipoB.agregarCompetidor(c3);

        competencia.agregarEquipo(equipoA);
        competencia.agregarEquipo(equipoB);

        String reporteDemo = competencia.generarReporte();
        System.out.println("inserción automática desde main" + reporteDemo);

        try {
            vista.mostrarMensaje("Reporte demo creado.");
            vista.mostrarMensaje(reporteDemo);
        } catch (Exception ex) {
            System.err.println("no se pudo mostrar el reporte en la vista (entorno GUI).");
        }
        controlador.iniciar();
    }
}
