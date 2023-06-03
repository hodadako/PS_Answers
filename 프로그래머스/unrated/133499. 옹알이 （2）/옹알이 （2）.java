import java.util.*;

class Solution {
    public String[] bab = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < 4; j++) {
                babbling[i] = babbling[i].replaceAll(bab[j], String.valueOf(j));
            }
            
            System.out.println(babbling[i]); 
            
            LinkedList<Character> tmp = new LinkedList<>();
            boolean add = true;
            for (int j = 0; j < babbling[i].length(); j++) {
                if (Character.isLowerCase(babbling[i].charAt(j))) {
                    add = false;
                    break;
                } else {
                    if (tmp.isEmpty()) {
                        tmp.add(babbling[i].charAt(j));
                    } else {
                        if (tmp.peekLast() == babbling[i].charAt(j)) {
                            add = false;
                            break;
                        } else {
                            tmp.add(babbling[i].charAt(j));
                        }
                    }
                }
            }
            if (add) {
                answer++;
            }
        }
        return answer;
    }
}