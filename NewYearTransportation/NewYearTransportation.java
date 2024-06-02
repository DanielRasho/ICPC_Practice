import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class NewYearTransportation {
    public static void main(String args[]) {
        try(Scanner sc = new Scanner(System.in)) {
            String[] initialInfo = sc.nextLine().split(" ");
            final int cellsQuantity = Integer.parseInt(initialInfo[0]);
            final int targetCell = Integer.parseInt(initialInfo[1]);
            
            List<Integer> portalJumps = Arrays
                .asList(sc.nextLine().split(" "))
                .stream().map(Integer::parseInt)
                .toList();

            int currentCell = 1;
            while (true) {
                int nextCell = currentCell + portalJumps.get(currentCell - 1);
                System.out.println(String.format("Jumping from {%s} to {%s}", currentCell, nextCell));

                if (nextCell < targetCell) {
                    currentCell = nextCell;
                    continue;
                }

                if (nextCell == targetCell){
                    System.out.println("YES");
                } else if (nextCell > targetCell) {
                    System.out.println("NO");
                }

                break;
            }
        }
    }
}