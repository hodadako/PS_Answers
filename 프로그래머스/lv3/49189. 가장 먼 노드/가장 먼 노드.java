import java.util.*;

class Solution {
    private final int INF = (int) 1e9;
    private int max = 0;
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    int[] distances;
    class Node {
        int dist, now;
        
        public Node(int dist, int now) {
            this.dist = dist; 
            this.now = now;
        }
    }
    
    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist); 
        distances[start] = 0;
        pq.add(new Node(0, start));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (distances[node.now] < node.dist) continue;
            for (Node next : graph.get(node.now)) {
                int cost = node.dist + next.dist;
                if (cost < distances[next.now]) {
                    distances[next.now] = cost;
                    pq.add(new Node(cost, next.now));
                    if (cost != INF) {
                        max = Math.max(max, cost);
                    }
                }
            }
        }
    }  
    
    public int solution(int n, int[][] edge) {
        distances = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        Arrays.fill(distances, INF);
        for (int[] e : edge) {
            graph.get(e[0]).add(new Node(1, e[1]));
            graph.get(e[1]).add(new Node(1, e[0]));
        }
        
        dijkstra(1);
        
        return (int)Arrays.stream(distances).filter(i -> i == max).count();
    }
}