package AB02;
import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);

    private static void calculateCollatz(int startingPoint) {
        int currentValue = startingPoint;

        while (currentValue != 1) {
            if (currentValue % 2 == 0) {
                currentValue /= 2;
                System.out.print(currentValue + " ");
            } else {
                currentValue = currentValue * 3 + 1;
                System.out.print(currentValue + " ");
            }
        }
    }

    private static void funktionaleCollatz(int currentValue) {
        if (currentValue != 1) {
            if (currentValue % 2 == 0) {
                System.out.print(currentValue / 2 + " ");
                funktionaleCollatz(currentValue / 2);
            } else {
                System.out.print(currentValue * 3 + 1 + " ");
                funktionaleCollatz(currentValue * 3 + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Geben Sie den Startpunk ein. ");
        int number = scanner.nextInt();
        calculateCollatz(number);
        System.out.println("");
        funktionaleCollatz(number);
    }
}
