import java.util.*;

class Solution {
    private boolean isValid(int n, int[] rocks, int mid) {
        int removed = 0;
        int lastRock = 0;
        for (int rock : rocks) { 
            if (rock - lastRock < mid) {
                removed++;
                continue;
            }
            
            lastRock = rock;
        }
        
        return removed <= n;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int[] rocksCopy = Arrays.copyOf(rocks, rocks.length + 1);
        rocksCopy[rocksCopy.length - 1] = distance;
        Arrays.sort(rocksCopy);
        int start = 0;
        int end = distance + 1;
        
        while (start + 1 < end) {
            double miD = (start + end) /(double) 2;
            System.out.println(start + "  " + end);
            System.out.println(miD);
            int mid = (int) miD;
            if (isValid(n, rocksCopy, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}