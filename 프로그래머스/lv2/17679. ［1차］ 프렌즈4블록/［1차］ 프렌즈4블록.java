import java.util.*;

class Solution {
    private int[] dx = {0, 1, 1};
    private int[] dy = {1, 0, 1};
    private char[][] map = new char[30][30];
    
    class Node {
        int x;
        int y;
        
        private Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        private int getX() {
            return this.x;
        }
        
        private int getY() {
            return this.y;
        }
    }
    
    private void down(int m, int n) {
        for (int i = m - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    int x = i;
                    int y = j;
                    while (map[x][y] == '*') {
                        x--;
                        if (x == 0) {
                            break;
                        }
                    }
                    if (map[x][y] !=  '*') {
                        map[i][j] = map[x][y];
                        map[x][y] = '*';
                    }
                }
            }
        }
    } 
    
    private void erase(int m, int n) {
        ArrayList<Node> dots = new ArrayList<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                boolean check = true;
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (map[i][j] != map[nx][ny]) {
                        check = false;
                        break;
                    }
                }
                
                if (check) {
                    dots.add(new Node(i, j));
                    for (int k = 0; k < 3; k++) {
                        dots.add(new Node(i + dx[k], j + dy[k]));
                    }
                }
            }
        }
        
        for (Node node : dots) {
            int x = node.getX();
            int y = node.getY();
            map[x][y] = '*';
        }
    }
    
    private boolean check(int m, int n) {
        boolean check = false; 
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                boolean one = true;
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (map[i][j] != map[nx][ny]) {
                        one = false;
                    }
                }
                if (one) {
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        
        return check;
    }
    
    private void init(String[] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
    }
    
    private int count(int m, int n) {
        int answer = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) { 
                if (map[i][j] == '*') {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        init(board, m, n);
        for (int i = 0; i < m * n / 4; i++){
            erase(m, n);
            down(m, n);
            if (!check(m, n)) {
                break;
            }
        }
        

        // for (int i = 0; i < m ; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        answer = count(m, n);
        return answer;
    }
}