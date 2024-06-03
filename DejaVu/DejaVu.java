import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DejaVu {

  static class TestCase {
    private List<Integer> Xs;
    private List<Integer> As;

    public TestCase(List<Integer> xs, List<Integer> as)  {
      Xs = new ArrayList<>(xs);
      As = new ArrayList<>(as);
    }

    public void showModifications() {

      int[] cache = new int[31];

      final var modifiedList = As.stream().map(a_j -> {
        if (a_j % 2 != 0) {
          return a_j;
        }

        // a_i may change depending on the modification
        int new_a = a_j;

        for( int i = 0; i < Xs.size(); i++) {
          final var x_i = Xs.get(i);
          if (cache[x_i] == 0) {
            cache[x_i] = 0b1 << x_i;
          }
          final int divisor = cache[x_i];

          final boolean isDivisor = new_a % divisor == 0;
          if (!isDivisor) {
            continue;
          }

          if (cache[x_i -1] == 0) {
            cache[x_i -1] = 0b1 << (x_i -1);
          }

          final int power = cache[x_i -1];
          new_a += power;
        }

        return new_a;
      }).toList();

      for (long a: modifiedList) {
        System.out.print(String.format("%s ", a));
      }
    }
  }

  public static void main (String[] args) {
    //System.out.println(String.format("%s", 2% 1024));

    try (Scanner sc = new Scanner(System.in)) {

      var testCount = sc.nextInt();
      sc.nextLine();


      List<TestCase> tests = new ArrayList<>(testCount);
      for (int i = 0; i < testCount; i++) {
        sc.nextLine().split(" ");

        var as = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).toList();
        var xs = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).toList();

        tests.add(new TestCase( xs, as ));
      }

      tests.stream().forEach(t -> {
        t.showModifications();
        System.out.println();
        //System.out.println();
      });

    }
  }
}
