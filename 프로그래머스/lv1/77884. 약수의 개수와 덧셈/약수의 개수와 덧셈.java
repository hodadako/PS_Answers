import java.util.*;

class Solution {
    public boolean check (int n) {
        int total = 1;
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int cur = 0;
            while (n % i == 0) {
                n /= i;
                cur += 1;
            }
            tmp.add(cur);
        }
        
        for (int i = 0; i < tmp.size(); i++) {
            total *= (tmp.get(i) + 1); 
        }
        
        if (total % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                answer += i;
            } else {
                answer -= i;
            }
            System.out.println(answer);
        }
        return answer;
    }
}