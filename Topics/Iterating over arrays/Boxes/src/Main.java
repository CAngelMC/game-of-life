import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        int box1BiggersSides = 0;
        int box2BiggersSides = 0;

        for (int i = 0; i < 3; i++) {
            box1[i] = scanner.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            box2[i] = scanner.nextInt();
        }

        Arrays.sort(box1);
        Arrays.sort(box2);

        for (int i = 0; i < 3; i++) {
            if (box1[i] > box2[i]) {
                box1BiggersSides++;
            } else if (box1[i] < box2[i]){
                box2BiggersSides++;
            }
        }

        if (box1BiggersSides == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (box2BiggersSides == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}
