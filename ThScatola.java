/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            array[id].setSabbiaSpostata();
            
            
            try {
                Thread.sleep(10);                        //provare 5 millisecondi
            } catch (InterruptedException ex) {
                Logger.getLogger(ThScatola.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (ptrDati.getInclinazioneY() > 0) {
                
                array[id].getBall().IncrementaVelocitàX();
                
                if (id == 0) {
                    if (array[id].getSabbiaPersa() > 0) {

                        float newQuantity = array[id].getSandQuantity() - array[id].getSabbiaPersa();
                        if (newQuantity < 0) {
                            newQuantity = 0;
                            array[id].setSandQuantity(newQuantity);
                            array[id].setPerSabbia(0);
                            array[array[id].getIdTarget()].setPerSabbia(100);
                            array[array[id].getIdTarget()].setSandQuantity(3375);
                            
                            
                            
                        } else {
                            array[id].setSandQuantity(newQuantity);
                            array[id].setPerSabbia((int) (array[id].getSandQuantity() * 100) / 3375);                                         //100 : 3375 = x : sandQuantity
                            //System.out.println("prova:1 sandQuantity "+array[id].getSandQuantity());      //OUTPUT DI PROVA
                            array[id].setIdTarget(id + 1);
                            array[array[id].getIdTarget()].setSandQuantity(array[array[id].getIdTarget()].getSandQuantity() + array[id].getSabbiaPersa());
                            array[array[id].getIdTarget()].setPerSabbia((int) (array[array[id].getIdTarget()].getSandQuantity() * 100) / 3375);
                            
                            
                            
                        }
                    }
                }
            }
            if (ptrDati.getInclinazioneY() < 0) {
                
                array[id].getBall().DecrementaVelocitàX();
                
                if (id == 1) {

                    if (array[id].getSabbiaPersa() > 0) {

                        float newQuantity = array[id].getSandQuantity() - array[id].getSabbiaPersa();
                        
                        if ((newQuantity < 0) && (array[id].getIdTarget()!=-1)) {
                            newQuantity = 0;
                            array[id].setSandQuantity(newQuantity);
                            array[id].setPerSabbia(0);
                            array[array[id].getIdTarget()].setPerSabbia(100);
                            array[array[id].getIdTarget()].setSandQuantity(3375);
                            
                            
                        } else {
                            array[id].setSandQuantity(newQuantity);
                            array[id].setPerSabbia((int) (array[id].getSandQuantity() * 100) / 3375);                                         //100 : 3375 = x : sandQuantity
                            //System.out.println("prova:1 sandQuantity "+array[id].getSandQuantity());      //OUTPUT DI PROVA
                            array[id].setIdTarget(id - 1);
                            array[array[id].getIdTarget()].setSandQuantity(array[array[id].getIdTarget()].getSandQuantity() + array[id].getSabbiaPersa());
                            array[array[id].getIdTarget()].setPerSabbia((int) (array[array[id].getIdTarget()].getSandQuantity() * 100) / 3375);
                            
                            
                    } //
                    }
                }

            } else {
                //
            }
            array[id].moveBall();
            
            array[id].setSabbiaPersa(0);
            ptrDati.setArray(array);
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
