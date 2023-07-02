import java.util.*;

class Solution {
    private int[] dx = {1, 0, -1};
    private int[] dy = {0, 1, -1};
    
    private int turn(int direction) {
        if (direction < 3) direction++;
        if (direction == 3) direction = 0;
        
        return direction;
    }
    
    private int[] getAnswer(int[][] result) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] > 0) answer.add(result[i][j]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray(); 
    }
    
    class Node { 
        public final int x, y, count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        if (n == 1) arr[0][0] = 1;
        else if (n == 2) {
            arr[0][0] = 1;
            arr[1][0] = 2;
            arr[1][1] = 3;
        } else {
            LinkedList<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, 1));
            int direction = 0;
            while (!q.isEmpty()) {
                Node node = q.removeFirst();
                int x = node.x, y = node.y, count = node.count;
                arr[x][y] = count;
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    direction = turn(direction);
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }
                if (arr[nx][ny] > 0) {
                    direction = turn(direction);
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }
                if (arr[nx][ny] == 0) {
                    q.add(new Node(nx, ny, count + 1));
                }
            }

    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 System.out.print(arr[i][j] + " ");
    //             }
    //             System.out.println();
    //         }
        }
        return getAnswer(arr);
    }
}