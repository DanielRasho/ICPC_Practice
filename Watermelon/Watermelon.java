import java.io.*;
import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int weight = input.nextInt();
        input.close();

        if (weight < 0) {
            System.out.println("NO");
            return;
        }
        
        if (IsEven(weight))
            System.out.println("YES");
        else 
            System.out.println("NO");
        
    }

    public static boolean IsEven(int number) {
        if (number == 1 || number == 2) {
            return false;
        }

        return number % 2 ==0;
    }
}