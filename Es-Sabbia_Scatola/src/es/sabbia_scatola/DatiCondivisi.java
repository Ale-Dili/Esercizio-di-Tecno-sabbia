package es.sabbia_scatola;

import java.util.concurrent.Semaphore;



/**
 * @author Christian Sipione
 *
 * @brief Daticondivisi.java: classe Daticondivisi che permette la condivisione
 * di dati fra classi.
 */
public class DatiCondivisi {
    private Semaphore eseguiPallina;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo Int che rappresenta la lunghezza dello schermo.
     */
    private int lungS;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo Int che rappresenta l'altezza dello schermo.
     */
    private int altS;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo Int che rappresenta il numero di righe di scatole
     */
    private int numRighe;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo Int che rappresenta il numero di colonne di scatole
     */
    private int numColonne;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo boolean che indica se far avvenire lo spostamento.
     */
    private boolean sposta;
    /**
     * @author Christian Sipione
     *
     * @brief Attributo Int che rappresenta la percentuale della sabbia.
     */
    private int perSabbia;
    /**
     * @author Christian Sipione
     *
     * @brief Oggetto di tipo Sensore che serve per richiamare i metodi della
     * classe Sensore.
     */
    private Sensore s = new Sensore();
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
     * @brief Metodo costruttore con parametri
     *
     * Metodo che inizializza gli attributi numColonne, numRighe, array e vengono
     * passati i parametri per iniziAlizzare gli attributi lungS,altS,perSabbia
     *
     * @param lungS parametro che serve per inizlizzare la lunghezza dello
     * schermo.
     * @param altS parametro che serve per inizlizzare l'altezza dello schermo.
     * @param perSabbia parametro che serve per inizlizzare la percentuale della
     * sabbia.
     */
    public DatiCondivisi(int lungS, int altS, int perSabbia) {
        this.lungS = lungS;
        this.altS = altS;
        this.numColonne = 3;
        this.numRighe = 2;
        this.perSabbia = perSabbia;
        array = new Scatole[6];
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo costruttore senza parametri
     *
     * Metodo che inizializza gli attributi numColonne, numRighe, array e
     * perSabbia.
     */
    public DatiCondivisi() {
        this.perSabbia = 100;
        this.numColonne = 8;
        this.numRighe = 2;
        array = new Scatole[numColonne * numRighe];
        eseguiPallina=new Semaphore(0);
    }
    
    public  void waitPallina() throws InterruptedException {
        eseguiPallina.acquire();
    }
    
    public void signalPallina() {
        eseguiPallina.release();
    }
     
    
    
    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna se deve avvenire lo spostamento.
     *
     * @return sposta attributo che indica se far avvenire lo spostamento.
     */
    public synchronized boolean isSposta() {
        return sposta;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta il valore dell'attributo sposta.
     */
    public synchronized void setSposta(boolean sposta) {
        this.sposta = sposta;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta il valore dell'oggetto s.
     */
    public synchronized void setS(Sensore s) {
        this.s = s;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna l'oggetto della classe Sensore.
     *
     * @return s oggetto della classe Sensore.
     */
    public synchronized Sensore getS() {
        return s;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna il numero di righe di scatole presenti.
     *
     * @return numRighe rappresenta il numero di righe di scatole.
     */
    public synchronized int getNumRighe() {
        return numRighe;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta il valore dell'attributo numRighe.
     */
    public synchronized void setNumRighe(int numRighe) {
        this.numRighe = numRighe;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna il numero di colonne di scatole presenti.
     *
     * @return numRighe rappresenta il numero di righe di scatole.
     */
    public synchronized int getNumColonne() {
        return numColonne;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta il valore della Attributo numColonne.
     */
    public synchronized void setNumColonne(int numColonne) {
        this.numColonne = numColonne;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna l'inclinazione sull'asse x.
     *
     * @return s.getInclinazioneX() rappresenta l'inclinazione sull'asse x.
     */
    public synchronized float getInclinazioneX() {
        return s.getInclinazioneX();
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna l'inclinazione sull'asse y.
     *
     * @return s.getInclinazioneX() rappresenta l'inclinazione sull'asse y.
     */
    public synchronized float getInclinazioneY() {
        return s.getInclinazioneY();
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta l'inclinazione sull'asse x.
     */
    public synchronized void setInclinazioneX(float inclinazione) {
        s.setInclinazioneX(inclinazione);
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta l'inclinazione sull'asse y.
     */
    public synchronized void setInclinazioneY(float inclinazione) {
        s.setInclinazioneY(inclinazione);
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna la lunghezza dello schermo.
     *
     * @return lungS rappresenta la lunghezza dello schermo.
     */
    public synchronized int getLungS() {
        return lungS;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna l'altezza dello schermo.
     *
     * @return lungS rappresenta l'altezza dello schermo.
     */
    public synchronized int getAltS() {
        return altS;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta la lunghezza dello schermo.
     */
    public synchronized void setLungS(int lungS) {
        this.lungS = lungS;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta l'altezza dello schermo.
     */
    public synchronized void setAltS(int altS) {
        this.altS = altS;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta la percentuale della sabbia.
     */
    public synchronized void setPerSabbia(int perSabbia) {
        this.perSabbia = perSabbia;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna la percentuale della sabbia.
     *
     * @return perSabbia rappresenta la percentuale della sabbia.
     */
    public synchronized int getPerSabbia() {
        return perSabbia;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna l'insieme di scatole.
     *
     * @return array serve per richiamare i metodi della classe Scatole.
     */
    public synchronized Scatole[] getArray() {
        return array;
    }
   /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta l'insieme di scatole.
     */
    public synchronized void setArray(Scatole[] array) {
        this.array = array;
    }

}
