package es.sabbia_scatola;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Christian
 *
 */
public class Sabbia {
    
    private float SabbiaSpostata;
    DatiCondivisi ptrDati;
 
    Sabbia(DatiCondivisi ptrDati) {
        this.SabbiaSpostata = 0;
        this.ptrDati = ptrDati;
    }

    /**
     *
     * In questo metodo si contolla se l'inclinazione è sufficiente per lo spostamento della sabbia da una scatola a quella adiacente.
     * Successivamente manda la quantità di sabbia da spostare a ThScatola tramite DatiCondivisi.
     *
     */
    public void move() {       
        if (ptrDati.getInclinazioneY() > 10) {
            SabbiaSpostata = (float) (0.2 * ptrDati.getInclinazioneY());
            //System.out.println("prova1 "+ptrDati.getInclinazioneY());             OUTPUT DI PROVA
        }
        if(ptrDati.getInclinazioneY()<-10) {
            SabbiaSpostata = (float) (0.2 * ptrDati.getInclinazioneY()) * -1;
            //System.out.println("prova2 "+ptrDati.getInclinazioneY());             OUTPUT DI PROVA
        }   
    }

    /**
     *
     * Metodo get che fa ritornare la quantità di sabbia spostata.
     *
     */
    public float getSabbiaSpostata() {
        return SabbiaSpostata;
    }

    /**
     *
     * Metodo set che permette di settare la quantità di sabbia spostata.
     *
     */
    public void setSabbiaSpostata(float SabbiaSpostata) {
        this.SabbiaSpostata = SabbiaSpostata;
    }
    
    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }
}
