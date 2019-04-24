/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class DatiCondivisi {

    private int lungS, altS; //dimensioni schermo
    private int lungB, altB, profB; //dimensioni scatola
    private int perSabbia; //percentuale sabbia
    private Sensore s=new Sensore();
    private Scatole[] array;

    public DatiCondivisi(int lungS, int altS, int lungB, int altB,int profB, int perSabbia) {
        this.lungS = lungS;
        this.altS = altS;
        this.lungB = lungB;
        this.altB = altB;
        this.perSabbia = perSabbia;
        this.profB = profB;
        array = new Scatole[2];
        
    }

    public void setProfB(int profB) {
        this.profB = profB;
    }

    public void setS(Sensore s) {
        this.s = s;
    }

    public int getProfB() {
        return profB;
    }

    public Sensore getS() {
        return s;
    }

    


    public float getInclinazioneX() {
        return s.getInclinazioneX();
    }
    
    public float getInclinazioneY() {
        return s.getInclinazioneY();
    }
    
    public void setInclinazioneX(float inclinazione) {
        s.setInclinazioneX(inclinazione);
    }
    
    public void setInclinazioneY(float inclinazione) {
        s.setInclinazioneY(inclinazione);
    }

    public DatiCondivisi() {

    }

    public int getLungS() {
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

    public void setPerSabbia(int perSabbia) {
        this.perSabbia = perSabbia;
    }

    public int getPerSabbia() {
        return perSabbia;
    }

    public Scatole[] getArray() {
        return array;
    }

    public void setArray(Scatole[] array) {
        this.array = array;
    }

   
    


}
