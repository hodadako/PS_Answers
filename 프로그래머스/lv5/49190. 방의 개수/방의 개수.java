import java.util.*;

class Solution {
    static class Node {
        int x, y;
        String id;
        HashSet<String> dots;
        
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
            this.id = id(x, y);
            this.dots = new HashSet<>();
        }
        
        public static String id(int x, int y) {
            return String.format("(%d, %d)", x, y);
        }
    }
    public int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
     
    public int solution(int[] arrows) {
        int answer = 0;
        HashMap<String, Node> key = new HashMap<>();
        Node node = new Node(0, 0);
        key.put(node.id, node);
        for (int k : arrows) {
            for (int i = 0; i < 2; i++) {
                int nx = node.x + dx[k], ny = node.y + dy[k];
                String id = Node.id(nx, ny);
                if (!key.containsKey(id)) {
                    key.put(id, new Node(nx, ny));
                } else if (!node.dots.contains(id)) {
                    answer++;
                }
                Node next = key.get(id);
                node.dots.add(next.id);
                next.dots.add(node.id);
                // System.out.println(node.dots);
                node = key.get(id);
            }
        }
        
        // System.out.println(key.get("00").dots);
        return answer;
    }
}