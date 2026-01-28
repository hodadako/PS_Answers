import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums1) {
            pq.add(i);
        }

        for (int j : nums2) {
            pq.add(j);
        }
        
        System.out.println(pq);
        int n = pq.size();
        double answer = 0d;
        if (n % 2 == 0) {
            int count = 0;
            while (!pq.isEmpty()) {
                int now = pq.poll();
                if (count == n / 2 || count == n / 2 - 1) {
                    answer += (double) now;
                }
                count++;
            }
            answer /= 2d;
        } else {
            int count = 0;
            while (!pq.isEmpty()) {
                int now = pq.poll();
                if (count == (n - 1) / 2) {
                    answer += (double) now;
                }
                count++;
            }
        }
        return answer;
    }
}