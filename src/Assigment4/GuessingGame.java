package Assigment4;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Handy
 */
public class GuessingGame{

    private int number;

    private GuessingGame(){
        JFrame j = new JFrame();
        j.setSize(300,160);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.setTitle("Guessing Game");
        j.setLayout(new FlowLayout(FlowLayout.CENTER));

        number = (int) (Math.random() * 1000);

        JLabel jLabel = new JLabel("i have a number between 1 and 100.");
        JLabel label = new JLabel("Can you guess my number ?");
        JLabel mesg = new JLabel("Enter your guess in here : ");
        JTextField guess = new JTextField(4);
        mesg.setLabelFor(guess);
        JButton reset = new JButton("New Game");

        guess.addActionListener(e -> {
            if (Integer.parseInt(guess.getText())==number){
                mesg.setText("Correct !! You Guessed It");
                j.getContentPane().setBackground(Color.GREEN);
                guess.setEditable(false);
            } else if (Integer.parseInt(guess.getText())>number){
                mesg.setText("Too High.Try a lower number");
                j.getContentPane().setBackground(Color.RED);
            } else if (Integer.parseInt(guess.getText())<number){
                mesg.setText("Too Low.Try a higher number");
                j.getContentPane().setBackground(Color.BLUE);
            }
        });

        reset.addActionListener(e -> {
            if (e.getSource()==reset){
                number = (int) (Math.random() * 1000);
                mesg.setText("Enter your guess in here : ");
                guess.setText("");
                guess.setEditable(true);
                j.getContentPane().setBackground(Color.white);
            }
        });

        j.add(jLabel);
        j.add(label);
        j.add(mesg);
        j.add(guess);
        j.add(reset);
        j.setVisible(true);
    }

    public static void main(String[] args) {
        new GuessingGame();
    }
}