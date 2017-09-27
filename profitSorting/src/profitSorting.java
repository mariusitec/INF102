import edu.princeton.cs.algs4.*;
import java.util.Random;

public class profitSorting {

    public static void main(String[] args) {

       int[] intArray = new int[10000];

        Random rand = new Random();

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
        Stopwatch linearWatch = new Stopwatch();

        StdOut.println("Linear Search: ");
        linearSearch(intArray, randoms);

        double linearTime = linearWatch.elapsedTime();
        StdOut.println("(Linear)Time elapsed: " + linearTime + "s");

        //Binary search
        Stopwatch binaryWatch = new Stopwatch();

        StdOut.println("Binary Search: ");
        binarySearch(intArray, randoms);

        double binaryTime = binaryWatch.elapsedTime();
        StdOut.println("(Binary)Time elapsed: " + binaryTime + "s");

    }

    public static void linearSearch(int[] all, int[] randoms) {
        StdOut.println("Found:");
        for(int i = 0; i < randoms.length;i++) {
            for (int j = 0; j < all.length; j++) {
                if (all[j] == randoms[i])
                    StdOut.println("Hit at position " + j);
            }

        }
    }

    public static void binarySearch(int[] all, int[] randoms) {

        BinarySearchST<Integer, Integer> st = new BinarySearchST();
        //sorting
        for (int i = 0; i < all.length; i++) {
            st.put(all[i], i);

        }
        StdOut.println("Hei");
        //searching
        for (int i = 0; i < randoms.length;i++) {
            if (st.get(randoms[i]) != null)
                StdOut.println("Hit at position " + st.get(randoms[i]));

        }

    }

}
