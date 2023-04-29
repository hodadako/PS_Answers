class Solution {
    public int count = 0;
    
    public void check(int a, int i, int target, String oper, int[] numbers) {
        if (oper.equals("-")) {
            a -= numbers[i];
        } else {
            a += numbers[i];
        }
        if (i < numbers.length - 1) {
            check(a, i + 1, target, "-", numbers);
            check(a, i + 1, target, "+", numbers);
        } else {
            if (a == target) {
                count += 1;
            }
        }
        
    }
    
    public int solution(int[] numbers, int target) {
        check(-numbers[0], 1, target, "-", numbers);
        check(-numbers[0], 1, target, "+", numbers);
        check(numbers[0], 1, target, "-", numbers);
        check(numbers[0], 1, target, "+", numbers);
        return count;
    }
}