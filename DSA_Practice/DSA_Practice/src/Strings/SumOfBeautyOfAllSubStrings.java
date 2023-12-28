package Strings;
class SumOfBeautyOfAllSubStrings {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++){
            int[] windowCount = new int[26];

            for (int j = i; j < n; j++) {
                windowCount[s.charAt(j) - 'a']++;
                sum += calculateBeauty(windowCount);
            }

        }
        return sum;
    }

    public int calculateBeauty(int [] windowCount) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int freq: windowCount){
            if(freq > max){
                max = freq;
            }
            if(freq > 0 && freq < min){
                min = freq;
            }
        }
        return max - min;
    }
}