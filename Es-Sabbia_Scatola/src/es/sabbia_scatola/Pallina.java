/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Luca
 */
public class Pallina {

    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo float che rappresenta la posizione della
     * pallina sull'asse delle x.
     */
    private float posX;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo float che rappresenta la posizione della
     * pallina sull'asse delle y.
     */
    private float posY;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo double che rappresenta la velocità della
     * pallina sull'asse delle x.
     */
    private double velX;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo double che rappresenta la velocità della
     * pallina sull'asse delle y.
     */
    private double velY;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo intero che rappresenta il raggio di grandezza
     * della pallina.
     */
    private int Raggio;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo intero che rappresenta la direzione della
     * pallina sull'asse delle x.
     */
    private int direzioneX;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo intero che rappresenta la direzione della
     * pallina sull'asse delle y.
     */
    private int direzioneY;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Oggetto di tipo DatiCondivisi che serve per richiamare i metodi
     * della classe DatiCondivisi.
     */
    private DatiCondivisi ptrDati;

    private int cont = 0;

    /**
     * @author Edoardo Ballabio
     *
     * @brief Costruttore senza parametri che all'inizio dell'esecuzione del programma posiziona la pallina al centro 
     * della scatola e imposta le sue velocità a 0.
     */
    public Pallina(DatiCondivisi dati, float posX, float posY) {
        this.ptrDati = dati;
        this.Raggio = 20;
        this.posX = posX;          //Cambiare in base a lunghezza della scatola
        this.posY = posY;          //Cambiare in base a larghezza della scatola
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

    /**
     * @author Edoardo Ballabio
     *
     * @brief Costruttore con parametri
     */
    public Pallina(float posX, float posY, double velX, double velY, int direzioneX, int direzioneY, int Raggio) {
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
        this.direzioneX = direzioneX;
        this.direzioneY = direzioneY;
        this.Raggio = Raggio;

    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare l'oggetto di tipo DatiCondivisi.
     */
    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore dell'oggetto di tipo DatiCondivisi.
     */
    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della variabile cont.
     */
    public int getCont() {
        return cont;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile cont.
     * 
     */
    public void setCont(int cont) {
        this.cont = cont;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della direzione della pallina sull'asse delle x.
     * 
     * @return direzioneX attributo che rappresenta la direzione della pallina sull'asse delle x.
     */
    public int getDirezioneX() {
        return direzioneX;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della direzione della pallina sull'asse delle x.
     * 
     * @param direzioneX Parametro che indica la direzione della pallina sull'asse delle x.
     */
    public void setDirezioneX(int direzioneX) {
        this.direzioneX = direzioneX;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della direzione della pallina sull'asse delle y.
     * 
     * @return direzioneY attributo che rappresenta la direzione della pallina sull'asse delle y.
     */
    public int getDirezioneY() {
        return direzioneY;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della direzione della pallina sull'asse delle y.
     * 
     * @param direzioneY Parametro che indica la direzione della pallina sull'asse delle y.
     */
    public void setDirezioneY(int direzioneY) {
        this.direzioneY = direzioneY;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore del raggio della pallina.
     * 
     * @return Raggio attributo che rappresenta il raggio di grandezza della pallina.
     */
    public int getRaggio() {
        return Raggio;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore del raggio della pallina.
     * 
     * @param Raggio Parametro che indica il raggio di grandezza della pallina.
     */
    public void setRaggio(int Raggio) {
        this.Raggio = Raggio;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della posizione della pallina sull'asse delle x.
     * 
     * @return posX attributo che rappresenta la posizione della pallina sull'asse delle x.
     */
    public float getPosX() {
        return posX;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della posizione della pallina sull'asse delle x.
     * 
     * @param posX Parametro che indica la posizione della pallina sull'asse delle x.
     */
    public void setPosX(float posX) {
        this.posX = posX;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della posizione della pallina sull'asse delle y.
     * 
     * @return posY attributo che rappresenta la posizione della pallina sull'asse delle x.
     */
    public float getPosY() {
        return posY;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della posizione della pallina sull'asse delle y.
     * 
     * @param posY Parametro che indica la posizione della pallina sull'asse delle y.
     */
    public void setPosY(float posY) {
        this.posY = posY;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della velocità della pallina sull'asse delle x.
     * 
     * @return velX attributo che rappresenta la velocità della pallina sull'asse delle x.
     */
    public double getVelX() {
        return velX;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della velocità della pallina sull'asse delle x.
     * 
     * @param velX Parametro che indica la velocità della pallina sull'asse delle x.
     */
    public void setVelX(double velX) {
        this.velX = velX;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della velocità della pallina sull'asse delle y.
     * 
     * @return velY attributo che rappresenta la velocità della pallina sull'asse delle x.
     */
    public double getVelY() {
        return velY;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della velocità della pallina sull'asse delle y.
     * 
     * @param velY Parametro che indica la velocità della pallina sull'asse delle y.
     */
    public void setVelY(double velY) {
        this.velY = velY;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che si occupa di muovere la pallina.
     * 
     * In questo metodo in base all'inclinazione viene cambiata la direzione della pallina.
     * Inoltre la posizione della pallina viene aggiornata in base alla velocitò di quest'ultima.
     * Più la scatola è inclinata più la pallina si sposterà velocemente.
     * Quando la pallina tocca il bordo della scatola, se ha una velocità sufficiente, passerà nell'altra scatola.
     * 
     * @param idBox Parametro che indica il codice identificativo della scatola in cui la pallina si muove.
     */
    public void Move(int idBox) {
        if (ptrDati.getInclinazioneY() > 10) {
            direzioneX = 1;
        }
        if (ptrDati.getInclinazioneY() < -10) {
            direzioneX = -1;
        }

        posX = posX + (float) ((velX * direzioneX) * (ptrDati.getInclinazioneY() / 10));      
        posY = posY + (float) (velY * direzioneY);                                        
        if (posX >= 150 + ((150 * idBox) - (Raggio / 2))) {             

            if ((velX * (ptrDati.getInclinazioneY() / 10)) > 1) {
                ptrDati.setSposta(true);
            }

            posX = 150 + (150 * idBox) - (Raggio / 2);
            velX = 0;
        }


        if ((posX <= 0 + (150 * idBox) + (Raggio / 2))) {

            if (((velX * (ptrDati.getInclinazioneY() / 10))* -1) < -1) {
                ptrDati.setSposta(true);
            }
            posX = 0 + (150 * idBox) + (Raggio / 2);
            velX = 0;
        }

        /*if(posY>=HEIGHT_SCREEN-Raggio) {
            posY=HEIGHT_SCREEN-Raggio;              //FUTURO
        }       
         */
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che incrementa la velocità della pallina sull'asse delle x.
     * 
     * In questo metodo se la variabile contatore è pari a 10 la velocità sull'asse delle x viene 
     * incrementata di 0.02.
     * Infine se la velocità sull'asse delle x è maggiore di 0.2, quest'ultima viene impostata a 0.2 (velocità massima verso destra).
     */
    public void IncrementaVelocitàX() {
        if (cont == 10) {                          //CONTATORE CHE SERVE PER INCREMENTARE LA VELOCITA DELLA PALLINA SOLO 1 VOLTA OGNI 20 RICHIAMI DEL METODO
            velX += 0.02;
            if (velX > 0.2) {
                velX = 0.2;                       
            }
            cont = 0;
        } else {
            cont++;
        }

    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che incrementa la velocità della pallina sull'asse delle y.
     */
    public void IncrementaVelocitàY() {
        velY += 0.2;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che decrementa la velocità della pallina sull'asse delle x.
     * 
     * In questo metodo se la variabile contatore è pari a 10 la velocità sull'asse delle x viene 
     * decrementata di 0.02.
     * Infine se la velocità sull'asse delle x è minore di -0.2, quest'ultima viene impostata a -0.2 (velocità massima verso sinistra). 
     */
    public void DecrementaVelocitàX() {
        if (cont == 10) {                          //CONTATORE CHE SERVE PER DECREMENTARE LA VELOCITA DELLA PALLINA SOLO 1 VOLTA OGNI 20 RICHIAMI DEL METODO
            velX -= 0.02;                        //DecrementaVelocitàX(), IN QUESTO MODO SI EVITA CHE LA VELOCITA NON DIMINUISCA TROPPO VELOCEMENTE
            if (velX < -0.2) {
                velX = -0.2;                      
            }
            cont = 0;
        } else {
            cont++;
        }
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che decrementa la velocità della pallina sull'asse delle y.
     */
    public void DecrementaVelocitàY() {
        velY -= 0.2;
        if (velY < 0) {
            velY = 0;
        }
    }

    public String VisualizzaInfo() {
        return "PosizioneX: " + String.valueOf(posX) + "/PosizioneY:" + String.valueOf(posY) + "/VelocitàX:" + String.valueOf(velX) + "/VelocitàY:" + String.valueOf(velY);
    }
    
}
