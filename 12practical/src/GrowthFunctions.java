import java.util.Random;

public class GrowthFunctions {
    public static int mcsOn3(int[] X) {
        int n = X.length;
        int maxsofar = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += X[k];
                }
                if (sum > maxsofar) {
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;    
    }

    public static int mcsOn2A(int [] X) {
        int n = X.length;
        int maxsofar = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += X[j];
                if (sum > maxsofar) {
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;
    }

    public static int mcsOn2B(int [] X) {
        int n = X.length;
        int[] sumTo = new int[n + 1];
        sumTo[0] = 0;
        for (int i = 0; i < n; i++) {
            sumTo[i + 1] = sumTo[i] + X[i];
    }
        int maxsofar = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sumTo[j + 1] - sumTo[i];
                if (sum > maxsofar) {
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;
    }

    public static int msconOn(int [] X) {
        int N = X.length;
        int maxsofar = 0;
        int maxToHere = 0;
        for (int i = 0; i < N; i++) {
            maxToHere = Math.max(0, maxToHere + X[i]);
            maxsofar = Math.max(maxsofar, maxToHere);
        }
        return maxsofar;
    }

    public static void main(String[] args) {
        int n = 20;
        int [] X = new int[n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            X[i] = rand.nextInt(1, n) * (-1) ^ rand.nextInt(2,4);
        }
        
        int countP = 0; 
        int countM = 0; 
        
        for (int i = 0; i < n; i++) {
            if (X[i] > 0) {
                countP++;
            } else if (X[i] < 0) {
                countM++;
            }
        }
        System.out.println("Positive numbers: " + countP);
        System.out.println("Negative numbers: " + countM);
    }
}
