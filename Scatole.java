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
     *
     * Attributo che rappresenta la quantitá della sabbia totale
     *
     */
    float sandQuantity;
    /**
     *
     * Attributo che rappresenta la percentuale della sabbia totale
     *
     */
    int perSabbia;
    /**
     *
     * Attributo che identifica la singola scatola
     *
     */
    int id;
    /**
     *
     * Attributo che identifica se la pallina nella scatola é presente
     *
     */
    boolean ballTF;
    /**
     *
     * Oggetto che appartiene alla classe DatiCondivisi
     *
     */
    DatiCondivisi ptrDati;
    /**
     *
     * Oggetto che appartiene alla classe Sabbia
     *
     */
    Sabbia sand;
    /**
     *
     * Oggetto che appartiene alla classe Pallina
     *
     */
    Pallina ball;
    /**
     *
     * Attributo che rappresenta la sabbia persa
     *
     */
    float sabbiaPersa;
    /**
     *
     * Attributo che rappresenta l'id della scatola in cui si deve spostare la
     * sabbia
     *
     */
    int idTarget;
    /**
     *
     * Attributo che rappresenta la lunghezza dalla scatola
     *
     */
    private int lungB;
    /**
     *
     * Attributo che rappresenta l'altezza dalla scatola
     *
     */
    private int altB;
    /**
     *
     * Attributo che rappresenta la profonditá dalla scatola
     *
     */
    private int profB;

    /**
     *
     * Metodo get che fa ritornare la lunghezza dalla scatola
     *
     */
    public int getLungB() {
        return lungB;
    }

    /**
     *
     * Metodo get che fa ritornare l'altezza dalla scatola
     *
     */
    public int getAltB() {
        return altB;
    }

    /**
     *
     * Metodo get che fa ritornare la profonditá dalla scatola
     *
     */
    public int getProfB() {
        return profB;
    }

    /**
     *
     * Metodo set che permette di settare la lunghezza della scatola
     *
     */
    public void setLungB(int lungB) {
        this.lungB = lungB;
    }

    /**
     *
     * Metodo set che permette di settare l'altezza della scatola
     *
     */
    public void setAltB(int altB) {
        this.altB = altB;
    }

    /**
     *
     * Metodo set che permette di settare la profonditá della scatola
     *
     */
    public void setProfB(int profB) {
        this.profB = profB;
    }

    /**
     *
     * Metodo costruttore con parametri
     *
     */
    public Scatole(float sandQuantity, int perSabbia, int id, boolean ballTF, DatiCondivisi ptrDati, int lunB, int altB, int profB) {
        this.sandQuantity = sandQuantity;
        this.perSabbia = perSabbia;
        this.id = id;
        this.ballTF = ballTF;
        this.ptrDati = ptrDati;
        this.ball = new Pallina(ptrDati);
        this.sand = new Sabbia(ptrDati);
        this.sabbiaPersa = 0;
        this.idTarget = -1;
        this.lungB = lunB;
        this.altB = altB;
        this.profB = profB;
    }

    /**
     *
     * Metodo costruttore
     *
     */
    public Scatole(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    /**
     *
     * Metodo set che permette di settare la quantitá della sabbia
     *
     */
    public void setSandQuantity(float sandQuantity) {
        this.sandQuantity = sandQuantity;
    }

    /**
     *
     * Metodo set che permette di settare la percentuale di sabbia
     *
     */
    public void setPerSabbia(int perSabbia) {
        this.perSabbia = perSabbia;
    }

    /**
     *
     * Metodo set che permette di settare l'id della singola scatola
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * Metodo set che permette di settare la presenza della pallina nella
     * scatola
     *
     */
    public void setBallTF(boolean ballTF) {
        this.ballTF = ballTF;
    }

    /**
     *
     * Metodo set che permette di settare l'oggetto della classe DatiCondivisi
     *
     */
    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    /**
     *
     * Metodo set che permette di settare l'oggetto della classe Pallina
     *
     */
    public void setBall(Pallina ball) {
        this.ball = ball;
    }

    /**
     *
     * Metodo set che permette di settare l'oggetto della classe Sabbia
     *
     */
    public void setSand(Sabbia sand) {
        this.sand = sand;
    }

    /**
     *
     * Metodo set che permette di settare la sabbia persa
     *
     */
    public void setSabbiaPersa(float sabbiaPersa) {
        this.sabbiaPersa = sabbiaPersa;
    }

    /**
     *
     * Metodo set che permette di settare l'id della scatola in cui si deve
     * spostare la sabbia
     *
     */
    public void setIdTarget(int idTarget) {
        this.idTarget = idTarget;
    }

    /**
     *
     * Metodo get che fa ritornare la quantitá della sabbia totale
     *
     */
    public float getSandQuantity() {
        return sandQuantity;
    }

    /**
     *
     * Metodo get che fa ritornare la percentuale della sabbia totale
     *
     */
    public int getPerSabbia() {
        return perSabbia;
    }

    /**
     *
     * Metodo get che fa ritornare l'dentificazione dela singola scatola
     *
     */
    public int getId() {
        return id;
    }

    /**
     *
     * Metodo get che fa ritornare se la pallina nella scatola é presente
     *
     */
    public boolean isBallTF() {
        return ballTF;
    }

    /**
     *
     * Metodo get che fa ritornare l'oggetto della classe DatiCondivisi
     *
     */
    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    /**
     *
     * Metodo get che fa ritornare l'oggetto della classe Pallina
     *
     */
    public Pallina getBall() {
        return ball;
    }

    /**
     *
     * Metodo get che fa ritornare l'oggetto della classe sabbia
     *
     */
    public Sabbia getSand() {
        return sand;
    }

    /**
     *
     * Metodo get che fa ritornare la sabbia persa
     *
     */
    public float getSabbiaPersa() {
        return sabbiaPersa;
    }

    /**
     *
     * Metodo get che fa ritornare l'id della scatola in cui si deve spostare la
     * sabbia
     *
     */
    public int getIdTarget() {
        return idTarget;
    }

    /**
     *
     * Metodo che richiama il metodo move della classe Sabbia
     *
     */
    public void move() {
        sand.move();

    }

    /**
     *
     * Metodo che richiama il metodo move della classe Pallina
     *
     */
    public void moveBall() {
        ball.Move();
    }

    /**
     *
     * Metodo get che fa ritornare la quantitá di sabbia spostata
     *
     */
    public float getSabbiaSpostata() {
        return sand.getSabbiaSpostata();
    }

    /**
     *
     * Metodo set che imposta la quantitá di sabbia spostata
     *
     */
    public void setSabbiaSpostata() {
        sand.setSabbiaSpostata(0);
    }

    /**
     * public float valueSand() { perSabbia = (int) ((sandQuantity * 100) /
     * 3375); return (255 * perSabbia) / 100;
     *
     * }
     */
    /**
     *
     * Metodo get che fa ritornare la percentuale di sabbia
     *
     */
    public int valueSandPixel() {
        float temp = ((float) lungB) / 100;
        return (int) (perSabbia * temp);
    }

}
