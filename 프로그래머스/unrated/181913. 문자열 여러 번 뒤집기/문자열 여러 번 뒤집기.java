class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        String[] myArr = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            myArr[i] = String.valueOf(my_string.charAt(i));
        }
        
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0], e = queries[i][1];
            int count = 0;
            for (int j = s; j < s + (e - s + 1) / 2; j++) {
                String tmp = myArr[j];
                myArr[j] = myArr[e - count];
                myArr[e - count] = tmp;
                count += 1;
            }
        }
        
        for (int i = 0; i < myArr.length; i++) {
            answer += myArr[i];
        }
        return answer;
    }
}