/**
 * Task 4, mandatory assignment 1
 * INF102
 *
 * @author Marius Kleppe Larnøy
 * @author Martin Skivenesvåg Johannessen
 *
 */

import edu.princeton.cs.algs4.*;
import java.util.Random;

public class profitSorting {

    public static void main(String[] args) {

        //creates array for ints to be stored
        int[] intArray = new int[1000000];

        Random rand = new Random();

        //generates random integers to fill the intArray
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt();
        }

        StdOut.println("Enter a value S which is the number of searches that will be conducted: ");
        int s = Integer.parseInt(StdIn.readLine());

        int[] randoms = new int[s];

        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = rand.nextInt();
        }

        //Linear search
        StdOut.println("Linear Search: ");

        Stopwatch linearWatch = new Stopwatch();
        linearSearch(intArray, randoms);
        double linearTime = linearWatch.elapsedTime();

        StdOut.println("(Linear)Time elapsed: " + linearTime + "s");


        //Binary search
        StdOut.println("Binary Search: ");

        Stopwatch binaryWatch = new Stopwatch();

        binarySearch(intArray, randoms);

        double binaryTime = binaryWatch.elapsedTime();
        StdOut.println("(Binary)Time elapsed: "+binaryTime +"s");
    }


    public static void linearSearch(int[] all, int[] randoms) {
        for(int i = 0; i < randoms.length;i++) {
            for (int j = 0; j < all.length; j++) {
                if (all[j] == randoms[i])
                    StdOut.println("Hit at position " + j);
            }

        }
    }

    public static void binarySearch(int[] all, int[] randoms) {

        BST<Integer, Integer> st = new BST<>();
        //sorting
        for (int i = 0; i < all.length; i++) {
            Integer key = all[i];
            st.put(key, i);

        }

        //searching
        for (int i = 0; i < randoms.length;i++) {
            if (st.contains(randoms[i]))
                StdOut.println("Hit at position " + st.get(randoms[i]));
        }

    }

}
