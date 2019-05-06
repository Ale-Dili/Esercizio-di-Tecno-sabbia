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

    static ThScatola thBoxes[];         //NUOVO
    static Scatole[] array;

    /**
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

        for (int i = 0; i < thBoxes.length; i++) {                 //NUOVO
            thBoxes[i] = new ThScatola(ptrDati, i);           //NUOVO
        }                                                   //NUOVO

        PApplet.main(new String[]{"es.sabbia_scatola.EsSabbia_Scatola"});

    }

    public void settings() {
        size(ptrDati.getLungS(), ptrDati.getAltS());

        for (int i = 0; i < array.length; i++) {       //NUOVO
            thBoxes[i].start();                 //NUOVO
        }                                       //NUOVO

    }

    public void setup() {
        noStroke();
        frameRate(60);
    }

    public void draw() {
        background(119, 136, 153);
        for (int i = 0; i < (int) (ptrDati.getAltS() / 150); i++) {          // i --> sono righe (coordinata Y)
            for (int ii = 0; ii < (int) (ptrDati.getLungS() / 150); ii++) {  // ii --> sono colonne (coordinata X)
                int id = ii + (ptrDati.getNumColonne() * i);      // id = colonnaCorrente+(numeroDelleColonne * rigaCorrente)
                drawBoxPixel(id, ii * 150, i * 150);
                //drawBox(id, ii * 150, i * 150);
                if (array[id].ballTF) {
                    drawBall(id);
                }
            }
        }

    }

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

    public void drawBall(int id) {
        fill(color(255, 0, 0));
        stroke(0, 0, 0);
        ellipse(array[id].getBall().getPosX(), array[id].getBall().getPosY(), array[id].getBall().getRaggio(), array[id].getBall().getRaggio());
        noFill();
    }
}
