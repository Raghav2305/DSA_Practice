package Random_Questions_practice;

import java.util.Scanner;

public class ToMyCritics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test_cases = scanner.nextInt();


        while(test_cases >0){
            test_cases--;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if((a <=9 && a >=0) && (b <=9 && b >=0) && (c <=9 && c >=0)){
                if(a + b >= 10) System.out.println("YES");
                else if(b + c >= 10) System.out.println("YES");
                else if(a + c >=10) System.out.println("YES");
                else System.out.println("NO");
            }


        }
        scanner.close();

    }
}
