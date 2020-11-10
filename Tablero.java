/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograpoozombiedefense;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author pablo
 */
public class Tablero implements ActionListener{
    public GUITablero GUI= new GUITablero();
    public int[][] Tablero= new int[24][16];
    public Mascota Pet;
    public Tanque Tan;
    public Rango Ran;
    public boolean Modo=true;
    public JButton[][] MatrizTablero= new JButton[24][16];
    public int turno;
    public int jugando=6;
    public Boolean AtackMode=false; 
    public ArrayList<Zombie> ListaZombies=new ArrayList();
    public ArrayList<Integer> Spawners= new ArrayList();

    public Tablero() {
        GUI.BtnReload.addActionListener(this);
        GUI.BtnAtaque.addActionListener(this);
        
        Spawners.add(1);
        Spawners.add(1);
        
        Spawners.add(22);
        Spawners.add(1);
        
        Spawners.add(1);
        Spawners.add(14);
        
        Spawners.add(22);
        Spawners.add(14);

        
        GUI.BtnCambiar.addActionListener(this);
        GUI.BtnVision.addActionListener(this);
        
        Pet= new Mascota(1,40,10, 3, 0, 500, 200,4 , 10, Tablero);
        Pet.X=2;
        Pet.Y=8;
        Tan= new Tanque(1,10, 0,3,3 ,1500, 200, 2, 40, Tablero);
        Tan.X=1;
        Tan.Y=7;
        Ran = new Rango(24, 0, 20, 2, 3, 750, 300, 1, 0, Tablero);
        Ran.X=1;
        Ran.Y=8;
        
        for (int i = 0; i < 24; i++) {
            Tablero[i][0]=4;
            Tablero[i][15]=4;
        }
        
        for (int i = 0; i < 16; i++) {
            Tablero[0][i]=4;
            Tablero[23][i]=4;
        }
        
        Tablero[Pet.X][Pet.Y]=6;
        Tablero[Tan.X][Tan.Y]=7;
        Tablero[Ran.X][Ran.Y]=8;
        //Lineas y creacion del mapa
        Tablero[1][6]=1;
        Tablero[2][6]=1;
        Tablero[3][6]=1;
        Tablero[4][6]=1;
        Tablero[5][6]=1;
        Tablero[6][6]=1;
        Tablero[7][6]=1;
        Tablero[8][6]=1;
        Tablero[9][6]=1;
        Tablero[10][6]=1;
        Tablero[13][6]=1;
        Tablero[14][6]=1;
        Tablero[15][6]=1;
        Tablero[16][6]=1;
        Tablero[17][6]=1;
        Tablero[18][6]=1;
        Tablero[19][6]=1;
        Tablero[20][6]=1;
        Tablero[20][4]=1;
        Tablero[20][3]=1;
        
        
        Tablero[4][4]=1;
        Tablero[4][3]=1;
        Tablero[5][3]=1;
        Tablero[8][3]=1;
        Tablero[9][3]=1;
        Tablero[10][3]=1;
        Tablero[11][3]=1;
        Tablero[12][3]=1;
        Tablero[13][3]=1;
        Tablero[14][3]=1;
        Tablero[15][3]=1;
        Tablero[18][3]=1;
        Tablero[19][3]=1;
        

        Tablero[4][11]=1;
        Tablero[4][12]=1;
        Tablero[5][12]=1;
        Tablero[8][12]=1;
        Tablero[9][12]=1;
        Tablero[10][12]=1;
        Tablero[11][12]=1;
        Tablero[12][12]=1;
        Tablero[13][12]=1;
        Tablero[14][12]=1;
        Tablero[15][12]=1;
        Tablero[18][12]=1;
        Tablero[19][12]=1;
        Tablero[20][12]=1;
        Tablero[20][11]=1;
        Tablero[20][9]=1;
        
        
        Tablero[1][9]=1;
        Tablero[2][9]=1;
        Tablero[3][9]=1;
        Tablero[4][9]=1;
        Tablero[5][9]=1;
        Tablero[6][9]=1;
        Tablero[7][9]=1;
        Tablero[8][9]=1;
        Tablero[9][9]=1;
        Tablero[10][9]=1;
        Tablero[10][9]=1;
        Tablero[13][9]=1;
        Tablero[14][9]=1;
        Tablero[15][9]=1;
        Tablero[16][9]=1;
        Tablero[17][9]=1;
        Tablero[18][9]=1;
        Tablero[19][9]=1;
        
        Tablero[0][7]=3;
        Tablero[0][8]=3;
        pintarSpawners();
         _init_();
        Tags();
        apagarTodo();
        Pet.encenderAlrededor(Pet.X, Pet.Y, MatrizTablero);
        ZombieSpawn();
        paint();
        
        

        
        paint();
    }
    public void _init_(){
        generarBotones();
    }
    public void generarBotones(){
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
                JButton Boton= new JButton();
                Boton.addActionListener(this);
                MatrizTablero[i][j]=Boton;
                Border emptyBorder = BorderFactory.createEmptyBorder();
                Boton.setBorder(emptyBorder);
                Boton.setSize(50, 50);
                if(Tablero[i][j]>5){
                    if(Tablero[i][j]==6){
                        Boton.setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Z"+".png"));
                    }
                }
                else{
                Boton.setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+Tablero[i][j]+".png"));
                }
                GUI.PnlFondo.add(Boton);
                Boton.setLocation(i*50, j*50);
            }
        }
    } 
    public void encenderTodo(){
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
                MatrizTablero[i][j].setEnabled(true);
            }
            
        }
    }
    public void apagarTodo(){
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
                if(MatrizTablero[i][j].isEnabled()){
                    MatrizTablero[i][j].setEnabled(false);
                }else{}
            }
            
        }
    }      
    public void encenderAlrededor(int i, int j){
        MatrizTablero[i][j].setEnabled(true);
        if(Tablero[i+1][j]==0){
            MatrizTablero[i+1][j].setEnabled(true);
        }else{
            
        }
        if(Tablero[i-1][j]==0){
            MatrizTablero[i-1][j].setEnabled(true);
        }else{
            
        }
        if(Tablero[i][j+1]==0){
            MatrizTablero[i][j+1].setEnabled(true);
        }
        else{
            
        }
        if(Tablero[i][j-1]==0){
            MatrizTablero[i][j-1].setEnabled(true);
        }else{
            
        }
    }
    public void pintarSpawners(){
        for (int i = 0; i < Spawners.size()/2; i++) {
            Tablero[Spawners.get(i+i)][Spawners.get(i+i+1)]=2;
            
        }
    }
    public void paint(){
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
                if(Tablero[i][j]>=5){
                 if(Tablero[i][j]==5){
                        MatrizTablero[i][j].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Zombie"+".png"));
                }else if(Tablero[i][j]==6){
                        MatrizTablero[i][j].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Z"+".png"));
                    }else if(Tablero[i][j]==7){
                        MatrizTablero[i][j].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"T"+".png"));
                    } else{
                        MatrizTablero[i][j].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"R"+".png"));
                    }
                }
                else{
                MatrizTablero[i][j].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+Tablero[i][j]+".png"));
                }
            }
        }
    }
    public void Encender_Aux(){
        apagarTodo();
        if(jugando==6){
            encenderAlrededor(Pet.X, Pet.Y);
        }else if(jugando==7){
            encenderAlrededor(Tan.X, Tan.Y);
        }else{
            encenderAlrededor(Ran.X, Ran.Y);
        }
    }
    public void jugando(){
        if(jugando==6){
            jugando=7;
            Tan.Movimientos=2;
            GUI.LblTanqueMovimientos.setText(Tan.Movimientos+"");
            encenderAlrededor(Tan.X, Tan.Y);
            if(Tan.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
        } else if(jugando==7){
            jugando=8;
            Ran.Movimientos=1;
            GUI.LblRangoMovimientos.setText(Ran.Movimientos+"");
            encenderAlrededor(Ran.X, Ran.Y);
            if(Ran.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
        } else{
            for (int i = 0; i < ListaZombies.size(); i++) {
                ListaZombies.get(i).ZombieMovimiento(MatrizTablero);
                
            }
             ZombieSpawn();          
            
            jugando=6;
            Pet.Movimientos=4;
            if(Pet.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
            GUI.LblPetMovimientos.setText(Pet.Movimientos+"");
            Pet.encenderAlrededor(Pet.X, Pet.Y, MatrizTablero);
        }
    }
    public void Leveling(){
        if(Pet.Experiencia>=300){
            Pet.SubirNivel();
            
            Pet.Experiencia-=300;
            Pet.Vida=Pet.VidaMax;
            GUI.TxALog.append(Pet.Nombre+" ha subido de nivel"+"\n");
            GUI.LblPetLvl.setText(Pet.Nivel+"");
            GUI.LblPetXp.setText(Pet.Experiencia+"");
            Tags();
        }
        if(Tan.Experiencia>=300){
            
            Tan.SubirNivel();
            Tan.Experiencia-=300;
            Tan.Vida=Tan.VidaMax;
            GUI.TxALog.append(Tan.Nombre+" ha subido de nivel"+"\n");
            GUI.LblTanqueLvl.setText(Tan.Nivel+"");
            GUI.LblTanqueXp.setText(Tan.Experiencia+"");
            Tags();
        }
        if(Ran.Experiencia>=300){
            
            Ran.SubirNivel();
            Ran.Vida=Ran.VidaMax;
            GUI.TxALog.append(Ran.Nombre+" ha subido de nivel"+"\n");
            GUI.LblPetLvl.setText(Ran.Nivel+"");
            Ran.Experiencia-=300;
            GUI.LblRangoLvl.setText(Ran.Nivel+"");
            GUI.LblRangoXp.setText(Ran.Experiencia+"");
            Tags();
        }
    }
    public void paintSolo(int x,int y){
                if(Tablero[x][y]>5){
                     if(Tablero[x][y]==6){
                        MatrizTablero[x][y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"Z"+".png"));
                    }else if(Tablero[x][y]==7){
                        MatrizTablero[x][y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"R"+".png"));
                    } else{
                        MatrizTablero[x][y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"T"+".png"));
                    }
                }
                else{
                MatrizTablero[x][y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+Tablero[x][y]+".png"));
                }
            
        
    }
    public ArrayList<Integer> EncontrarPuntoSpawn(int x, int y){
        ArrayList<Integer> SpawnPoints= new ArrayList();
        if(EncontrarPuntoSpawn_Aux(x, y+1)){
            SpawnPoints.add(x);
            SpawnPoints.add(y+1);
        }
        if(EncontrarPuntoSpawn_Aux(x, y-1)){
            SpawnPoints.add(x);
            SpawnPoints.add(y-1);
        }
        if(EncontrarPuntoSpawn_Aux(x+1, y)){
            SpawnPoints.add(x+1);
            SpawnPoints.add(y);
        }
        if(EncontrarPuntoSpawn_Aux(x-1, y)){
            SpawnPoints.add(x-1);
            SpawnPoints.add(y);
        }
        if(EncontrarPuntoSpawn_Aux(x+1, y+1)){
            SpawnPoints.add(x+1);
            SpawnPoints.add(y+1);
        }
        if(EncontrarPuntoSpawn_Aux(x+1, y-1)){
            SpawnPoints.add(x+1);
            SpawnPoints.add(y-1);
        }
        if(EncontrarPuntoSpawn_Aux(x-1, y-1)){
            SpawnPoints.add(x-1);
            SpawnPoints.add(y-1);
        }
        if(EncontrarPuntoSpawn_Aux(x-1, y+1)){
            SpawnPoints.add(x-1);
            SpawnPoints.add(y+1);
        }
        return SpawnPoints;
    }
    public boolean EncontrarPuntoSpawn_Aux(int x, int y){
        if(Tablero[x][y]==0){
            return true;
        }else
            return false;
    }
    public void Tags(){
        GUI.LblPetName.setText(Pet.Nombre);
        GUI.LblPetLvl.setText(Pet.Nivel+"");
        GUI.LblPetCrit.setText(Pet.Critico+"%");
        GUI.LblPetDefensa.setText(Pet.Defensa+"%");
        GUI.LblPetEvasion.setText(Pet.Evasion+"%");
        GUI.LblPetMovimientos.setText(Pet.Movimientos+"");
        GUI.LblPetVida.setText(Pet.Vida+"");
        GUI.LblPetXp.setText(Pet.Experiencia+"");
        GUI.LblPetAmmo.setText(Pet.CapacidadActual+"");        
       
        GUI.LblTanqueName.setText(Tan.Nombre);
        GUI.LblTanqueLvl.setText(Tan.Nivel+"");
        GUI.LblTanqueCrit.setText(Tan.Critico+"%");
        GUI.LblTanqueDefensa.setText(Tan.Defensa+"%");
        GUI.LblTanqueEvasion.setText(Tan.Evasion+"%");
        GUI.LblTanqueMovimientos.setText(Tan.Movimientos+"");
        GUI.LblTanqueVida.setText(Tan.Vida+"");
        GUI.LblTanqueXp.setText(Tan.Experiencia+"");
        GUI.LblTanqueAmmo.setText(Tan.CapacidadActual+"");
        
        GUI.LblRangoName.setText(Ran.Nombre);
        GUI.LblRangoLvl.setText(Ran.Nivel+"");
        GUI.LblRangoCrit.setText(Ran.Critico+"%");
        GUI.LblRangoDefensa.setText(Ran.Defensa+"%");
        GUI.LblRangoEvasion.setText(Ran.Evasion+"%");
        GUI.LblRangoMovimientos.setText(Ran.Movimientos+"");
        GUI.LblRangoVida.setText(Ran.Vida+"");
        GUI.LblRangoXp.setText(Ran.Experiencia+"");
        GUI.LblRangoAmmo.setText(Ran.CapacidadActual+"");
    }
    public void ZombieSpawn(){
        Random R = new Random();
        int SpawnKey=R.nextInt(Spawners.size()/2);
        Zombie Enemigo = new Zombie(600, 250, 1);
        Enemigo.Tablero=Tablero;

        ArrayList<Integer> Points =EncontrarPuntoSpawn(Spawners.get(SpawnKey+SpawnKey),Spawners.get(SpawnKey+SpawnKey+1));
        if(Points.size()==0){
            
        } else{
            int SpawnerSelec=R.nextInt(Points.size()/2);
            Enemigo.X=Points.get((SpawnerSelec+SpawnerSelec));
            Enemigo.Y=Points.get((SpawnerSelec+SpawnerSelec)+1);
            Tablero[Enemigo.X][Enemigo.Y]=5;
            
            Enemigo.PintarseSolos(MatrizTablero);
            ListaZombies.add(Enemigo);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(GUI.BtnReload)){
            if(jugando==6){
                if(Pet.CapacidadActual==0){
                    Pet.CapacidadActual=Pet.Capacidad;
                    GUI.LblPetAmmo.setText(Pet.CapacidadActual+"");
                }else{
                    
                }
            }else if(jugando==7){
                    Tan.CapacidadActual=Tan.Capacidad;
                    GUI.LblTanqueAmmo.setText(Tan.CapacidadActual+"");
            }else{
                Ran.CapacidadActual=Ran.Capacidad;
                    GUI.LblRangoAmmo.setText(Ran.CapacidadActual+"");
            }
        }
        if(e.getSource().equals(GUI.BtnAtaque)){
            AtackMode=true;
            Modo=false;
            apagarTodo();
            if(jugando==6){
                Pet.atacar(MatrizTablero);
            }else if(jugando==7){
                Tan.atacar(MatrizTablero);
            }else{
                Ran.atacar(MatrizTablero);
            }
        }
       if(e.getSource().equals(GUI.BtnVision)){
            if(Modo){
            encenderTodo();
            Modo=!Modo;
            }else{
                Encender_Aux();
                Modo=!Modo;
            }
        }
                
        if(Modo){ 
        if(e.getSource().equals(GUI.BtnCambiar)){
            apagarTodo();
            
            jugando();
        }    
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
       
        if(e.getSource().equals(MatrizTablero[i][j])){
            
            if(Pet.X==i&&Pet.Y==j){
                break;
            }else{
                if(Tan.X==i&&Tan.Y==j){
                break;
                }
                else{
                    if(Ran.X==i&&Ran.Y==j){
                        break;
            }
            }
            }
            
            if(jugando==6){
            if(Pet.Movimientos>0){
            Tablero[Pet.X][Pet.Y]=0;
            paintSolo(Pet.X, Pet.Y);
            Pet.X=i;
            Pet.Y=j;
            Tablero[Pet.X][Pet.Y]=6;
            paintSolo(Pet.X, Pet.Y);
            Pet.Movimientos-=1;
            GUI.LblPetMovimientos.setText(Pet.Movimientos+"");
            apagarTodo();
            Pet.encenderAlrededor(Pet.X, Pet.Y, MatrizTablero);
            } else{
                apagarTodo();
                MatrizTablero[Pet.X][Pet.Y].setEnabled(true);
            }
        }else if(jugando==8){
            if(Ran.Movimientos>0){
            Tablero[Ran.X][Ran.Y]=0;
            paintSolo(Ran.X, Ran.Y);
            Ran.X=i;
            Ran.Y=j;
            Tablero[Ran.X][Ran.Y]=7;
            paintSolo(Ran.X, Ran.Y);
            Ran.Movimientos-=1;
            GUI.LblRangoMovimientos.setText(Ran.Movimientos+"");
            apagarTodo();
            encenderAlrededor(Ran.X, Ran.Y);
            } else{
                apagarTodo();
                MatrizTablero[Ran.X][Ran.Y].setEnabled(true);
            }
            
        }else{
            if(Tan.Movimientos>0){
            Tablero[Tan.X][Tan.Y]=0;
            paintSolo(Tan.X, Tan.Y);
            Tan.X=i;
            Tan.Y=j;
            Tablero[Tan.X][Tan.Y]=8;
            paintSolo(Tan.X, Tan.Y);
            Tan.Movimientos-=1;
            GUI.LblTanqueMovimientos.setText(Tan.Movimientos+"");
            apagarTodo();
            encenderAlrededor(Tan.X, Tan.Y);
            } else{
                apagarTodo();
                MatrizTablero[Tan.X][Tan.Y].setEnabled(true);
            }
        }
        }
    }
    }
                
        
    }
