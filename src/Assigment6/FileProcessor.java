package Assigment6;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FileProcessor {
    public FileProcessor() {
        JFrame j = new JFrame();
        j.setSize(420, 470);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("File Processing");
        j.setResizable(true);

        JTextArea textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.setPreferredSize(new Dimension(400, 450));
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem open = new JMenuItem("open", 'o');
        JMenuItem save = new JMenuItem("save", 's');
        JMenuItem close = new JMenuItem("close", 'c');
        JMenuItem exit = new JMenuItem("Exit", 'x');
        JMenuItem font = new JMenuItem("font", 'f');
        JMenuItem color = new JMenuItem("color", 'l');

        file.add(open);
        file.add(save);
        file.add(close);
        file.add(exit);
        edit.add(font);
        edit.add(color);
        menuBar.add(file);
        menuBar.add(edit);

        String[] fonts = {"plain", "italic", "bold"};
        JComboBox<String> box = new JComboBox<>(fonts);

        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setColor(Color.BLACK);
        JDialog dialog = JColorChooser.createDialog(null, "Colors", false,
                colorChooser, e -> System.out.println("done"), null);

        JFileChooser fileChooser = new JFileChooser();
        open.addActionListener(e -> {
            textArea.setText("");
            fileChooser.showOpenDialog(j);
            if (fileChooser.getSelectedFile() != null) {
                File file1 = fileChooser.getSelectedFile();
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file1);
                } catch (FileNotFoundException ee) {
                }
                if (scanner == null) throw new AssertionError();
                while (scanner.hasNext()) {
                    textArea.setText(textArea.getText() + "\n" + scanner.nextLine());
                }
                textArea.setText(textArea.getText().trim());
            }
            textArea.setEditable(true);
        });

        save.addActionListener((ActionEvent e) -> {
            File file1 = fileChooser.getSelectedFile();
            
            if (file1!=null){
                String textHolder="";
                String newLine = System.getProperty("line.separator");
                Scanner scanner = new Scanner(textArea.getText());
                while (scanner.hasNext()){
                    textHolder = textHolder.concat(scanner.nextLine()+newLine);
                }
                String path = file1.getPath();
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(path);
                } catch (FileNotFoundException ee) {
                }
                try (PrintWriter pw = new PrintWriter(fos)) {
                    pw.write(textHolder);
                    pw.flush();
                }
            }
        });

        close.addActionListener(e -> {
            textArea.setText("");
            textArea.setEditable(false);
        });

        exit.addActionListener(e -> System.exit(0));

        font.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, box, "font",
                    JOptionPane.QUESTION_MESSAGE);
            switch (box.getSelectedIndex()) {
                case 0:
                    textArea.setFont(new Font("Arial", Font.PLAIN, 14));
                    break;
                case 1:
                    textArea.setFont(new Font("Arial", Font.ITALIC, 14));
                    break;
                case 2:
                    textArea.setFont(new Font("Arial", Font.BOLD, 14));
                    break;
            }
        });

        color.addActionListener(e -> textArea.setForeground(JColorChooser.showDialog(null,
                "Colors", Color.black)));

        j.setJMenuBar(menuBar);
        j.add(pane);
        j.setVisible(true);
    }

    public static void main(String[] args) {
        new FileProcessor();
    }
}