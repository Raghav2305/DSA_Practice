package Random_Questions_practice;


import java.util.Scanner;

public class TenWordWisdom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases  =scanner.nextInt();


        while(cases > 0){
            cases-- ;

            int responses = scanner.nextInt();
            int most = -1, index = -1;
            for (int i = 0; i < responses; i++) {
                int words = scanner.nextInt();
                int quality = scanner.nextInt();

                if(words <=10 && quality > most){
                    most = quality;
                    index = i;
                }
            }
            System.out.println(index + 1);
        }
        scanner.close();
    }
}
