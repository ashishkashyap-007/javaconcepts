package com.ashish.java.concepts.basics;

public class StringImmutabilityExample {

    static void main() {
        String str1 = "Hello";

        String str2 = "Hello";

        String str3 = str1 + " World";

        String str4 = str1.toUpperCase();

        String str5 = "Hello World";

        String str6 = new String("Hello World").intern();

        String str7 = new String("Hello");

        System.out.println("str1: " + str1); // Output: Hello
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str3 == str5); // why false? Because str3 is created using concatenation, which creates a new String object, whereas str5 is a string literal.
        System.out.println(str5 == str6); // why true? Because str6 is interned, which means it refers to the same string literal in the string pool as str5.
        System.out.println(str1 == str7); // why false? Because str7 is created using the new keyword, which creates a new String object, whereas str1 is a string literal.
    }
}
