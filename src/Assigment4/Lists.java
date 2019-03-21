package Assigment4;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Lists {

    private Lists() {
        JFrame j = new JFrame();
        j.setTitle("Multiple Selection Lists");
        j.setLayout(new FlowLayout());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(320, 140);
        j.setLocationRelativeTo(null);
        String[] colorNames = {"Black", "Blue", "Cyan", "Gray", "Green", "Magenta", "Orange", "Pink",
                "Red", "White", "Yellow"};
        JList<String> cuJList = new JList<>(colorNames);
        cuJList.setVisibleRowCount(5);
        JList<String> coJList = new JList<>();
        coJList.setVisibleRowCount(5);
        coJList.setFixedCellWidth(100);
        coJList.setFixedCellHeight(15);
        coJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        cuJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        

        JButton copyJButton = new JButton("Copy >>>");
        copyJButton.addActionListener(
                event -> coJList.setListData(
                        cuJList.getSelectedValuesList().toArray(
                                new String[0])));

        j.add(new JScrollPane(cuJList));
        j.add(copyJButton);
        JScrollPane scrollPane = new JScrollPane(coJList);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.
                HORIZONTAL_SCROLLBAR_NEVER);
        j.add(scrollPane);
        j.setVisible(true);

    }

    public static void main(String[] args) {
        new Lists();
    }
}
