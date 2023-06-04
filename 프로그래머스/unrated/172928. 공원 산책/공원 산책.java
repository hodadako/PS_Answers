import java.util.*;

class Solution {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    public String[] dir = {"N", "W", "S", "E"};
    
    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0, nx = 0, ny = 0;
        int n = park.length, m = park[0].length();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                    nx = i;
                    ny = j;
                    map[i][j] = 'O';
                }
            }
        }
        
        HashMap<String, Integer> directions = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            directions.put(dir[i], i);
        }
        

        for (String s : routes) {
            String[] oper = s.split(" ");
            boolean change = true;
            for (int i = 0; i < Integer.parseInt(oper[1]); i++) {
                nx += dx[directions.get(oper[0])];
                ny += dy[directions.get(oper[0])];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    change = false;
                    break;
                } 
                if (map[nx][ny] == 'X') {
                    change = false;
                    break;
                } 
            }
            
            if (change) {
                x = nx;
                y = ny;
            } else {
                nx = x;
                ny = y;
            }
        }
        
        int[] answer = {x, y};
        return answer;
    }
}