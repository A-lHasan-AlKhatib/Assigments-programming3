package Assigment2;

import java.io.IOException;

/**
 *
 * @author Handy
 */
public class Try {

    public static void assigment2_1_a() {
        try {
            throw new ExceptionA();
        } catch (ExceptionA a) {
            System.out.println(a.getMessage());
        }

        try {
            throw new ExceptionB();
        } catch (ExceptionA a) {
            System.out.println(a.getMessage());
        }

        try {
            throw new ExceptionC();
        } catch (ExceptionA a) {
            System.out.println(a.getMessage());
        }
    }

    public static void assigment2_1_b() throws IOException {

        try {
            throw new ExceptionA();
        } catch (ExceptionA a) {
            System.out.println(a.getMessage());
        }

        try {
            throw new ExceptionB();
        } catch (ExceptionB b) {
            System.out.println(b.getMessage());
        }

        try {
            throw new NullPointerException();
        } catch (NullPointerException ne) {
            System.out.println(ne);
        }

        throw new IOException();
    }

    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static void someMethod2() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        assigment2_1_a();
        try {
            assigment2_1_b();
        } catch (IOException io) {
            System.out.println(io);
        }
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}