import java.util.*;

public class DejaVu {

  static class TestCase {
    public List<Long> Xs;
    public List<Long> As;
  
    public TestCase(List<Long> xs, List<Long> as)  {
      Xs = new ArrayList<>(xs);
      As = new ArrayList<>(as);

      Xs.sort(Long::compareTo);
    }
  
    public void showModifications() {
      Map<Integer, Long> cache = new HashMap<>();

      for (int j = 0; j < As.size(); j++) {
          final var a_i = As.get(j);

          for( int i = 0; i < Xs.size(); i++){
            final var x_i = Xs.get(i);
            System.out.println(String.format("X_i: %s", x_i));
            
            if(!cache.containsKey(i)) {
              cache.put(i, Math.round(Math.pow(2, x_i)));
            }
            final long divisor = cache.get(i);

            final boolean isDividible = a_i % divisor == 0;
            if (!isDividible){
              break;
            }

            final long power = divisor / 2;
            final long new_a = a_i+power;
  
            As.set(j , new_a);
          }
      }

      // for( int i = 0; i < Xs.size(); i++){

      //   final var x_i = Xs.get(i);
      //   final long divisor = Math.round(Math.pow(2, x_i));

      //   for (int j = 0; j < As.size(); j++) {
      //     final var a_i = As.get(j);
      //     if (a_i % 2 != 0) {
      //       continue;
      //     }
          
      //     // System.out.println(String.format("a_i: %s\tx_i: %s", a_i, x_i));

      //     final boolean isDividible = a_i % divisor == 0;
      //     //System.out.println(String.format("Divisor: %s\t%s", divisor, isDividible));
  
      //     if (isDividible){
      //       final long power = divisor / 2;
      //       final long new_a = a_i+power;
  
      //       // System.out.println(String.format("power: %s\tnew_a: %s", power, new_a));
  
      //       As.set(j , new_a);
      //     }
      //   }
      // }
  
      for (long a: As) {
        System.out.print(String.format("%s ", a));
      } 
    }
  }

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
