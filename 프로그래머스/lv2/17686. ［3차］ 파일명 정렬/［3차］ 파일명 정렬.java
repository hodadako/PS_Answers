import java.util.*;

class Solution {
    class Cache {
        String original;
        String head;
        String number;
        
        private Cache(String file) {
            this.original = file;
            int s = 0, e = 0;
            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);
                if (Character.isDigit(c)) {
                    if (s == 0) {
                        s = i;
                        e = i;
                    } else {
                        e = i;
                    }
                }
                
                if (e != 0 && !Character.isDigit(c)) {
                    break;
                }
            }
            

            this.head = file.substring(0, s);
            this.number = file.substring(s, e + 1);
        }
        
        private String getOriginal() {
            return this.original;
        }
        
        private String getHead() {
            return this.head.toLowerCase();
        }
        
        private int getNumber() {
            return Integer.parseInt(this.number);
        }
    }
    public String[] solution(String[] files) {
        ArrayList<Cache> result = new ArrayList<>();
        for (String s : files) {
            result.add(new Cache(s));
        }
        Collections.sort(result, Comparator.comparing(Cache::getHead).thenComparing(Cache::getNumber));
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).getOriginal();
            // System.out.println(answer[i]);
        }
        return answer;
    }
}