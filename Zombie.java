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
import javax.swing.JTextArea;

/**
 *
 * @author pablo
 */
public class Zombie extends Base {
    public int Tipo;
    public int Tablero[][];
    public int Evasion=0;
    public int PosicionEnemiga=0;
    public int Defensa=0;
    public boolean movimiento=true;
    public boolean ZombieRapido=false;
    public boolean ZombieTanque=false;
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
                        PintarseSolos(Matriz);
                        
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
                        PintarseSolos(Matriz);
                        
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
                        PintarseSolos(Matriz);
                        
            }
            else{
                //No se puede mover hacia Arriba
                if(movimiento){
                    if(Tablero[this.X+1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X+=1;
                        Tablero[this.X][this.Y]=5;
                        PintarseSolos(Matriz);
                        
                }else{
                        movimiento=!movimiento;
                    }
                }else{
                    if(Tablero[this.X-1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X-=1;
                        Tablero[this.X][this.Y]=5;
                        PintarseSolos(Matriz);
                        
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
                PintarseSolos(Matriz);
                        
                
            }
            else{
                //No se puede mover hacia rariba
                if(movimiento){
                    
                    if(Tablero[this.X+1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X+=1;
                        Tablero[this.X][this.Y]=5;
                       PintarseSolos(Matriz);
                        
                        
                        
                }else{
                        movimiento=!movimiento;
                    }
                }else{
                    if(Tablero[this.X-1][this.Y]==0){
                        Tablero[this.X][this.Y]=0;
                        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                        this.X-=1;
                        Tablero[this.X][this.Y]=5;
                        PintarseSolos(Matriz);
                        
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
    if(this.ZombieRapido){
        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"ZombieAtleta"+".png"));
    }else if(ZombieTanque){
        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"ZombieTanque"+".png"));
    }else{
        Matriz[this.X][this.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
    }
                
}
public boolean AquiEstoy(int x, int y){
    if(this.X==x&&this.Y==y){
        return true;
    }
    return false;
}
public boolean EstaPj(int Jugador){
    
    if(Tablero[X+1][Y]==Jugador){
        return true;
    }
    if(Tablero[X][Y+1]==Jugador){
        return true;
    }
    if(Tablero[X-1][Y]==Jugador){
        return true;
    }
    if(Tablero[X][Y-1]==Jugador){
        return true;
    }
    return false;
}
public void Ataque(Tanque Tan, Rango Ran, Mascota Pet,JTextArea Area){
    if(EstaPj(7)){
        if(Esquivar(Ran.Evasion)){
            Area.append("Zombie a intentado atacar a "+Ran.Nombre+", pero ha fallado \n");
        }else{
            int Ataque=250-(250/100)*Ran.Defensa;
            Ran.Vida-=Ataque;
            Area.append("Zombie a atacado a "+Ran.Nombre+" por "+Ataque+" de daño \n");
            if(Ran.Vida<=0){
                Area.append("Zombie ha matado a "+Ran.Nombre+ "\n");
                Tablero[Ran.X][Ran.Y]=0;
                
            }
        }
        
    } else if(EstaPj(8)){
        if(Esquivar(Tan.Evasion)){
            Area.append("Zombie a intentado atacar a "+Tan.Nombre+", pero ha fallado \n");
        }else{
            int Ataque=250-(250/100)*Tan.Defensa;
            Tan.Vida-=Ataque;
            Area.append("Un zombie a atacado a "+Tan.Nombre+" por "+Ataque+" de daño \n");
            if(Tan.Vida<=0){
                Area.append("Zombie ha matado a "+Tan.Nombre+ "\n");
                Tablero[Tan.X][Tan.Y]=0;
                
            }
        }
    }else{
        if(Esquivar(Pet.Evasion)){
            Area.append("Zombie a intentado atacar a "+Pet.Nombre+", pero ha fallado \n");
        }else{
            int Ataque=250-(250/100)*Pet.Defensa;
            Pet.Vida-=Ataque;
            Area.append("Zombie a atacado a "+Pet.Nombre+" por "+Ataque+" de daño \n");
            if(Pet.Vida<=0){
                Area.append("Zombie ha matado a "+Pet.Nombre+ "\n");
                Tablero[Pet.X][Pet.Y]=0;
                
            }
        }
    }
}
public boolean Esquivar(int prob){
    Random R= new Random();
    if(R.nextInt(100)<prob){
        return true;
    }else{
        return false;
    }
}

}



    
