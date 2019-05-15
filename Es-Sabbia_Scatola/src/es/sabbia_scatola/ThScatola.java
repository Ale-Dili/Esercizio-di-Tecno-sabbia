package es.sabbia_scatola;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.*;

/**
 * @author Luca Tosetti
 *
 * @brief ThScatola.java: classe ThScatola che si occupa della gestione della
 * sabbia.
 */
public class ThScatola extends Thread {

    /**
     * @author Christian Sipione
     *
     * @brief Oggetto di tipo DatiCondivisi che serve per richiamare i metodi
     * della classe DatiCondivisi.
     */
    private DatiCondivisi ptrDati;
    /**
     * @author Christian Sipione
     *
     * @brief Insieme di oggetti di tipo Scatole che serve per richiamare i
     * metodi della classe Scatole.
     */
    private Scatole[] array;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo di tipo int che rappresenta la singola scatola.
     */
    private int id;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo di tipo float che rappresenta di volta in volta la
     * quantitá della sabbia.
     */
    private float newQuantity;

    /**
     * @author Christian Sipione
     *
     * @brief Metodo costruttore con parametri
     *
     * @param ptrDati parametro che serve per richiamare i metodi della classe
     * DatiCondivisi.
     * @param id parametro che serve per rappresentare la singola scatola.
     */
    public ThScatola(DatiCondivisi ptrDati, int id) {
        this.id = id;
        this.ptrDati = ptrDati;
        array = ptrDati.getArray();

    }

