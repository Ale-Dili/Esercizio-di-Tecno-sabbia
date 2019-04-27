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

    private double SabbiaSpostata;
    DatiCondivisi c = new DatiCondivisi();
 
    Sabbia() {
        this.SabbiaSpostata = 0;
    }

//riceve da sensore l'inclinazione tramite get in dati condivisi, in seguito controlla se l'inclinazione é sufficente per lo spostamento della sabbia, poi manda la quantita' di sabbia a thscatola tramite dati condivisi
    public void move() {
        if (c.getInclinazioneX() > 10) {
            SabbiaSpostata = 0.2 * c.getInclinazioneX();
        }
    }

    public void setC(DatiCondivisi c) {
        this.c = c;
    }

    public DatiCondivisi getC() {
        return c;
    }

}
