package es.sabbia_scatola;

/**
 * @author Christian Sipione
 *
 * @brief Sabbia.java: classe Sabbia che si occupa dello spostamento della
 * sabbia
 */
public class Sabbia {

    /**
     * @author Christian Sipione
     *
     * @brief Attributo di tipo float che rappresenta la quantitá di sabbia
     * spostata
     */
    private float sabbiaSpostata;
    /**
     * @author Christian Sipione
     *
     * @brief Oggetto di tipo DatiCondivisi che serve per richiamare i metodi
     * della classe DatiCondivisi.
     */
    DatiCondivisi ptrDati;
    /**
     * @author Christian Sipione
     *
     * @brief Insieme di oggetti di tipo Scatole che serve per richiamare i
     * metodi della classe Scatole.
     */
    Scatole array[];

    /**
     * @author Christian Sipione
     *
     * @brief Metodo costruttore
     *
     * Metodo che inizializza gli attributi ptrDati, array ed imposta a zero la
     * Attributo SabbiaSpostata
     *
     * @param ptrDati parametro che serve per richiamare i metodi della classe
     * DatiCondivisi.
     */
    Sabbia(DatiCondivisi ptrDati) {
        this.sabbiaSpostata = 0;
        this.ptrDati = ptrDati;
        array = ptrDati.getArray();
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di muovere la sabbia.
     *
     * Metodo che calcola la quantitá di sabbia spostata ricevendo dal metodo
     * getInclinazioneY() l'inclinazione tramite dati condivisi, in seguito
     * controlla se l'inclinazione é sufficente per lo spostamento della sabbia,
     * se sufficiente procede con il calcolo della sabbia da spostare.
     */
    public void move(int id) {

        if (ptrDati.getInclinazioneY() > 10) {
            sabbiaSpostata = (float) (0.2 * ptrDati.getInclinazioneY());
        }
        if (ptrDati.getInclinazioneY() < -10) {
            sabbiaSpostata = (float) (0.2 * ptrDati.getInclinazioneY()) * -1;
        }

    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta il valore dell' attributo sabbiaSpostata.
     */
    public void setSabbiaSpostata(float SabbiaSpostata) {
        this.sabbiaSpostata = SabbiaSpostata;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta l'oggetto ptrDati.
     */
    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna la quantitá di sabbia spostata.
     *
     * @return SabbiaSpostata attributo che rappresenta la sabbia spostata.
     */
    public float getSabbiaSpostata() {
        return sabbiaSpostata;
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che ritorna l'oggetto ptrDati.
     *
     * @return ptrDati oggetto che permette la condivisione dei dati fra classi.
     */
    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

}
