class Solution {
    public int longestValidParentheses(String s) {
        List<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[s.length()];
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (q.isEmpty()) {
                if (c == '(') {
                    q.add(i);
                } 
            } else {
                if (c == '(') {
                    q.add(i);
                } else {
                    check[q.removeLast()] = true;
                    check[i] = true;
                }    
            }
        }

        System.out.println(Arrays.toString(check));
        for (int i = 0; i < s.length(); i++) {
            if (check[i]) {
                int start = i;
                while (check[i]) {
                    i++;
                    if (i == s.length()) {
                        i--;
                        break;
                    } else if (check[i] == false) {
                        i--;
                        break;
                    }
                }
                answer = Math.max(answer, i - start + 1);
            }
        }
        return answer;
    }
}