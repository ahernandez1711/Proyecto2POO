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
    public String Nombre;
    public Mascota Pet;
    public Rango(int Distancia, int Evasion, int Critico, int Capacidad, int CantidadCuraciones, int Vida, int Ataque, int Movimientos, int Defensa) {
        super(Distancia, Evasion, Critico, Capacidad, CantidadCuraciones, Vida, Ataque, Movimientos, Defensa);
    }

    @Override
    public void SubirNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
