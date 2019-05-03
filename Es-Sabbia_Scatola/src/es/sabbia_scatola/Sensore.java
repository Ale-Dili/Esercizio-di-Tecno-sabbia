package es.sabbia_scatola;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Christian
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Sensore {

    private JFrame frame;
    float inclinazioneX;
    float inclinazioneY;

    public Sensore() {
        this.inclinazioneX = 0;
        this.inclinazioneY = 0;
    }

    /**
     *
     * Metodo costruttore con parametri che si occupa di creare i componenti del frame, definendone tutte le caratteristiche fisiche e gli eventi da loro eseguiti.
     *
     */
    public Sensore(DatiCondivisi datiC) {

        frame = new JFrame("Controls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight())/1.5 );
        frame.setLocation(x, y);
        // creazione di panel all'interno del quale vengono aggiunti i pulsanti.
        JPanel controls = new JPanel();
        JSlider slider = new JSlider();
        JLabel valore = new JLabel();
        valore.setText("0");
        
        /**
         *
         * Creazione del bottone "Aumenta" che quando viene premuto incrementa di 1 il valore dell'inclinazione sull'asse delle y e setta con il nuovo valore lo slider.
         *
         */
        JButton AddValue = new JButton("Aumenta");
        AddValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slider.setValue((int) (datiC.getInclinazioneY() + 1));
            }
        });

        /**
         *
         * Creazione del bottone "Decrementa" che quando viene premuto decrementa di 1 il valore dell'inclinazione sull'asse delle y e setta con il nuovo valore lo slider.
         *
         */
        JButton DecValue = new JButton("Decrementa");
        DecValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slider.setValue((int) (datiC.getInclinazioneY() - 1));
            }
        });

        slider.setMaximum(90);
        slider.setMinimum(-90);
        slider.setValue(0);
        // Add change listener to the slider
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                float value = (float) slider.getValue();
                valore.setText(Integer.toString((int) value));
                datiC.setInclinazioneY(value);
            }
        });
        JButton resetB = new JButton("Reset");
        resetB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slider.setValue(0);
            }
        });

        // aggiungono i bottoni al panel    
        controls.add(AddValue);
        controls.add(DecValue);
        controls.add(resetB);
        controls.add(slider);
        controls.add(valore);

        // aggiunge panel al frame
        frame.add(controls);
        frame.setSize(400, 120);
    }

    /**
     *
     * Metodo set che permette di settare l'inclinazione sull'asse delle x
     *
     */
    public void setInclinazioneX(float inclinazioneX) {
        this.inclinazioneX = inclinazioneX;
    }

    /**
     *
     * Metodo set che permette di settare l'inclinazione sull'asse delle y
     *
     */
    public void setInclinazioneY(float inclinazioneY) {
        this.inclinazioneY = inclinazioneY;
    }

    /**
     *
     * Metodo get che fa ritornare l'inclinazione sull'asse delle x
     *
     */
    public float getInclinazioneX() {
        return inclinazioneX;
    }

    /**
     *
     * Metodo get che fa ritornare l'inclinazione sull'asse delle y
     *
     */
    public float getInclinazioneY() {
        return inclinazioneY;
    }

    /**
     *
     * Metodo che rende visibile il frame
     *
     */
    public void show() {
        frame.setVisible(true);
    }
}