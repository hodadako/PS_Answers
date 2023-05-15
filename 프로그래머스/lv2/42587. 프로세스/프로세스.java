import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        int[] answer = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            pq.add(priorities[i]);
            q.add(i);
        }
        
        for (int i = 0; i < n; i++) {
            int cur = pq.poll();
            for (int j = 0; j < n; j++) {
                if (priorities[q.peekFirst()] != cur) {
                    q.addLast(q.removeFirst());
                } else {
                    answer[q.removeFirst()] = i + 1;
                    break;
                } 
            }
        }
        
        
        return answer[location];
    }
}