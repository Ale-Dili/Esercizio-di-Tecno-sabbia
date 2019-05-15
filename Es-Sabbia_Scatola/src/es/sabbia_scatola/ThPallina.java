/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tosetti_luca
 */
public class ThPallina extends Thread{

    private DatiCondivisi ptrDati;
    private Scatole ptrScatola;
    private Scatole[] array;
    
    public ThPallina(DatiCondivisi ptrDati) {
        this.ptrDati=ptrDati;
        array=ptrDati.getArray();
        ptrScatola=array[0];
    }
    
    public void run() {
        try {
        while(true) {
            
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
    
    private void GestionePallinaVersoDestra() {
        if (array[ptrScatola.getId()].isBallTF()) {
            array[ptrScatola.getId()].getBall().IncrementaVelocitàX();      //incremento velocità pallina se presente nella scatola
        }                                                                                                                                                                           
        if ((array[ptrScatola.getId()].getIdTarget() % ptrDati.getNumColonne()) != 0) {                                                                                                                                                                         
            if ((array[ptrScatola.getId()].isBallTF()) && (ptrDati.isSposta()) && (array[ptrScatola.getId()].getBall().getPosX() == (150 + (150 * ptrScatola.getId())) - (array[ptrScatola.getId()].getBall().getRaggio() / 2)) && (ptrScatola.isPiena())) {     //se pallina è presente, se ha raggiunto una velocità sufficente e se tocca il bordo
                array[array[ptrScatola.getId()].getIdTarget()].setBall(new Pallina(array[ptrScatola.getId()].getPtrDati(), (array[ptrScatola.getId()].getIdTarget() * 150) + (array[ptrScatola.getId()].getBall().getRaggio() / 2), 75));      //Creo nuova pallina in scatola successiva

                CambioPallina();        //Resetto ball e ballTF della scatola in esecuzione, resetto l'attributo sposta e indico che la scatola successiva ha la pallina
            }
        }
    }
    
    private void CambioPallina() {
        array[array[ptrScatola.getId()].getIdTarget()].setBallTF(true);
        array[ptrScatola.getId()].setBall(null);
        array[ptrScatola.getId()].setBallTF(false);
        ptrDati.setSposta(false);
        ptrScatola=array[ptrScatola.getIdTarget()];
    }
    
    private void GestionePallinaVersoSinistra() {
        if (array[ptrScatola.getId()].isBallTF()) {
            array[ptrScatola.getId()].getBall().DecrementaVelocitàX();      //decremento velocità pallina se presente nella scatola
        }

        if ((ptrScatola.getId() % ptrDati.getNumColonne()) != 0) {
            if ((array[ptrScatola.getId()].isBallTF()) && (ptrDati.isSposta()) && (array[ptrScatola.getId()].getBall().getPosX() == (150 * ptrScatola.getId()) + (array[ptrScatola.getId()].getBall().getRaggio() / 2)) && (ptrScatola.isPiena())) {             //se pallina è presente, se ha raggiunto una velocità sufficente e se tocca il bordo
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
