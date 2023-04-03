class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] strArr = my_string.split(" ");
        int i = 0;
        int j = 1;
        int k = 2;
        answer += Integer.parseInt(strArr[i]);
        while (k < strArr.length) {
            if (strArr[j].equals("+")) {
                answer += Integer.parseInt(strArr[k]);
            } else {
                answer -= Integer.parseInt(strArr[k]);
            }
            j += 2;
            k += 2;
        }
        return answer;
    }
}