/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograpoozombiedefense;

import javax.swing.JButton;

/**
 *
 * @author pablo
 */
public class Tanque extends Personaje {
    public String Nombre="Taiyo";
    public Tanque(int Distancia, int Evasion, int Critico, int Capacidad, int CantidadCuraciones, int Vida, int Ataque, int Movimientos, int Defensa, int[][] Tablero) {
        super(Distancia, Evasion, Critico, Capacidad, CantidadCuraciones, Vida, Ataque, Movimientos, Defensa,Tablero);
    }
    @Override
    public void SubirNivel(){
        this.Nivel++;
        this.VidaMax+=100;
        this.Defensa++;
        Evasion++;
        if(Nivel%2==0){
            this.Capacidad++;
        }
        this.CantidadCuraciones++;
    }

    @Override
    public void atacar(JButton[][] Matriz) {
        if(Tablero[this.X+1][this.Y]==5){
                    Matriz[this.X+1][this.Y].setEnabled(true);
            }
            if(Tablero[this.X-1][this.Y]==5){
                    Matriz[this.X-1][this.Y].setEnabled(true);
            }
            if(Tablero[this.X][this.Y+1]==5){       
                    Matriz[this.X][this.Y+1].setEnabled(true);
            }
            if(Tablero[this.X][this.Y-1]==5){
                    Matriz[this.X][this.Y-1].setEnabled(true);
            }
            if(Tablero[this.X-1][this.Y-1]==5){
                    Matriz[this.X-1][this.Y-1].setEnabled(true);
            }
            if(Tablero[this.X+1][this.Y-1]==5){
                    Matriz[this.X+1][this.Y-1].setEnabled(true);
            }
            if(Tablero[this.X+1][this.Y+1]==5){
                    Matriz[this.X+1][this.Y+1].setEnabled(true);
            }
            if(Tablero[this.X-1][this.Y+1]==5){
                    Matriz[this.X-1][this.Y+1].setEnabled(true);
            }
    }
}
