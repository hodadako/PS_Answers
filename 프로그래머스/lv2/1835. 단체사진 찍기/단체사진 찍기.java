import java.util.*;

class Solution {
    private int answer = 0;
    
    private char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private ArrayList<ArrayList<Character>> photos = new ArrayList<>();
    private void permutation(ArrayList<Character> list, int count) {
        if (count == 0) {
            photos.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < characters.length; i++) {
            if (list.contains(characters[i])) continue;
            list.add(characters[i]);
            permutation(list, count - 1);
            list.remove(list.size() - 1);
        }
    }
    
    private void check(String[] data, ArrayList<Character> list) {
        boolean add = true;
        for (int i = 0; i < data.length; i++) {
            char star = data[i].charAt(0);
            char other = data[i].charAt(2);
            char oper  = data[i].charAt(3);
            int distance = Character.getNumericValue(data[i].charAt(4));
            int cur = Math.abs(list.indexOf(star) - list.indexOf(other)) - 1;
            if (oper == '=') {
                if (cur != distance) {
                    add = false;
                    break;
                }
            } else if (oper == '<') {
                if (cur >= distance) {
                    add = false;
                    break;
                }
            } else {
                if (cur <= distance) {
                    add = false;
                    break; 
                }
            }
        }
        
        if (add) {
            answer++;
        }
    }
    
    public int solution(int n, String[] data) {
        permutation(new ArrayList<Character>(), 8);
        for (int i = 0; i < photos.size(); i++) {
            check(data, photos.get(i));
        }
        return answer;
    }
}