package Random_Questions_practice;

import java.util.Scanner;

public class CheckEvenness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            int differentIndex = findDifferentIndex(numbers);
            System.out.println(differentIndex);
        }

        scanner.close();
    }

    public static int findDifferentIndex(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
                evenIndex = i;
            } else {
                oddCount++;
                oddIndex = i;
            }


            if (evenCount > 0 && oddCount > 0) {
                break;
            }
        }


        if (evenCount == 1) {
            return evenIndex + 1;
        } else {
            return oddIndex + 1;
        }
    }
}
