/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.Timer;

/**
 *
 * @author Luca
 */
public class Pallina {

    /*@brief: Posizione della pallina sull'asse delle x*/
    private float posX;
    /*@brief: Posizione della pallina sull'asse delle y*/
    private float posY;
    /*@brief: Velocità della pallina sull'asse delle x*/
    private double velX;
    /*@brief: Velocità della pallina sull'asse delle y*/
    private double velY;

    private int Raggio;

    private int direzioneX;

    private int direzioneY;

    private DatiCondivisi ptrDati;

    Timer timer = new Timer();

    /*@brief: Costruttore senza parametri, posiziono la pallina al centro della scatola e le sue velocità a 0*/
    public Pallina(DatiCondivisi dati) {
        this.ptrDati = dati;
        this.Raggio = 20;
        this.posX = 150 / 2;          //Cambiare in base a lunghezza della scatola
        this.posY = 150 / 2;          //Cambiare in base a larghezza della scatola
        this.velX = 0;
        this.velY = 0;
        /*Genero un numero random tra 0 e 2 (0,1), poi calcolo il resto della divisione con il numero 2 facendo il modulo(%),
          in questo modo ho il 50% di possibilità che la direzione sia 1(da sinistra a destra) o -1(da destra a sinistra)
         */
        if (ptrDati.getInclinazioneX() < 0) {
            direzioneX = -1;       //sinistra --> destra
        } else {
            direzioneX = 1;      //destra --> sinistra
        }
        /*Uguale a sopra*/
 /*if((int) ((Math.random()*2)%2)==0) {
            direzioneY=1;       //sopra --> sotto
        }
        else {                                              //PER FUTURA INCLINAZIONE SULL'ASSE DELLE Y
            direzioneX=-1;      //sotto --> sopra
        }
        
        WIDTH_SCREEN=900;
        HEIGHT_SCREEN=900;
         */
    }

    /*@brief: Costruttore con parametri*/
    public Pallina(float posX, float posY, double velX, double velY, int direzioneX, int direzioneY, int Raggio) {
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
        this.direzioneX = direzioneX;
        this.direzioneY = direzioneY;
        this.Raggio = Raggio;

    }

    public int getDirezioneX() {
        return direzioneX;
    }

    public void setDirezioneX(int direzioneX) {
        this.direzioneX = direzioneX;
    }

    public int getDirezioneY() {
        return direzioneY;
    }

    public void setDirezioneY(int direzioneY) {
        this.direzioneY = direzioneY;
    }

    public int getRaggio() {
        return Raggio;
    }

    public void setRaggio(int Raggio) {
        this.Raggio = Raggio;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void AggiornaInfo(int posX, int posY, int velX, int velY) {
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
    }

    public void Move() {
        if (ptrDati.getInclinazioneY() > 10) {
            posX = posX + (float) (velX * direzioneX);
            posY = posY + (float) (velY * direzioneY);

            if (posX >= 150 - Raggio) {
                posX = 150 - Raggio;
            }
        }
        if(ptrDati.getInclinazioneY() < -10) {
            posX = posX + (float) (velX * direzioneX);
            posY = posY + (float) (velY * direzioneY);

            if (posX >= 150 - Raggio) {
                posX = 150 - Raggio;
            }
        }
        /*if(posY>=HEIGHT_SCREEN-Raggio) {
            posY=HEIGHT_SCREEN-Raggio;              //FUTURO
        }       
         */
    }

    public void IncrementaVelocitàX() {
        velX += 0.05;
        if(velX<0.4) {
            velX=0.4;
        }
    }

    public void IncrementaVelocitàY() {
        velY += 0.2;
    }

    public void DecrementaVelocitàX() {
        velX -= 0.2;
        if (velX < 0) {
            velX = 0;
        }
    }

    public void DecrementaVelocitàY() {
        velY -= 0.2;
        if (velY < 0) {
            velY = 0;
        }
    }

    public String VisualizzaInfo() {
        return "PosizioneX: " + String.valueOf(posX) + "/PosizioneY:" + String.valueOf(posY) + "/VelocitàX:" + String.valueOf(velX) + "/VelocitàY:" + String.valueOf(velY);
    }

    public class TimerTask {

        public void run() {

        }
    }
}


