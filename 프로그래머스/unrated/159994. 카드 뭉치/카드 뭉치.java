import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int n = 0, m = 0;
        for (int i = 0; i < goal.length; i++) {
            if (n < cards1.length) {
                if (goal[i].equals(cards1[n])) {
                    n++;
                }
            }
            if (m < cards2.length) {
                if (goal[i].equals(cards2[m])) {
                    m++;
                } 
            }
        }
        
        String result = "";
        if (n + m == goal.length) {
            result = "Yes";
        } else {
            result = "No";
        }
        return result;
    }
}