// package JoJosIncredibleAdventures;

import java.util.*;

public class JoJosIncredibleAdventures {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            var testCount = sc.nextInt();
            sc.nextLine();

            for (var i=0; i < testCount; i++) {
                var testLine = sc.nextLine();
                // System.out.println("Test Line: " + testLine);
                if (!testLine.contains("1")) {
                    System.out.println(0);
                } else if (!testLine.contains("0")) {
                    System.out.println(testLine.length() * testLine.length());
                } else {
                    var max1sCount = getMaximumConsecutive1s(testLine);
                    // System.out.println(String.format("The max 1s are: %s", max1sCount));
                    System.out.println(f(max1sCount));
                }
            }
        }
    }

    public static int a(int x) {
        return (int) Math.ceil((double)x / 2.0);
    }
    public static int b(int x) {
        return (int) Math.ceil((x + 1.0) / 2.0);
    }

    public static int f(int x) {
        if (x == 1) {
            return 1;
        }

        var a = a(x);
        var b = b(x);
        // System.out.println(String.format("Calculating: %s x %s", a, b));
        return a*b;
    }

    public static int getMaximumConsecutive1s(String inputLine) {

        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < inputLine.length(); i ++ ){
            if( inputLine.charAt(i) == '0' )
                zeros.add(i);
        }

        if (zeros.size() == 1) {
            return inputLine.length() -1;
        } else {
            int max = 0;
            int maxIndex = inputLine.length() -1;
            int lastZeroIndex = zeros.get(zeros.size() - 1);
            int firstZeroIndex = zeros.get(0);

            // System.out.println(String.format("lastZeroIndex == maxIndex, %s == %s", lastZeroIndex, maxIndex)); 
            boolean isAtEdge = lastZeroIndex == maxIndex;

            if(!isAtEdge) {
                int edgesOnes = maxIndex - lastZeroIndex + firstZeroIndex;
                // System.out.println(String.format("Calculating 1s in edges: %s - %s + %s", maxIndex, lastZeroIndex, firstZeroIndex));
                if (max < edgesOnes) {
                    max = edgesOnes;
                }
            }

            int previousIndex = -1;
            for(var i = 0; i < zeros.size(); i++) {
                int onesSlice = zeros.get(i) - (previousIndex + 1);
                // System.out.println(String.format("Calculating 1s in middle: %s - %s", zeros.get(i), previousIndex +1));
                if (max < onesSlice) {
                    max = onesSlice;
                }

                previousIndex = zeros.get(i);
            }

            return max;
        }
    }

}