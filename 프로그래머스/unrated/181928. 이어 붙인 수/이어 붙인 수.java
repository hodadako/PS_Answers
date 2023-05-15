class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) { 
                even += String.valueOf(num_list[i]);
            } else {
                odd += String.valueOf(num_list[i]);
            }
        }
        int answer = Integer.parseInt(even) + Integer.parseInt(odd);
        return answer;
    }
}