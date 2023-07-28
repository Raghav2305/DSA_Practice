package Random_Questions_practice;

import java.util.ArrayList;

public class CreatePartition {
    public static void main(String[] args) {
        int [] arrayOfIntegers  = {2,6,4,0,8,7,1,5,3,9};
        String operation = "+";
        int result = 8;

        ArrayList<ArrayList<Integer>> res = Partition(operation, result, arrayOfIntegers);

        for(ArrayList<Integer> k : res){
            System.out.println(k);
        }
    }

    public static ArrayList<ArrayList<Integer>> Partition(String operation, int result, int[] arr){
        if(arr.length % 2 != 0){
            System.out.println("Invalid Input"); // we need only even numbered array
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int arr_length = arr.length;
//        int[][] ans = new int[arr.length][arr.length];

        for (int i = 0; i <= arr.length - 2; i++) {
            if(operation.equals("+")){
                if(arr[i] + (arr[i +1]) == result){
                    ans.add(new ArrayList<Integer>());
                    ans.get(ans.size()).add(arr[i]);
                    ans.get(ans.size()).add(arr[i + 1]);
                }
            }if(operation.equals("-")){
                if(arr[i] - (arr[i +1]) == result){
                    ans.add(new ArrayList<>());
                    ans.get(ans.size()).add(arr[i]);
                    ans.get(ans.size()).add(arr[i + 1]);
                }
            }if(operation.equals("*")){
                if(arr[i] * (arr[i +1]) == result){
                    ans.add(new ArrayList<>());
                    ans.get(ans.size()).add(arr[i]);
                    ans.get(ans.size()).add(arr[i + 1]);
                }
            }if(operation.equals("/")){
                if(arr[i] / (arr[i +1]) == result){
                    ans.add(new ArrayList<>());

                    ans.get(ans.size()).add(arr[i]);
                    ans.get(ans.size()).add(arr[i + 1]);
                }
            }
        }
        if (ans.size() == 0){
            System.out.println("NUll");
        }
        return ans;
    }
}
