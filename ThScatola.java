/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import processing.core.*;

/**
 *
 * @author Alessandro
 */
public class ThScatola extends Thread{

    int sandQuantity;
    int perSabbia; //percentuale sabbia
    float inclinazione; //inclinazione asse y nel punto CENTRE,CENTRE dello schermo
    int id;
    boolean ball;
    DatiCondivisi ptrDati;

    public ThScatola(int sandQuantity, int perSabbia, float inclinazione, int id, boolean ball, DatiCondivisi ptrDati) {
        this.sandQuantity = sandQuantity;
        this.perSabbia = perSabbia;
        this.inclinazione = inclinazione;
        this.id = id;
        this.ball = ball;
        this.ptrDati = ptrDati;
    }

   

    public ThScatola() {

    }
    
    public void run(){
        while(true){
            
        
        }
    }

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
