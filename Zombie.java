/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograpoozombiedefense;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author pablo
 */
public class Zombie extends Base {
    public int Tipo;
    public int Tablero[][];
    public int Evasion;
    public int Defensa;
    public boolean movimiento=true;
    public Zombie(int Vida, int Ataque, int Movimientos) {
        super(Vida, Ataque, Movimientos);
    }
    public void ZombieMovimiento(JButton[][] Matriz){
        
        if(this.Y>=8){
            if(this.Y==8){
                        if(Tablero[this.X-1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X-=1;
                        Tablero[this.X][this.Y]=5;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
                    }
            }else{
                MovimientoArriba(Matriz);
                
            }          
            }else{
                if(Y==7){
                        if(Tablero[this.X-1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X-=1;
                        Tablero[this.X][this.Y]=5;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
                }else{
                    
                }
               
            }else{
            movimientoAbajo(Matriz);     
        }
        }
    }
    
    /**
     *
     */
    public void MovimientoArriba(JButton[][] Matriz){
                if(Tablero[this.X][this.Y-1]==0){
                //Moverse arriba, limpiar la casilla en la que está y moverse a la de arriba
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.Y-=1;
                        Tablero[this.X][this.Y]=5;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
            }
            else{
                //No se puede mover hacia Arriba
                if(movimiento){
                    if(Tablero[this.X+1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X+=1;
                        Tablero[this.X][this.Y]=5;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
                }else{
                        movimiento=!movimiento;
                    }
                }else{
                    if(Tablero[this.X-1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X-=1;
                        Tablero[this.X][this.Y]=5;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
                    }
                    else{
                        movimiento=!movimiento;
                    }
            }
            }
} 
public void movimientoAbajo(JButton[][] Matriz){
    try{
            if(Tablero[this.X][this.Y+1]==0){
                Tablero[this.X][this.Y]=0;
                //Moverse abajo, limpiar la casilla en la que está y moverse a la de abajo
                Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                this.Y+=1;
                Tablero[this.X][this.Y]=5;
                Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
                
            }
            else{
                //No se puede mover hacia rariba
                if(movimiento){
                    
                    if(Tablero[this.X+1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X+=1;
                        Tablero[this.X][this.Y]=5;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
                        
                        
                }else{
                        movimiento=!movimiento;
                    }
                }else{
                    if(Tablero[this.X-1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X-=1;
                        Tablero[this.X][this.Y]=5;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                        
                    }
                    else{
                        movimiento=!movimiento;
                    }
            }
            }
                
            }catch(Exception e){
    
}
}
public void PintarseSolos(JButton[][] Matriz){
                Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
}
public boolean AquiEstoy(int x, int y){
    if(this.X==x&&this.Y==y){
        return true;
    }
    return false;
}
}



    
