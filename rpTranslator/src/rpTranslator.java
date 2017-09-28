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
        //String input = "1 2 + 3 4 5 + + * 6 7 / 8 9 + * -";

        //puts the input RP strings in an array, as separated by empty space(" ")
        String[] elements = input.split(" ");

        //stack that will recieve elementes from elements[] 
        Stack everything = new Stack();
        //for loop that will gradually turn Stack everything into only one element when translated
        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals("*") || elements[i].equals("+")|| elements[i].equals("-")|| elements[i].equals("/")) {
                //when elements[i] contains an operator, it pops two numbers from everything[] 
                //and puts the operator between them, and puts it in parenthesis
                String formatted = ")" + everything.pop() + elements[i] + everything.pop() + "(";
                everything.push(formatted);
            } else{
                everything.push(elements[i]);
            }
        }
        StdOut.println("Input formatted as bracketed infix:");

        //oops. Since we didn't use variables for the pops in the for loop, so we have to reverse the string using stringbuilder. 
        StringBuilder feilVei = new StringBuilder(everything.pop().toString());
        StdOut.println(feilVei.reverse());


        }




}
