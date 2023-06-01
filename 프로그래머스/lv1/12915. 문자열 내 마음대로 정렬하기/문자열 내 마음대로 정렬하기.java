import java.util.*;

class Solution {
    class Word {
        String word;
        String ogWord;
        
        public Word(String word, String ogWord) {
            this.word = word;
            this.ogWord = ogWord;
        }
        
        public String getWord() {
            return this.word;
        }
        
        public String getOgWord() {
            return this.ogWord;
        }
    }
    
    public String[] solution(String[] strings, int n) {
        ArrayList<Word> result = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < strings[i].length(); j++) {
                if (j == n) {
                    tmp.insert(0, strings[i].charAt(j));
                } else {
                    tmp.append(strings[i].charAt(j));
                }
            } 
            result.add(new Word(tmp.toString(), strings[i]));
        }
        
        Collections.sort(result, (o1, o2) -> o1.getWord().compareTo(o2.getWord()));

        String[] answer = new String[strings.length];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).getOgWord();
        }
        return answer;
    }
}