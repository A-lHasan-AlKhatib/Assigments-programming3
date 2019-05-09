package Assigment8;

import java.util.function.IntConsumer;

/**
 *
 * @author Handy
 */
public class Q1 {
    public static String b(String s){
        return s.toUpperCase();
    }
    
    interface operation<T>{
        T operation (T x);
    }
    
    interface operation2{
         void operation2();
    }

    interface math<T>{
        T sqrt (T x);
    }
    
    public static void main(String[] args) {
        IntConsumer intConsumer = (int value) -> {
            System.out.printf("%d",value);
        };
        System.out.println("");
        intConsumer.accept(25);
        System.out.println(b("Hellooo!!"));
        operation2 op = () -> System.out.println("Welcome to lambdas!");;
        op.operation2();
        math<Double> m = (x) -> Math.sqrt(x);
        System.out.println(m.sqrt(25.0));
        operation<Integer> cube = (x) -> x*x*x;
        System.out.println(cube.operation(4));
    }
}
