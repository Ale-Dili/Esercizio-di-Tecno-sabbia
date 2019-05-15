/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.*;

/**
 *
 * @author scuola
 */
public class EsSabbia_Scatola extends PApplet {
    /**
     * @author Edoardo Ballabio
     *
     * @brief Oggetto di tipo DatiCondivisi che serve per richiamare i metodi
     * della classe DatiCondivisi.
     */
    static DatiCondivisi ptrDati;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Oggetto di tipo Sensore che serve per richiamare i metodi
     * della classe Sensore.
     */
    static Sensore s;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo che rappresenta un insieme di thread ThScatola.
     */
    static ThScatola thBoxes[];  
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo che rappresenta un insieme di scatole.
     */
    static Scatole[] array;

    static ThPallina thBall;
    /**
     * @author Edoardo Ballabio
     * 
     * @brief Metodo che inizializza i vari attributi della classe e crea una nuova canvas per il disegno dei vari elementi
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ptrDati = new DatiCondivisi();
        array = ptrDati.getArray();
        
        thBoxes = new ThScatola[ptrDati.getNumRighe() * ptrDati.getNumColonne()];           //NUOVO

        ptrDati.setLungS(ptrDati.getNumColonne() * 150 + 1);            //il +1 è unicamente per vedere lo stroke (il bordo) delle scatole
        ptrDati.setAltS(ptrDati.getNumRighe() * 150 + 1);

        s = new Sensore(ptrDati);
        s.show();
        for (int i = 0; i < (ptrDati.getNumColonne() * ptrDati.getNumRighe()); i++) {
            if (i == 0) {
                array[i] = new Scatole(3375, 100, i, true, ptrDati, 150, 150, 150);
            } else {
                array[i] = new Scatole(0, 0, i, false, ptrDati, 150, 150, 150);
            }

        }
        

        for (int i = 0; i < thBoxes.length; i++) {               
            thBoxes[i] = new ThScatola(ptrDati, i);         
        }       
        
        thBall=new ThPallina(ptrDati);
        thBall.start();
        PApplet.main(new String[]{"es.sabbia_scatola.EsSabbia_Scatola"});

    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che inizializza le dimensioni della canvas e fa partire i vari thread ThScatola.
     */
    public void settings() {
        size(ptrDati.getLungS(), ptrDati.getAltS());

        for (int i = 0; i < array.length; i++) {       
            thBoxes[i].start();                 
        }                                       
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che inizializza la canvas.
     */
    public void setup() {
        noStroke();
        frameRate(60);
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che si occupa di disegnare la canvas e i suoi elementi.
     * 
     * In questo metodo viene colorato lo sfondo della canvas e vengono disegnate le varie scatole che la compongono.
     * Inoltre viene disegnata anche la pallina.
     */
    public void draw() {
        background(119, 136, 153);
        for (int i = 0; i < (int) (ptrDati.getAltS() / 150); i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < (int) (ptrDati.getLungS() / 150); ii++) {  // ii --> sono colonne (coordinata X)
                int id = ii + (ptrDati.getNumColonne() * i);      // id = colonnaCorrente+(numeroDelleColonne * rigaCorrente)
                drawBoxPixel(id, ii * 150, i * 150);
                
 
                if((ptrDati.getInclinazioneY()>10) || (ptrDati.getInclinazioneY()<-10)) {                    
                    ptrDati.signalPallina();
                }
                
                
                if (array[id].isBallTF()) {
                    drawBall(id);
                }
            }
        }

    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che si occupa di disegnare lo spostamento graduale della sabbia.
     * 
     * In questo metodo in base all'inclinazione della scatola vengono disegnate delle colonne di pixel che rappresentano la sabbia.
     */
    public void drawBoxPixel(int id, int colonnaPosX, int rigaPosY) {
        stroke(0, 0, 0);

        rect(colonnaPosX, rigaPosY, array[id].getLungB(), array[id].getAltB());

        if (ptrDati.getInclinazioneY() >= 0) {
            colonnaPosX = colonnaPosX + array[id].getLungB() - 2;
            for (int i = 0; i < array[id].valueSandPixel(); i++) {
                noStroke();
                fill(color(202, 188, 145));
                rect(colonnaPosX, rigaPosY, 1, array[id].getAltB());
                colonnaPosX--;

            }
        }
        if (ptrDati.getInclinazioneY() < 0) {
            for (int i = 0; i < array[id].valueSandPixel(); i++) {
                noStroke();
                fill(color(202, 188, 145));
                rect(colonnaPosX, rigaPosY, 1, array[id].getAltB());
                colonnaPosX++;
            }

        }
        stroke(0, 0, 0);
        noFill();
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che si occupa di disegnare la pallina.
     * 
     * In questo metodo la pallina viene disegnata in base al suo raggio e alla posizione.
     */
    public void drawBall(int id) {
        fill(color(255, 0, 0));
        stroke(0, 0, 0);
        ellipse(array[id].getBall().getPosX(), array[id].getBall().getPosY(), array[id].getBall().getRaggio(), array[id].getBall().getRaggio());
        noFill();
    }
}

