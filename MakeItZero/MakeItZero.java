import java.util.*;

public class MakeItZero {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      var testCount = sc.nextInt();
      sc.nextLine();

      for (var i = 0; i < testCount; i++) {
        var n = sc.nextInt();
        sc.nextLine();
        sc.nextLine();

        if (n %2 == 0) {
          var move = String.format("%s %s", 1, n);

          System.out.println(2);
          System.out.println(move);
          System.out.println(move);
        } else {
          System.out.println(4);
          System.out.println(1+ " " + n);
          System.out.println(2+ " " + n);
          System.out.println(1+ " " + 2);
          System.out.println(1+ " " + 2);
        }
      }
    }
  }
}
