import java.util.*;

class Solution {
    private int[][] map = new int[100][100];
    
    private void init(int rows, int columns) {
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = count;
                count++;
            }
        }
    }
    
    private int rotate(int[] query) {
        int result = 10001, count = 0;
        int length = (query[3] - query[1] + 1) *  2 + (query[2] - query[0] + 1) * 2 - 4;
        int[][] dots = new int[length][2];
        LinkedList<Integer> nums = new LinkedList<>();
        
        // 왼쪽 위에서 오른쪽 위로 
        for (int i = query[1] - 1; i < query[3]; i++) {
            int cur = map[query[0] - 1][i];
            dots[count][0] = query[0] - 1;
            dots[count][1] = i;
            nums.add(cur);
            count++;
            result = Math.min(result, cur);
        }
        
        // 오른쪽 위에서 오른쪽 아래로
        for (int i = query[0]; i < query[2]; i++) {
            int cur = map[i][query[3] - 1];
            dots[count][0] = i;
            dots[count][1] = query[3] - 1;
            nums.add(cur);
            count++;
            result = Math.min(result, cur);
        }
        
        // 오른쪽 아래에서 왼쪽 아래로
        for (int i = query[3] - 2; i >= query[1] - 1; i--) {
            int cur = map[query[2] - 1][i];
            dots[count][0] = query[2] - 1;
            dots[count][1] = i;
            nums.add(cur);
            count++;
            result = Math.min(result, cur);
        }
        
        // 왼쪽 아래에서 왼쪽 위로
        for (int i = query[2] - 2; i > query[0] - 1; i--) {
            int cur = map[i][query[1] - 1];
            dots[count][0] = i;
            dots[count][1] = query[1] - 1;
            nums.add(cur);
            count++;
            result = Math.min(result, cur);
        }
        
        nums.addFirst(nums.removeLast());
        for (int i = 0; i < dots.length; i++) {
            int x = dots[i][0], y = dots[i][1];
            map[x][y] = nums.get(i);
        }
        
        return result;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        init(rows, columns);
        for (int i = 0; i < queries.length; i++) {
            result.add(rotate(queries[i]));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}