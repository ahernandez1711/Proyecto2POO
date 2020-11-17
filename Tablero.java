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
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author pablo
 */
public class Tablero implements ActionListener{
    public GUITablero GUI= new GUITablero();
    public int[][] Tablero= new int[24][16];
    public int[][] TableroSonido= new int[24][16];
    public Mascota Pet;
    public Tanque Tan;
    public Rango Ran;
    public boolean Modo=true;
    public JButton[][] MatrizTablero= new JButton[24][16];
    public int turno;
    public int jugando=6;
    public Boolean AtackMode=false;
    public boolean PetUlti=true;
    public boolean TanqueUlti=true;
    public boolean RangoUlti=true;
    public ArrayList<Integer> futureSpawners=new ArrayList();
    public ArrayList<Zombie> ListaZombies=new ArrayList();
    public ArrayList<Zombie> ListaZombiesRapidos=new ArrayList();
    public ArrayList<Integer> Spawners= new ArrayList();

    public Tablero() {
        GUI.BtnReload.addActionListener(this);
        GUI.BtnAtaque.addActionListener(this);
        GUI.BtnDefinitiva.addActionListener(this);
        GUI.BtnCurarse.addActionListener(this);
        GUI.BtnDefinitiva.setEnabled(false);
        
        futureSpawners.add(8);
        futureSpawners.add(1);
        
        futureSpawners.add(15);
        futureSpawners.add(1);
        
        futureSpawners.add(5);
        futureSpawners.add(4);
        
        futureSpawners.add(19);
        futureSpawners.add(4);
        
        futureSpawners.add(1);
        futureSpawners.add(5); 
        
        futureSpawners.add(1);
        futureSpawners.add(10);
        
        futureSpawners.add(8);
        futureSpawners.add(14);
        
        futureSpawners.add(15);
        futureSpawners.add(14);
        
        futureSpawners.add(5);
        futureSpawners.add(11);
        
        futureSpawners.add(19);
        futureSpawners.add(11);
        
        
        
        
        Spawners.add(1);
        Spawners.add(1);
        
        Spawners.add(22);
        Spawners.add(1);
        
        Spawners.add(1);
        Spawners.add(14);
        
        Spawners.add(22);
        Spawners.add(14);

        System.out.println(futureSpawners.size());
        
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
        Pet.Dueño=Ran;
        Ran.Pet=Pet;
        
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
    public void limpiarSonido(){
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
                TableroSonido[i][j]=0;
            } 
        }
    }
    public void ZombieEnrage(){
        for (int i = 0; i < this.ListaZombies.size(); i++) {
            Zombie get = ListaZombies.get(i);
            if(get.Enrage){
                
            }
            else if(TableroSonido[get.X][get.Y]==1){
                GUI.TxALog.append("Un zombie ha escuchado un sonido y se enfurece \n");
                get.Enrage=true;
                get.Ataque+=20;
                get.PintarseSolos(MatrizTablero);
            }
    }
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
                }else{
                }
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
    public void EndGame(){
     if(Pet.Vida<=0&&Tan.Vida<=0&&Ran.Vida<=0){
         JOptionPane.showMessageDialog(null, "Todos los personajes han muerto, los zombien ganan");
         GUI.dispose();
     }   
     if(Tablero[1][7]==5||Tablero[1][8]==5){
         JOptionPane.showMessageDialog(null, "Los zombies han entrado a la base, los zombies ganan");
         GUI.dispose();
     }
    }
    public boolean solo_aux(){
        if(Pet.Vida<=0&&Ran.Vida<=0){
            return true;
        }
        if(Pet.Vida<=0&&Tan.Vida<=0){
            return true;
        }
        if(Ran.Vida<=0&&Ran.Vida<=0){
            return true;
        }
        return false;
    }
    public void solo(){
        if(Pet.Vida<=0&&Ran.Vida<=0){
            for (int i = 0; i < ListaZombies.size(); i++) {
                if(ListaZombies.get(i).EstaPj(7)||ListaZombies.get(i).EstaPj(8)||ListaZombies.get(i).EstaPj(6)){
                    ListaZombies.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                ListaZombies.get(i).ZombieMovimiento(MatrizTablero);
                }
            }
             ZombieSpawn();    
            if(Tan.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            
            GUI.BtnCurarse.setEnabled(true);
            jugando=7;
            Tan.Movimientos=2;
            GUI.LblTanqueMovimientos.setText(Tan.Movimientos+"");
            encenderAlrededor(Tan.X, Tan.Y);
            if(Tan.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
        }
        if(Pet.Vida<=0&&Tan.Vida<=0){
            for (int i = 0; i < ListaZombies.size(); i++) {
                if(ListaZombies.get(i).EstaPj(7)||ListaZombies.get(i).EstaPj(8)||ListaZombies.get(i).EstaPj(6)){
                    ListaZombies.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                ListaZombies.get(i).ZombieMovimiento(MatrizTablero);
                }
            }
             ZombieSpawn();    
            if(Ran.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            
            GUI.BtnCurarse.setEnabled(true);
            jugando=8;
            Ran.Movimientos=1;
            GUI.LblRangoMovimientos.setText(Ran.Movimientos+"");
            encenderAlrededor(Ran.X, Ran.Y);
            if(Ran.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
        }
        if(Ran.Vida<=0&&Tan.Vida<=0){
            for (int i = 0; i < ListaZombies.size(); i++) {
                if(ListaZombies.get(i).EstaPj(7)||ListaZombies.get(i).EstaPj(8)||ListaZombies.get(i).EstaPj(6)){
                    ListaZombies.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                ListaZombies.get(i).ZombieMovimiento(MatrizTablero);
                }
            }
             ZombieSpawn();    
            if(Pet.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            
            GUI.BtnCurarse.setEnabled(true);
            jugando=6;
            Ran.Movimientos=4;
            GUI.LblPetMovimientos.setText(Pet.Movimientos+"");
            encenderAlrededor(Pet.X, Pet.Y);
            if(Pet.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
        }
    
        
    }
    public void jugando(){
        EndGame();
        if(solo_aux()){
            solo();
            ZombieEnrage();
        }else{
        if(jugando==6){
            if(Tan.Vida>0){
            ZombieEnrage();
                for (int i = 0; i < ListaZombiesRapidos.size(); i++) {
                if(ListaZombiesRapidos.get(i).EstaPj(7)||ListaZombiesRapidos.get(i).EstaPj(8)||ListaZombiesRapidos.get(i).EstaPj(6)){
                    ListaZombiesRapidos.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                Zombie get = ListaZombiesRapidos.get(i);
                get.ZombieMovimiento(MatrizTablero);            
                }
                }
            if(Tan.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            
            GUI.BtnCurarse.setEnabled(true);
            jugando=7;
            Tan.Movimientos=2;
            GUI.LblTanqueMovimientos.setText(Tan.Movimientos+"");
            encenderAlrededor(Tan.X, Tan.Y);
            if(Tan.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
            
            }else{
                ZombieEnrage();
                for (int i = 0; i < ListaZombiesRapidos.size(); i++) {
                if(ListaZombiesRapidos.get(i).EstaPj(7)||ListaZombiesRapidos.get(i).EstaPj(8)||ListaZombiesRapidos.get(i).EstaPj(6)){
                    ListaZombiesRapidos.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                Zombie get = ListaZombiesRapidos.get(i);
                get.ZombieMovimiento(MatrizTablero);            
            }
            }
            if(Ran.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            if(Ran.Vida>0){
            GUI.BtnCurarse.setEnabled(true);
            jugando=8;
            Ran.Movimientos=1;
            GUI.LblRangoMovimientos.setText(Ran.Movimientos+"");
            encenderAlrededor(Ran.X, Ran.Y);
            if(Ran.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
            }
            }
            
        }
         else if(jugando==7){
            ZombieEnrage();
             for (int i = 0; i < ListaZombiesRapidos.size(); i++) {
                if(ListaZombiesRapidos.get(i).EstaPj(7)||ListaZombiesRapidos.get(i).EstaPj(8)||ListaZombiesRapidos.get(i).EstaPj(6)){
                    ListaZombiesRapidos.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                Zombie get = ListaZombiesRapidos.get(i);
                get.ZombieMovimiento(MatrizTablero);            
            }
            }
            if(Ran.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            if(Ran.Vida>0){
            GUI.BtnCurarse.setEnabled(true);
            jugando=8;
            Ran.Movimientos=1;
            GUI.LblRangoMovimientos.setText(Ran.Movimientos+"");
            encenderAlrededor(Ran.X, Ran.Y);
            if(Ran.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
            }else{
                ZombieEnrage();
                MatrizTablero[Ran.X][Ran.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                for (int i = 0; i < ListaZombies.size(); i++) {
                if(ListaZombies.get(i).EstaPj(7)||ListaZombies.get(i).EstaPj(8)||ListaZombies.get(i).EstaPj(6)){
                    ListaZombies.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                ListaZombies.get(i).ZombieMovimiento(MatrizTablero);
                }
            }
             ZombieSpawn();          
            if(Ran.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            if(Pet.Vida>0){
            Pet.ProximidadAlRango(GUI.BtnCurarse);
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
            
        } else{
            ZombieEnrage();
            for (int i = 0; i < ListaZombies.size(); i++) {
                if(ListaZombies.get(i).EstaPj(7)||ListaZombies.get(i).EstaPj(8)||ListaZombies.get(i).EstaPj(6)){
                    ListaZombies.get(i).Ataque(Tan, Ran, Pet, GUI.TxALog);
                    Tags();
                }else{
                ListaZombies.get(i).ZombieMovimiento(MatrizTablero);
                }
            }
             ZombieSpawn(); 
             limpiarSonido();
            if(Ran.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            if(Pet.Vida>0){
            Pet.ProximidadAlRango(GUI.BtnCurarse);
            jugando=6;
            Pet.Movimientos=4;
            if(Pet.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
            GUI.LblPetMovimientos.setText(Pet.Movimientos+"");
            Pet.encenderAlrededor(Pet.X, Pet.Y, MatrizTablero);
            }else{
                MatrizTablero[Pet.X][Pet.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\"+"0"+".png"));
                if(Tan.Nivel>=10){
                GUI.BtnDefinitiva.setEnabled(true);
            }else{
                GUI.BtnDefinitiva.setEnabled(false);
            }
            GUI.BtnCurarse.setEnabled(true);
            jugando=7;
            Tan.Movimientos=2;
            GUI.LblTanqueMovimientos.setText(Tan.Movimientos+"");
            encenderAlrededor(Tan.X, Tan.Y);
            if(Tan.CapacidadActual==0){
                GUI.BtnAtaque.setEnabled(false);
            }else{
                GUI.BtnAtaque.setEnabled(true);
            }
            }
        }
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
    public void sonidoRango(){
        try{
        TableroSonido[Ran.X-2][Ran.Y-2]=1;
        TableroSonido[Ran.X-1][Ran.Y-2]=1;
        TableroSonido[Ran.X][Ran.Y-2]=1;
        TableroSonido[Ran.X+1][Ran.Y-2]=1;
        TableroSonido[Ran.X+2][Ran.Y-2]=1;
        
        TableroSonido[Ran.X-2][Ran.Y-1]=1;
        TableroSonido[Ran.X-1][Ran.Y-1]=1;
        TableroSonido[Ran.X][Ran.Y-1]=1;
        TableroSonido[Ran.X+1][Ran.Y-1]=1;
        TableroSonido[Ran.X+2][Ran.Y-1]=1;
        
        TableroSonido[Ran.X-2][Ran.Y]=1;
        TableroSonido[Ran.X-1][Ran.Y]=1;
        TableroSonido[Ran.X][Ran.Y]=1;
        TableroSonido[Ran.X+1][Ran.Y]=1;
        TableroSonido[Ran.X+2][Ran.Y]=1;
        
        TableroSonido[Ran.X-2][Ran.Y+1]=1;
        TableroSonido[Ran.X-1][Ran.Y+1]=1;
        TableroSonido[Ran.X][Ran.Y+1]=1;
        TableroSonido[Ran.X+1][Ran.Y+1]=1;
        TableroSonido[Ran.X+2][Ran.Y+1]=1;
        
        TableroSonido[Ran.X-2][Ran.Y+2]=1;
        TableroSonido[Ran.X-1][Ran.Y+2]=1;
        TableroSonido[Ran.X][Ran.Y+2]=1;
        TableroSonido[Ran.X+1][Ran.Y+2]=1;
        TableroSonido[Ran.X+2][Ran.Y+2]=1;
        }
        catch(Exception e){
            
        }
        }
    public void SonidoPet(){
        try{
        TableroSonido[Pet.X-2][Pet.Y-2]=1;
        TableroSonido[Pet.X-1][Pet.Y-2]=1;
        TableroSonido[Pet.X][Pet.Y-2]=1;
        TableroSonido[Pet.X+1][Pet.Y-2]=1;
        TableroSonido[Pet.X+2][Pet.Y-2]=1;
        
        TableroSonido[Pet.X-2][Pet.Y-1]=1;
        TableroSonido[Pet.X-1][Pet.Y-1]=1;
        TableroSonido[Pet.X][Pet.Y-1]=1;
        TableroSonido[Pet.X+1][Pet.Y-1]=1;
        TableroSonido[Pet.X+2][Pet.Y-1]=1;
        
        TableroSonido[Pet.X-2][Pet.Y]=1;
        TableroSonido[Pet.X-1][Pet.Y]=1;
        TableroSonido[Pet.X][Pet.Y]=1;
        TableroSonido[Pet.X+1][Pet.Y]=1;
        TableroSonido[Pet.X+2][Pet.Y]=1;
        
        TableroSonido[Pet.X-2][Pet.Y]=1;
        TableroSonido[Pet.X-1][Pet.Y]=1;
        TableroSonido[Pet.X][Pet.Y]=1;
        TableroSonido[Pet.X+1][Pet.Y]=1;
        TableroSonido[Pet.X+2][Pet.Y]=1;
        
        TableroSonido[Pet.X-2][Pet.Y+1]=1;
        TableroSonido[Pet.X-1][Pet.Y+1]=1;
        TableroSonido[Pet.X][Pet.Y+1]=1;
        TableroSonido[Pet.X+1][Pet.Y+1]=1;
        TableroSonido[Pet.X+2][Pet.Y+1]=1;
        
        TableroSonido[Pet.X-2][Pet.Y+2]=1;
        TableroSonido[Pet.X-1][Pet.Y+2]=1;
        TableroSonido[Pet.X][Pet.Y+2]=1;
        TableroSonido[Pet.X+1][Pet.Y+2]=1;
        TableroSonido[Pet.X+2][Pet.Y+2]=1;
        }
        catch(Exception e){
            
        }
    }
    public void SonidoTanque(){
        try{
        TableroSonido[Tan.X-2][Tan.Y-2]=1;
        TableroSonido[Tan.X-1][Tan.Y-2]=1;
        TableroSonido[Tan.X][Tan.Y-2]=1;
        TableroSonido[Tan.X+1][Tan.Y-2]=1;
        TableroSonido[Tan.X+2][Tan.Y-2]=1;
        
        TableroSonido[Tan.X-2][Tan.Y-1]=1;
        TableroSonido[Tan.X-1][Tan.Y-1]=1;
        TableroSonido[Tan.X][Tan.Y-1]=1;
        TableroSonido[Tan.X+1][Tan.Y-1]=1;
        TableroSonido[Tan.X+2][Tan.Y-1]=1;
        
        TableroSonido[Tan.X-2][Tan.Y]=1;
        TableroSonido[Tan.X-1][Tan.Y]=1;
        TableroSonido[Tan.X][Tan.Y]=1;
        TableroSonido[Tan.X+1][Tan.Y]=1;
        TableroSonido[Tan.X+2][Tan.Y]=1;
        
        TableroSonido[Tan.X-2][Tan.Y+1]=1;
        TableroSonido[Tan.X-1][Tan.Y+1]=1;
        TableroSonido[Tan.X][Tan.Y+1]=1;
        TableroSonido[Tan.X+1][Tan.Y+1]=1;
        TableroSonido[Tan.X+2][Tan.Y+1]=1;
        
        TableroSonido[Tan.X-2][Tan.Y+2]=1;
        TableroSonido[Tan.X-1][Tan.Y+2]=1;
        TableroSonido[Tan.X][Tan.Y+2]=1;
        TableroSonido[Tan.X+1][Tan.Y+2]=1;
        TableroSonido[Tan.X+2][Tan.Y+2]=1;
        }
        catch(Exception e){
            
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
        GUI.LblCurasPet.setText(0+"");
       
        GUI.LblTanqueName.setText(Tan.Nombre);
        GUI.LblTanqueLvl.setText(Tan.Nivel+"");
        GUI.LblTanqueCrit.setText(Tan.Critico+"%");
        GUI.LblTanqueDefensa.setText(Tan.Defensa+"%");
        GUI.LblTanqueEvasion.setText(Tan.Evasion+"%");
        GUI.LblTanqueMovimientos.setText(Tan.Movimientos+"");
        GUI.LblTanqueVida.setText(Tan.Vida+"");
        GUI.LblTanqueXp.setText(Tan.Experiencia+"");
        GUI.LblTanqueAmmo.setText(Tan.CapacidadActual+"");
        GUI.LblCurasTanque.setText(Tan.CantidadCuraciones+"");
        
        GUI.LblRangoName.setText(Ran.Nombre);
        GUI.LblRangoLvl.setText(Ran.Nivel+"");                                                                                                                                                                                                                                                                                                                                                                                                                                   
        GUI.LblRangoCrit.setText(Ran.Critico+"%");
        GUI.LblRangoDefensa.setText(Ran.Defensa+"%");
        GUI.LblRangoEvasion.setText(Ran.Evasion+"%");
        GUI.LblRangoMovimientos.setText(Ran.Movimientos+"");
        GUI.LblRangoVida.setText(Ran.Vida+"");
        GUI.LblRangoXp.setText(Ran.Experiencia+"");
        GUI.LblRangoAmmo.setText(Ran.CapacidadActual+"");
        GUI.LblCurasRango.setText(Ran.CantidadCuraciones+"");
    }
    public void ZombieSpawn(){
        Random R = new Random();
        int SpawnKey=R.nextInt(Spawners.size()/2);
        Zombie Enemigo = new Zombie(600, 250, 1);
        if(R.nextInt(100)<10){
            Enemigo.ZombieRapido=true;
            this.ListaZombiesRapidos.add(Enemigo);
            Enemigo.Evasion+=20;
        }else if(R.nextInt(100)<15){
            Enemigo.ZombieTanque=true;
            Enemigo.Defensa+=10;
            Enemigo.Vida+=600;
        }
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
    public void procTanque(){
        Random R = new Random();
        if(R.nextInt(100)<10){
            Tan.Experiencia+=50;
            GUI.TxALog.append("Un zombie ha dejado caer un libro,"+Tan.Nombre+" ha obtenido 50 puntos de experiencia"+"\n");
        }
        if(R.nextInt(100)<7){
            Tan.CapacidadActual++;
            GUI.TxALog.append("Un zombie ha dejado caer un arma,"+Tan.Nombre+" ha 1 de municion"+"\n");
        }
        if(R.nextInt(100)<5){
            Tan.CantidadCuraciones++;
            GUI.TxALog.append("Un zombie ha dejado caer un vial de curacion,"+Tan.Nombre+" tiene una cura más"+"\n");
        }
    }
    public void MuerteZombie(Zombie get){
        if(get.Vida<=0){
                        if(jugando==6){
                            Pet.Experiencia+=150;
                            Tan.Experiencia+=100;
                            Ran.Experiencia+=100;
                            GUI.TxALog.append(Pet.Nombre+" ha ganado 150 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Tan.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            GUI.TxALog.append(Ran.Nombre+" ha ganado 100 puntos de experiencia"+"\n");
                            procMascota();
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
                            procTanque();
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
                            procRango();
                            GUI.LblPetXp.setText(Pet.Experiencia+"");
                            GUI.LblTanqueXp.setText(Tan.Experiencia+"");
                            GUI.LblRangoXp.setText(Ran.Experiencia+"");
                            GUI.TxALog.append("\n");
                        }
                        Leveling();
                        Tablero[get.X][get.Y]=0;
                        MatrizTablero[get.X][get.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\0.png"));
                        ListaZombies.remove(get);
                        if(get.ZombieRapido){
                            ListaZombiesRapidos.remove(get);
                        }
                }
    }
    public void procMascota(){
        Random R = new Random();
        if(R.nextInt(100)<10){
            Pet.Experiencia+=50;
            GUI.TxALog.append("Ese golpe hizo que "+Pet.Nombre+" se diera cuenta una debilidad del zombie, ha obtenido 50 puntos de experiencia"+"\n");
        }
        if(R.nextInt(100)<7){
            Pet.CapacidadActual++;
            GUI.TxALog.append("Ese zombie basicamente estana muerto,"+Pet.Nombre+ "no ha tenido que atacar"+"\n");
        }
        if(R.nextInt(100)<5){
            Pet.Movimientos++;
            GUI.TxALog.append("La agilidad de "+Pet.Nombre+" le ha dado 1 movimiento más este turno"+"\n");
        }
    }
    public void procRango(){
        Random R = new Random();
        if(R.nextInt(100)<10){
            Ran.Experiencia+=50;
            GUI.TxALog.append("Disparo a la cabeza!, "+Ran.Nombre+" ha obtenido 50 puntos de experiencia"+"\n");
        }
        if(R.nextInt(100)<7){
            Ran.CapacidadActual++;
            GUI.LblRangoAmmo.setText(Ran.CapacidadActual+"");   
            GUI.TxALog.append(Ran.Nombre+ " ha encontrado una bala extra en el piso, 1 de munición extra"+"\n");
        }
        if(R.nextInt(100)<5){
            Ran.Movimientos++;
            GUI.TxALog.append("Disparo presuroso!, "+Ran.Nombre+" obtiene 1 movimiento extra este turno"+"\n");
        }
    }
    public void generarSpawner(){
        Random R = new Random();
        if(R.nextInt(100)<5){
            
            int i= R.nextInt((futureSpawners.size()/2));
            System.out.println("x:"+futureSpawners.get(i+i));
            System.out.println("y:"+futureSpawners.get(i+i+1));
            
            if(Tablero[futureSpawners.get(i+i)][futureSpawners.get((i+i)+1)]==0){
                Tablero[futureSpawners.get(i+i)][futureSpawners.get((i+i)+1)]=2;
                Spawners.add(futureSpawners.get(i+i));
                Spawners.add(futureSpawners.get((i+i)+1));
                paintSolo(futureSpawners.get(i+i), futureSpawners.get(i+i+1));
            }
            
            
        } else{
        }
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(GUI.BtnDefinitiva)){
            if(jugando==6){
                if(PetUlti){
                GUI.TxALog.append(Pet.Nombre+" se lame las heridas curandose en el proceso \n");
                Pet.Vida=Pet.VidaMax;
                PetUlti=false;
            }
            }
        
            
            if(jugando==7){
                if(TanqueUlti){
                    GUI.TxALog.append(Tan.Nombre+" hace un golpe alrededor suyo, golpeando a todos los zombies alrededor \n");
                
                int Damage=0;
        if(Tablero[Tan.X+1][Tan.Y]==5){
            for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X+1&&get1.Y==Tan.Y){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            if(Tablero[Tan.X-1][Tan.Y]==5){
            for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X-1&&get1.Y==Tan.Y){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            if(Tablero[Tan.X][Tan.Y+1]==5){       
            for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X&&get1.Y==Tan.Y+1){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            if(Tablero[Tan.X][Tan.Y-1]==5){
            for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X&&get1.Y==Tan.Y-1){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            if(Tablero[Tan.X-1][Tan.Y-1]==5){
             for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X-1&&get1.Y==Tan.Y-1){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            if(Tablero[Tan.X+1][Tan.Y-1]==5){
            for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X+1&&get1.Y==Tan.Y-1){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            if(Tablero[Tan.X+1][Tan.Y+1]==5){
            for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X+1&&get1.Y==Tan.Y+1){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            if(Tablero[Tan.X-1][Tan.Y+1]==5){
            for (int i = 0; i < ListaZombies.size(); i++) {
                Zombie get1 = ListaZombies.get(i);
                if(get1.X==Tan.X-1&&get1.Y==Tan.Y+1){
                    get1.Vida-=200;
                    Damage+=200;
                    MuerteZombie(get1);
                }
            }
            }
            GUI.TxALog.append("Daño total: "+Damage+"\n" );
            TanqueUlti=false;
            }
            }
            if(jugando==8){
                if(RangoUlti){
                    GUI.TxALog.append(Ran.Nombre+" obtiene una maestría de tiro, aumentando su daño un 10% \n");
                    Ran.Ataque+=30;
                    RangoUlti=false;
                }
            }
        }
        if(e.getSource().equals(GUI.BtnCurarse)){
            if(jugando==6){
                if(Ran.CantidadCuraciones>0){
                    Pet.Vida=Pet.VidaMax;
                    Ran.CantidadCuraciones--;
                    GUI.TxALog.append(Pet.Nombre+" ha mordido un vial de curacion de "+Ran.Nombre+" lo que ha hecho que se cure \n");
                    Tags();
                }
            }
            if(jugando==7){
                if(Tan.CantidadCuraciones>0){
                    Tan.Vida=Tan.VidaMax;
                    GUI.TxALog.append(Tan.Nombre+" lo que ha hecho que se cure \n");
                    Tan.CantidadCuraciones--;
                    Tags();
                }
            }
            if(jugando==8){
                if(Ran.CantidadCuraciones>0){
                    Ran.Vida=Ran.VidaMax;
                    Ran.CantidadCuraciones--;
                    GUI.TxALog.append(Ran.Nombre+" usa un vial de curación curandose toda la vida \n");
                    Tags();
                }
            }
            
        }
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
            generarSpawner();
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
    Random R= new Random();
    try{
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 16; j++) {
        if(e.getSource().equals(MatrizTablero[i][j])){
            
            GUI.BtnAtaque.setEnabled(false);
            for (int k = 0; k < ListaZombies.size(); k++) {
                Zombie get = ListaZombies.get(k);
                if(get.AquiEstoy(i, j)){
                    if(jugando==6){
                        SonidoPet();
                        if(R.nextInt(100)<get.Evasion){
                            GUI.TxALog.append(Pet.Nombre+" intentado atacar a un zombie pero ha esquivado tu ataque"+"\n");
                        }else{
                        if(Pet.CapacidadActual>0){
                            Pet.CapacidadActual--;
                            GUI.LblPetAmmo.setText(Pet.CapacidadActual+"");
                            
                            if(Pet.Criticos(Pet.Critico)){
                                get.Vida-=((Pet.Ataque*2)-((Pet.Ataque*2)/100)*get.Defensa);
                                Pet.Dueño.Marcado=get;
                                GUI.TxALog.append(Pet.Nombre+" ha realizado un golpe crítico de "+((Pet.Ataque*2)-((Pet.Ataque*2)/100)*get.Defensa)+" a un Zombie"+"\n");
                            }else{
                                get.Vida-=((Pet.Ataque)-((Pet.Ataque)/100)*get.Defensa);
                                 Pet.Dueño.Marcado=get;
                                GUI.TxALog.append(Pet.Nombre+" ha realizado un ataque de "+((Pet.Ataque)-((Pet.Ataque)/100)*get.Defensa)+" a un Zombie"+"\n");
                            }
                        }
                        }
                    }else if(jugando==7){
                        SonidoTanque();
                        Tan.CapacidadActual--;
                        GUI.LblTanqueAmmo.setText(Tan.CapacidadActual+"");
                        if(R.nextInt(100)<get.Evasion){
                            GUI.TxALog.append(Tan.Nombre+" intentado atacar a un zombie pero ha esquivado tu ataque"+"\n");
                        }else{
                        if(Tan.CapacidadActual>0){
                            
                            if(Tan.Criticos(Tan.Critico)){
                                get.Vida-=((Tan.Ataque*2)-((Tan.Ataque*2)/100)*get.Defensa);
                                GUI.TxALog.append(Tan.Nombre+" ha realizado un golpe crítico de "+ ((Tan.Ataque*2)-((Tan.Ataque*2)/100)*get.Defensa)+" a un Zombie"+"\n");
                            }else{
                                get.Vida-=((Tan.Ataque)-((Tan.Ataque)/100)*get.Defensa);
                                GUI.TxALog.append(Tan.Nombre+" ha realizado un ataque de "+ ((Tan.Ataque)-((Tan.Ataque)/100)*get.Defensa)+" a un Zombie"+"\n");
                            }
                        }
                        }
                    }else{
                        if(Ran.CapacidadActual>0){
                            sonidoRango();
                            Ran.CapacidadActual--;
                            if(R.nextInt(100)<get.Evasion){
                                GUI.TxALog.append(Ran.Nombre+" intentado atacar a un zombie pero ha esquivado tu ataque"+"\n");
                            }else{
                            GUI.LblRangoAmmo.setText(Ran.CapacidadActual+"");
                            boolean Crit=Ran.Criticos(Ran.Critico);
                            boolean Marcado=false;
                            int Damg=Ran.Ataque;
                            if(Crit){
                                Damg=Damg*2;
                            }
                            try{
                                if(get.equals(Ran.Marcado)){
                                    Damg=Damg*2;
                                    Marcado=true;
                                }
                            }
                            catch(Exception f){
                            }
                            
                            if(Crit||Marcado){
                                if(Crit&&Marcado){
                                    get.Vida-=Damg-(Damg/100)*get.Defensa;
                                    GUI.TxALog.append(Ran.Nombre+" ha realizado un golpe crítico y estaba marcado por "+Pet.Nombre +" y se ha inflingido  "+ (Damg-(Damg/100)*get.Defensa)+" a un Zombie"+"\n");
                                }else{
                                    if(Crit){
                                        get.Vida-=Damg-(Damg/100)*get.Defensa;
                                        GUI.TxALog.append(Ran.Nombre+" ha realizado un golpe crítico de "+ (Damg-(Damg/100)*get.Defensa)+" a un Zombie"+"\n");
                                    }else{
                                        get.Vida-=Damg-(Damg/100)*get.Defensa;
                                        GUI.TxALog.append(Ran.Nombre+" ha realizado ataque en un Zombie marcado por "+ (Damg-(Damg/100)*get.Defensa)+" a un Zombie"+"\n");
                                    }
                                }
                                
                            }else{
                                GUI.TxALog.append(Ran.Nombre+" ha realizado un ataque de "+ (Damg-(Damg/100)*get.Defensa)+" a un Zombie"+"\n");
                                get.Vida-=(Damg-(Damg/100)*get.Defensa);
                            }
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
                            procMascota();
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
                            procTanque();
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
                            procRango();
                            GUI.LblPetXp.setText(Pet.Experiencia+"");
                            GUI.LblTanqueXp.setText(Tan.Experiencia+"");
                            GUI.LblRangoXp.setText(Ran.Experiencia+"");
                            GUI.TxALog.append("\n");
                        }
                        Leveling();
                        Tablero[get.X][get.Y]=0;
                        MatrizTablero[get.X][get.Y].setIcon(new ImageIcon("C:\\Users\\pablo\\OneDrive\\Documentos\\NetBeansProjects\\PrograPooZombieDefense\\Img\\0.png"));
                        ListaZombies.remove(get);
                        if(get.ZombieRapido){
                            ListaZombiesRapidos.remove(get);
                        }
                        
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

