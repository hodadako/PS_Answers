class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++){
            StringBuilder seq = new StringBuilder();
            for (int j = 0; j < n; j++){
                seq.append(my_string.charAt(i));
            }
            sb.append(seq);
        }
        
        answer = sb.toString();
        return answer;
    }
}