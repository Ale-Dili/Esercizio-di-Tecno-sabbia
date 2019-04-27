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

//riceve da sensore l'inclinazione tramite get in dati condivisi, in seguito controlla se l'inclinazione é sufficente per lo spostamento della sabbia, poi manda la quantita' di sabbia a thscatola tramite dati condivisi
    public void move() {
        if (ptrDati.getInclinazioneY() > 10) {
            SabbiaSpostata = (float) (0.2 * ptrDati.getInclinazioneY());
        }
    }

    public float getSabbiaSpostata() {
        return SabbiaSpostata;
    }

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
