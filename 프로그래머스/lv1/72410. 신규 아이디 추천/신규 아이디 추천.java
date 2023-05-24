import java.util.*;

class Solution {
    public String check(String new_id) {
        LinkedList<Character> result = new LinkedList<>();
        for (int i = 0; i < new_id.length(); i++) {
            result.add(new_id.charAt(i));
        }
        // 대문자 -> 소문자
        for (int i = 0; i < new_id.length(); i++) {
            if (Character.isUpperCase(result.get(i))) {
                result.set(i, Character.toLowerCase(result.get(i)));
            }
        }
        
        // 소문자, 숫자, 빼기, 밑줄, 마침표 빼고 다 제거
        LinkedList<Character> tmp = new LinkedList<>();
        for (int i = 0; i < new_id.length(); i++) {
            char c = result.get(i); 
            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                tmp.add(c);
            }
        }
        
        // 연속 마침표 제거
        LinkedList<Character> tmp2 = new LinkedList<>();
        boolean flag = true;
        for (int i = 0; i < tmp.size(); i++) {
            char c = tmp.get(i); 
            if (c == '.' && flag) {
                tmp2.add(c);
                flag = false;
            } else if (c != '.'){
                tmp2.add(c);
                flag = true;
            }
        }
        
        // 시작, 끝 마침표 제거 
        if (!tmp2.isEmpty()) {
            if (tmp2.peekFirst() == '.') {
                tmp2.pollFirst();
            }
        }

        if (!tmp2.isEmpty()) {
            if (tmp2.peekLast() == '.') {
                tmp2.pollLast();
            }
        }
        
        // 빈 문자열??
        if (tmp2.isEmpty()) {
            tmp2.add('a');
        }
        
        // 길이가 16 이상일때
        if (tmp2.size() >= 16) {
            while (tmp2.size() != 15) {
                tmp2.pollLast();
            }
            
            if (tmp2.peekLast() == '.') {
                tmp2.pollLast();
            }
        }
        
        // 길이가 2 이하일때 
        if (tmp2.size() <= 2) {
            char ct = tmp2.peekLast();
            while (tmp2.size() != 3) {
                tmp2.addLast(ct);
            }
        }
        
        //문자열 합치기;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp2.size(); i++) {
            sb.append(tmp2.get(i));
        }
        
        return sb.toString();
    }
    
    public String solution(String new_id) {
        String answer = check(new_id);
        return answer;
    }
}