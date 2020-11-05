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
        public void encenderAlrededor(int i, int j,JButton[][] MatrizTablero){
        MatrizTablero[i][j].setEnabled(true);
        if(Tablero[i+1][j]==0){
            MatrizTablero[i+1][j].setEnabled(true);
        }else{
            if(Tablero[i+1][j]==1){
                if(Tablero[i+2][j]==0){
                    MatrizTablero[i+2][j].setEnabled(true);
                }
                else{
                    
                }
            }else{
                
            }
        }
        if(Tablero[i-1][j]==0){
            MatrizTablero[i-1][j].setEnabled(true);
        }else{
            if(Tablero[i-1][j]==1){
                if(Tablero[i-2][j]==0){
                    MatrizTablero[i-2][j].setEnabled(true);
                }
                else{
                    
                }
            }else{
                
            }
        
        }
        if(Tablero[i][j+1]==0){
            MatrizTablero[i][j+1].setEnabled(true);
        }
        else{
            if(Tablero[i][j+1]==1){
                if(Tablero[i][j+2]==0){
                    MatrizTablero[i][j+2].setEnabled(true);
                }
                else{
                    
                }
            }else{
                
            }
        }
        
        if(Tablero[i][j-1]==0){
            MatrizTablero[i][j-1].setEnabled(true);
        }else{
            if(Tablero[i][j-1]==1){
                if(Tablero[i][j-2]==0){
                    MatrizTablero[i][j-2].setEnabled(true);
                }
                else{
                    
                }
            }else{
                
            }
        }
        }
        public void atacar(){
            //Lo dejaste por aqui
            if(Tablero[this.X+1][this.Y]==5){
                
            }
            if(Tablero[this.X-1][this.Y]==5){
                
            }
            if(Tablero[this.X][this.Y+1]==5){
                
            }
            if(Tablero[this.X+1][this.Y-1]==5){
                
            }
        }
        
        
        
        
        
    }


