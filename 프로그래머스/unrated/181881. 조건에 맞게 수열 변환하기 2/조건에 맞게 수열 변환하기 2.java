import java.util.*;

class Solution {
    public int getNum(int n) {
        int count = 0;
        while ((n >= 50 && n % 2 == 0)||(n < 50 && n % 2 != 0)) {
                if (n >= 50 && n % 2 == 0) {
                    n /= 2;
                } else if (n < 50 && n % 2 != 0) {
                    n = 2 * n + 1; 
                }
            count += 1;
            }
        return count;
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        for (int i : arr) {
            answer = Math.max(answer, getNum(i));
        }
        
        return answer;
    }
}