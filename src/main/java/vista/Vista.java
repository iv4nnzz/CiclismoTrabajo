/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vista;

/**
 *
 * @author 9spot
 */
import javax.swing.JOptionPane;
import modelo.Equipo;
import java.util.List;

public class Vista {

    public int mostrarMenu() {
        String menu = "Seleccione una opción:\n"
                + "1. Agregar equipo\n"
                + "2. Agregar competidor a un equipo\n"
                + "3. Actualizar puntos de un competidor\n"
                + "4. Finalizar evento y actualizar rankings (global)\n"
                + "5. Generar reporte de la competencia\n"
                + "6. Mostrar competidores de un equipo\n"
                + "7. Salir";
        String resp = JOptionPane.showInputDialog(null, menu, "Menú", JOptionPane.PLAIN_MESSAGE);
        if (resp == null) return 7; 
        try {
            return Integer.parseInt(resp);
        } catch (Exception e) {
            return -1;
        }
    }

    public String pedirTexto(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String elegirEquipoTexto(List<Equipo> equipos) {
        if (equipos.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < equipos.size(); i++) {
            sb.append(i).append(". ").append(equipos.get(i).getNombre())
              .append(" (").append(equipos.get(i).getPais()).append(")\n");
        }
        return sb.toString();
    }

    public String listarCompetidoresSimple(List<Equipo> equipos, int indiceEquipo) {
        if (equipos.isEmpty() || indiceEquipo < 0 || indiceEquipo >= equipos.size()) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < equipos.get(indiceEquipo).getCompetidores().size(); i++) {
            sb.append(i).append(". ").append(equipos.get(indiceEquipo).getCompetidores().get(i).getNombre()).append("\n");
        }
        return sb.toString();
    }
}

