import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DeathNote {

  public static void main (String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      String[] initialInfo = sc.nextLine().split(" ");
      final int days = Integer.parseInt(initialInfo[0]);
      final int namesPerPage = Integer.parseInt(initialInfo[1]);
      final int[] names = Arrays.stream(sc.nextLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

      int r = 0;

      for (int i = 0; i < names.length; i ++) {
        int a = (names[i] + r) / namesPerPage;
        r = (names[i] + r) % namesPerPage;
        // System.out.println(a);
        // System.out.println(r);
        // System.out.println("=========");
        System.out.print( Integer.toString(a) + " ");
      }


    } catch (Exception e) {
      System.out.println(e.toString());
    }

  }

}
