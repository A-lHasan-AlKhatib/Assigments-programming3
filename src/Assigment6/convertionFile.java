/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class convertionFile extends javax.swing.JFrame {

    File text = new File("C:\\Users\\Handy\\Documents\\NetBeansProjects\\Hasan\\"
            + "src\\Assigment6\\conve.txt");
    
    File binary = new File("C:\\Users\\Handy\\Documents\\NetBeansProjects\\Hasan\\"
            + "src\\Assigment6\\conve.dat");

    public convertionFile() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toBinary = new javax.swing.JButton();
        toText = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toBinary.setText("convert to Binary");
        toBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionToBinary(evt);
            }
        });

        toText.setText("convert to text");
        toText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionToText(evt);
            }
        });

        area.setEditable(false);
        area.setColumns(20);
        area.setLineWrap(true);
        area.setRows(5);
        area.setWrapStyleWord(true);
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toText, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toBinary))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(toBinary)
                .addGap(18, 18, 18)
                .addComponent(toText)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionToBinary(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionToBinary
        try {
            FileReader reader = new FileReader(text);
            BufferedReader br = new BufferedReader(reader);
            String out = "";
            for(String line = br.readLine();line != null;line = br.readLine()){
                out += line+"\n";
            }
            FileOutputStream fo = new FileOutputStream(binary);
            DataOutputStream dos = new DataOutputStream(fo);
            dos.writeChars(out);
            dos.close();
            fo.close();
            area.setText("Following text has been convert to binary and "
                    + "written to a binary file.\n"+out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(convertionFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(convertionFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_actionToBinary

    private void actionToText(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionToText
        try {
            FileInputStream fi = new FileInputStream(binary);
            DataInputStream di = new DataInputStream(fi);
            String r = "";
            String b = "";
            for (int i = di.read(); i != -1; i = di.read()) {
                b += i;
                r+= (char) i;
            }
            area.setText("Following binary data has been convert to text and "
                    + "written to a text file.\n"+b);
            FileOutputStream fos = new FileOutputStream(text);
            
            Formatter formatter = new Formatter(fos);
            formatter.format("%s\n", r);
            formatter.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(convertionFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(convertionFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        

    }//GEN-LAST:event_actionToText

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(convertionFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(convertionFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(convertionFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(convertionFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new convertionFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton toBinary;
    private javax.swing.JButton toText;
    // End of variables declaration//GEN-END:variables
}