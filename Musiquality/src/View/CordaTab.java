/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CordaController;
import Main.Util;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Usuário
 */
public class CordaTab {
    private Color bg,fg;
    private JPanel mainTab,top,bot;
    private JPanel auxTop1,auxTop2; 
    private JPanel auxBot1,auxBot2;
    private JLabel[][] rhythms;
    private JLabel[] rhythmList;
    private JLabel[][] tempo;
    private JLabel[] notes, nTempo;
    private JLabel oitavaLabel,tempoLabel;
    private JComboBox c1;
    private JRadioButton[] oitavas;
    private ButtonGroup g;
    
    private final int TIPO;
    private int selec;//Levada selecionada
    public CordaController controller;
    
    public CordaTab(int tipo, Color bg, Color fg){
        this.bg=bg;
        this.fg=fg;
        TIPO=tipo;
        controller=new CordaController(TIPO);
        selec=0;
        this.iniialize();
    }

    private void iniialize() {
        this.initializeComponents();
        mainTab.setLayout(new GridLayout(2,1));
        this.iniializeTop();
        
        this.iniializeBot();
        this.setListeners();
        
       mainTab.add(top);
       mainTab.add(bot);
    }

    JPanel get() {
        return mainTab;
    }

    private void iniializeTop() {
        top.setLayout(new BorderLayout());
        
        auxTop1 = new JPanel();
        auxTop1.setLayout(new GridLayout(10,1));
        
        rhythms = new JLabel[10][50];
        
        auxTop2 = new JPanel();
        auxTop2.setLayout(new GridLayout(rhythms.length,rhythms[0].length));
        
        rhythmList = new JLabel[10];
        for(int i=0;i<rhythms.length;i++){
            for(int j=0;j<rhythms[i].length;j++){
                rhythms[i][j] = new JLabel();
                rhythms[i][j].setOpaque(true);
                rhythms[i][j].setBackground(bg);
                rhythms[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                auxTop2.add(rhythms[i][j]);
            }
            rhythmList[i] = new JLabel("Ritmo " + (i+1));
            auxTop1.add(rhythmList[i]);
        }
        top.add(auxTop1,BorderLayout.WEST);
        top.add(auxTop2,BorderLayout.CENTER);
        
    }

    private void iniializeBot() {
        bot.setLayout(new BorderLayout());
        auxBot1.setLayout(new GridLayout(13,17));
        auxBot2.setLayout(new GridLayout(4,2));
        String[] labelName=controller.getNomes(0);
        nTempo[0]=new JLabel();
        
        double p=0;
        for(int i = 1;i<nTempo.length;i++,p+=0.25)
            nTempo[i]=new JLabel(String.valueOf(p));
       
        for(int i=0;i<17;i++)
           auxBot1.add(nTempo[i]);
       
        for(int i = 0;i<notes.length;i++){
            notes[i]=new JLabel(labelName[i]);
            auxBot1.add(notes[i]);
            for(int j=0;j<16;j++){
               tempo[i][j]=new JLabel();
               tempo[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
               tempo[i][j].setOpaque(true);
               tempo[i][j].setBackground(bg);
               tempo[i][j].setForeground(fg);
               auxBot1.add(tempo[i][j]);
            }
        }
        auxBot2.add(tempoLabel);
        auxBot2.add(c1);
        auxBot2.add(oitavaLabel);
        for(int i=0;i<oitavas.length;i++){
            oitavas[i]=new JRadioButton();
            if(this.TIPO==Util.BASS)
                oitavas[i].setText(String.valueOf(i+2));
            else
                oitavas[i].setText(String.valueOf(i+3));
            g.add(oitavas[i]);
            auxBot2.add(oitavas[i]);
        }
        oitavas[0].setSelected(true);
        bot.add(auxBot1,BorderLayout.CENTER);
        bot.add(auxBot2,BorderLayout.EAST);
    }

    private void initializeComponents() {
        mainTab = new JPanel();
        String[] s={"0.25","0.5","0.75","1","1.25","1.5","1.75","2","2.25","2.5","2.75","3","3.25","3.5","3.75","4"};
        c1=new JComboBox(s);
        c1.setSelectedIndex(s.length-1);
        c1.setForeground(fg);
        c1.setBackground(bg);
        top=new JPanel();
        top.setBackground(bg);
        auxTop1 = new JPanel();
        auxTop1.setBackground(bg);
        auxTop2 = new JPanel();
        auxTop2.setBackground(bg);
        bot=new JPanel();
        bot.setBackground(bg);
        auxBot1=new JPanel();
        auxBot1.setBackground(bg);
        auxBot2=new JPanel();
        auxBot2.setBackground(bg);
        tempoLabel=new JLabel("Tempo");
        tempoLabel.setForeground(fg);
        nTempo=new JLabel[17];
        //tempo=new JCheckBox[controller.getQtd()][16];
        tempo=new JLabel[12][16];
        notes=new JLabel[12];
        g=new ButtonGroup();
        oitavas=new JRadioButton[5];
        oitavaLabel=new JLabel("Oitava");
        
   }    

    private void setListeners() {
       LabelListener r=new LabelListener();
        for(int i=0;i<rhythmList.length;i++)
            rhythmList[i].addMouseListener(r);
        
        c1.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int maxTempos = c1.getSelectedIndex();
                controller.setMaxTempo(selec,maxTempos);
                for (JLabel[] tempo1 : tempo) {
                    for (int j = 0; j<=maxTempos; j++) {
                        if(tempo1[j].getBackground().equals(Color.BLACK))
                            tempo1[j].setBackground(bg);
                    }
                }
                for (JLabel[] tempo1 : tempo) {
                    for (int j = maxTempos+1; j<tempo1.length; j++) {
                        tempo1[j].setBackground(java.awt.Color.BLACK);
                    }
                }
            }    
        });
        for(int i=0;i<tempo.length;i++){
            for(int j=0;j<tempo[i].length;j++){
                tempo[i][j].addMouseListener(r);
            }
        }
        for(int i=0;i<oitavas.length;i++){
            int j=i;
            oitavas[i].addActionListener((ActionEvent e) -> {
                if(oitavas[j].isSelected()){
                    String[] labelName=controller.getNomes(j);
                    for(int k=0;k<notes.length;k++){
                        notes[k].setText(labelName[k]);
                    }
                }
            });
        }
    }
        private class LabelListener implements MouseListener{
        private Color hover=new Color(168,177,184);
        private Color bgpressed=new Color (0,39,94);
        private Color fgpressed=new Color (242,242,242);
        private Color nota= new Color (254,183,41);
        @Override
        public void mouseClicked(MouseEvent e) {
            for(int i=0;i<rhythmList.length;i++){
                if(e.getSource()==rhythmList[i]){
                    for(int j=0;j<rhythmList.length;j++){
                        if(i==j)
                            continue;
                        rhythmList[j].setForeground(fg);
                        rhythmList[j].setBackground(bg);
                    }
                    rhythmList[i].setBackground(bgpressed);
                    rhythmList[i].setForeground(fgpressed);
                    selec=i;
                    int t = controller.load(selec,notes,tempo,bg,nota);
                    c1.setSelectedIndex(t-1);
                }
            }
            
            for(int i=0;i<tempo.length;i++){
                for(int j=0;j<tempo[i].length;j++){
                    if(e.getSource()==tempo[i][j]){
                        if(tempo[i][j].getBackground().equals(Color.BLACK));
                        else{
                            controller.switchNota(selec,notes[i].getText(),j);
                            if(tempo[i][j].getBackground().equals(bg))
                                tempo[i][j].setBackground(nota);
                            else
                                tempo[i][j].setBackground(bg);
                        }
                    }
                }
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            for(int i=0;i<rhythmList.length;i++){
                if(e.getSource()==rhythmList[i]){
                    if(rhythmList[i].getBackground().equals(bg))
                        rhythmList[i].setBackground(hover);
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            for(int i=0;i<rhythmList.length;i++){
                if(e.getSource()==rhythmList[i]){
                    if(rhythmList[i].getBackground().equals(hover))
                        rhythmList[i].setBackground(bg);
                }
            }
        }
        
    }
}
