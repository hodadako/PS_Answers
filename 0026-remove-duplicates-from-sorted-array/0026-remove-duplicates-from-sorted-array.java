class Solution {
    Set<Integer> set = new HashSet<>();
    public int removeDuplicates(int[] nums) {
        for (int i : nums) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, (o1, o2) -> o1 - o2);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < list.size()) {
                nums[i] = list.get(i);
            } else {
                nums[i] = 0;
            }
        }
        return set.size();
    }
}