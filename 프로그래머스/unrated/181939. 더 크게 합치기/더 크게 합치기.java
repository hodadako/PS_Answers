import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        int tmp1 = Integer.parseInt(aStr + bStr);
        int tmp2 = Integer.parseInt(bStr + aStr);
        
        if (tmp1 >= tmp2) {
            answer = tmp1;
        } else {
            answer = tmp2;
        }
        
        return answer;
    }
}