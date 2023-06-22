import java.util.*;

class Solution {
    private ArrayList<Integer> result = new ArrayList<>();
    
    private void isPrime(int n) {
        boolean prime = true;
        if (n <= 1) {
            prime = false;
        } else {
            for (int i = 2; i < (int)Math.sqrt(n) + 1; i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        
        if (prime && !result.contains(n)) {
            result.add(n);
        }
    }
    
        private void permutation(ArrayList<String> list, ArrayList<String> nums, int count) {
        if (count == 0) {
            isPrime(Integer.parseInt(String.join("", list)));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            String temp = nums.remove(i);;
            list.add(temp);
            permutation(list, nums, count - 1); 
            list.remove(list.size() - 1);
            nums.add(i, temp);
        }
    }
    
    public int solution(String numbers) {
        ArrayList<String> nums = new ArrayList<>(Arrays.asList(numbers.split("")));
        for (int i = 1; i < nums.size()+ 1; i++) {
            permutation(new ArrayList<String>(), nums, i);
        }
        
        return result.size();
    }
}