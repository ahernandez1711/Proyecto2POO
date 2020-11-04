/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograpoozombiedefense;

/**
 *
 * @author pablo
 */
public class Rango extends Personaje{
    public String Nombre="Tsuki";
    public Mascota Pet;
    public Rango(int Distancia, int Evasion, int Critico, int Capacidad, int CantidadCuraciones, int Vida, int Ataque, int Movimientos, int Defensa,int[][] Tablero) {
        super(Distancia, Evasion, Critico, Capacidad, CantidadCuraciones, Vida, Ataque, Movimientos, Defensa, Tablero);
    }

    @Override
    public void SubirNivel() {
        this.Nivel++;
        this.VidaMax+=10;
        this.Critico+=2;
        this.Capacidad++;
        this.CantidadCuraciones++;
    }
}
