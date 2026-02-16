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

    public static long mcsOn3WithCount(int [] X) {
        int n = X.length;
        int maxsofar = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += X[k];
                    count++;
                }
                if (sum > maxsofar) {
                    maxsofar = sum;
                }
            }
        }
        System.out.println("Count: " + count);
        return maxsofar;
    }

    public static void main(String[] args) {
        int n = 20;
        int [] X = new int[n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int sign = (rand.nextInt(2, 4) % 2 == 0) ? -1 : 1;
            X[i] = rand.nextInt(1,n + 1) * sign;
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

        public static void main(String[] args) {
        System.out.println("n        O(n³)        O(n²)A       O(n²)B       O(n)");
    System.out.println("-------------------------------------------------------");
    
    int[] sizes = {100, 1000, 10000, 100000, 1000000};
    
    for (int n : sizes) {
        int[] X = generateArray(n);
        
        System.out.print(n + "     ");
        System.out.print(mcsOn3WithCount(X) + "     ");
        System.out.print(mcsOn2AWithCount(X) + "     ");
        System.out.print(mcsOn2BWithCount(X) + "     ");
        System.out.println(mcsOnWithCount(X));
    }
}

    }
    
}
