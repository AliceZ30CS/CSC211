//Malika Bull 
//CSC211 12practical
//4502860
import java.util.Random;

public class GrowthFunctions {
    
    // Count version - returns the count
    public static long mcsOn3WithCount(int[] X) {
        int n = X.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    count++;  // Count the core operation
                }
            }
        }
        return count;  // Return count, not maxsofar
    }

    public static long mcsOn2AWithCount(int[] X) {
        int n = X.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                count++;  // Count the core operation
            }
        }
        return count;
    }

    public static long mcsOn2BWithCount(int[] X) {
        int n = X.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                count++;  // Count the core operation
            }
        }
        return count;
    }

    public static long mcsOnWithCount(int[] X) {
        int N = X.length;
        long count = 0;
        for (int i = 0; i < N; i++) {
            count++;  // Count the core operation
        }
        return count;
    }

    public static int[] generateArray(int n) {
        int[] X = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < n; i++) {
            int sign = (rand.nextBoolean()) ? 1 : -1;
            X[i] = rand.nextInt(1, n + 1) * sign;
        }
        
        return X;
    }

    public static void main(String[] args) {
        System.out.println("n\t\tO(n³)\t\tO(n²)A\t\tO(n²)B\t\tO(n)");
        System.out.println("-------------------------------------------------------");
        
        int[] sizes = {100, 1000, 10000, 100000};  // Skip 1000000 for O(n³) - it will take too long!
        
        for (int size : sizes) {  // Changed variable name to avoid conflict
            int[] X = generateArray(size);
            
            long count1 = mcsOn3WithCount(X);
            long count2A = mcsOn2AWithCount(X);
            long count2B = mcsOn2BWithCount(X);
            long countN = mcsOnWithCount(X);
            
            System.out.println(size + "\t\t" + count1 + "\t\t" + count2A + "\t\t" + count2B + "\t\t" + countN);
        }
    }
}