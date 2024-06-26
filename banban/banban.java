import java.util.*;

public class banban {
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      int testcases = sc.nextInt();
      sc.nextLine();

      for(int i = 0; i < testcases; i++) {
        int test = sc.nextInt();
        sc.nextLine();

        if ( test == 1 ) {
          System.out.println(1);
          System.out.println(
            String.format("%d %d", 2, 3)
          );
          continue;
        }

        int m = (int) Math.ceil(test / 2.0);
        System.out.println(m);

        for(int j = 0; j < m ; j++) {
          int a = 1 + 3 * j ;
          int b = 3 * test - 3 * j;
          System.out.println(
            String.format("%d %d",a, b)
          );
        }
      }
    }
  }
}
