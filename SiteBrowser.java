/**
 * Created by Martin on 22.09.2017.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;
import java.util.Scanner;

public class SiteBrowser {

    public static void main(String[] args) {

        Stack past = new Stack();
        Stack future = new Stack();
        String input = "11\n" +
                "Facebook\n" +
                "Twitter\n" +
                "Google\n" +
                "∗back∗\n" +
                "∗back∗\n" +
                "∗forward∗\n" +
                "YouTube\n" +
                "∗forward∗\n" +
                "LinkedIn\n" +
                "∗back∗\n" +
                "∗back∗";
        Scanner scanner = new Scanner(input);

        int numberOfLines = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = scanner.nextLine();

            if (currentLine.equals("∗back∗")) {
                if (!past.isEmpty()) {
                    future.push(past.pop());
                    StdOut.println(past.peek());
                } else {
                    StdOut.println("Error: There is no back from here. ");
                }
            } else if (currentLine.equals("∗forward∗")) {
                if (!future.isEmpty()) {
                    past.push(future.pop());
                    StdOut.println(past.peek());
                } else {
                    StdOut.println("Error: There is no forward from here. ");
                }
            } else {
                past.push(currentLine);
                StdOut.println(past.peek());
                future = new Stack();
            }

        }


    }


}

