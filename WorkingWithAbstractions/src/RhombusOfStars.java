import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            printRow(i, n - 1);
        }
        for (int i = n - 1; i > 0 ; i--) {
            printRow(i, n - 1);
        }
    }

    private static void printRow(int numbersOfStars, int numbersOfLeadingSpaces){
        for (int i = 0; i < numbersOfLeadingSpaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < numbersOfStars; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
