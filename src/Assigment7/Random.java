/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment7;

import java.util.Collections;
import java.util.LinkedList;

public class Random {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();        
        for (int i = 0; i < 25; i++) {
            int num = (int) (Math.random() *101);
            list.add(num);
        }
        System.out.println("unsortend");
        System.out.println(list.toString());
        System.out.println("***********************************************");
        Collections.sort(list);
        System.out.println("sorted");
        System.out.println(list.toString());
        System.out.println("***********************************************");
        float f = 0;
        for(int i : list){
            f += i;
        }
        f /= 25;
        System.out.println("The average of the elements : " + String.format("%.4f", f));
    }
    
}
