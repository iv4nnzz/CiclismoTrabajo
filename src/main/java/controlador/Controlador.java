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
}
