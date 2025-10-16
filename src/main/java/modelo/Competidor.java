/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

/**
 *
 * @author 9spot
 */
public class Competidor extends Persona {
    private int rankingMundial;
    private double estatura;
    private double peso;
    private int puntos; 

    public Competidor(String nombre, int edad, String pais, int rankingMundial, double estatura, double peso) {
        super(nombre, edad, pais);
        this.rankingMundial = rankingMundial;
        this.estatura = estatura;
        this.peso = peso;
        this.puntos = 0;
    }

    public int getRankingMundial() { return rankingMundial; }
    public void setRankingMundial(int rankingMundial) { this.rankingMundial = rankingMundial; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public void actualizarPuntos(int puntosObtenidos) {
        this.puntos += puntosObtenidos;
    }

    public void actualizarPuntos(int puntosObtenidos, boolean mostrarDetalle) {
        this.puntos += puntosObtenidos;
    }

    public String obtenerDatos() {
        return toString();
    }

    public String obtenerDatos(boolean conPuntos) {
        if (conPuntos) {
            return toString() + ", Ranking: " + rankingMundial + ", Puntos: " + puntos;
        } else {
            return toString();
        }
    }

    @Override
    public String toString() {
        return super.toString()
             + ", Ranking mundial: " + rankingMundial
             + ", Estatura: " + estatura + "m, Peso: " + peso + "kg";
    }
}
