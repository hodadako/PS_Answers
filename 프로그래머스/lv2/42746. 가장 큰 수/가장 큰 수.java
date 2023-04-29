import java.util.*;

class Solution {
    String[] orderDesc(String[] arr) {
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        return arr;
    }
    
    public String solution(int[] numbers) {
        int count = 0;
        String answer = "";
        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
            count += numbers[i];
        }
        orderDesc(temp);
        for (int i = 0; i < numbers.length; i++) {
            answer += temp[i];
        }
        if (count == 0) {
            answer = "0";
        }
        return answer;
    }
}