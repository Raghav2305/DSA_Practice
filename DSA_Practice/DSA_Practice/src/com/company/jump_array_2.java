// We shift goalpost to the previous locations every time we can reach 
// the end element from the previous element.
package com.company;

class Jump_array {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 1, 4 };
        int ans = jump(arr);
        System.out.println(ans);
    }

    public static int jump(int arr[]) {
        int res = 0;
        int l = 0;
        int r = 0;

        while (r < arr.length - 1) {
            int farthest = 0;
            for (int i = l; i < r + 1; i++) {
                farthest = Math.max(farthest, i + arr[i]);
            }

            l = r + 1;
            r = farthest;
            res += 1;
        }
        return res;
    }
}
