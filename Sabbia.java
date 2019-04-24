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

    //posizione di partenza sulle x
    private float posX;
    //posizione di partenza sulle y
    private float posY;
    //di quanto si muove la sabbia
    private double velX;
    private int xdirection;
    //di quanto si riduce la sabbia
    private int riduzionePercentuale;
    DatiCondivisi c = new DatiCondivisi();
    Sensore sensore = new Sensore();

    //valori indicativi   
    Sabbia() {
        velX = 4.8;
        // yspeed = 2.2;   
        posX = 0;
        posY = 0;
        c.setPerSabbia(100);
        riduzionePercentuale = 0;
    }
//metodo per muovere la sabbia

    public void move() {
        posX = posX + (float) (velX * xdirection);
        //ora non serve
        //ypos = ypos + (float) (yspeed * ydirection);

        //se la sabbia esce dal contenitore
        if (posX > c.getLungB() - c.getLungS() || posX < c.getLungS()) {
            //cambia la percentuale presente nella scatola
            aggiornaPercentuale();
        }
        //ora non serve
        //  if (ypos > AltezzaBordo - larghezzaSabbia || AltezzaBordo < larghezzaSabbia) {
        //    fuoriScatola=true;
        // }
    }

    public void incVel() {
        velX += 0.2 * sensore.getInclinazioneX();
        //yspeed += 0.2;
    }

    public void decVel() {
        velX -= 0.2 * sensore.getInclinazioneX();
        if (velX < 0) {
            velX = 0;
        }
        //  yspeed -= 0.2;
        //  if (yspeed < 0) {
        //       yspeed = 0;
        //   }
    }

    //imposta la larghezza del contenitore
    void setBordo() {
        posX = c.getLungB() / 2;
        posY = c.getAltB() / 2;
    }

    public void aggiornaPercentuale() {
        riduzionePercentuale += 1 * sensore.getInclinazioneX();
        c.setPerSabbia(c.getPerSabbia() - riduzionePercentuale);
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setXdirection(int xdirection) {
        this.xdirection = xdirection;
    }

    public void setRiduzionePercentuale(int riduzionePercentuale) {
        this.riduzionePercentuale = riduzionePercentuale;
    }

    public void setC(DatiCondivisi c) {
        this.c = c;
    }

    public void setSensore(Sensore sensore) {
        this.sensore = sensore;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public double getVelX() {
        return velX;
    }

    public int getXdirection() {
        return xdirection;
    }

    public int getRiduzionePercentuale() {
        return riduzionePercentuale;
    }

    public DatiCondivisi getC() {
        return c;
    }

    public Sensore getSensore() {
        return sensore;
    }

}
