import java.util.*;

class Solution {
    private boolean check(int n, int[] times, long mid) {
        long total = 0;
        for (int i : times) {
            total += mid / i;
        }
        
        return total >= n;
    }
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = (long) n * times[times.length - 1];
        long mid = 0;
        
        while (start < end) {
            mid = (start + end) / 2;
            if (check(n, times, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}