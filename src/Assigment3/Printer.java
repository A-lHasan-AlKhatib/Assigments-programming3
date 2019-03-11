/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Handy
 */
public class Printer {
    
    public Printer(){
    JFrame j = new JFrame();
        j.setSize(700, 200);
        j.setLayout(new GridLayout(1, 4));
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("Printer");
        j.setResizable(false);
        JPanel p1 = new JPanel(new GridLayout(3,1));
        JPanel p2 = new JPanel(new GridLayout(4, 1));
        p2.add(new JButton("OK"));
        p2.add(new JButton("Cancel"));
        p2.add(new JButton("Setup..."));
        p2.add(new JButton("Help"));
        JPanel pp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pp2 = new JPanel(new GridLayout(1, 2));
        JPanel pp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pp1.add(new JLabel("Printer :MyPrinter"));
        pp2.add(new JTextArea(3, 1));
        JPanel ppp1 = new JPanel(new GridLayout(3, 1));
        
        ppp1.add(new JCheckBox("Image"));
        ppp1.add(new JCheckBox("Text"));
        ppp1.add(new JCheckBox("Code"));
        pp2.add(ppp1);
        JPanel p3 = new JPanel(new GridLayout(3,1));
        p3.add(new JLabel());
        JPanel ppp4 = new JPanel(new GridLayout(1, 3));
        ppp4.add(new JTextArea(3, 3));
        JRadioButton b1 = new JRadioButton("Selection");
        JRadioButton b2 = new JRadioButton("All");
        JRadioButton b3 = new JRadioButton("Applet");
        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        JPanel pppp1 = new JPanel(new GridLayout(3,1));
        pppp1.add(b1);
        pppp1.add(b2);
        pppp1.add(b3);
        ppp4.add(pppp1);
        p3.add(ppp4);
        p1.add(pp1);
        p1.add(pp2);
        pp3.add(new JLabel("      Print Quality:"));
        JPanel pp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<String> box = new JComboBox<>();
        box.addItem("Best");
        box.addItem("Good");
        box.addItem("Bad");
        pp4.add(box);
        
        JPanel pp5 = new JPanel();
        p1.add(pp3);
        p3.add(pp4);
        
        JPanel p4 = new JPanel(new GridLayout(3,1));
        p4.add(new JLabel());
        p4.add(new JTextArea(3, 3));
        p4.add(new JCheckBox("Print to file"));
        j.add(p1);
        j.add(p3);
        j.add(p4);
        j.add(p2);
        j.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new Printer();
    }
}
