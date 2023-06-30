import java.util.*;

class Solution {
    private int answer = 0;
    private int[] indegree = new int[26];
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
    
    private void init(String skill) {
        ArrayList<Integer> skillList = new ArrayList<>(); 
        for (int i = 0; i < skill.length(); i++) {
            skillList.add((int)skill.charAt(i) - 65);
        }
        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (skillList.contains(i)) {
                int index = skillList.indexOf(i);
                if (index < skillList.size() - 1) {
                    temp.add(skillList.get(index + 1));
                    indegree[skillList.get(index + 1)]++; 
                }
            }
            graph.add(temp);
        }
    }
    
    public int solution(String skill, String[] skill_trees) {
        init(skill);
        for (String s : skill_trees) {
            boolean add = true;
            int[] curArr = Arrays.copyOfRange(indegree, 0, 26);
            for (int i = 0; i < s.length(); i++) {
                int cur = (int)s.charAt(i) - 65;
                if (curArr[cur] == 1) {
                    add = false;
                    break;
                } else {
                    // System.out.println(graph.get(cur));
                    if (!graph.get(cur).isEmpty()) {
                        curArr[graph.get(cur).get(0)]--;
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