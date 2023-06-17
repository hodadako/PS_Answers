import java.util.*;

class Solution {
    private String[] sharps = {"C#", "D#", "E#", "F#", "G#", "A#", "B#"};
    private String[] changed = {"c", "d", "e", "f", "g", "a", "b"};
    
    class Music {
        int time;
        int length;
        String name;
        String melody;
        
        private Music(String musicInfo) {
            String[] info = musicInfo.split(",");
            this.length = (Integer.parseInt(info[1].substring(0, 2)) - Integer.parseInt(info[0].substring(0, 2))) * 60 + (Integer.parseInt(info[1].substring(3, 5)) - Integer.parseInt(info[0].substring(3, 5)));
            this.name = info[2];
            this.melody = changeMelody(info[3]);
            this.time = this.melody.length();
        }
        
        private String getName() {
            return this.name;
        }
        
        private int getTime() {
            return this.time;
        }
        
        private int getLength() {
            return this.length;
        }
        
        private String getMelody() {
            return this.melody;
        }
    }
    
    private String changeMelody(String melody) {
        for (int i =  0; i < sharps.length; i++) {
            if (melody.contains(sharps[i])) {
                melody = melody.replaceAll(sharps[i], changed[i]);
            }
        }
        return melody;
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int cur = 0;
        m = changeMelody(m);
        for (String s : musicinfos) {
            Music music = new Music(s);
            String melody = music.getMelody();
            String name =  music.getName();
            int length = music.getLength();
            int time = music.getTime();
            System.out.println(melody);
            StringBuilder totalMelody = new StringBuilder();
            for (int i = 0; i < length; i++) {
                totalMelody.append(melody.charAt(i % time));
            }
            
            if (totalMelody.toString().contains(m)) {
                if (length > cur) {
                    answer = name;
                    cur = length;
                }
            }
        }
        
        if (answer.equals("")) {
            answer = "(None)";
        }
        return answer;
    }
}