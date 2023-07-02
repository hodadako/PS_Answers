class Solution {
    private String[] nSplit(String s, int n) {
        String[] result = new String[s.length() / n + (s.length() % n > 0 ? 1 : 0)];
        for (int i = 0; i < result.length; i++) {
            if (n + n * i >= s.length()) {
                result[i] = s.substring(0 + i * n, s.length());
            } else {
                result[i] = s.substring(0 + i * n, n + i * n);
            }
            // System.out.println(result[i]);
        }
        
        return result;
    }
    
    private int compress(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        String step = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].equals(step)) {
                count++;
            }
            else {
                if (count == 1) {
                    sb.append(step);
                    step = strArr[i];
                } else {
                    sb.append(String.valueOf(count));
                    sb.append(step);
                    count = 1;
                    step = strArr[i];
                }
            } 
        }
        
        if (count == 1) {
            sb.append(step);
        } else {
            sb.append(String.valueOf(count));
            sb.append(step);
        }
        

        return sb.length();
    }
    
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            String[] cur = nSplit(s, i);
            answer = Math.min(answer, compress(cur));
            // System.out.println("____________");
        }
        return answer;
    }
}