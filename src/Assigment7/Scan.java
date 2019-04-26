package Assigment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Scan {
    public static void main(String[] args) throws FileNotFoundException {
         
        HashMap<String, Integer> map = new HashMap();
        File file = new File("C:\\code\\t.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            String word = scan.next();
            System.out.println(word);
            Integer i = map.get(word);
            if (i == null) {
                map.put(word, 1);
            } else {
                map.put(word, i + 1);
            }
            for (int j = 0; j < word.length(); j++) {
                Character chr = word.charAt(j);
                System.out.println(chr);
                Integer i2 = map.get(chr.toString());
                if (i2 == null) {
                    map.put(chr.toString(), 1);
                } else {
                    map.put(chr.toString(), i2 + 1);
                }
            }
            System.out.println(map);           
        }
    }
}