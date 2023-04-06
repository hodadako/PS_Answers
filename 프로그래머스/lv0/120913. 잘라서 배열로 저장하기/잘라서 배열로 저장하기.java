class Solution {
    public String[] solution(String my_str, int n) {
        int count = 0;
        int check = my_str.length() / n;
        int flag = 0;
        if (my_str.length() % n > 0) {
            check += 1;
            flag = 1; 
        }
        
        String[] answer = new String[check];
        
        for (int i = 0; i < check; i++) {
            if (i == check - 1 && flag == 1) {
                answer[i] = my_str.substring(i * n, my_str.length());
            } else {
                answer[i] = my_str.substring(i * n, (i + 1) * n);
            }
        }
        
        return answer;
    }
}