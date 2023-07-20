import java.util.*;

class Solution {
    HashMap<Integer, Integer> total = new HashMap<>();
    ArrayList<ArrayList<Prime>> result = new ArrayList<>();
    ArrayList<Integer> types = new ArrayList<>();
    
    class Prime {
        int num, count;
        
        public Prime(int num, int count)  {
            this.num = num;
            this.count = count; 
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + num;
            result = prime * result + count;
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Prime)) {
                return false;
            }
            
            Prime other = (Prime) obj;
            return this.num == other.num;
        }
        
    }
    
    private ArrayList<Prime> getPrime(int n) {
        ArrayList<Prime> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int count = 0;
            while (n % i == 0) {
                if (!types.contains(i)) {
                    types.add(i);
                }
                n /= i;
                count++;
            }
            int index = types.indexOf(i);
            if (count > 0) {
                total.put(i, Math.max(total.getOrDefault(i, 0), count));
            }
        }
        
        return result;
    }
    
    public int solution(int[] arr) {
        for (int i : arr) {
            result.add(getPrime(i));
        }
        
        int answer = 1;
        // System.out.println(total);
        for (int i = 0; i < types.size(); i++) {
            int cur = 1;
            for (int j = 0; j < total.get(types.get(i)); j++) {
                cur *= types.get(i);
            }
            answer *= cur;
        }
        return answer;
    }
}