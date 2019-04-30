/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.ArrayList;
import processing.core.*;

/**
 *
 * @author Alessandro
 */
public class ThScatola extends Thread {

    private DatiCondivisi ptrDati;
    private Scatole[] array;
    private int id;

    public ThScatola(DatiCondivisi ptrDati, int id) {
        this.id = id;
        this.ptrDati = ptrDati;
        array = ptrDati.getArray();

    }

    public ThScatola() {

    }

    public void run() {
        while (true) {
            array[id].move();
            array[id].setSabbiaPersa(array[id].getSabbiaSpostata());
            if (array[id].getSabbiaPersa() > 0) {
                float persa = array[id].getSandQuantity() - array[id].getSabbiaPersa();
                array[id].setSandQuantity(persa);

                if (ptrDati.getInclinazioneY() > 0) {
                    if (id == 1) {
                        array[id].setIdTarget(id + 1);
                        array[array[id].getIdTarget()].setSandQuantity(array[array[id].getIdTarget()].getSandQuantity() + array[id].getSabbiaPersa());
                    }//
                }
                if (ptrDati.getInclinazioneY() > 0) {
                    if (id == 1) {
                        array[id].setIdTarget(id - 1);
                        array[array[id].getIdTarget()].setSandQuantity(array[array[id].getIdTarget()].getSandQuantity() + array[id].getSabbiaPersa());
                    } //
                }
                array[id].setSabbiaPersa(0);
            } else {
                //
            }
            //-------------------------------------------------------------SETTARE NUOVAMENTE L'ARRAY
        }
    }

    /* public int getSabbiaPersa() {
        return sabbiaPersa;
    }
    
     public void setSabbiaPersa(int sabbiaPersa) {
        this.sabbiaPersa = sabbiaPersa;
    }
     */
    // public DatiCondivisi(){
    //}
    /*  public int getLungS() {
        return lungS;
    }
    public int getAltS() {
        return altS;
    }
    public int getLungB() {
        return lungB;
    }
    public int getAltB() {
        return altB;
    }
    public void setLungS(int lungS) {
        this.lungS = lungS;
    }
    public void setAltS(int altS) {
        this.altS = altS;
    }
    public void setLungB(int lungB) {
        this.lungB = lungB;
    }
    public void setAltB(int altB) {
        this.altB = altB;
    }
    public int getPerSabbia() {
        return perSabbia;
    }
    public float getInclinazione() {
        return inclinazione;
    }
    public void setPerSabbia(int perSabbia) {
        this.perSabbia = perSabbia;
    }
    public void setInclinazione(float inclinazione) {
        this.inclinazione = inclinazione;
    }
    public int valueSand() {
        return (255 * perSabbia) / 100;
    }*/
}
