import java.util.*;

class Solution {
    private int paraSearch(int n, int k, int[] enemy) {
        int start = 0, end = enemy.length, result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(0,  mid, enemy, n, k)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } 
        return result;
    }
    
    private boolean check(int start, int end, int[] enemy, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < end; i++) {
            pq.add(enemy[i]);
        }
        
        for (int i = 0; i < k; i++) {
            pq.poll();
        }
        
        for (int i : pq.stream().mapToInt(i -> i).toArray()) {
            n -= i;
            if (n < 0) {
                break;
            }
        }

        if (n >= 0) {
            return true;
        } else {
            return false;
        }
    } 
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        answer = paraSearch(n, k, enemy);
        return answer;
    }
}