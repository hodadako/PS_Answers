class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 1; i <= nums2.length; i++) {
            nums1[nums1.length - i] = nums2[i - 1];
        }

        Arrays.sort(nums1);
    }
}