import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, ArrayList<Integer>> reported = new HashMap<>();
        ArrayList<String> tmp = new ArrayList<>();
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            ArrayList<Integer> tmprepo = new ArrayList<>();
            tmprepo.add(0);
            reported.put(id_list[i], tmprepo);
            tmp.add(id_list[i]);
        }  
        Set<String> set = new HashSet<>(Arrays.asList(report));
        String[] newReport = set.toArray(new String[0]);

        
        for(int i = 0; i < newReport.length; i++) {
            String[] content = newReport[i].split(" ");
            ArrayList<Integer> tmp2 = reported.get(content[1]);
            tmp2.set(0, tmp2.get(0) + 1);
            tmp2.add(tmp.indexOf(content[0]));
            reported.put(content[1], tmp2);
        } 
        
        for (int i = 0; i < id_list.length; i++) {
            ArrayList<Integer> cur = reported.get(id_list[i]);
            if (cur.get(0) >= k) {
                for (int j = 1; j < cur.size(); j++) {
                    answer[cur.get(j)] += 1;
                }
            }
        }
        return answer;
    }
}