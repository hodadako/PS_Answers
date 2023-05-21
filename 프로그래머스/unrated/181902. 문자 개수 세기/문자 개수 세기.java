class Solution {
    public int[] solution(String my_string) {
        int[] ascii = new int[52];
        int[] answer = new int[52];
        for (int i = 65; i <= 90; i++) {
            ascii[i - 65] = i;
        }
        
        for (int i = 97; i <= 122; i++) {
            ascii[i - 97 + 26] = i;
        }
        
        for (int i = 0; i < 52; i++) {
            char c = (char) ascii[i];
            System.out.println(c);
            for (int j = 0; j < my_string.length(); j++) {
                if (my_string.charAt(j) == c) {
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}