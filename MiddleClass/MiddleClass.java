import java.util.*;

public class MiddleClass {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            var testCount = sc.nextInt();
            sc.nextLine();

            for (var i = 0; i < testCount; i++) {
                var testInfo = sc.nextLine();
                int richBar = Integer.parseInt( testInfo.split(" ")[1] );
                String savingsInput = sc.nextLine();

                // System.out.println(String.format("BAR: %s Savings: %s", richBar, savingsInput));

                int[] savings = Arrays.stream(savingsInput.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                // System.out.println("\n");

                var maxRich = RayoMethod(savings, richBar);
                System.out.println(maxRich);
            }
        }
    }
        public static int RayoMethod(int[] savings, int richBar) {
        
        Arrays.sort(savings);

        int maxRichPeople = 0;

        double savingsSum = 0; 
        int peopleChecked = 1;

        int searchIndex = savings.length - 1;

        while(searchIndex >= 0){
            int personSavings = savings[searchIndex];

            if( personSavings < richBar ){
                // System.out.println(
                //    String.format("SavingsSum = %d MaxRichPeople = %d SearchIndex = %d " 
                //    ,savingsSum, maxRichPeople, searchIndex));
                break;
            }

            savingsSum += savings[searchIndex];
            maxRichPeople++;
            peopleChecked++;

            searchIndex--;
        }

        for(; searchIndex >= 0; searchIndex--){
            savingsSum += savings[searchIndex];

            // System.out.println(
            //     String.format("SavingsSum = %f MaxRichPeople = %d PeopleChecked = %d " 
            //     ,savingsSum, maxRichPeople, peopleChecked));

            double newAverageWealth = savingsSum / (peopleChecked);

            // System.out.println(
            //     String.format("Average = %f" ,newAverageWealth));

            // System.out.println( newAverageWealth );

            if (newAverageWealth < richBar) {
                // System.out.println(
                //     String.format("Breack for average:  %f " 
                //     ,savingsSum));
                break;
            }

            maxRichPeople++;
            peopleChecked++;

        }
        // System.out.println(String.format("maxRichPeople: %d people: %d", maxRichPeople, peopleChecked));
        return maxRichPeople;
    }
}
