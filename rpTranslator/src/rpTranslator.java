import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class rpTranslator {

    public static void main(String[] args) {

        StdOut.println("Enter expression in reverse polish form: ");
        //String input = StdIn.readLine();
        String input = "1 2 + 3 4 5 + + *";

        String[] elements = input.split(" ");

        Stack everything = new Stack();

        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals("*") || elements[i].equals("+")) {
                String formatted = ")" + everything.pop() + elements[i] + everything.pop() + "(";
                everything.push(formatted);
            } else{
                everything.push(elements[i]);
            }
        }
        StdOut.println("Input formatted as bracketed infix:");

        StringBuilder feilVei = new StringBuilder(everything.pop().toString());

        StdOut.println(feilVei.reverse());


        }




}
