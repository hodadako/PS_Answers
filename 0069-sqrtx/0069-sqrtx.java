class Solution {
    public int mySqrt(int x) {
        int s = 0, e = x;
        if (x == 0) return 0;
        if (x == 1) return 1;
        int answer = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (mid <= x / mid) {
                answer = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return answer;
    }
}