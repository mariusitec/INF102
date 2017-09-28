/**
 * Task 1, mandatory assignment 1
 * INF102
 *
 * @author Marius Kleppe Larnoy
 * @author Martin Skivenesvaag Johannessen
 *
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class rpTranslator {

    public static void main(String[] args) {

        StdOut.println("Enter expression in reverse polish form: ");
        String input = StdIn.readLine();

        //put all elements into an array separated by space
        String[] elements = input.split(" ");

        Stack everything = new Stack();

        //the loop runs through the elements array
        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals("*") || elements[i].equals("+")) {   //checks if the elements is an operator
                String formatted = ")" + everything.pop() + elements[i] + everything.pop() + "("; //adds formatted elements
                everything.push(formatted); //pushes the formatted string to the stack
            } else{
                everything.push(elements[i]);
            }
        }

        StdOut.println("Input formatted as bracketed infix:");
        //reverses the finished string
        StringBuilder feilVei = new StringBuilder(everything.pop().toString());

        StdOut.println(feilVei.reverse());


        }




}
