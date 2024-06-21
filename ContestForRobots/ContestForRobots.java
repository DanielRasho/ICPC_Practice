import java.util.*;

public class ContestForRobots {
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      var problemCount = sc.nextInt();
      sc.nextLine();
      var gustavoProblems = sc.nextLine().split(" ");
      var irvingProblems = sc.nextLine().split(" ");

      int count_01 = 0;
      int count_10 = 0;
      for (int i = 0; i < problemCount; i++) {
        if (gustavoProblems[i].equals("1") && irvingProblems[i].equals("0")) {
          count_10++;
        } else if (gustavoProblems[i].equals("0") && irvingProblems[i].equals("1")) {
          count_01++;
        }
      }

      if (count_10 == 0) {
        System.out.println(-1);
      } else if (count_10 > count_01) {
        System.out.println(1);
      } else {
        double division = (count_01+0.0) / (count_10+0.0);
        //System.out.println(String.format("%s / %s = %s", count_01, count_10, division));
        System.out.println(String.format("%s", 1+(int)Math.floor(division)));
      }
    }
  }
}
