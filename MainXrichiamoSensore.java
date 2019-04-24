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
   static DatiCondivisi datiC;
    static Scatola box2;
    static Scatola box1;// dati condivisi
    //static ThBall[] thBalls;    // vettore con i threads
    //static int numBalls;        // numero di balls e di thread

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //numBalls = 2;
        box2 = new Scatola();
        box2.setAltS(320);
        box2.setLungS(640);
        box2.setAltB(150);
        box2.setLungB(150);
        box2.setPerSabbia(70);    //70

        box1 = new Scatola();

        box1.setAltS(320);
        box1.setLungS(640);
        box1.setAltB(150);
        box1.setLungB(150);
        box1.setPerSabbia(30);   ///30
        //thBalls = new ThBall[numBalls];
        //for (int i = 0; i < thBalls.length; i++) {
        //   thBalls[i] = new ThBall(datiC, i);
        //}

        PApplet.main(new String[]{"es.sabbia_scatola.EsSabbia_Scatola"});

         Sensore s = new Sensore(datiC);
        // shows Swing windows
         s.show();
    }

    public void settings() {
        size(box1.getLungS(), box1.getAltS());
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

        // clean the screen
        background(119, 136, 153);

        drawBox(box1, box2);

    }

    public void drawBox(Scatola box1, Scatola box2) {
        int lunB1 = box1.getLungB();
        int altB1 = box1.getAltB();
        int lunB2 = box2.getLungB();
        int altB2 = box2.getAltB();
        int lunS = box1.getLungS();
        int altS = box1.getAltS();

        stroke(0, 0, 0);

        fill(color(202, 188, 145, box2.valueSand()));

        rect((lunS / 2), ((altS / 2) - (altB2 / 2)), lunB2, altB2);

        fill(color(202, 188, 145, box1.valueSand()));
        rect(((lunS / 2) - lunB1), ((altS / 2) - (altB1 / 2)), lunB1, altB1);
    }

}
