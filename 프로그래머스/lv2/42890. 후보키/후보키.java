import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> candidateKey = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> keys = new ArrayList<ArrayList<Integer>>();
    
    private void combination(ArrayList<Integer> list, int[] numArr, int index, int r){
        if (r == 0) {
            keys.add(new ArrayList<>(list));
        } else if (r > 0) {
            for (int i = index; i < numArr.length; i++) {
                list.add(numArr[i]);
                combination(list, numArr, i + 1, r - 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private void findKey(String[][] relation, int n) {
        int[] numArr = new int[relation[0].length];
        for (int i = 0; i < relation[0].length; i++) {
            numArr[i] = i;
        }
        combination(new ArrayList<Integer>(), numArr, 0, n);
        for (int i = 0; i < keys.size(); i++) {
            ArrayList<ArrayList<String>> temp = new ArrayList<>();
            ArrayList<Integer> key = keys.get(i);
            for (int j = 0; j < relation.length; j++) {
                ArrayList<String> inner = new ArrayList<>();
                for (int k = 0; k < key.size(); k++) {
                    if (!inner.contains(relation[j][key.get(k)])){
                        inner.add(relation[j][key.get(k)]); 
                    }
                }
                if (!temp.contains(inner)) {
                    temp.add(inner);
                }
            }
            
            if (temp.size() == relation.length) {
                boolean add = true;
                for (int j = 0; j < candidateKey.size(); j++) {
                    int count = 0;
                    ArrayList<Integer> cKey = candidateKey.get(j);
                    for (int k = 0; k < cKey.size(); k++) {
                        if (key.contains(cKey.get(k))) {
                            count++;
                        }
                    }
                    if (count == cKey.size()) {
                        add = false;
                    }
                }
                if (add) {
                    candidateKey.add(key);
                }
            }
        }
    } 
    
    public int solution(String[][] relation) {
        for (int j = 1; j <= relation[0].length; j++) {
            findKey(relation, j);
            keys.clear();
        }

        return candidateKey.size();
    }
}