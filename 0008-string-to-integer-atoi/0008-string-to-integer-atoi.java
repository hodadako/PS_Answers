class Solution {
    final int MAX = Integer.MAX_VALUE / 10;
    final int MIN = Integer.MIN_VALUE / 10 * -1; 

    public int myAtoi(String s) {
        // WhiteSpace
        s = s.trim();
        
        // Signedness
        boolean negative = s.startsWith("-");
        if (negative) {
            s = s.replaceFirst("-", "");
        }

        if (!negative && s.startsWith("+")) {
            s = s.replaceFirst("\\+", "");
        }

        // Conversion
        boolean digitFound = false;

        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!digitFound && c == '0') continue;
                sb.append(c);
                digitFound = true;
            } else {
                break;
            }
        }
        
        String str = sb.toString();
        int result = 0;
        System.out.println(sb);
        
        // Rounding
        
        System.out.println(negative);

        System.out.println(str);
        for (char c : str.toCharArray()) {
            int now = Character.getNumericValue(c);

            if (!negative && (result > MAX || (result == MAX && now >= 7))) return Integer.MAX_VALUE;
            if (negative && (result > MIN || (result == MIN && now >= 8))) return Integer.MIN_VALUE;
            result = result * 10 + now;
        }


        return negative ? result * -1 : result;
    }
}