import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class rpTranslator {

    public static void main(String[] args) {

        StdOut.println("Enter expression in reverse polish form: ");
        String input = StdIn.readLine();

        String[] elements = input.split(" ");

        Stack numbers = new Stack();
        Stack operators = new Stack();

        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals("*") || elements[i].equals("+"))
                operators.push(elements[i]);
            else
                numbers.push(elements[i]);

            if (!operators.empty()) {

                String formatted = "(" + numbers.pop() + operators.pop() + numbers.pop() + ")";
                numbers.push(formatted);

            }
        }

        StdOut.println("Input formatted as bracketed infix:");
        StdOut.print(numbers.pop());

    }
}
