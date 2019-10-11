package View;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class MainView {
    private final int BPM_MIN=40,BPM_MAX=160,BPM_INIT=100;
    
    private JFrame mainFrame;
    private JPanel control;
    private JButton tocar, parar, pausar;
    private JCheckBox drum,bass,guitar1,guitar2;
    private JSlider bpm;
    
    private JTabbedPane conteiner;
    
    
    public MainView (){
        mainFrame = new JFrame("Musiquality");
        mainFrame.setLayout(new BorderLayout());
        
        conteiner = new JTabbedPane();
        //mainDrum = new JPanel();
        //mainBass = new JPanel();
        //mainGuitar1 = new JPanel();
        //mainGuitar2 = new JPanel();
        
        //mainDrum.setLayout(new GridLayout(2,1));
        //mainBass.setLayout(new GridLayout(2,1));
        //mainGuitar1.setLayout(new GridLayout(2,1));
        //mainGuitar2.setLayout(new GridLayout(2,1));
       
        DrumTab drums=new DrumTab();
        BassTab basses=new BassTab();
        Guitar1Tab g1=new Guitar1Tab();
        Guitar2Tab g2=new Guitar2Tab();
        
        conteiner.add("Bateria",drums.get());
        conteiner.add("Baixo",basses.get());
        conteiner.add("Guitarra 1",g1.get());
        conteiner.add("Guitarra 2",g2.get());
        
        //this.initialize_drum();
//        this.initialize_bass();
  //      this.initialize_guitar1();
    //    this.initialize_guitar2();
        mainFrame.add(conteiner,BorderLayout.CENTER);
        initialize_control();
        mainFrame.setSize(1200, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
    private void initialize_control(){
        control = new JPanel();
        
        tocar = new JButton("Play");
        pausar = new JButton ("Pause");
        parar = new JButton("Stop");
        
        bpm = new JSlider(JSlider.HORIZONTAL,BPM_MIN,BPM_MAX,BPM_INIT);
        bpm.setMajorTickSpacing((BPM_MAX-BPM_MIN)/5);
        bpm.setMinorTickSpacing((BPM_MAX-BPM_MIN)/10);
        bpm.setPaintTicks(true);
        bpm.setPaintLabels(true);
        
        drum = new JCheckBox("Bateria");
        bass = new JCheckBox("Baixo");
        guitar1 = new JCheckBox("Guitarra 1");
        guitar2 = new JCheckBox("Guitarra 2");
        
        
        control.add(tocar);
        control.add(pausar);
        control.add(parar);
        control.add(bpm);
        
        control.add(drum);
        control.add(bass);
        control.add(guitar1);
        control.add(guitar2);
        mainFrame.add(control,BorderLayout.NORTH);
        
    }
    
    
}
