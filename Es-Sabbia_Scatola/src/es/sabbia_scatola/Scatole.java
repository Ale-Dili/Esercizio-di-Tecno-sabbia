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
    
    Sabbia sand;
    Pallina ball;
    float sabbiaPersa;
    int idTarget;
    private int lungB, altB, profB; //dimensioni scatola
    
    private boolean piena;   //PROVA
    
    public int getLungB() {
        return lungB;
    }

    public int getAltB() {
        return altB;
    }

    public int getProfB() {
        return profB;
    }

    public void setLungB(int lungB) {
        this.lungB = lungB;
    }

    public void setAltB(int altB) {
        this.altB = altB;
    }

    public void setProfB(int profB) {
        this.profB = profB;
    }

    public Scatole(float sandQuantity, int perSabbia, int id, boolean ballTF, DatiCondivisi ptrDati, int lunB, int altB, int profB) {
        this.sandQuantity = sandQuantity;
        this.perSabbia = perSabbia;
        this.id = id;
        this.ballTF = ballTF;
        this.ptrDati = ptrDati;
        if(this.ballTF) {
            this.ball = new Pallina(ptrDati,(id*150)+75,75);
        }
        
        this.sand = new Sabbia(ptrDati);
        this.sabbiaPersa = 0;
        this.idTarget = -1;
        this.lungB = lunB;
        this.altB = altB;
        this.profB = profB;
        
        if(this.perSabbia==100) {
            piena=true;
        }
        else {
            piena=false;
        }
    }

    public Scatole(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public boolean isPiena() {
        return piena;
    }

    public void setPiena(boolean piena) {
        this.piena = piena;
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

    public void move() {
        sand.move(id);
        
    }
    public void moveBall(int idBox) {
        ball.Move(idBox);
    }

    public float getSabbiaSpostata() {
        return sand.getSabbiaSpostata();
    }

    public void setSabbiaSpostata() {
        sand.setSabbiaSpostata(0);
    }

    public float valueSand() {
        perSabbia = (int) ((sandQuantity * 100) / 3375);
        return (255 * perSabbia) / 100;

    }

    public int valueSandPixel() {
        float temp = ((float) lungB) / 100;
        return (int) (perSabbia * temp);
    }

}
