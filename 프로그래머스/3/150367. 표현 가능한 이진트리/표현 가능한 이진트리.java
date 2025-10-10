class Solution {
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            int length = getTreeLength(binary.length());
            binary = "0".repeat(length - binary.length()) + binary;
            
            answer[i] = isValid(binary) ? 1 : 0;
        }
        return answer;
    }

    int getTreeLength(int n) {
        int len = 1;
        while (len < n) len = len * 2 + 1;
        return len;
    }

    boolean isValid(String tree) {
        return dfs(tree, 0, tree.length() - 1, false);
    }

    boolean dfs(String tree, int start, int end, boolean forbiddenParent) {
        if (start > end) return true;

        int mid = (start + end) / 2;
        char root = tree.charAt(mid);

        if (forbiddenParent && root == '1') return false;

        boolean nextForbidden = (root == '0');

        boolean left = dfs(tree, start, mid - 1, nextForbidden);
        boolean right = dfs(tree, mid + 1, end, nextForbidden);

        return left && right;
    }
}
