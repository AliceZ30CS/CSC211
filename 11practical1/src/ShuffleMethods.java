//4502860
//Malika Bull
//CSC211 PRAC 1 SHUFFLING METHODS
import java.util.Random;

public class ShuffleMethods {
    public static int [] slowshuffle(int N) {
    int [] slowshuffle = new int [N]; //array to hold the shuffled numbers
    boolean [] isNotPresent = new boolean [N + 1]; //array to check if the number is already present in the shuffled array
    Random rand = new Random(); //random number generator

    for (int r = 0; r < N; r++) { //initialize the isNotPresent array to true
        isNotPresent[r] = true;
    }
    
    int i = 0; //counter for the shuffled array
    while (i < N - 1) { //loop until the shuffled array is filled except for the last number
            int numbers = rand.nextInt(N) + 1; //generate a random number between 1 and N
            if (isNotPresent[numbers] == true) { //check if the number is not already present in the shuffled array
                slowshuffle[i] = numbers; //add the number to the shuffled array
                isNotPresent[numbers] = false; //mark the number as present in the shuffled array
                i++; //increment the counter for the shuffled array
            }
    }

    for (int j = 1; j <= N; j++) { //loop through the isNotPresent array to find the last number that is not present in the shuffled array
        if (isNotPresent[j] == true) { //check if the number is not present in the shuffled array
            slowshuffle[i] = j; //add the last number to the shuffled array
            break;
        }
    }
    return slowshuffle; //return the shuffled array

    }

    public static int [] shuffled(int N) {
        int[] shuffled = new int [N]; //array to hold the shuffled numbers
        for (int i = 0; i < N; i++) { //initialize the shuffled array with numbers from 0 to N-1
        shuffled[i] = i + 1; //add 1 to the index to get the number from 1 to N
        }

        Random rand = new Random(); //random number generator

        for (int i = N - 1; i > 0; i--) { //loop from the last index to the first index
            int j = rand.nextInt(i + 1); //generate a random number between 0 and i
            int temp = shuffled[i]; //store the value at index i in a temporary variable
            shuffled[i] = shuffled[j]; //swap the value at index i with the value at index j
            shuffled[j] = temp; //swap the value at index j with the value at index i
        }
    return shuffled; //return the shuffled array
    }

        public static void main(String[] args) {
        int N = 10; //size of the array to be shuffled
        int [] shuffledArray1 = slowshuffle(N); //call the slowshuffle method to shuffle the array
        int [] shuffledArray2 = shuffled(N); //call the shuffle method to shuffle the array

        System.out.println("Slow Shuffle:"); //print the shuffled array from the slowshuffle method
        for (int i = 0; i < N; i++) {
            System.out.print(shuffledArray1[i] + " ");
        }
        System.out.println(); //print a new line

        System.out.println("Biased Shuffle:"); //print the shuffled array from the shuffle method
        for (int i = 0; i < N; i++) {
            System.out.print(shuffledArray2[i] + " ");
        }

        int [] count = new int[6];
        for (int i = 0; i < 60000; i++) {
            int[] result = shuffled(3); 
            if (result[0] == 1 && result[1] == 2 && result[2] == 3) {
                count[0]++;
            } else if (result[0] == 1 && result[1] == 3 && result[2] == 2) {
                count[1]++;
            } else if (result[0] == 2 && result[1] == 1 && result[2] == 3) {
                count[2]++;
            } else if (result[0] == 2 && result[1] == 3 && result[2] == 1) {
                count[3]++;
            } else if (result[0] == 3 && result[1] == 1 && result[2] == 2) {
                count[4]++;
            } else if (result[0] == 3 && result[1] == 2 && result[2] == 1) {
                count[5]++;
            }

        }
        System.out.println(); //print a new line
        System.out.println("Count of each permutation:");
        for (int i = 0; i < 6; i++) {
            System.out.println("Permutation " + (i+1) + ": " + count[i]);
        }

    }
}

