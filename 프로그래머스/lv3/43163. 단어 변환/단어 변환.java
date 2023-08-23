import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int n;
    
    class Node {
        private int now, count;
        
        public Node (int now, int count) {
            this.now = now;
            this.count = count;
        }
    }
    
    private void bfs(int n, String[] words, String target) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        visited[n] = true;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            for (int next : graph.get(node.now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Node(next, node.count + 1));
                    if (words[next].equals(target)) {
                        answer = Math.min(answer, node.count + 1);
                    }
                }
            }
        }
    }
    
    private void getGraph(String start, String[] words, int n) {
        for (int j = 0; j < words.length; j++) {
            String s = words[j];
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == start.charAt(i)) {
                    cur++;
                }
            }
            
            if (cur == s.length() - 1) {
                graph.get(n).add(j);
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        visited = new boolean[n + 1];
        words = Arrays.copyOf(words, n + 1);
        words[n] = begin;
        int s = n, e = -1;
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            if (words[i].equals(target)) {
                e = i;
            }
        }
        
        if (e == -1) {
            answer = 0;
        } else {
            for (int i = 0; i < n + 1; i++) {
                getGraph(words[i], words, i);
            }
            bfs(s, words, target);
        }    

        return answer;
    }
}