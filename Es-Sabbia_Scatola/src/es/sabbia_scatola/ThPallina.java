package es.sabbia_scatola;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Luca Tosetti
 *
 * @brief ThPallina.java: classe ThPallina che si occupa della gestione della
 * pallina.
 */
public class ThPallina extends Thread {

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
     * @brief Oggetto di tipo Scatole che serve per identificare la scatola di
     * riferimento.
     */
    private Scatole ptrScatola;
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
     * Metodo che inizializza gli attributi ptrDati, array ed imposta la scatola
     * di riferimento.
     *
     * @param ptrDati parametro che serve per richiamare i metodi della classe
     * DatiCondivisi.
     */
    public ThPallina(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        array = ptrDati.getArray();
        ptrScatola = array[0];
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di gestire lo spostamento della spallina
     *
     * Metodo che gestisce la pallina attraverso i metodi
     * GestionePallinaVersoDestra(),GestionePallinaVersoSinistra() inoltre
     * utilizza l'oggetto array tramite puntatore id per indicare la scatola di
     * riferimento su cui lavorare.
     */
    public void run() {
        try {
            while (true) {

                ptrDati.waitPallina();
                if (array[ptrScatola.getId()].isBallTF()) {                  //Se nella scatola è presente la pallina (ballTF=true)
                    array[ptrScatola.getId()].moveBall(ptrScatola.getId());             //La pallina viene mossa
                }

                try {
                    Thread.sleep(10);                        //provare 5 millisecondi
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThPallina.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (ptrDati.getInclinazioneY() > 10) {

                    GestionePallinaVersoDestra();

                }

                if (ptrDati.getInclinazioneY() < -10) {

                    GestionePallinaVersoSinistra();

                }

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThPallina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di gestire lo spostamento della pallina.
     *
     * Metodo che prima verifica la presenza della pallina nella scatola, se
     * presente incrementa la velocitá della pallina, in seguito se la pallina
     * tocca il bordo ad una velocitá sufficiente e se la scatola di riferimento
     * é piena avviene lo spostamento nell'altra scatola.
     */
    private void GestionePallinaVersoDestra() {
        if (array[ptrScatola.getId()].isBallTF()) {
            array[ptrScatola.getId()].getBall().IncrementaVelocitàX();      //incremento velocità pallina se presente nella scatola
        }
        if ((array[ptrScatola.getId()].getIdTarget() % ptrDati.getNumColonne()) != 0) {
            if ((array[ptrScatola.getId()].isBallTF()) && (ptrDati.isSposta()) && (array[ptrScatola.getId()].getBall().getPosX() == (150 + (150 * ptrScatola.getId())) - (array[ptrScatola.getId()].getBall().getRaggio() / 2)) && ((ptrScatola.getSandQuantity()>3000) || (ptrScatola.isPiena()))) {     //se pallina è presente, se ha raggiunto una velocità sufficente e se tocca il bordo
                array[array[ptrScatola.getId()].getIdTarget()].setBall(new Pallina(array[ptrScatola.getId()].getPtrDati(), (array[ptrScatola.getId()].getIdTarget() * 150) + (array[ptrScatola.getId()].getBall().getRaggio() / 2), 75));      //Creo nuova pallina in scatola successiva

                CambioPallina();        //Resetto ball e ballTF della scatola in esecuzione, resetto l'attributo sposta e indico che la scatola successiva ha la pallina
            }
        }
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che imposta di volta in volta la presenza della pallina
     * nella scatola.
     *
     * Metodo che notifica dopo lo spostamento della pallina nella scatola
     * adiacente la presenza della stessa nella nuova scatola.
     *
     */
    private void CambioPallina() {
        array[array[ptrScatola.getId()].getIdTarget()].setBallTF(true);
        array[ptrScatola.getId()].setBall(null);
        array[ptrScatola.getId()].setBallTF(false);
        ptrDati.setSposta(false);
        ptrScatola = array[ptrScatola.getIdTarget()];
    }

    /**
     * @author Christian Sipione
     *
     * @brief Metodo che si occupa di gestire lo spostamento della pallina.
     *
     * Metodo che prima verifica la presenza della pallina nella scatola, se
     * presente decrementa la velocitá della pallina, in seguito se la pallina
     * tocca il bordo ad una velocitá sufficiente e se la scatola di riferimento
     * é piena avviene lo spostamento nell'altra scatola.
     */
    private void GestionePallinaVersoSinistra() {
        if (array[ptrScatola.getId()].isBallTF()) {
            array[ptrScatola.getId()].getBall().DecrementaVelocitàX();      //decremento velocità pallina se presente nella scatola
        }
 
        if ((ptrScatola.getId() % ptrDati.getNumColonne()) != 0) {
            if ((array[ptrScatola.getId()].isBallTF()) && (ptrDati.isSposta()) && (array[ptrScatola.getId()].getBall().getPosX() == (150 * ptrScatola.getId()) + (array[ptrScatola.getId()].getBall().getRaggio() / 2)) && ((ptrScatola.getSandQuantity()>3000) || (ptrScatola.isPiena()))) {             //se pallina è presente, se ha raggiunto una velocità sufficente e se tocca il bordo
                if (array[ptrScatola.getId()].getIdTarget() == 0) {
                    array[array[ptrScatola.getId()].getIdTarget()].setBall(new Pallina(array[ptrScatola.getId()].getPtrDati(), (150 + (array[ptrScatola.getId()].getIdTarget() * 150)) - (array[ptrScatola.getId()].getBall().getRaggio() / 2), 75));       //Creo nuova pallina in scatola precedente(se è la scatola con id=0)
                } else {
                    array[array[ptrScatola.getId()].getIdTarget()].setBall(new Pallina(array[ptrScatola.getId()].getPtrDati(), (ptrScatola.getId() * 150) - (array[ptrScatola.getId()].getBall().getRaggio() / 2), 75));       //Creo nuova pallina in scatola precedente
                }
                CambioPallina();      //Resetto ball e ballTF della scatola in esecuzione, resetto l'attributo sposta e indico che la scatola successiva ha la pallina
            }
        }
    }

}
