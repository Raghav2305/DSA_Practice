//This is a greedy approach and fails in most edge cases

//package Stacks_and_Queues;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class GameOf2Stacks {
//    static int TwoStacks(int maxSum, int[] A, int[] B){
//        return twoStacksHelper(maxSum, A, B, 0,0) - 1;
//    }
//
//    private static int twoStacksHelper(int maxSum, int[] a, int[] b, int sumSoFar, int count) {
//        if(sumSoFar > maxSum){
//            return count;
//        }
//
//        if(a.length == 0 || b.length == 0){
//            return count;
//        }
//
//        int ansFromA = twoStacksHelper(maxSum, Arrays.copyOfRange(a, 1, a.length), b, sumSoFar + a[0], count + 1);
//        int ansFromB = twoStacksHelper(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sumSoFar + b[0], count + 1);
//
//        return Math.max(ansFromA, ansFromB);
//    }
//
//    public static void main(String[] args) {
//            Scanner s = new Scanner(System.in);
//            int t = s.nextInt();
//            for (int i = 0; i < t; i++) {
//                int n = s.nextInt();
//                int m = s.nextInt();
//                int x = s.nextInt();
//                int[] a = new int[n];
//                int[] b = new int[m];
//                for (int j = 0; j < n; j++) {
//                    a[j] = s.nextInt();
//                }
//                for (int j = 0; j < m; j++) {
//                    b[j] = s.nextInt();
//                }
//                System.out.println(TwoStacks(x, a, b));
//            }
//
//    }
//}

//This is the efficient solution which takes element from the first stack and adds to the sum. then it checks for the elements from the other stack and adds it too. if the sum exceeds the max_sum then elements from the first stack are removed and the sum is adjusted to come down below the required maxSum

package Stacks_and_Queues;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Two_Stacks{
   public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b){
       int result = 0, st1_count = 0, st2_count = 0, total_sum = 0;

       // Get elements from first stack
       for (Integer st1_element : a) {
           if (total_sum + st1_element > maxSum)
               break;
           total_sum += st1_element;
           st1_count++;
       }
       result = st1_count;

       // Try to use elements of second stack
       for (Integer st2_element : b) {
           total_sum += st2_element;
           st2_count++;
           while (total_sum > maxSum && st1_count > 0) {
               total_sum -= a.get(st1_count - 1);
               st1_count--;
           }
           result = (total_sum <= maxSum) ?
                   Math.max(st1_count + st2_count, result) : result;
       }

       return result;

   }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            for (int i = 0; i < t; i++) {
                int n = s.nextInt();
                int m = s.nextInt();
                int x = s.nextInt();
                List<Integer> a = new ArrayList<>(n);
                List<Integer> b = new ArrayList<>(m);
//                int[] a = new int[n];
//                int[] b = new int[m];
                for (int j = 0; j < n; j++) {
//                    a[j] = s.nextInt();
                    a.add(j, s.nextInt());
                }
                for (int j = 0; j < m; j++) {
//                    b[j] = s.nextInt();
                    b.add(j, s.nextInt());
                }
                System.out.println(twoStacks(x, a, b));
    }}
}

