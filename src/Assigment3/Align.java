/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Handy
 */
public class Align {
    
    public Align(){
        JFrame j = new JFrame();
        j.setSize(320, 140);
        j.setLayout(new FlowLayout(FlowLayout.LEFT));
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("Align");
        j.setResizable(false);
        JPanel pan = new JPanel(new GridLayout(1,3));
        
        JCheckBox snap = new JCheckBox("Snap to Grid");
        JCheckBox show = new JCheckBox("show Grid");
        JPanel p = new JPanel(new GridLayout(2,1));
        p.add(snap);
        p.add(show);
        
        
        JTextField field = new JTextField(3);
        JPanel pp = new JPanel();
        JPanel pp1 = new JPanel();
        pp.add(new JLabel("Y :"));
        pp1.add(new JLabel("X :"));
        JTextField field1 = new JTextField(3);
        pp.add(field);
        pp1.add(field1);
        
        JPanel p1 = new JPanel(new GridLayout(2,1));
        
        p1.add(pp);
        p1.add(pp1);
        
        JPanel p2 = new JPanel(new GridLayout(3,1));
        p2.add(new JButton("OK"));
        p2.add(new JButton("Cancel"));
        p2.add(new JButton("Help!!"));
        
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        p3.add(new JLabel());
        p3.add(p2);
        pan.add(p3);
        
        pan.add(p1);
        
        
        pan.add(p);
        j.add(pan);
        
        j.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new Align();
    }
}
