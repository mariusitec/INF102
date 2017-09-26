import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;
import java.util.Set;

public class exactTriplicates {

    //FOR PERFORMANCE TESTING
    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        String[] tabell1 = {"martin", "othilie", "petter", "helge"};
        String[] tabell2 = {"espen", "martin", "martin", "stian"};
        String[] tabell3 = {"othilie", "marius", "oda", "petter"};
        String[] tabell4 = {"iver", "lars", "othilie", "petter"};

        //remove duplicates
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        Set<String> set4 = new HashSet<>();

        for (String s : tabell1)
            set1.add(s);
        for (String s : tabell2)
            set2.add(s);
        for (String s : tabell3)
            set3.add(s);
        for (String s : tabell4)
            set4.add(s);

        String[] done1 = set1.toArray(new String[set1.size()]);
        String[] done2 = set2.toArray(new String[set2.size()]);
        String[] done3 = set3.toArray(new String[set3.size()]);
        String[] done4 = set4.toArray(new String[set4.size()]);

        String[] merged = new String[done1.length + done2.length + done3.length + done4.length];

        System.arraycopy(done1, 0 , merged, 0, done1.length);
        System.arraycopy(done2, 0 , merged, done1.length, done2.length);
        System.arraycopy(done3, 0 , merged, done1.length*2 - 1, done3.length);
        System.arraycopy(done4, 0 , merged, done1.length*3 - 1, done4.length);

        UBST<String,Integer> st = new UBST<>();

        for (int i = 0; i < merged.length; i++) {
            String key = merged[i];
            Integer j = st.get(key);
            if (j != null) st.put(key, j + 1);
            else st.put(key, 1);
        }
        for (int i = 0; i < merged.length; i++) {
            if (st.get(merged[i]).equals(Integer.parseInt("3"))) {
                StdOut.println(merged[i] + " is the lexicographically first occurance of a name that appears in three lists");
                break;
            }
        }

        //FOR PERFORMANCE TESTING
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime-startTime;
        StdOut.println("Runtime: " + elapsedTime + "ms");

        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
    }
}
