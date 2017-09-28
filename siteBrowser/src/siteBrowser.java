/**
 * Task 2, mandatory assignment 1
 * INF102
 *
 * @author Marius Kleppe Larnoy
 * @author Martin Skivenesvaag Johannessen
 *
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;
import java.util.Scanner;

public class siteBrowser {

    public static void main(String[] args) {
        
        //Stacks where the web pages are saved
        Stack past = new Stack();
        Stack future = new Stack();

       //saves the user input in Scanner scanner
        StdOut.println("Enter number of commands you will use and press 'enter', then write commands separated by enter: ");
        Scanner scanner = new Scanner(StdIn.readLine());
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        String lines = "";
        for (int i=0;i<numberOfLines;i++) { lines += StdIn.readLine()+"\n";}
        scanner = new Scanner(lines);


        //for loop that goes throug the commands from user and prints out appropriate response
        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = scanner.nextLine();

            //if user wants to go back, an element from Stack past is popped, and then pushed to Stack future. 
            //then we peek at past and print it.
            if (currentLine.equals("∗back∗")||currentLine.equals("*back*")) {
                if (past.size()>1) {
                    future.push(past.pop());
                    StdOut.println(past.peek());
                } else {
                    StdOut.println("Error: There is no back from here. ");
                }
            //if the user wants to go forward the revers from the above happens. 
            //pop from future and push it to past. then peek from past   
            } else if (currentLine.equals("∗forward∗")||currentLine.equals("*forward*")) {
                if (!future.isEmpty()) {
                    past.push(future.pop());
                    StdOut.println(past.peek());
                } else {
                    StdOut.println("Error: There is no forward from here. ");
                }
            //if the user wants to go to a new website, it is pushed to past and printed. 
            //the future is also erased to make room for an eventual new future in the future. Wow that's deep man
            } else {
                past.push(currentLine);
                StdOut.println(past.peek());
                future = new Stack();
            }

        }


    }


}

