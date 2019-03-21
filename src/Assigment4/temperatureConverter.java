package Assigment4;
/**
 *
 * @author Handy
 */
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class temperatureConverter {

    private temperatureConverter() {
        JFrame j = new JFrame();
        j.setLayout(new FlowLayout());
        j.setTitle("Temperature Converter");
        j.setSize(420, 180);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("Enter Celsius temperature : ");
        JTextField textField = new JTextField();
        textField.setColumns(25);
        JRadioButton Fahrenheit = new JRadioButton("Fahrenheit");
        JRadioButton Kelvin = new JRadioButton("Kelvin");
        ButtonGroup group = new ButtonGroup();
        group.add(Fahrenheit);
        group.add(Kelvin);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(Fahrenheit);
        jPanel.add(Kelvin);
        JLabel label = new JLabel("New temperature in is : ");
        JPanel panel = new JPanel();
        JPanel jPanel2 = new JPanel();
        jPanel2.add(textField);
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setLayout(new GridLayout(4, 1));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(jLabel);
        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel5.add(label);
        panel.add(panel4);
        panel.add(jPanel2);
        panel.add(jPanel);
        panel.add(panel5);

        Fahrenheit.addActionListener(ae -> {
            float Celsius=Integer.parseInt(textField.getText());
            float Fahrenheit1 = Celsius* 9/5 + 32;
            label.setText("New temperature in is:"+String.valueOf(Fahrenheit1));
        });

        Kelvin.addActionListener(ae -> {
            float Celsius=Integer.parseInt(textField.getText());
            float Kelvin1 = (float) (Celsius + 273.15);
            label.setText("New temperature in is: "+String.valueOf(Kelvin1));
        });

        j.add(panel);
        j.setVisible(true);
    }

    public static void main(String[] args) {
        new temperatureConverter();
        }

}
