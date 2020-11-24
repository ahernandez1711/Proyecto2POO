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
public class Rango extends Personaje{
    public String Nombre="Tsuki";
    public Mascota Pet;
    public Zombie Marcado;
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


    public void atacarDerecha(JButton[][] Matriz) {
        try{
        for (int i = 0; i < 24; i++) {
            if(Tablero[this.X+i][this.Y]==1){
                break;
            }
            if(Tablero[this.X+i][this.Y]==5){
                Matriz[this.X+i][this.Y].setEnabled(true);
            }
        }
        }
        catch(Exception e){
            
        }
        
    }
    public void atacarIzquierda(JButton[][] Matriz) {
        try{
        for (int i = 0; i < 24; i++) {
            if(Tablero[this.X-i][this.Y]==1){
                break;
            }
            if(Tablero[this.X-i][this.Y]==5){
                Matriz[this.X-i][this.Y].setEnabled(true);
            }
        }
        }
        catch(Exception e){
            
        }
        
    }
    public void atacarArriba(JButton[][] Matriz) {
        try{
        for (int i = 0; i < 16; i++) {
            if(Tablero[this.X][this.Y+i]==1){
                break;
            }
            if(Tablero[this.X][this.Y+i]==5){
                Matriz[this.X][this.Y+i].setEnabled(true);
            }
        }
        }
        catch(Exception e){
            
        }
        
    }
    public void atacarAbajo(JButton[][] Matriz) {
        try{
        for (int i = 0; i < 16; i++) {
            if(Tablero[this.X][this.Y-i]==1){
                break;
            }
            if(Tablero[this.X][this.Y-i]==5){
                Matriz[this.X][this.Y-i].setEnabled(true);
            }
        }
        }
        catch(Exception e){
            
        }
        
    }

    @Override
    public void atacar(JButton[][] Matriz) {
        atacarAbajo(Matriz);
        atacarArriba(Matriz);
        atacarDerecha(Matriz);
        atacarIzquierda(Matriz);
    }
    
}
