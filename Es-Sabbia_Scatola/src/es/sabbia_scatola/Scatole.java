/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

/**
 *
 * @author Alessandro
 */
public class Scatole { 
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo float che rappresenta la quantità di
     * sabbia presente in una sola scatola.
     */
    private float sandQuantity;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo intero che rappresenta la percentuale di
     * sabbia presente in una sola scatola.
     */
    private int perSabbia; 
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo intero che rappresenta il codice identificativo
     * della scatola.
     */
    private int id;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo boolean che indica se la pallina è 
     * presente oppure no in quella determinata scatola.
     */
    private boolean ballTF;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Oggetto di tipo DatiCondivisi che serve per richiamare i metodi
     * della classe DatiCondivisi.
     */
    private DatiCondivisi ptrDati;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Oggetto di tipo Sabbia che serve per richiamare i metodi
     * della classe Sabbia.
     */
    private Sabbia sand;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Oggetto di tipo Pallina che serve per richiamare i metodi
     * della classe Pallina.
     */
    private Pallina ball;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo float che indica indica la quantità di 
     * sabbia persa dalla scatola per l'inclinazione.
     */
    private float sabbiaPersa;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo intero che indica a quale scatola va passata
     * la pallina, la sabbia o entrambe.
     */
    private int idTarget;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributi di tipo intero che indicano le dimensioni della scatola.
     */
    private int lungB, altB, profB;
    /**
     * @author Edoardo Ballabio
     *
     * @brief Attributo di tipo boolean che indica se la scatola è piena.
     */
    private boolean piena;  

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della lunghezza della scatola.
     * 
     * @return lungB attributo che indica la lunghezza di una scatola.
     */
    public int getLungB() {
        return lungB;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore dell'altezza della scatola.
     * 
     * @return altB attributo che indica l'altezza di una scatola.
     */
    public int getAltB() {
        return altB;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della profondità della scatola.
     * 
     * @return profB attributo che indica la profondità di una scatola.
     */
    public int getProfB() {
        return profB;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile lungB.
     * 
     * @param lungB Parametro che indica la lunghezza di una scatola.
     */
    public void setLungB(int lungB) {
        this.lungB = lungB;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile altB.
     * 
     * @param altB Parametro che indica l'altezza di una scatola.
     */
    public void setAltB(int altB) {
        this.altB = altB;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile profB.
     * 
     * @param profB Parametro che indica la profondità di una scatola.
     */
    public void setProfB(int profB) {
        this.profB = profB;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo costruttore con parametri che crea la sabbia e la pallina a sinistra della scatola.
     */
    public Scatole(float sandQuantity, int perSabbia, int id, boolean ballTF, DatiCondivisi ptrDati, int lunB, int altB, int profB) {
        this.sandQuantity = sandQuantity;
        this.perSabbia = perSabbia;
        this.id = id;
        this.ballTF = ballTF;
        this.ptrDati = ptrDati;
        if (this.ballTF) {
            this.ball = new Pallina(ptrDati, (id * 150) + 75, 75);
        }

        this.sand = new Sabbia(ptrDati);
        this.sabbiaPersa = 0;
        this.idTarget = -1;
        this.lungB = lunB;
        this.altB = altB;
        this.profB = profB;

        if (this.perSabbia == 100) {
            piena = true;
        } else {
            piena = false;
        }
    }

    public Scatole(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che indica se una scatola è piena oppure no.
     * 
     * @return piena attributo che indica se una scatola è piena oppure no.
     */
    public boolean isPiena() {
        return piena;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile piena.
     * 
     * @param piena Parametro che indica se una scatola è piena oppure no.
     */
    public void setPiena(boolean piena) {
        this.piena = piena;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile sandQuantity.
     * 
     * @param sandQuantity Parametro che indica la quantità di sabbia presente in una sola scatola.
     */
    public void setSandQuantity(float sandQuantity) {
        this.sandQuantity = sandQuantity;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile perSabbia.
     * 
     * @param perSabbia Parametro che indica la percentuale di sabbia presente in una sola scatola.
     */
    public void setPerSabbia(int perSabbia) {
        this.perSabbia = perSabbia;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile id.
     * 
     * @param id Parametro che rappresenta il codice identificativo della scatola.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile ballTF.
     * 
     * @param ballTF Parametro che indica se la pallina è presente oppure no in quella determinata scatola.
     */
    public void setBallTF(boolean ballTF) {
        this.ballTF = ballTF;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore dell'oggetto di tipo DatiCondivisi.
     * 
     * @param ptrDati Parametro che rappresenta l'oggetto di tipo DatiCondivisi.
     */
    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }
    
    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore dell'oggetto di tipo Pallina.
     * 
     * @param ball Parametro che rappresenta l'oggetto di tipo Pallina.
     */
    public void setBall(Pallina ball) {
        this.ball = ball;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore dell'oggetto di tipo Sabbia.
     * 
     * @param sand Parametro che rappresenta l'oggetto di tipo Sabbia.
     */
    public void setSand(Sabbia sand) {
        this.sand = sand;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile sabbiaPersa.
     * 
     * @param sabbiaPersa Parametro che indica la quantità di sabbia persa dalla scatola per l'inclinazione.
     */
    public void setSabbiaPersa(float sabbiaPersa) {
        this.sabbiaPersa = sabbiaPersa;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo set che imposta il valore della variabile idTarget.
     * 
     * @param idTarget Parametro che indica a quale scatola va passata la pallina, la sabbia o entrambe.
     */
    public void setIdTarget(int idTarget) {
        this.idTarget = idTarget;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della quantità di sabbia in una scatola.
     * 
     * @return sandQuantity attributo che indica la quantità di sabbia presente in una sola scatola.
     */
    public float getSandQuantity() {
        return sandQuantity;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare il valore della percentuale di sabbia in una scatola.
     * 
     * @return perSabbia attributo che indica la percentuale di sabbia presente in una sola scatola.
     */
    public int getPerSabbia() {
        return perSabbia;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare l'id di una scatola.
     * 
     * @return id attributo che rappresenta il codice identificativo della scatola.
     */
    public int getId() {
        return id;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che fa ritornare un valore booleano in base alla presenza o meno della pallina in una scatola.
     * 
     * @return ballTF attributo che indica se la pallina è presente oppure no in quella determinata scatola.
     */
    public boolean isBallTF() {
        return ballTF;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare l'oggetto di tipo DatiCondivisi.
     * 
     * @return ptrDati oggetto di tipo DatiCondivisi.
     */
    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare l'oggetto di tipo Pallina.
     * 
     * @return ball oggetto di tipo Pallina.
     */
    public Pallina getBall() {
        return ball;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare l'oggetto di tipo Sabbia.
     * 
     * @return sand oggetto di tipo Sabbia.
     */
    public Sabbia getSand() {
        return sand;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare la quantità di sabbia persa di una scatola.
     * 
     * @return sabbiaPersa attributo che indica la quantità di sabbia persa dalla scatola per l'inclinazione.
     */
    public float getSabbiaPersa() {
        return sabbiaPersa;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo get che fa ritornare a quale scatola va passata la pallina, la sabbia o entrambe.
     * 
     * @return idTarget attributo che indica a quale scatola va passata la pallina, la sabbia o entrambe.
     */
    public int getIdTarget() {
        return idTarget;
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che serve a far muovere la sabbia
     * 
     * In questo metodo viene richiamato il metodo "move" dalla classe Sabbia che permette lo spostamento della sabbia.
     */
    public void move() {
        sand.move(id);
    }

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che serve a far muovere la pallina
     * 
     * In questo metodo viene richiamato il metodo "move" dalla classe Pallina che permette lo spostamento della pallina.
     * 
     * @param idBox Parametro che indica il codice identificativo della scatola in cui la pallina si muove.
     */
    public void moveBall(int idBox) {
        ball.Move(idBox);
    }

    public float getSabbiaSpostata() {
        return sand.getSabbiaSpostata();
    }

    public void setSabbiaSpostata() {
        sand.setSabbiaSpostata(0);
    }

    /**
    public float valueSand() {
        perSabbia = (int) ((sandQuantity * 100) / 3375);
        return (255 * perSabbia) / 100;
    }
    */

    /**
     * @author Edoardo Ballabio
     *
     * @brief Metodo che restituisce il numero di colonne, che hanno larghezza un pixel, da colorare per disegnare la sabbia.
     * 
     * @return Restituisce il numero di colonne di pixel da colorare di una scatola.
     */
    public int valueSandPixel() {
        float temp = ((float) lungB) / 100;
        return (int) (perSabbia * temp);
    }

}
