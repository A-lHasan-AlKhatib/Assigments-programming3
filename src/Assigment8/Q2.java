package Assigment8;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author Handy
 */
public class Q2 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\Handy\\Documents\\NetBeansProjects\\"
                + "Hasan\\src\\Assigment8\\text.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String out = "";
        int sum = 0;
        String temp = reader.readLine(); 
        while(temp != null){
            out+=temp;
            temp = reader.readLine();
        }
        String[] words = out.split(" ");
        out o = w -> w.length() ;
        for(String s : words){
              sum += o.output(s);
        }
        System.out.println(sum);
    }
    interface out{
        int output(String w);
    }
}