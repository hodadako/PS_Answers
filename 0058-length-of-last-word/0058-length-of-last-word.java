class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (split[split.length - 1].equals("")) {
            return split[split.length - 2].length();
        }
        return split[split.length - 1].length();
    }
}