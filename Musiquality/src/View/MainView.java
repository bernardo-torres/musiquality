package View;


import Controller.MainController;
import Main.Util;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    private final int BPM_MIN=40,BPM_MAX=140,BPM_INIT=90;
    private Color bg,fg;
    
    private JFrame mainFrame;
    private JPanel control;
    private JLabel tocar, parar, pausar,salvar,carregar;
    private JSlider bpmSlider;
    private JLabel bpmLabel;
    private JTabbedPane conteiner;
    
    private int bpm;
    private MainController controller;
    private DrumTab drum;
    private CordaTab bass,g1,g2;
    ImageIcon iconTocar,iconPausar,iconParar;
    ImageIcon iconTocar1,iconPausar1,iconParar1;
    
    
    public MainView (){
        controller = new MainController();
        bg=new Color(255,255,255);
        fg=new Color (0,0,0);
        bpm = BPM_INIT;
        iconTocar=new ImageIcon("src/Icons/png/play.png");
        iconPausar=new ImageIcon("src/Icons/png/pause.png");
        iconParar=new ImageIcon("src/Icons/png/stop.png");
        iconTocar1=new ImageIcon("src/Icons/png/play(1).png");
        iconPausar1=new ImageIcon("src/Icons/png/pause(1).png");
        //iconParar=new ImageIcon("src/Icons/png/stop.png");
        mainFrame = new JFrame("Musiquality");
        mainFrame.setBackground(bg);
        mainFrame.setLayout(new BorderLayout());
        conteiner = new JTabbedPane();
        
        drum = new DrumTab(bg,fg);
        bass = new CordaTab(Util.BASS,bg,fg);
        g1 = new CordaTab(Util.GUITAR1,bg,fg);
        g2 = new CordaTab(Util.GUITAR2,bg,fg);
        
        conteiner.add("Bateria",drum.get());
        conteiner.add("Baixo",bass.get());
        conteiner.add("Guitarra 1",g1.get());
        conteiner.add("Guitarra 2",g2.get());
       
        conteiner.setBackground(bg);
        
        mainFrame.add(conteiner,BorderLayout.CENTER);
        this.initialize_control();
        this.setListeners();
        mainFrame.setSize(1200, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
    private void initialize_control(){
        control = new JPanel();
        control.setBackground(bg);
        
        tocar = new JLabel();
        tocar.setIcon(iconTocar);
        //tocar.setPreferredSize(new Dimension(150,150));
        pausar = new JLabel (iconPausar);
        parar = new JLabel(iconParar);
        
        bpmSlider = new JSlider(JSlider.HORIZONTAL,BPM_MIN,BPM_MAX,BPM_INIT);
        bpmSlider.setMajorTickSpacing((BPM_MAX-BPM_MIN)/5);
        bpmSlider.setMinorTickSpacing((BPM_MAX-BPM_MIN)/10);
        bpmSlider.setName("BPM");
        bpmSlider.setPaintTicks(true);
        bpmSlider.setPaintLabels(true);
        bpmSlider.setOpaque(true);
        bpmSlider.setBackground(bg);
        
        salvar = new JLabel("Salvar Musica");
        carregar = new JLabel("Carregar Musica");
        bpmLabel = new JLabel("BPM: " + String.valueOf(bpm));
        bpmLabel.setHorizontalAlignment(JLabel.CENTER);
        bpmLabel.setPreferredSize(new Dimension(100,45));
        
        control.add(tocar);
        control.add(pausar);
        control.add(parar);
        control.add(bpmSlider);
        control.add(bpmLabel);
        
        
        control.add(salvar);
        control.add(carregar);
        mainFrame.add(control,BorderLayout.NORTH);
        
    }

    private void setListeners() {
        
        
        bpmSlider.addChangeListener((ChangeEvent e) -> {
            bpm=bpmSlider.getValue();
            bpmLabel.setText("BPM: " + String.valueOf(bpm));
        });
        tocar.addMouseListener(new MouseListener(
        ) {
            @Override
            public void mouseClicked(MouseEvent e) {controller.tocar(drum,bass,g1,g2,bpm);}
            @Override
            public void mousePressed(MouseEvent e) {tocar.setIcon(iconTocar1);}
            @Override
            public void mouseReleased(MouseEvent e) {tocar.setIcon(iconTocar);}
            @Override
            public void mouseEntered(MouseEvent e) {tocar.setIcon(iconTocar1);}
            @Override
            public void mouseExited(MouseEvent e) {tocar.setIcon(iconTocar);}
        });
        /*
        tocar.addActionListener((ActionEvent e) -> {
            
        });
        
        pausar.addActionListener((ActionEvent e) -> {
            controller.pausar(drum,bass,g1,g2,bpm);
        });
        parar.addActionListener((ActionEvent e) -> {
            controller.parar(drum,bass,g1,g2,bpm);
        });*/
    }

    
    public int getBpm() {return bpm;}
    
    
}
