/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Handy
 */
public class Calc {
    public Calc(){
        JFrame j = new JFrame();
        j.setSize(190, 180);
        j.setLayout(new FlowLayout());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("Calculator");
        j.setResizable(false);
        JTextField field = new JTextField(16);
        j.add(field);
        JButton num7 = new JButton("7");
        JButton num8 = new JButton("8");
        JButton num9 = new JButton("9");
        JButton op_div = new JButton("/");
        JButton num4 = new JButton("4");
        JButton num5 = new JButton("5");
        JButton num6 = new JButton("6");
        JButton op_prod = new JButton("*");
        JButton num1 = new JButton("1");
        JButton num2 = new JButton("2");
        JButton num3 = new JButton("3");
        JButton op_sub = new JButton("-");
        JButton num0 = new JButton("0");
        JButton dot = new JButton(".");
        JButton equal = new JButton("=");
        JButton op_sum = new JButton("+");
        j.add(num7);
        j.add(num8);
        j.add(num9);
        j.add(op_div);
        j.add(num4);
        j.add(num5);
        j.add(num6);
        j.add(op_prod);
        j.add(num1);
        j.add(num2);
        j.add(num3);
        j.add(op_sub);
        j.add(num0);
        j.add(dot);
        j.add(equal);
        j.add(op_sum);
        j.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Calc();
    }
}