    public ThScatola() {

    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di gestire lo spostamento della sabbia 
     *
     * Metodo che gestisce la sabbia attraverso i metodi
     * GestioneSabbiaVersoDestra(),GestioneSabbiaVersoSinistra() inoltre utilizza
     * l'oggetto array tramite puntatore id per indicare la scatola di
     * riferimento su cui lavorare.
     */
    public void run() {
        while (true) {

            array[id].move();
            array[id].setSabbiaPersa(array[id].getSabbiaSpostata());        //Sposta il valore di SabbiaSpostata in SabbiaPersa
            array[id].setSabbiaSpostata();          //Resetta a 0 il valore di SabbiaSpostata

            try {
                Thread.sleep(10);                        //provare 5 millisecondi
            } catch (InterruptedException ex) {
                Logger.getLogger(ThScatola.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (ptrDati.getInclinazioneY() > 10) {

                array[id].setIdTarget(id + 1);

                GestioneSabbiaVersoDestra();

            }
            if (ptrDati.getInclinazioneY() < -10) {

                array[id].setIdTarget(id - 1);

                GestioneSabbiaVersoSinistra();

            } else {

            }

            array[id].setSabbiaPersa(0);
            ptrDati.setArray(array);
            //-------------------------------------------------------------SETTARE NUOVAMENTE L'ARRAY
        }

    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di gestire lo spostamento della sabbia.
     *
     * Metodo che prima verifica la presenza della sabbia nella scatola, se
     * presente calcola la nuova quantita di sabbia da spostare, se la scatola e
     * l'ultima della sua righa non avviene l'aggiornamento della quantitá di
     * sabbia, inoltre nel caso si generi un eccezione quando la prima scatola è
     * piena di sabbia non avviene il controllo delle condizioni riguardanti la
     * presenza di sabbia.
     */
    private void GestioneSabbiaVersoDestra() {
        try {                                                           //Faccio un try
            if (((array[id].getSabbiaPersa() > 0) && (array[id].isPiena()) && (array[id - 1].getSandQuantity() == 0)) || ((array[id].getSabbiaPersa() > 0) && (array[id].getSandQuantity() != 0) && (array[array[id].getIdTarget()].isPiena()))) {            //Quando c'è sabbia da spostare e scatola in esecuzione è piena

                newQuantity = array[id].getSandQuantity() - array[id].getSabbiaPersa();     //Calcolo nuova quantità di sabbia
                if (newQuantity < 0) {
                    CambioSabbia();                         //Se <0 resetto a 0 valori di sabbia della scatola in esecuzione e setto ai valori di default quelli della scatola successiva

                } else {
                    if ((array[id].getIdTarget() % ptrDati.getNumColonne()) == 0) {           //Se scatola è ultima nella sua riga non aggiorno la sabbia

                    } else {
                        AggiornaSabbia();                   //Aggiorno spostamento della sabbia
                    }

                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {                    //Nel caso si generi un'eccezione(in --> array[id - 1].getSandQuantity() == 0) di tipo ArrayIndexOutOfBounds si tratta della scatola con id pari a 0 
            //e dato che questo errore si genererà solo quando la prima scatola è piena di sabbia non c'è bisogno di tutte le altre condizioni
            if ((array[id].getSabbiaPersa() > 0) && (array[id].isPiena())) {
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

    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di gestire lo spostamento della sabbia.
     *
     * Metodo che prima verifica la presenza della sabbia nella scatola, se
     * presente calcola la nuova quantita di sabbia da spostare, se la scatola e
     * la prima della sua righa non avviene l'aggiornamento della quantitá di
     * sabbia, inoltre nel caso si generi un eccezione quando l'ultima scatola è
     * piena di sabbia non avviene il controllo delle condizioni riguardanti la
     * presenza di sabbia.
     */
    private void GestioneSabbiaVersoSinistra() {
        if (array[id].getIdTarget() != -1) {
            try {
                if (((array[id].getSabbiaPersa() > 0) && (array[id].isPiena()) && (array[id + 1].getSandQuantity() == 0)) || ((array[id].getSabbiaPersa() > 0) && array[array[id].getIdTarget()].isPiena() && (array[id].getSandQuantity() != 0))) {            //Quando c'è sabbia da spostare e scatola in esecuzione è piena

                    newQuantity = array[id].getSandQuantity() - array[id].getSabbiaPersa();     //Calcolo nuova quantità di sabbia

                    if ((newQuantity < 0)) {                //Se <0 resetto a 0 valori di sabbia della scatola in esecuzione e setto ai valori di default quelli della scatola precedente
                        CambioSabbia();
                    } else {
                        if ((id % ptrDati.getNumColonne()) == 0) {      //Se scatola è prima nella sua riga non aggiorno la sabbia

                        } else {
                            AggiornaSabbia();         //Aggiorno spostamento della sabbia 
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) {                    //Nel caso si generi un'eccezione(in --> array[id + 1].getSandQuantity() == 0) di tipo ArrayIndexOutOfBounds si tratta dell'ultima scatola(Quella con id più alto) 
                //e dato che questo errore si genererà solo quando l'ultima scatola è piena di sabbia non c'è bisogno di tutte le altre condizioni
                if ((array[id].getSabbiaPersa() > 0) && (array[id].isPiena())) {
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
        }
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di impostare la quantitá di sabbia.
     *
     * Metodo che resetta la quantitá, la percentuale e la presenza di sabbia ed
     * imposta la sabbia presenta in una scatola specifica.
     */
    private void CambioSabbia() {
        newQuantity = 0;
        array[id].setSandQuantity(newQuantity);
        array[id].setPerSabbia(0);
        array[id].setPiena(false);
        array[array[id].getIdTarget()].setPerSabbia(100);
        array[array[id].getIdTarget()].setSandQuantity(3375);
        array[array[id].getIdTarget()].setPiena(true);
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di aggiornare la quantitá di sabbia.
     *
     * Metodo che aggiorna la quantitá e la percentuale di sabbia di volta in
     * volta sommando o sottraendo alla sabbia giá presente.
     */
    private void AggiornaSabbia() {
        array[id].setSandQuantity(newQuantity);
        array[id].setPerSabbia((int) (array[id].getSandQuantity() * 100) / 3375);                                         //100 : 3375 = x : sandQuantity
        //System.out.println("prova:1 sandQuantity "+array[id].getSandQuantity());      //OUTPUT DI PROVA

        array[array[id].getIdTarget()].setSandQuantity(array[array[id].getIdTarget()].getSandQuantity() + array[id].getSabbiaPersa());
        array[array[id].getIdTarget()].setPerSabbia((int) (array[array[id].getIdTarget()].getSandQuantity() * 100) / 3375);
    }

}
