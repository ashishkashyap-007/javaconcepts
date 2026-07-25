package com.ashish.java.concepts.basics;

public class PassByValueExample {

    public static void main(String[] args) {
        int num=10;
        System.out.println("Value of num before modifyValue method call: " + num);
        modifyValue(num);
        System.out.println("Value of num after modifyValue method call: " + num);

        StringBuilder sb = new StringBuilder(("Hello"));
        System.out.println("Value of sb before modifyReference method call: " + sb);
        modifyReference(sb);
        System.out.println("Value of sb after modifyReference method call: " + sb);
    }

    private static void modifyReference(StringBuilder sb) {
        sb.append(" World");
        System.out.println("Value of sb inside modifyReference method: " + sb);
    }

    private static void modifyValue(int num) {
        num+=20;
        System.out.println("Value of num inside modifyValue method: " + num);
    }

}
