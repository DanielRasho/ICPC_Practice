import java.util.*;

public class Ugu {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      var testCount = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i<testCount; i++) {
        sc.nextInt();
        sc.nextLine();
        var line = sc.nextLine();
        var output = handleTest(line);

        System.out.println(output);
      }
    }
  }

  public static String handleTest(String line) {
    int operationCount =0;
    int erroneousIndex = 0;
    var cases = new String[] {
      "10",
      "01"
    };

    int previous = 0;
    while ((previous = line.indexOf(cases[erroneousIndex % 2], previous)) != -1) {
      operationCount++;
      erroneousIndex++;
    }


    return operationCount+"";
  }
}
