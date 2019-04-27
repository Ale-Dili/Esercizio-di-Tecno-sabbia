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
    float sandQuantity;
    int perSabbia; //percentuale sabbia
    int id;
    boolean ballTF;
    DatiCondivisi ptrDati;
    Pallina ball;
    Sabbia sand;
    float sabbiaPersa;
    int idTarget;

    public Scatole(float sandQuantity, int perSabbia, int id, boolean ballTF, DatiCondivisi ptrDati, Pallina ball, Sabbia sand, float sabbiaPersa, int idTarget) {
        this.sandQuantity = sandQuantity;
        this.perSabbia = perSabbia;
        this.id = id;
        this.ballTF = ballTF;
        this.ptrDati = ptrDati;
        this.ball = ball;
        this.sand = sand;
        this.sabbiaPersa = sabbiaPersa;
        this.idTarget = idTarget;
    }

    public void setSandQuantity(float sandQuantity) {
        this.sandQuantity = sandQuantity;
    }

    public void setPerSabbia(int perSabbia) {
        this.perSabbia = perSabbia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBallTF(boolean ballTF) {
        this.ballTF = ballTF;
    }

    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void setBall(Pallina ball) {
        this.ball = ball;
    }

    public void setSand(Sabbia sand) {
        this.sand = sand;
    }

    public void setSabbiaPersa(float sabbiaPersa) {
        this.sabbiaPersa = sabbiaPersa;
    }

    public void setIdTarget(int idTarget) {
        this.idTarget = idTarget;
    }

    public float getSandQuantity() {
        return sandQuantity;
    }

    public int getPerSabbia() {
        return perSabbia;
    }

    public int getId() {
        return id;
    }

    public boolean isBallTF() {
        return ballTF;
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    public Pallina getBall() {
        return ball;
    }

    public Sabbia getSand() {
        return sand;
    }

    public float getSabbiaPersa() {
        return sabbiaPersa;
    }

    public int getIdTarget() {
        return idTarget;
    }
    
    public void move(){
        sand.move();
    }

    public float getSabbiaSpostata(){
        return sand.getSabbiaSpostata();
    }
    
    
}

