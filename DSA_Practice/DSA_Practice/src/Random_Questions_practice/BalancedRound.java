////package Random_Questions_practice;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class BalancedRound {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int cases = sc.nextInt();
//        sc.nextLine();
//
//        while(cases > 0){
//            cases--;
//
//
//            int numOfProblems = sc.nextInt();
//            int diff = sc.nextInt();
//            sc.nextLine();
//            int [] difficulty = new int[numOfProblems];
//            int[] diff_arr = new int[numOfProblems];
//            for (int i = 0; i < numOfProblems; i++) {
//                int difficult = sc.nextInt();
//                difficulty[i] = difficult;
//            }
//            Arrays.sort(difficulty);
//            for (int i = 0; i < difficulty.length; i++) {
//                int count = 0;
//                for (int j = 0; j <difficulty.length ; j++) {
//                 if( Math.abs(difficulty[j] - difficulty[i]) > diff){
//                     count ++;
//                     diff_arr[i] = count ;
//                 }
//                }
//            }
//
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < diff_arr.length; i++) {
//                if(diff_arr[i] < min){
//                    min = diff_arr[i];
//                }
//            }
//
//            System.out.println(min);
//
//        }
//
//    }
//
//
//}
//
package Random_Questions_practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class BalancedRound{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();

        while(cases > 0) {
            cases--;
            int numOfProblems = sc.nextInt();
            int diff = sc.nextInt();
            sc.nextLine();
            int[] difficulty = new int[numOfProblems];
            for (int i = 0; i < numOfProblems; i++) {
                int difficult = sc.nextInt();
                difficulty[i] = difficult;
            }
            Arrays.sort(difficulty);
            int val=1;
            for (int i = 1, x=1; i <numOfProblems ; i++) {
                if(Math.abs(difficulty[i] - difficulty[i-1]) <=diff){
                    x++;
                }else{
                    x = 1;
                }
                val = Math.max(val, x);
            }
            System.out.println(numOfProblems- val);
        }

    }
}