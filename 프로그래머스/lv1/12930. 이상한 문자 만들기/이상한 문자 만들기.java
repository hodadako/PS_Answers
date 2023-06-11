class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index % 2 == 0) {
                if (Character.isLetter(c)) {
                    sb.append(Character.toUpperCase(c));
                    index++;
                } else {
                    sb.append(' ');
                    index = 0;
                }
            } else {
                if (Character.isLetter(c)) {
                    sb.append(Character.toLowerCase(c));
                    index++;
                } else {
                    sb.append(' ');
                    index = 0;
                }
            }
        }
        return sb.toString();
    }
}