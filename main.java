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

    static DatiCondivisi ptrDati;
    static Sensore s;
    
    static ThScatola box[];
    static Scatole[] array;
    // dati condivisi
    //static ThBall[] thBalls;    // vettore con i threads
    //static int numBalls;        // numero di balls e di thread

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //numBalls = 2;
        ptrDati = new DatiCondivisi();
        array = ptrDati.getArray();

        ptrDati.setLungS(300 + 1);            //il +1 è unicamente per vedere lo stroke (il bordo) delle scatole
        ptrDati.setAltS(150 + 1);

        s = new Sensore(ptrDati);
        s.show();
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                array[i] = new Scatole(3375, 100, i, false, ptrDati, 150, 150, 150);
            } else {
                array[i] = new Scatole(0, 0, i, false, ptrDati, 150, 150, 150);
            }

        }

        PApplet.main(new String[]{"es.sabbia_scatola.EsSabbia_Scatola"});

    }

    public void settings() {
        size(ptrDati.getLungS(), ptrDati.getAltS());

        ThScatola th0 = new ThScatola(ptrDati, 0);
        ThScatola th1 = new ThScatola(ptrDati, 1);

        th0.start();
        th1.start();
        //ptrDati.setScreen(width, height);
        /*for (int i = 0; i < thBalls.length; i++) {
            thBalls[i].start();
        }*/
    }

    public void setup() {
        noStroke();
        frameRate(30);
        // ellipseMode(RADIUS);
    }

    public void draw() {
        /*if (!datiC.isRunning()) {
            exit();
        }*/
        background(119, 136, 153);
        for (int i = 0; i < ptrDati.getAltS() / 150; i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < ptrDati.getLungS() / 150; ii++) {  // ii --> sono colonne (coordinata X)
                int id = ii + (ptrDati.getNumColonne() * i);      // id = colonnaCorrente+(numeroDelleColonne * rigaCorrente)
                drawBoxPixel(id, ii * 150, i * 150);

            }
        }
        // clean the screen

        //for (int i = 0; i < 2; i++) {
        //    drawBox(i);
        //}
    }

    public void drawBox(int id, int colonnaPosX, int rigaPosY) {

        stroke(0, 0, 0);
       // noFill();
       fill(color(202, 188, 145, array[id].valueSand()));

        rect(colonnaPosX, rigaPosY, array[id].getLungB(), array[id].getAltB());
        
        
        //rect(i*150,ii*150,lunB1,altB1); 

        //rect(((lunS / 2) - lunB1), ((altS / 2) - (altB1 / 2)), lunB1, altB1);
        // fill(color(202, 188, 145, box1.valueSand()));
        //rect((lunS / 2), ((altS / 2) - (altB2 / 2)), lunB2, altB2);
    }

    public void drawBoxPixel(int id, int colonnaPosX, int rigaPosY) {
        int percentuale = array[id].getPerSabbia();
        float inclinazione = ptrDati.getInclinazioneY();
        
        //stroke(0, 0, 0);
        
        if (inclinazione > 0) {
            colonnaPosX=colonnaPosX+array[id].getLungB()-1;
            for(int i=0; i<array[id].valueSandPixel(); i++){
                fill(color(202, 188, 145));
                rect(colonnaPosX, rigaPosY, 1, array[id].getAltB());
                colonnaPosX--;
            }
        }

        
        stroke(0, 0, 0);
        noFill();
        rect(colonnaPosX, rigaPosY, array[id].getLungB(), array[id].getAltB());
    }

}
