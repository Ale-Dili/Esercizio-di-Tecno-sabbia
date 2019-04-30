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
    
    public Sensore(DatiCondivisi datiC) {
        
        frame = new JFrame("Controls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // a panel where add buttons with flow layout
        JPanel controls = new JPanel();
        JSlider slider = new JSlider();
        JLabel valore = new JLabel();
        // define the button to choose color background
        JButton AddValue = new JButton("Aumenta");
        AddValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slider.setValue((int) (datiC.getInclinazioneY() + 1));
            }
        });

        // define the button to show the animated figure
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

        // add the buttons to the panel      
        controls.add(AddValue);
        controls.add(DecValue);
        controls.add(slider);
        controls.add(valore);
        controls.add(resetB);
        
        // add the panel to the frame
        frame.add(controls);
        frame.setSize(400, 150);
    }
    
    public void setInclinazioneX(float inclinazioneX) {
        this.inclinazioneX = inclinazioneX;
    }
    
    public void setInclinazioneY(float inclinazioneY) {
        this.inclinazioneY = inclinazioneY;
    }
    
    public float getInclinazioneX() {
        return inclinazioneX;
    }
    
    public float getInclinazioneY() {
        return inclinazioneY;
    }
    
    public void show() {
        frame.setVisible(true);
    }
}
