package com.contrastsecurity;
import org.apache.commons.text.WordUtils;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Capitalize first letter of each white-spaced word:");
        String a = "hello world";
        String b = "i am FINE";
        String c = "The DOG Has a BoNE";

        System.out.println("Before: " + a + "\nAfter: " + WordUtils.capitalize(a) + "\n");
        System.out.println("Before: " + b + "\nAfter: " + WordUtils.capitalize(b) + "\n");
        System.out.println("Before: " + c + "\nAfter: " + WordUtils.capitalize(c) + "\n\n");

        System.out.println("Capitalize first letter of each white-spaced word, " +
                "un-capitalize each following letter of word:");
        System.out.println("Before: " + a + "\nAfter: " + WordUtils.capitalizeFully(a) + "\n");
        System.out.println("Before: " + b + "\nAfter: " + WordUtils.capitalizeFully(b) + "\n");
        System.out.println("Before: " + c + "\nAfter: " + WordUtils.capitalizeFully(c));
    }
}

