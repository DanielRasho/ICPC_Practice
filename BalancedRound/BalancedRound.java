import java.util.*;

public class BalancedRound {
  public static void main(String[]args) {
    try (Scanner sc = new Scanner(System.in)) {
      var testCount = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i < testCount; i++) {
        var metaInfo = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var difficulties = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        var output = solveTest(metaInfo[1], difficulties);
        System.out.println(output);
      }
    }
  }

  public static String solveTest(int maxDelta, int[] difficulties) {
    if (difficulties.length <= 1) {
      return "0";
    }

    Arrays.sort(difficulties);

    int maxLength = 0;
    for(int i = 0; i < difficulties.length-1; i++) {

      int localLength = 0;
      while ((difficulties[i+1] - difficulties[i]) <= maxDelta) {
        //System.out.println(String.format("Compared %s - %s  <= %s", difficulties[i+1], difficulties[i], maxDelta));
        localLength++;
        i++;


        if (i >= (difficulties.length - 1)) {
          //System.out.println("Breaking...");
          i--;
          break;
        }
      }

      localLength++;

      if (localLength > maxLength) {
        //System.out.println(String.format("Local: %s Max: %s", localLength, maxLength));
        maxLength = localLength;
      }
    }

    return (difficulties.length - maxLength) + "";
  }
}
