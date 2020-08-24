package com.contrastsecurity;
import org.apache.commons.text.WordUtils;

public class HelloWorld {
    public static void main(String[] args) {
        String a = "hello world";
        String b = "i am FINE";
        String c = "The DOG Has a BoNE";

        System.out.println("Capitalize first letter of each white-spaced word:");

        String newVal = WordUtils.capitalize(a);

        System.out.println("Before: " + a + "\nAfter: " + newVal
                + "\nnewVal.contains(Hello World): "
                + newVal.contains("Hello World")        // agent will take in this new String constant and swap it
                                                        // with ":wave: hello, world!" so this will equate to false
                + "\nnewVal.equals(Hello World): "
                + newVal.equals("Hello World"));        // agent will take in this new String constant and swap it
                                                        // with ":wave: hello, world!" so this will equate to false

        System.out.println("\nBefore: " + a
                + "\nAfter: " + WordUtils.capitalize(a)
                + "\nWordUtils.capitalize(a).contains(Hello World): "
                + WordUtils.capitalize(a).contains("Hello World")       // agent will take in this new String constant and swap it
                                                                        // with ":wave: hello, world!" so this will equate to false
                + "\nWordUtils.capitalize(a).equals(Hello World): "
                + WordUtils.capitalize(a).equals("Hello World"));     // agent will take in this new String constant and swap it
                                                                      // with ":wave: hello, world!" so this will equate to false

        System.out.println("\nBefore: " + b + "\nAfter: " + WordUtils.capitalize(b) + "\n\n");
        System.out.println("\nBefore: " + c + "\nAfter: " + WordUtils.capitalize(c) + "\n\n");

        System.out.println("Capitalize first letter of each white-spaced word, " +
                "un-capitalize each following letter of word:");

        System.out.println("Before: " + a + "\nAfter: " + WordUtils.capitalizeFully(a) + "\n");
        System.out.println("Before: " + b + "\nAfter: " + WordUtils.capitalizeFully(b) + "\n");
        System.out.println("Before: " + c + "\nAfter: " + WordUtils.capitalizeFully(c));
    }
}

