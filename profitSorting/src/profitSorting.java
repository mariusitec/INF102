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
        StdOut.println("Linear Search: ");
        double averageLinearTime = 0;
        for (int i = 0; i<1000; i++) {
            Stopwatch linearWatch = new Stopwatch();
            linearSearch(intArray, randoms);
            double linearTime = linearWatch.elapsedTime();
            averageLinearTime += linearTime;
            //StdOut.println("(Linear)Time elapsed: " + linearTime + "s");
        }
        averageLinearTime = averageLinearTime/1000;
        StdOut.println("Average of 1000 runs (Linear)Time elapsed: " + averageLinearTime + "s");


        //Binary search
        StdOut.println("Binary Search: ");
        double averageBinaryTime = 0;
        for (int i = 0; i<1000; i++) {
            Stopwatch binaryWatch = new Stopwatch();
            binarySearch(intArray, randoms);
            double binaryTime = binaryWatch.elapsedTime();
            averageBinaryTime += binaryTime;

            //StdOut.println("(Binary)Time elapsed: " + binaryTime + "s");
        }
        averageBinaryTime= averageBinaryTime/1000;
        StdOut.println("Average of 1000 runs (Binary)Time elapsed: " + averageBinaryTime + "s");

    }

    public static void linearSearch(int[] all, int[] randoms) {
        //StdOut.println("Found:");
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
