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
    private float newQuantity;

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
            array[id].setSabbiaPersa(array[id].getSabbiaSpostata());        //Sposta il valore di SabbiaSpostata in SabbiaPersa
            array[id].setSabbiaSpostata();          //Resetta a 0 il valore di SabbiaSpostata
            if (array[id].ballTF) {                  //Se nella scatola è presente la pallina (ballTF=true)
                array[id].moveBall(id);             //La pallina viene mossa
            }
            try {
                Thread.sleep(10);                        //provare 5 millisecondi
            } catch (InterruptedException ex) {
                Logger.getLogger(ThScatola.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (ptrDati.getInclinazioneY() > 10) {

                array[id].setIdTarget(id + 1);

                GestionePallinaVersoDestra();
                GestioneSabbiaVersoDestra();

            }
            if (ptrDati.getInclinazioneY() < -10) {

                array[id].setIdTarget(id - 1);

                GestionePallinaVersoSinistra();
                GestioneSabbiaVersoSinistra();

            } else {

            }

            array[id].setSabbiaPersa(0);
            ptrDati.setArray(array);
            //-------------------------------------------------------------SETTARE NUOVAMENTE L'ARRAY
        }

    }

    private void GestionePallinaVersoDestra() {
        if (array[id].ballTF) {
            array[id].getBall().IncrementaVelocitàX();      //incremento velocità pallina se presente nella scatola
        }

        if ((array[id].isBallTF()) && (ptrDati.isSposta()) && (array[id].getBall().getPosX() == 150 - (array[id].getBall().getRaggio() / 2))) {     //se pallina è presente, se ha raggiunto una velocità sufficente e se tocca il bordo
            array[array[id].getIdTarget()].setBall(new Pallina(array[id].getPtrDati(), (array[id].getIdTarget() * 150) + (array[id].getBall().getRaggio() / 2), 75));      //Creo nuova pallina in scatola successiva

            CambioPallina();        //Resetto ball e ballTF della scatola in esecuzione, resetto l'attributo sposta e indico che la scatola successiva ha la pallina
        }
    }

    private void GestionePallinaVersoSinistra() {
        if (array[id].ballTF) {
            array[id].getBall().DecrementaVelocitàX();      //decremento velocità pallina se presente nella scatola
        }

        if ((array[id].isBallTF()) && (ptrDati.isSposta()) && (array[id].getBall().getPosX() == 150 + (array[id].getBall().getRaggio() / 2))) {             //se pallina è presente, se ha raggiunto una velocità sufficente e se tocca il bordo
            if (array[id].getIdTarget() == 0) {
                array[array[id].getIdTarget()].setBall(new Pallina(array[id].getPtrDati(), (150 + (array[id].getIdTarget() * 150)) - (array[id].getBall().getRaggio() / 2), 75));       //Creo nuova pallina in scatola precedente(se è la scatola con id=0)
            } else {
                array[array[id].getIdTarget()].setBall(new Pallina(array[id].getPtrDati(), (array[id].getIdTarget() * 150) + (array[id].getBall().getRaggio() / 2), 75));       //Creo nuova pallina in scatola precedente
            }
            CambioPallina();        //Resetto ball e ballTF della scatola in esecuzione, resetto l'attributo sposta e indico che la scatola successiva ha la pallina
        }
    }

    private void CambioPallina() {
        array[array[id].getIdTarget()].setBallTF(true);
        array[id].setBall(null);
        array[id].setBallTF(false);
        ptrDati.setSposta(false);
    }

    private void GestioneSabbiaVersoDestra() {
        if ((array[id].getSabbiaPersa() > 0) && (array[id].isPiena())) {            //Quando c'è sabbia da spostare e scatola in esecuzione è piena

            newQuantity = array[id].getSandQuantity() - array[id].getSabbiaPersa();     //Calcolo nuova quantità di sabbia
            if (newQuantity < 0) {
                CambioSabbia();                         //Se <0 resetto a 0 valori di sabbia della scatola in esecuzione e setto ai valori di default quelli della scatola successiva

            } else {
                if (((array[id].getIdTarget()) % ptrDati.getNumColonne()) == 0) {           //Se scatola è ultima nella sua riga non aggiorno la sabbia

                } else {
                    AggiornaSabbia();                   //Aggiorno spostamento della sabbia
                }

            }
        }

    }

    private void GestioneSabbiaVersoSinistra() {
        if ((array[id].getSabbiaPersa() > 0) && (array[id].isPiena())) {            //Quando c'è sabbia da spostare e scatola in esecuzione è piena

            newQuantity = array[id].getSandQuantity() - array[id].getSabbiaPersa();     //Calcolo nuova quantità di sabbia

            if (array[id].getIdTarget() != -1) {        

                if ((newQuantity < 0)) {                //Se <0 resetto a 0 valori di sabbia della scatola in esecuzione e setto ai valori di default quelli della scatola precedente
                    CambioSabbia();
                } else {
                    if ((id % ptrDati.getNumColonne()) == 0) {      //Se scatola è prima nella sua riga non aggiorno la sabbia

                    } else {
                         AggiornaSabbia();         //Aggiorno spostamento della sabbia 
                    }
                }
            }
        }
    }

    private void CambioSabbia() {
        newQuantity = 0;
        array[id].setSandQuantity(newQuantity);
        array[id].setPerSabbia(0);
        array[id].setPiena(false);
        array[array[id].getIdTarget()].setPerSabbia(100);
        array[array[id].getIdTarget()].setSandQuantity(3375);
        array[array[id].getIdTarget()].setPiena(true);
    }

    private void AggiornaSabbia() {
        array[id].setSandQuantity(newQuantity);
        array[id].setPerSabbia((int) (array[id].getSandQuantity() * 100) / 3375);                                         //100 : 3375 = x : sandQuantity
        //System.out.println("prova:1 sandQuantity "+array[id].getSandQuantity());      //OUTPUT DI PROVA

        array[array[id].getIdTarget()].setSandQuantity(array[array[id].getIdTarget()].getSandQuantity() + array[id].getSabbiaPersa());
        array[array[id].getIdTarget()].setPerSabbia((int) (array[array[id].getIdTarget()].getSandQuantity() * 100) / 3375);
    }

}
