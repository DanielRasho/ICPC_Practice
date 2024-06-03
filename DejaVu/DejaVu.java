import java.util.*;

class TestCase {
  public List<Long> Xs;
  public List<Long> As;

  public TestCase(List<Long> xs, List<Long> as)  {
    Xs = new ArrayList<>(xs);
    As = new ArrayList<>(as);
  }

  public void showModifications() {
    for( int i = 0; i < Xs.size(); i++){
      for (int j = 0; j < As.size(); j++) {
        final var a_i = As.get(j);
        final var x_i = Xs.get(i);

        // System.out.println(String.format("a_i: %s\tx_i: %s", a_i, x_i));

        final long divisor = Math.round(Math.pow(2, x_i));
        final boolean isDividible = a_i % divisor == 0;
        //System.out.println(String.format("Divisor: %s\t%s", divisor, isDividible));

        if (isDividible){
          final var power = Math.round(Math.pow(2, x_i - 1));
          final var new_a = a_i+power;

          // System.out.println(String.format("power: %s\tnew_a: %s", power, new_a));

          As.set(j , new_a);
        }
      }
    }

    for (long a: As) {
      System.out.print(String.format("%s ", a));
    } 
  }
}

class DejaVu {

  public static void main (String[] args) {
    try (Scanner sc = new Scanner(System.in)) {

      var testCount = sc.nextInt();
      sc.nextLine();

      
      List<TestCase> tests = new ArrayList<>(testCount);
      for (int i = 0; i < testCount; i++) {
        var inputLengths = sc.nextLine().split(" ");

        var as = Arrays.asList(sc.nextLine().split(" ")).stream().map(Long::parseLong).toList();
        var xs = Arrays.asList(sc.nextLine().split(" ")).stream().map(Long::parseLong).toList();
        
        tests.add(new TestCase( xs, as ));
      }

      tests.stream().forEach(t -> {
         t.showModifications();
         System.out.println("");
      });
      
    }
    
    

  }

  
}
