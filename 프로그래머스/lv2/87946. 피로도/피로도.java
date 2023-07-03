import java.util.*;

class Solution {
    private int answer = 0;
    private ArrayList<Integer> nums = new ArrayList<>();
    private void init(int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            nums.add(i);
        }
    }
    
    private int solve(ArrayList<Integer>list, int[][] dungeons, int k) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (k >= dungeons[n][0]) {
                k -= dungeons[n][1];
                count++;
            }
        }
        
        return count;
    }
    
    private void permutation(ArrayList<Integer> list, int count, int[][] dungeons, int k) {
        if (count == 0) {
            // System.out.println(list);
            answer = Math.max(answer, solve(list, dungeons, k));
            return;
        }    
        
        for (int i = 0; i < nums.size(); i++) {
            int a = nums.remove(i);
            list.add(a);
            permutation(list, count - 1, dungeons, k);
            list.remove(list.size() - 1);
            nums.add(i, a);
        }
    }
    public int solution(int k, int[][] dungeons) {
        init(dungeons);
        permutation(new ArrayList<Integer>(), dungeons.length, dungeons, k);
        return answer;
    }
}