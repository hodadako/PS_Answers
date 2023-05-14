import java.util.*;

class Solution {
    class Music {
        private String genre;
        private int plays;
        private int num;
        
        public Music(String genre, int plays, int num) {
            this.genre = genre;
            this.plays = plays;
            this.num = num;
        }
        
        public String getGenre() {
            return this.genre;
        }
        
        public int getPlays() {
            return this.plays;
        }
        
        public int getNum() {
            return this.num;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Music> playList = new ArrayList<>();
        int[] visited = new int[plays.length]; 
        for (int i = 0; i < genres.length; i++) {
            playList.add(new Music(genres[i], plays[i], i));
        }
        
        Collections.sort(playList, (o1, o2) -> o2.getPlays() - o1.getPlays());
        
        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (counter.containsKey(genres[i])) {
                counter.put(genres[i], counter.get(genres[i]) + plays[i]);
            } else {
                counter.put(genres[i], plays[i]);
            }
        }
        String[][] counterArr = new String[counter.size()][2];
        int p = 0;
        for (String key : counter.keySet()) {
            counterArr[p][0] = String.valueOf(counter.get(key));
            counterArr[p][1] = key;
            p += 1;
        }
        Arrays.sort(counterArr, (o1, o2) -> Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]));

        
        LinkedList<Integer> answerList = new LinkedList<>();
        for (int i = 0; i < counterArr.length; i++) {
            String curGenre = counterArr[i][1];
            int count = 2;
            for (int j = 0; j < plays.length; j++) {
                Music music = playList.get(j);            
                if (music.getGenre().equals(curGenre) && visited[j] == 0) {
                    visited[j] = 1;
                    answerList.add(music.getNum());
                    count -= 1;
                    if (count == 0) {
                        break;
                    }
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
           return answer;
    }
}