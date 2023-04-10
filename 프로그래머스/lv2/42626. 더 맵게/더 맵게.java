import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (pq.peek() < K) {
            int lowest = pq.poll();
            int secondLowest = pq.poll();
            int newSpicy = lowest + secondLowest * 2;
            pq.add(newSpicy);
            answer += 1; 
            if (pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}