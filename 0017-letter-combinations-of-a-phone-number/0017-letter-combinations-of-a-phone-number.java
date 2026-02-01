class Solution {
    HashMap<Integer, List<Character>> map = new HashMap<>();
    List<String> answer = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
        
        getLetters(digits, 0, new StringBuilder());
        return answer;
    }
    
    public void getLetters(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            answer.add(sb.toString());
            return;
        }

        for (char c : map.get(Character.getNumericValue(digits.charAt(index)))) {
            System.out.println(c);
            sb.append(c);
            getLetters(digits, index + 1, new StringBuilder(sb.toString()));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}