class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int n = 0;
        StringBuilder tmp = new StringBuilder();
        my_string = my_string.toLowerCase();
        while (n < my_string.length()) {
            if (Character.isDigit(my_string.charAt(n))) {
                tmp.append(String.valueOf(my_string.charAt(n)));
                n += 1;
            } else if (Character.isLowerCase(my_string.charAt(n)) && tmp.length() == 0) {
                n += 1;
            } else {
                answer += Integer.parseInt(tmp.toString());
                tmp.delete(0, tmp.length());
                n += 1;
            } 
        }
        
        if (tmp.length() != 0) {
            answer += Integer.parseInt(tmp.toString());
        }
        return answer;
    }
}