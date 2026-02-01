class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int answer = (int) 1e9;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int s = i + 1, e = n - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                int diff = Math.abs(target - sum);
                int now = Math.abs(target - answer);
                if (diff < now) {
                    answer = sum;
                }

                if (sum > target) {
                    e--;
                } else if (sum < target) {
                    s++;
                } else {
                    s++;
                    e--;
                }
            }
        }
        return answer;
    }
}