import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        //중복 제거
        String[] strArr = s.split("");
        List<String> list = Arrays.asList(strArr);
        Set<String> set = new HashSet<String>(list); 
        
        //개수 세기
        String[] Arr = set.toArray(new String[0]);
        Arrays.sort(Arr);
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < Arr.length; i++) {
            map.put(Arr[i], 0);
        }
        for (int i = 0; i < strArr.length; i++) {
            int tmp = map.get(strArr[i]);
            map.put(strArr[i], tmp + 1);
        }
        String answer = "";
        for (int i = 0; i < Arr.length; i++) {
            if (map.get(Arr[i]) == 1) {
                answer += Arr[i];
            }
        }
        return answer;
    }
}