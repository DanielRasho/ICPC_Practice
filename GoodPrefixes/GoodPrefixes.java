import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GoodPrefixes {

  public static void main (String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      final int tests = sc.nextInt();
      sc.nextLine();
      //System.out.println(tests);

      for( int i = 0; i < tests; i++) {
        int prefixes = 0;
        long total = 0;
        int length = sc.nextInt();
        long max = 0;

        for( int j = 0; j < length; j++ ) {
          long number = sc.nextLong();

          // System.out.println(number);
          if ( number > max ) {
            total += max;
            max = number;
          } else {
            total += number;
          }
          if (total == max) {
            prefixes++;
          }
          // System.out.println(String.format("total: %d max: %d", total, max));
        }

        // System.out.println("--------");
        System.out.println(prefixes);
        // System.out.println("========");

      }
    }
  }
}
