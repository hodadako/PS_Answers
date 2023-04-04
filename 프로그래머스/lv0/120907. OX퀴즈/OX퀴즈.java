import java.util.ArrayList;

class Solution {
    boolean calc(String s) {
        String[] strArr = s.split(" ");
        int answer = Integer.parseInt(strArr[4]);
        int result = 0;
        if (strArr[1].equals("-")) {
            result = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]);
        } else {
            result = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
        }
        
        if (result == answer) {
            return true;
        } else {
            return false;
        }
    }
    
    public String[] solution(String[] quiz) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < quiz.length; i++) {
            if (calc(quiz[i])) {
                result.add("O");
            } else {
                result.add("X");
            }
        }
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }
}