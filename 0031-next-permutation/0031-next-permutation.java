class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (checkBackward(nums)) {
            Arrays.sort(nums);
        } else {
            int target = n - 2, change = -1;
            for (int i = n - 2; i >= 0; i--) {
                boolean found = false;
                for (int j = i; j < n; j++) {
                    if (nums[j] > nums[i]) {
                        target = i;
                        if (change == -1) {
                            change = j;
                        } else {
                            change = Math.min(nums[j], nums[change]) == nums[change] ? change : j;
                        }
                        found = true;
                    }
                }
                if (found) break;
            }

            // System.out.println(target + " " + change);

            // System.out.println("check");

            int temp = nums[target];
            nums[target] = nums[change];
            nums[change] = temp;
            Arrays.sort(nums, target + 1, n);
        }
    }

    boolean checkBackward(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            if (a < b) return false; 
        }
        return true;
    }
}