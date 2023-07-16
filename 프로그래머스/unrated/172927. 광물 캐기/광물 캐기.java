import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    String[] types = {"dStick", "iStick", "sStick"};
    int[] dia;
    int[] iro;
    int[] sto;
    
    ArrayList<String> sticks = new ArrayList<>();
    
    private int solve(ArrayList<String> list) {
        int cur = 0, total = 0;
        for (int i = 0; i < dia.length; i++) {
            if (i != 0 && i % 5 == 0) {
                cur++;
            }
            if (cur == list.size()) break;
            if (list.get(cur).equals("dStick")) {
                total += dia[i];
            } else if (list.get(cur).equals("iStick")) {
                total += iro[i];
            } else {
                total += sto[i];
            }
        }
        return total;
    }
    
    private void permutation(ArrayList<String> list, int count, int types) {
        if (count == 0 || list.size() == types) {
            answer = Math.min(answer, solve(list));
            return;
        }
        
        for (int i = 0; i < sticks.size(); i++) {
            String cur = sticks.remove(i);
            list.add(cur);
            permutation(list, count - 1, types);
            list.remove(list.size() - 1);
            sticks.add(i, cur);
        }
    }
    
    private void init(int stickNums, int[] picks) {
        for (int i = 0; i < picks.length; i++) {
            int cur = picks[i];
            for (int j = 0; j < cur; j++) {
                sticks.add(types[i]);
                stickNums--;
                if (stickNums == 0) break;
            }
            if (stickNums == 0) break;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        dia = new int[minerals.length];
        iro = new int[minerals.length];
        sto = new int[minerals.length];
        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                dia[i] = 1;
                iro[i] = 5;
                sto[i] = 25;
            } else if (minerals[i].equals("iron")) {
                dia[i] = 1;
                iro[i] = 1;
                sto[i] = 5;
            } else {
                dia[i] = 1;
                iro[i] = 1;
                sto[i] = 1;
            }
        }
        
        int stickNum = minerals.length % 5 == 0 ? minerals.length / 5 : minerals.length / 5 + 1;
        init(stickNum, picks);
        permutation(new ArrayList<String>(), stickNum, sticks.size());
        return answer;
    }
}