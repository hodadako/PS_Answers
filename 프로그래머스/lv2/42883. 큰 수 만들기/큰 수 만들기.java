import java.util.*;

class Solution {
        public String solution(String number, int k) {
        String answer = "";
        String[] numArr = number.split("");
        int target = number.length() - k;
        LinkedList<String> result = new LinkedList<>();
        LinkedList<String> numList = new LinkedList<>(Arrays.asList(numArr));
        while (!numList.isEmpty() && k > 0) {
            result.add(numList.removeFirst());
            if (!numList.isEmpty()) {
                while (Integer.parseInt(result.peekLast()) < Integer.parseInt(numList.peekFirst()) && k > 0) {
                    result.removeLast();
                    k--;
                    if (result.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (result.size() == numArr.length) {
            for (int i = 0; i < k; i++) {
                result.removeLast();
            }
        }
        return String.join("", result) + String.join("", numList);
    }
}