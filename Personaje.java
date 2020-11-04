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
public abstract class Personaje extends Base {
    public int Distancia;
    public int Nivel;
    public int Experiencia;
    public int Evasion;
    public int Critico;
    public int[][] Tablero;
    public int Capacidad;
    public int Defensa;
    public int CantidadCuraciones;

    public Personaje(int Distancia, int Evasion, int Critico, int Capacidad, int CantidadCuraciones, int Vida, int Ataque, int Movimientos,int Defensa, int Tablero[][]) {
        super(Vida, Ataque, Movimientos);
        this.Distancia = Distancia;
        this.Nivel = 1;
        this.Experiencia = 0;
        this.Evasion = Evasion;
        this.Critico = Critico;
        this.Capacidad = Capacidad;
        this.CantidadCuraciones = CantidadCuraciones;
        this.Defensa=Defensa;
        this.Tablero=Tablero;
    }
    public void Curarse(){
        if(CantidadCuraciones==0){
            
        }else{
            CantidadCuraciones-=1;
            Vida=VidaMax;
        }
    }
    public abstract void SubirNivel();
    
    
    
}
