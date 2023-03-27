import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 ) {
                if (!factors.contains(i)) {
                    factors.add(i);
                }
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        int[] answer = new int[factors.size()]; 
        for (int i = 0; i < factors.size(); i++) {
            answer[i] = factors.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}