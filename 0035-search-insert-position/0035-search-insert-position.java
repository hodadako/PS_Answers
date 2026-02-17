class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            // System.out.println(mid + " " + s + " " + e);
            if (nums[mid] >= target) {
                e--;
            } else if (nums[mid] < target) {
                s++;
            } 
        }
        return s;
    }
}