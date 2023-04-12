class Solution {
    boolean strCheck(String input) { 
        String[] key = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < 4; i++) {
            if (input.contains(key[i])) {
                input = input.replace(key[i], ".");
            }
        }
        int flag = 1;
        for (int i = 0; i < input.length(); i++) {
            if (!String.valueOf(input.charAt(i)).equals(".")) {
                flag = 0;
            }
        }
        
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (strCheck(babbling[i])) {
                answer += 1;
            }
        }
        return answer;
    }
}