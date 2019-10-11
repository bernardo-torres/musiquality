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
    
    private JPanel mainDrum,mainBass,mainGuitar1,mainGuitar2;
    private JPanel aux1Drum,aux1Bass,aux1Guitar1,aux1Guitar2;
    private JPanel sDrum,sBass,sGuitar1,sGuitar2;
    private JPanel southDrum,southBass,southGuitar1,southGuitar2;
    private JPanel rListDrum,rListBass,rListGuitar1,rListGuitar2;
    private JCheckBox drumRhythms[][],bassRhythms[][],guitar1Rhythms[][],guitar2Rhythms[][];
    private JButton drumRList[],bassRList[],guitar1RList[],guitar2RList[];
    
    private JCheckBox drumTempo[][];
    private JLabel drumNotes[];
    
    public MainView (){
        mainFrame = new JFrame("Musiquality");
        mainFrame.setLayout(new BorderLayout());
        
        conteiner = new JTabbedPane();
        //mainDrum = new JPanel();
        mainBass = new JPanel();
        mainGuitar1 = new JPanel();
        mainGuitar2 = new JPanel();
        
        //mainDrum.setLayout(new GridLayout(2,1));
        mainBass.setLayout(new GridLayout(2,1));
        mainGuitar1.setLayout(new GridLayout(2,1));
        mainGuitar2.setLayout(new GridLayout(2,1));
       
        DrumTab drum=new DrumTab();
        
        conteiner.add("Bateria",drum.get());
        conteiner.add("Baixo",mainBass);
        conteiner.add("Guitarra 1",mainGuitar1);
        conteiner.add("Guitarra 2",mainGuitar2);
        
        //this.initialize_drum();
        this.initialize_bass();
        this.initialize_guitar1();
        this.initialize_guitar2();
        mainFrame.add(conteiner,BorderLayout.CENTER);
        initialize_control();
        mainFrame.setSize(1200, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
  /*  
    private void initialize_drum(){
        aux1Drum = new JPanel();
        rListDrum = new JPanel();
        aux1Drum.setLayout(new BorderLayout());
        rListDrum.setLayout(new GridLayout(10,1));
        
        drumRhythms = new JCheckBox[10][50];
        
        sDrum = new JPanel();
        sDrum.setLayout(new GridLayout(drumRhythms.length,drumRhythms[0].length));
        
        drumRList = new JButton[10];
        for(int i=0;i<drumRhythms.length;i++){
            for(int j=0;j<drumRhythms[i].length;j++){
                drumRhythms[i][j] = new JCheckBox();
                sDrum.add(drumRhythms[i][j]);
            }
            drumRList[i] = new JButton("Ritmo " + (i+1));
            rListDrum.add(drumRList[i]);
        }
        aux1Drum.add(rListDrum,BorderLayout.WEST);
        aux1Drum.add(sDrum,BorderLayout.CENTER);
        
       southDrum=new JPanel();
       southDrum.setLayout(new GridLayout(9,17));
       
       drumTempo=new JCheckBox[9][16];
       drumNotes=new JLabel[9];
       
       for(int i = 0;i<9;i++){
           drumNotes[i]=new JLabel("Nota "+ i);
           southDrum.add(drumNotes[i]);
           for(int j=0;j<16;j++){
               drumTempo[i][j]=new JCheckBox();
               southDrum.add(drumTempo[i][j]);
               drumTempo[i][j].setEnabled(false);
           }
       }
       
       
       mainDrum.add(aux1Drum);
       mainDrum.add(southDrum);
    }
*/    
    private void initialize_bass(){
        aux1Bass = new JPanel();
        rListBass = new JPanel();
        aux1Bass.setLayout(new BorderLayout());
        rListBass.setLayout(new GridLayout(10,1));
        
        bassRhythms = new JCheckBox[10][50];
        
        sBass = new JPanel();
        sBass.setLayout(new GridLayout(bassRhythms.length,bassRhythms[0].length));
        
        bassRList = new JButton[10];
        for(int i=0;i<bassRhythms.length;i++){
            for(int j=0;j<bassRhythms[i].length;j++){
                bassRhythms[i][j] = new JCheckBox();
                sBass.add(bassRhythms[i][j]);
            }
            bassRList[i] = new JButton("Ritmo " + (i+1));
            rListBass.add(bassRList[i]);
        }
        aux1Bass.add(rListBass,BorderLayout.WEST);
        aux1Bass.add(sBass,BorderLayout.CENTER);
        
       mainBass.add(aux1Bass);
    }
    
    private void initialize_guitar1(){
        aux1Guitar1 = new JPanel();
        rListGuitar1 = new JPanel();
        aux1Guitar1.setLayout(new BorderLayout());
        rListGuitar1.setLayout(new GridLayout(10,1));
        
        guitar1Rhythms = new JCheckBox[10][50];
        
        sGuitar1 = new JPanel();
        sGuitar1.setLayout(new GridLayout(guitar1Rhythms.length,guitar1Rhythms[0].length));
        
        guitar1RList = new JButton[10];
        for(int i=0;i<guitar1Rhythms.length;i++){
            for(int j=0;j<guitar1Rhythms[i].length;j++){
                guitar1Rhythms[i][j] = new JCheckBox();
                sGuitar1.add(guitar1Rhythms[i][j]);
            }
            guitar1RList[i] = new JButton("Ritmo " + (i+1));
            rListGuitar1.add(guitar1RList[i]);
        }
        aux1Guitar1.add(rListGuitar1,BorderLayout.WEST);
        aux1Guitar1.add(sGuitar1,BorderLayout.CENTER);
        
       mainGuitar1.add(aux1Guitar1);
    }
    
    private void initialize_guitar2(){
        aux1Guitar2 = new JPanel();
        rListGuitar2 = new JPanel();
        aux1Guitar2.setLayout(new BorderLayout());
        rListGuitar2.setLayout(new GridLayout(10,1));
        
        guitar2Rhythms = new JCheckBox[10][50];
        
        sGuitar2=new JPanel();
        sGuitar2.setLayout(new GridLayout(guitar2Rhythms.length,guitar2Rhythms[0].length));
        
        guitar2RList = new JButton[10];
        for(int i=0;i<guitar2Rhythms.length;i++){
            for(int j=0;j<guitar2Rhythms[i].length;j++){
                guitar2Rhythms[i][j] = new JCheckBox();
                sGuitar2.add(guitar2Rhythms[i][j]);
            }
            guitar2RList[i] = new JButton("Ritmo " + (i+1));
            rListGuitar2.add(guitar2RList[i]);
        }
        aux1Guitar2.add(rListGuitar2,BorderLayout.WEST);
        aux1Guitar2.add(sGuitar2,BorderLayout.CENTER);
        
       mainGuitar2.add(aux1Guitar2);
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
