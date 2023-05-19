class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        String[] result = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            result[i] = my_string.substring(my_string.length() - i, my_string.length());
            if (result[i].equals(is_suffix)) {
                answer = 1;
            }
        }
        result[0] = my_string;
        if (result[0].equals(is_suffix)) {
            answer = 1;
        }
        return answer;
    }
}