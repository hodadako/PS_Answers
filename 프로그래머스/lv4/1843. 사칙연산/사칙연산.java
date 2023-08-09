import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = (arr.length + 1) / 2, m = (arr.length - 1) / 2;
        String[] opers = new String[m];
        int[] nums = new int[n];
        int[][] dp = new int[n][n];
        int[][] minDp = new int[n][n];
        int[][] maxDp = new int[n][n];
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(arr[i]);
            } else {
                opers[i / 2] = arr[i];
            }
        }
        
        for (int[] min : minDp) {
            Arrays.fill(min, Integer.MAX_VALUE);
        }
        
        for (int[] max : maxDp) {
            Arrays.fill(max, Integer.MIN_VALUE);
        }
        
        for (int step = 0; step < dp.length; step++) {
            for (int i = 0; i < dp.length - step; i++) {
                int j = i + step;
                if (step == 0) {
                    maxDp[i][i] = nums[i];
                    minDp[i][i] = nums[i];
                } else {
                    for (int k = i; k < j; k++) {
                        if (opers[k].equals("+")) {
                            maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k+1][j]);
                            minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k+1][j]);
                        } else {
                            maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k+1][j]);
                            minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k+1][j]);
                        }
                    }
                }
            }
        }

        return maxDp[0][n - 1];
    }
}