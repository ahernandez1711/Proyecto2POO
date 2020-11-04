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
public class Mascota extends Personaje {
    public String Nombre= "Shinaina";
    public Rango Dueño;
    public Mascota(int Distancia, int Evasion, int Critico, int Capacidad, int CantidadCuraciones, int Vida, int Ataque, int Movimientos,int Defensa,int[][] Tablero) {
        super(Distancia, Evasion, Critico, Capacidad, CantidadCuraciones, Vida, Ataque, Movimientos,Defensa,Tablero);
    }

    @Override
    public void SubirNivel() {
        this.Nivel++;
        this.VidaMax+=75;
        this.Defensa++;
        Evasion++;
        if(Nivel%2==0){
            this.Capacidad++;
        }
        this.CantidadCuraciones++;
    }
    
}
