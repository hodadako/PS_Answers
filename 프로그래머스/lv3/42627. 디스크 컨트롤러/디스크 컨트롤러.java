import java.util.*;

class Solution {
    int n;
    
    class Job {
        int start, time;
        
        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        LinkedList<Job> q = new LinkedList<>();
        int answer = 0;
        n = jobs.length;
        for (int[] job : jobs) {
            q.add(new Job(job[0], job[1]));
        }
        
        Collections.sort(q, (a, b) -> a.start - b.start);
        int total = 0, time = 0;
        while (!q.isEmpty() || !pq.isEmpty()) {
             while (!q.isEmpty() && q.peek().start <= time){
                 pq.add(q.poll());
             }
            
            if (pq.isEmpty()) {
                time = q.peek().start;
                continue;
            }
            
            Job job = pq.poll();
            total += job.time + time - job.start;
            time += job.time;
        }

        return total / n;
    }
}