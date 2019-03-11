/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Handy
 */
public class Lists {
    
    public Lists(){
        JFrame j = new JFrame();
        j.setSize(300, 135);
        j.setLayout(new FlowLayout(FlowLayout.LEFT));
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("Selection Lists");
        j.setResizable(false);
        String[] colors = {"Black", "Blue", "Gray", "Cyan"  ,  "Green",  "Orange", "Pink",
            "Red", "White", "Yellow"};
        JList<String> colorList = new JList(colors);
        colorList.setVisibleRowCount(5);
        JScrollPane scrollPane = new JScrollPane(colorList);
        JTextArea textArea = new JTextArea(5,12);
        textArea.setText("Black\nCyan\nBlue");
        textArea.setEditable(false);
        j.add(scrollPane);
        j.add(new JLabel());
        JButton button = new JButton("Copy");
        j.add(button);
        j.add(new JLabel());
        
        
        j.add(new JLabel());
        j.add(textArea);
        
        j.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Lists();
    }
    
}
