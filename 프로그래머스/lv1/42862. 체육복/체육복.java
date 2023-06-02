import java.util.*;

class Solution {
    public boolean[] visited = new boolean[31];  
    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> noReserve = new ArrayList<>();
        ArrayList<Integer> trueReserve = new ArrayList<>();
        for (int i = 0; i < lost.length; i++) {
            noReserve.add(lost[i]);
        }
        
        for (int i = 0; i < reserve.length; i++) {
            trueReserve.add(reserve[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (noReserve.contains(i) && trueReserve.contains(i)) {
                noReserve.remove(noReserve.indexOf(i));
                trueReserve.remove(trueReserve.indexOf(i));
            }
        }
        Collections.sort(noReserve, Comparator.naturalOrder());
        Collections.sort(trueReserve, Comparator.naturalOrder());
        // 있는 애들 체크
        for (int i = 1; i <= n; i++) {
            if (!noReserve.contains(i)){
                visited[i] = true;
            }
        }
        
        System.out.println(noReserve);
        System.out.println(trueReserve);
        for (int i = 0; i < noReserve.size(); i++) {
            if (trueReserve.contains(noReserve.get(i) - 1) && trueReserve.contains(noReserve.get(i) + 1)) {
                visited[noReserve.get(i)] = true;
                trueReserve.remove(trueReserve.indexOf(noReserve.get(i) - 1));
            } else if (trueReserve.contains(noReserve.get(i) - 1)) {
                visited[noReserve.get(i)] = true;
                trueReserve.remove(trueReserve.indexOf(noReserve.get(i) - 1));
            } else if (trueReserve.contains(noReserve.get(i) + 1)) {
                visited[noReserve.get(i)] = true;
                trueReserve.remove(trueReserve.indexOf(noReserve.get(i) + 1));
            }
        }
        
        
        
        int answer = 0;
        for (int i = 1; i < 31; i++) {
            if (visited[i]) {
                answer += 1;
            }
        }
        return answer;
    }
}