if(AtackMode){
    try{
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
        if(e.getSource().equals(MatrizTablero[i][j])){
            
            GUI.BtnAtaque.setEnabled(false);
            for (int k = 0; k < ListaZombies.size(); k++) {
                Zombie get = ListaZombies.get(k);
                if(get.AquiEstoy(i, j)){
                    if(jugando==6){
                        if(Pet.CapacidadActual>0){
                            Pet.CapacidadActual--;
                            GUI.LblPetAmmo.setText(Pet.CapacidadActual+"");   
                            if(Pet.Criticos(Pet.Critico)){
                                get.Vida-=(Pet.Ataque*2);
                                
                                GUI.TxALog.append(Pet.Nombre+" ha realizado un golpe crítico de "+ Pet.Ataque*2+" a un Zombie"+"\n");
                            }else{
                                get.Vida-=(Pet.Ataque);
                                GUI.TxALog.append(Pet.Nombre+" ha realizado un ataque de "+ Pet.Ataque+" a un Zombie"+"\n");
                            }
                        }
                    }else if(jugando==7){
                        Tan.CapacidadActual--;
                        GUI.LblTanqueAmmo.setText(Tan.CapacidadActual+"");   
                        if(Tan.CapacidadActual>0){
                            if(Tan.Criticos(Tan.Critico)){
                                get.Vida-=(Tan.Ataque*2);
                                GUI.TxALog.append(Tan.Nombre+" ha realizado un golpe crítico de "+ Tan.Ataque*2+" a un Zombie"+"\n");
                            }else{
                                get.Vida-=(Tan.Ataque);
                                GUI.TxALog.append(Tan.Nombre+" ha realizado un ataque de "+ Tan.Ataque+" a un Zombie"+"\n");
                            }
                        }
                    }else{
                        if(Ran.CapacidadActual>0){
                            Ran.CapacidadActual--;
                            GUI.LblRangoAmmo.setText(Ran.CapacidadActual+"");   
                            if(Ran.Criticos(Ran.Critico)){
                                get.Vida-=(Ran.Ataque*2);
                                GUI.TxALog.append(Ran.Nombre+" ha realizado un golpe crítico de "+ Ran.Ataque*2+" a un Zombie"+"\n");
                            }else{
                                GUI.TxALog.append(Ran.Nombre+" ha realizado un ataque de "+ Ran.Ataque+" a un Zombie"+"\n");
                                get.Vida-=(Ran.Ataque);
                            }
                        }
                    }
                    if(get.Vida<=0){
                        if(jugando==6){
                            Pet.Experiencia+=150;
                            Tan.Experiencia+=100;
                            Ran.Experiencia+=100;
                            GUI.TxALog.append(Pet.Nombre+" ha ganado 150 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Tan.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Ran.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            GUI.LblPetXp.setText(Pet.Experiencia+"");
                            GUI.LblTanqueXp.setText(Tan.Experiencia+"");
                            GUI.LblRangoXp.setText(Ran.Experiencia+"");
                            GUI.TxALog.append("\n");
                        }else if(jugando==7){
                            Tan.Experiencia+=150;
                            Pet.Experiencia+=100;
                            Ran.Experiencia+=100;
                            GUI.TxALog.append(Tan.Nombre+" ha ganado 150 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Pet.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Ran.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            GUI.LblPetXp.setText(Pet.Experiencia+"");
                            GUI.LblTanqueXp.setText(Tan.Experiencia+"");
                            GUI.LblRangoXp.setText(Ran.Experiencia+"");
                            GUI.TxALog.append("\n"); 
                        }else{
                            Ran.Experiencia+=150;
                            Tan.Experiencia+=100;
                            Pet.Experiencia+=100;
                            GUI.TxALog.append(Ran.Nombre+" ha ganado 150 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Tan.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Pet.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            GUI.LblPetXp.setText(Pet.Experiencia+"");
                            GUI.LblTanqueXp.setText(Tan.Experiencia+"");
                            GUI.LblRangoXp.setText(Ran.Experiencia+"");
                            GUI.TxALog.append("\n");
                        }
                        Leveling();
                        Tablero[get.X][get.Y]=0;
                        MatrizTablero[get.X][get.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\0.png"));
                        ListaZombies.remove(get);
                        
                    }
                }

            }
            if(Modo){
                            encenderTodo();
                            Modo=!Modo;
                        }else{
                            Encender_Aux();
                            Modo=!Modo;
            }
            AtackMode=false;
        }
            }
        }
    }
    catch (NullPointerException f){
        
    }
    
        }
    }
}

