import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GravityFlip {
    public static void main (String[] args){
        try(Scanner scan = new Scanner(System.in)) {
            var numberOfColumns = scan.nextInt();
            List<Integer> columns = new ArrayList<>(numberOfColumns);

            scan.nextLine();
            var stringColumns = scan.nextLine().split(" ");
            for (String stringColumnCount: stringColumns) {
                columns.add(Integer.parseInt(stringColumnCount));
            }

            columns.sort(Integer::compareTo);
            
            StringBuilder sb = new StringBuilder();
            for (int col : columns) {
                sb.append(col + " ");
            }

            System.out.println(sb.toString());            
        }
    }
}
