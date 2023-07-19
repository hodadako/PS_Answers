import java.util.*;

class Solution {
    int[] answer; 
    private int isPrime(int n) {
        ArrayList<Integer> now = new ArrayList<>();
        int result = 1;
        if (n == 1) {
                return 0;
        }
        
        for (int i = 2; i < (int)Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                now.add(i);
            }
        }
        if (now.isEmpty()) {
            return 1;
        } else {
            for (int i = 0; i < now.size(); i++) { 
                if (n / now.get(i) <= 10_000_000 && !now.contains(n / now.get(i))) {
                   now.add(n / now.get(i));
                }
            }  
            // System.out.println(now);
            Collections.sort(now, (o1, o2) -> o1 - o2);
            return now.get(now.size() - 1);
        }
    }
    
    public int[] solution(long begin, long end) {
        answer = new int[(int)(end - begin) + 1];
        for (int i = (int)begin; i < (int)end + 1; i++) {
            answer[i - (int)begin] = isPrime(i);
        }
        return answer;
    }
}