import java.util.*;

class Solution {
    private int getDivisor(int n) {
        int[] divisorCounts = new int[n + 1];
        int result = 1;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                divisorCounts[i]++;
            }
        }
        
        for (int k : divisorCounts) {
            if (k != 0) {
                result *= k + 1;
            }
        }
        
        return result;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] knights = new int[number];
        for (int i = 0; i < number; i++) {
            knights[i] = getDivisor(i + 1);
        }
        
        for (int i : knights) {
            if (i > limit) {
                answer += power;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}