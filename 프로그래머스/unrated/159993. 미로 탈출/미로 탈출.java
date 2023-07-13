import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    private int bfsLE(char[][] graph, int[][] distance, int l_x, int l_y, int e_x, int e_y) {
        int n = graph.length, m = graph[0].length, c = 0;
        boolean[][] visited = new boolean[n][m];
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{l_x, l_y, c});
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0], y = cur[1], count = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        if (graph[nx][ny] == 'X') {
                            visited[nx][ny] = true;
                        } else if (graph[nx][ny] == 'O' || graph[nx][ny] == 'S') {
                            q.add(new int[]{nx, ny, count + 1});
                            distance[nx][ny] = count + 1;
                            visited[nx][ny] = true;
                        } else if (graph[nx][ny] == 'E') {
                            distance[nx][ny] = count + 1;
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        return distance[e_x][e_y] > 0 ? distance[e_x][e_y] : -1;
    }
    
    private int bfsSL(char[][] graph, int[][] distance, int s_x, int s_y, int l_x, int l_y) {
        int n = graph.length, m = graph[0].length, c = 0;
        boolean[][] visited = new boolean[n][m];
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{s_x, s_y, c});
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0], y = cur[1], count = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        if (graph[nx][ny] == 'X') {
                            visited[nx][ny] = true;
                        } else if (graph[nx][ny] == 'O' || graph[nx][ny] == 'E') {
                            q.add(new int[]{nx, ny, count + 1});
                            distance[nx][ny] = count + 1;
                            visited[nx][ny] = true;
                        } else if (graph[nx][ny] == 'L') {
                            distance[nx][ny] = count + 1;
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
        
        return distance[l_x][l_y] > 0 ? distance[l_x][l_y] : -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length, m = maps[0].length();
        int[][] distance = new int[n][m];
        char[][] graph = new char[n][m];
        int s_x = 0, s_y = 0, l_x = 0, l_y = 0, e_x = 0, e_y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = maps[i].charAt(j);
                if (graph[i][j] == 'S') {
                    s_x = i;
                    s_y = j; 
                }
                if (graph[i][j] == 'E') {
                    e_x = i;
                    e_y = j;
                }
                if (graph[i][j] == 'L') {
                    l_x = i;
                    l_y = j;
                }
            }
        }
        
        int answer1 = bfsSL(graph, distance, s_x, s_y, l_x, l_y);
        int answer2 = bfsLE(graph, distance, l_x, l_y, e_x, e_y);
        
        return (answer1 == -1 || answer2 == -1) ? -1 : answer1 + answer2;
    }
}