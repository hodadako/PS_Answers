class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            combination(nums, i, 0, new ArrayList<>());
        }

        return answer;
    }

    void combination(int[] nums, int count, int index, List<Integer> result) {
        if (count == 0) {
            answer.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            combination(nums, count - 1, i + 1, result);
            result.remove(result.size() - 1);
        }
    }
}