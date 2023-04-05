import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
        }
        HashSet<Integer> pick = new HashSet<Integer>(tmp);
        System.out.println(tmp);
        int n = pick.size();
        int k = nums.length / 2;
        if (n >= k) {
            answer = k;
        } else {
            answer = n;
        }
        return answer;
    }
}