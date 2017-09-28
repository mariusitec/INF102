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

        //creates array for integers to be stored, size 10e+6 
        int[] intArray = new int[1000000];

        Random rand = new Random();

        //generates random integers to fill the intArray
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt();
        }
        
        //takes an input from terminal, a number which is the number 
        //of random integers that will be searched for 
        StdOut.println("Enter a value S which is the number of searches that will be conducted: ");
        int s = Integer.parseInt(StdIn.readLine());
        
        //creates an array that will store the random search integers 
        int[] randoms = new int[s];
        
        //fills the array
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = rand.nextInt();
        }

        //Linear search
        StdOut.println("Linear Search: ");
        
        //stopwatch that will return time taken from object creation to .elapsedTime() is called
        Stopwatch linearWatch = new Stopwatch();
        linearSearch(intArray, randoms);    //calls on static method linearSearch
        double linearTime = linearWatch.elapsedTime();  //stores the elapsed time

        StdOut.println("(Linear)Time elapsed: " + linearTime + "s");


        //Binary search
        StdOut.println("Binary Search: ");
        //stopwatch for determining time used by the binary search
        Stopwatch binaryWatch = new Stopwatch();
        
        //calls static method binarySearch
        binarySearch(intArray, randoms);

        double binaryTime = binaryWatch.elapsedTime();
        StdOut.println("(Binary)Time elapsed: "+binaryTime +"s");
    }

    //static method that takes the big integer array and the search integer array as parameters
    public static void linearSearch(int[] all, int[] randoms) {
        for(int i = 0; i < randoms.length;i++) {   //double for loop that checks every element from array randoms
            for (int j = 0; j < all.length; j++) { //against every element in array all
                if (all[j] == randoms[i])
                    StdOut.println("Hit at position " + j); //prints the array index if number is found
            }

        }
    }

    public static void binarySearch(int[] all, int[] randoms) {
        //creates a BST(BinarySearchTree) object, uses the random number as key and array index as value
        BST<Integer, Integer> st = new BST<>();
        //sorting
        for (int i = 0; i < all.length; i++) {  //loop that will build the search tree from the all array
            Integer key = all[i];
            st.put(key, i);

        }

        //searching, 
        for (int i = 0; i < randoms.length;i++) {
            if (st.contains(randoms[i]))
                StdOut.println("Hit at position " + st.get(randoms[i])); //prints the array index(the value)if number is found
        }

    }

}
