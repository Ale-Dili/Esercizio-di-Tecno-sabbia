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
        ptrDati= new DatiCondivisi();
        array = ptrDati.getArray();
        ptrDati.setLungS(300);
        ptrDati.setAltS(150);
        
        s = new Sensore();

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
        for(int i=0;i<ptrDati.getAltS()/150;i++) {
            for(int ii=0;ii<ptrDati.getLungS()/150;ii++) {
                int id=ii+(ptrDati.getNumColonne()*i);      // id = colonnaCorrente+(numeroDelleColonne * rigaCorrente)
                drawBox(id);
                
                
                
            }
        }
        // clean the screen
        background(119, 136, 153);
        for (int i = 0; i < 2; i++) {
            drawBox(i);
        }

    }

    public void drawBox(int id) {
        int lunB1 = array[id].getLungB();
        int altB1 = array[id].getAltB();
        
        int lunB2 = array[id].getLungB();
        int altB2 = array[id].getAltB();
        int lunS = ptrDati.getLungS();
        int altS = ptrDati.getAltS();

        stroke(0, 0, 0);

        fill(color(202, 188, 145, array[id].valueSand()));
        
        //rect(i*150,ii*150,lunB1,altB1); 
        
        
        //rect(((lunS / 2) - lunB1), ((altS / 2) - (altB1 / 2)), lunB1, altB1);

       // fill(color(202, 188, 145, box1.valueSand()));
        
        
        //rect((lunS / 2), ((altS / 2) - (altB2 / 2)), lunB2, altB2);
    }

}
