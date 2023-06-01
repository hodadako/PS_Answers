import java.util.*;

class Solution {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    
    class Node {
        int x;
        int y;
        int distance;
        
        public Node(int x , int y) {
            this.x = x;
            this.y = y;
        }
        
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getDistance() {
            return this.distance;
        }
    }
    
    public boolean bfs(char[][] map, int a, int b, boolean visited[][]) {
        boolean flag = true;
        LinkedList<Node> q = new LinkedList<>();
        visited[a][b] = true;
        q.add(new Node(a, b, 0));
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            int x = node.getX();
            int y = node.getY();
            int distance = node.getDistance();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny] && distance < 2) {
                    if (map[nx][ny] == 'O') {
                        q.add(new Node(nx, ny, distance + 1));
                        visited[nx][ny] = true;
                    }
                    else if (map[nx][ny] == 'P') {
                        visited[nx][ny] = true;
                        flag = false;
                        break;
                    }
                }
            }
            
            if (!flag) {
                break;
            }
        }
        return flag;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int k = 0; k < places.length; k++) {
            String[] place = places[k];
            ArrayList<Node> person = new ArrayList<>();
            char[][] curMap = new char[5][5];
            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < place[i].length(); j++) {
                    curMap[i][j] = place[i].charAt(j);
                    if (curMap[i][j] == 'P') {
                        person.add(new Node(i, j));
                    }
                } 
            }
            
            
            boolean wellDistanced = true;
            for (int h = 0; h < person.size(); h++) {
                boolean[][] visited = new boolean[5][5];
                Node node = person.get(h);
                if (!bfs(curMap, node.getX(), node.getY(), visited)) {
                    wellDistanced = false;
                    break;
                }
            }
            
            if (wellDistanced) {
                answer[k] = 1;
            } else {
                answer[k] = 0;
            }
        }
        return answer;
    }
}