package Algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSequence {

    private static final long time = System.currentTimeMillis();

    private static long count = 0;

    private static final int inputSize = 5;

    private static boolean[] table = new boolean[inputSize * 2 + 1];

    private static boolean[] isUsed = new boolean[inputSize + 1];

    private static List<Integer> stack = new ArrayList<Integer>();

    private static boolean isPrime(int num) {
        int i = 2;
        while (i <= num / 2) {
            if (num % i == 0) {
                return false;
            }
            i = i + 1;
        }
        if (i == num / 2 + 1) {
            return true;
        }
        return false;
    }

    private void primeTable() {
        table[2] = true;
        for (int i = 1; i <= inputSize * 2; i = i + 2) {
            table[i] = isPrime(i);
        }
        
		System.out.println(Arrays.toString(table));
        
    }

    public static void main(String[] args) {

        PrimeSequence ps = new PrimeSequence();
        ps.primeTable();
        ps.generate();
        System.out.println("\nTotal No of Seq : " + count);
        System.out.println("Total Time : " + (System.currentTimeMillis() - time) + "(ms)");
    }


    private void generate() {

        if (stack.size() == inputSize) {
            count++;
            processSolution();
        }
        for (int i = 1; i <= inputSize; i++) {
        	
        	System.out.println(i+": ("+stack.isEmpty() + ") || ("+!isUsed[i]+" && "+(stack.size() - 1+1)+")");
            if (stack.isEmpty() || !isUsed[i] && table[stack.get(stack.size() - 1) + i]) {
                makeMove(i);
                generate();
                unmakeMove();
            }
        }
    }

    private void makeMove(int ele) {
        stack.add(ele);
        isUsed[ele] = true;
    }

    private void unmakeMove() {
        int ele = stack.remove(stack.size() - 1);
        isUsed[ele] = false;
    }

    private void processSolution() {
        System.out.print("\n\n\n Result : " + (System.currentTimeMillis() - time) + "(ms) : No " + count + " : " + stack);
    }
}