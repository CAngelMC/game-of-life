import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();

        int m = scanner.nextInt();

        boolean isNextTo = false;
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == n && numbers[i + 1] == m) {
                isNextTo = true;
                break;
            }

            if(numbers[i] == m && numbers[i + 1]== n) {
                isNextTo = true;
                break;
            }
        }

        System.out.println(!isNextTo);
    }
}
