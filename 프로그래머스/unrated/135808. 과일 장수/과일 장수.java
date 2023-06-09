import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : score) {
            pq.add(i);
        }
        
        while (pq.size() >= m) {
            PriorityQueue<Integer> box = new PriorityQueue<>();
            for (int i = 0; i < m ; i++) {
                box.add(pq.poll());
            }
            answer += box.peek() * m;
        }

        return answer;
    }
}