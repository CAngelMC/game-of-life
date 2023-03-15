import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int listLength = scanner.nextInt();
        int[] list = new int[listLength];
        for (int i = 0; i < listLength; i++) {
            list[i] = scanner.nextInt();
        }
        int numberToFind = scanner.nextInt();
        int timesThatNumberIsInList = 0;

        for (int i = 0; i < listLength; i++) {
            if (list[i] == numberToFind) {
                timesThatNumberIsInList++;
            }
        }
        System.out.println(timesThatNumberIsInList);
    }
}
