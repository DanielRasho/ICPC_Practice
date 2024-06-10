import java.util.*;

public class UniqueNumber {
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      var testCount = sc.nextInt();
      sc.nextLine();

      for (var i = 0; i < testCount; i++) {
        var x = sc.nextInt();
        sc.nextLine();

        var output = new StringBuilder(10);
        var printedMinus1 = false;
        for (var j = 9; j > 0; j--) {

          var remaining = x - j;

          if (remaining == 0) {
            output.append(j);
            x = x-j;
            break;
          }

          if (remaining > 0) {
            output.append(j);
            x = x-j;
          }

          if (j == 1) {
            System.out.println(-1);
            printedMinus1 = true;
          }
        }

        if (!printedMinus1) {
          System.out.println(output.reverse().toString());
        }
      }
    }
  }
}
