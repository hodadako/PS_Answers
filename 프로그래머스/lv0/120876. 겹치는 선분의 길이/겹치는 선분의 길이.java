import java.util.*;

class Solution {
    void overlap(int[] line1, int[] line2, boolean[] visited) {
        int start = -101;
        int end = -101;
        if (line1[0] <= line2[1] && line2[0] <= line1[1]) {
            if (line1[1] <= line2[1] && line1[0] <= line2[0] && line1[1] > line2[0]) {
            start = line2[0];
            end = line1[1];
        } else if (line2[1] <= line1[1] && line2[0] <= line1[0] && line2[1] > line1[0]) {
            start = line1[0];
            end = line2[1];
        } else if (line1[1] <= line2[1] && line1[0] >= line2[0]) {
            start = line1[0];
            end = line1[1];
        } else if (line2[1] <= line1[1] && line2[0] >= line1[0]) {
            start = line2[0];
            end = line2[1];
            }
        } 
        System.out.println(start);
        System.out.println(end);
        if (start != -101) {
        for (int i = start; i < end; i++) {
            visited[i] = true;
            }
        }
    }
    
    public int solution(int[][] lines) {
        int answer = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                nums.add(lines[i][j]);
            }
        }
        Collections.sort(nums);
        if (nums.get(0) < 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                lines[i][j] += Math.abs(nums.get(0));
            }
        }
    }
        int len = nums.get(5) - nums.get(0) + 1;
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);
        
        overlap(lines[0], lines[1], visited);
        overlap(lines[1], lines[2], visited);
        overlap(lines[0], lines[2], visited);
        
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                answer += 1;
            }
        }
        
        return answer;
    }
}