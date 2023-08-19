import java.util.*; 

class Solution {
    public int[] solution(int n, String[] words) {
        int[] count = new int[n + 1];
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[2];
        String j = words[0];
        set.add(j);
        count[1]++;
        for (int i = 1; i < words.length; i++) {
            char a = words[i - 1].charAt(words[i - 1].length() - 1), b = words[i].charAt(0);
            count[i % n + 1]++;
            if (set.contains(words[i]) || a != b) {
                answer[0] = i % n + 1;
                answer[1] = count[i % n + 1];
                break;
            } else {
                set.add(words[i]);
            }
        }
        
        return answer;
    }
}