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
public abstract class Base {
    public int VidaMax;
    public int Vida;
    public int Ataque;
    public int Movimientos;

    public Base(int Vida, int Ataque, int Movimientos) {
        this.VidaMax = Vida;
        this.Vida=VidaMax;
        this.Ataque = Ataque;
        this.Movimientos = Movimientos;
    }
    
    
}
